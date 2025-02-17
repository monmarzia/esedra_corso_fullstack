package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import it.esedra.corso.shoppinglist.exceptions.StoreException;
import it.esedra.corso.shoppinglist.helper.AESHelper;
import it.esedra.corso.shoppinglist.helper.GetFileResource;

/**
 * 
 * Gli elementi di queso modello sono: Prodotti Nome Identificatio univoco
 * numerico sequenziale Identificatore univoco pubblico alfanumerico (questo
 * identificatore consente di non ricevere scanning o attacchi dall'esterno)
 * Utente
 * 
 */

public class ShoppingList {

	private List<Product> products = new ArrayList<Product>();
	private String listName = new String();
	private User user;
	private BigInteger id;
	private String uniqueCode;
	private static final String fileName = "lista.csv";
	private static final String folderName = "shoppinglist";
	private static final String fieldSeparator = ",";

	public static enum Fields {
		listName, id, uniqueCode
	}

	@Deprecated
	private final static Map<String, Integer> fieldsMap;
	static {
		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
		tmpMap.put(Fields.id.name(), 0);
		tmpMap.put(Fields.listName.name(), 1);
		tmpMap.put(Fields.uniqueCode.name(), 2);
		tmpMap.put(Product.Fields.name.name(), 3);
		tmpMap.put(Product.Fields.qty.name(), 4);
		tmpMap.put(Product.Fields.unit.name(), 5);
		fieldsMap = Collections.unmodifiableMap(tmpMap);

	}

	public ShoppingList(List<Product> products, String listName, User user, BigInteger id, String uniqueCode) {
		this.products = products;
		this.listName = listName;
		this.user = user;
		this.id = id;
		this.uniqueCode = uniqueCode;
	}

	private ShoppingList() {

	}

	public User getUser() {
		return user;
	}

	public BigInteger getId() {
		return id;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getListName() {
		return listName;
	}

	/**
	 * 
	 * @return l'id piÃ¹ in alto assegnato
	 * @throws IOException
	 */
	public static synchronized BigInteger getLastId() throws IOException {
		BigInteger lastId = null;// (getAll().isEmpty()) ? SequenceManager.newIdUser() : getAll().last().getId();
		return lastId;

	}

	public static ShoppingList builderShoppingList(List<String[]> shoppingList) {

		ShoppingListBuilder builder = ShoppingListBuilder.builder();

		builder.listName(shoppingList.get(0)[fieldsMap.get(Fields.listName.name())])
				.id(new BigInteger(shoppingList.get(0)[fieldsMap.get(Fields.id.name())]))
				.uniqueCode(shoppingList.get(0)[fieldsMap.get(Fields.uniqueCode.name())]);

		builder.products(shoppingList.stream()
				.map(s -> new Product(s[fieldsMap.get(Product.Fields.name.name())],
						Integer.parseInt(s[fieldsMap.get(Product.Fields.qty.name())]),
						Unit.valueOf(s[fieldsMap.get(Product.Fields.unit.name())])))
				.collect(Collectors.toList()));

		return builder.build();
	}

	@Deprecated
	public ShoppingList get(ShoppingList inShoppingList) throws IOException {

		List<String> lines = Files
				.readAllLines(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName).toPath());
		ShoppingListBuilder builder = null;
		for (String line : lines) {
			String[] fields = line.split(ShoppingList.fieldSeparator);

			if (inShoppingList.getUniqueCode().equals(fields[fieldsMap.get(Fields.uniqueCode.name())])) {
				if (builder == null) {
					builder = ShoppingListBuilder.builder();
					builder.uniqueCode(fields[fieldsMap.get(Fields.uniqueCode.name())])
							.listName(fields[fieldsMap.get(Fields.listName.name())])
							.id(new BigInteger(fields[fieldsMap.get(Fields.id.name())]));
				}
				Product tmpProduct = new Product();
				tmpProduct.setName(fields[fieldsMap.get("name")]);
				tmpProduct.setQty(Integer.parseInt(fields[fieldsMap.get("qty")]));
				tmpProduct.setUnit(Unit.valueOf(fields[fieldsMap.get("unit")]));
				builder.addProduct(tmpProduct);
			}
		}
		return builder.build();
	}

	/**
	 * Salva un oggetto
	 */
	@Deprecated
	public void store() throws IOException {

		try {

			PrintWriter writer = new PrintWriter(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName));
			StringBuilder builder = new StringBuilder();

			if (this.getUniqueCode() == null) {
				this.uniqueCode = ShoppingList.generateUniqueKey(this.getId(), this.getListName());
			}

			for (Product listaTemp : products) {
				if (listaTemp == null) {
					continue;
				}
				builder.append(this.getId());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(this.getListName());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(this.getUniqueCode());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(listaTemp.getName());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(listaTemp.getQty());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(listaTemp.getUnit());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(System.getProperty("line.separator"));

			}

			writer.write(builder.toString());
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}

	}

	@Deprecated
	public static SortedSet<ShoppingList> getAll() throws IOException {
		try {
			List<String> lines = Files
					.readAllLines(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName).toPath());
			SortedSet<ShoppingList> shoppingLists = new TreeSet<ShoppingList>();
			ShoppingListBuilder builder = null;
			for (String line : lines) {
				String[] fields = line.split(ShoppingList.fieldSeparator);
				if (!fields[0].equals("")) {
					if (builder == null) {
						builder = ShoppingListBuilder.builder();
						builder.uniqueCode(fields[fieldsMap.get(Fields.uniqueCode.name())])
								.listName(fields[fieldsMap.get(Fields.listName.name())]);
					}
					Product tmpProduct = new Product();
					tmpProduct.setName(fields[fieldsMap.get("name")]);
					tmpProduct.setQty(Integer.parseInt(fields[fieldsMap.get("qty")]));
					tmpProduct.setUnit(Unit.valueOf(fields[fieldsMap.get("unit")]));
					builder.addProduct(tmpProduct);
				}
				shoppingLists.add(builder.build());

			}
			return shoppingLists;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	@Deprecated
	public void updateShoppingList() {

	}

	@Deprecated
	public void deleteShoppingList() {

	}

	/**
	 * Genera la unique key
	 * 
	 * @param id
	 * @param name
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@Deprecated
	private static String generateUniqueKey(BigInteger id, String name) throws StoreException {
		try {
			return URLEncoder.encode(AESHelper.encrypt(id + name, "EsedraShoppingList"),
					StandardCharsets.UTF_8.toString());
		} catch (Exception e) {
			throw new StoreException(e.getMessage());
		}

	}
}
