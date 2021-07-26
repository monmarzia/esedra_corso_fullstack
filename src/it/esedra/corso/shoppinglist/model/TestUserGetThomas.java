package it.esedra.corso.shoppinglist.model;




import java.io.BufferedReader;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import it.esedra.corso.shoppinglist.helper.GetFileResource;

/**
 * @author monica
 *
 */
public class TestUserGetThomas  {
	private static BigInteger id = new BigInteger("0");
	private BigInteger userId = id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;
	private final static String[] campi = {		
			"userId",
			"firstName",
			"lastName",
			"email",
			"mobilePhone",
			"isActive",
			"isPrivacyConsent",
			"isNewsletter",
	};
	private final static HashMap<String, String> fieldsMap = new HashMap<>() ;
	static {		
		for(int i = 0 ; i < campi.length; i++) {
			fieldsMap.put(campi[i],null ); // mi aggiunge alla mappa tutti i campi con le chiavi null cos� dopo posso richiamare i campi e rimpiazzare il null con la chiave desiderata
		}
	}

	
	public TestUserGetThomas() {
		
	}
	

	public TestUserGetThomas(String firstName, String lastName, String email, String mobilePhone, boolean isActive, boolean privacyConsent, boolean newsletter) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.isActive = isActive;
		this.privacyConsent = privacyConsent;
		this.newsletter = newsletter;
	}
	
	/**
	 * 
	 * @return new User()
	 * restituisce un'istanza di User con i parametri nell'ordine
	 */
	public TestUserGetThomas build() {
		return new TestUserGetThomas(firstName, lastName, email, mobilePhone, isActive, privacyConsent, newsletter);
	}

	public BigInteger getUserId() {
		return userId;
	}

	public TestUserGetThomas setUserId(BigInteger userId) {
		this.userId = userId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public TestUserGetThomas setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public TestUserGetThomas setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public TestUserGetThomas setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public boolean isPrivacyConsent() {
		return privacyConsent;
	}
	
	public TestUserGetThomas setPrivacyConsent(boolean privacyConsent) {
		this.privacyConsent = privacyConsent;
		return this;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public TestUserGetThomas setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public TestUserGetThomas setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public TestUserGetThomas setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
		return this;
	}
	
	/**
	 * 
	 * @return userID incrementato di 1
	 * 
	 * Testato l'incremento: il secondo user ha userId = 2;
	 */
	
	public BigInteger getSequence() {
		id = id.add(BigInteger.ONE);
		return userId = id ;
	}
	
	
	public void aggiornaMappa(String[] fields) {
		
		for(int i = 0 ; i < campi.length; i++) {
			fieldsMap.replace(campi[i],fields[i] );
		}
	}
	

	public static void main(String[] args) throws IOException {
		TestUserGetThomas prova = new TestUserGetThomas();
		prova.getAll();
	}
	
	public TestUserGetThomas get(BigInteger findId) throws IOException {		
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
			TestUserGetThomas user = null;
			for(String line:lines) {
				String[] fields = line.split(",") ;				
				aggiornaMappa(fields);
				BigInteger tmpUserId = new BigInteger(fieldsMap.get("userId"));
				if (tmpUserId.equals(findId)) {
					user = new TestUserGetThomas();					
					user.setFirstName(fieldsMap.get("firstName"));
					user.setLastName(fieldsMap.get("lastName"));
					user.setEmail(fieldsMap.get("email"));					
					user.setMobilePhone(fieldsMap.get("mobilePhone"));
					user.setActive(Boolean.parseBoolean(fieldsMap.get("isActive")));
					user.setPrivacyConsent(Boolean.parseBoolean(fieldsMap.get("isPrivacyConsent")));
					user.setNewsletter(Boolean.parseBoolean(fieldsMap.get("isNewsletter")));					
					user.setUserId(tmpUserId);
				}
			}
			return user;
		} catch (Exception e) {
			throw new IOException();
		}
				
	}
	
	/*
	 * @return SortedSet users
	 * 
	 * Restituisce un TreeSet di User ordinato secondo userId:
	 * Manca l'implementazione dell'interfaccia Comparator in una classe da utilizzare per l'ordinamento:
	 * 
	 * public class UserComparator implements Comparator<User> {
	 * 	@Override 
	 * 		public int compare(User o1, User o2) {
	 * 			return o1.getUserId().compareTo(o2.getUserId();
	 * 		}
	 * }
	 * 
	 * Costruire il TreeSet usando il comparator e il metodo Collections.syncronizedSortedSet
	 * 
	 * SortedSet users = Collections.syncronizedSortedSet(new TreeSet<User>(new UserComparator()));
	 */
	public void getAll() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
	
			for(String line:lines) {				
				String[] fields = line.split(",");
				aggiornaMappa(fields);
				if (!fieldsMap.get("userId").equals("")) {					
					System.out.println(new BigInteger(fieldsMap.get("userId")));
					System.out.println(fieldsMap.get("firstName"));
					System.out.println(fieldsMap.get("lastName"));
					System.out.println(fieldsMap.get("email"));					
					System.out.println(fieldsMap.get("mobilePhone"));
					System.out.println(Boolean.parseBoolean(fieldsMap.get("isActive")));
					System.out.println(Boolean.parseBoolean(fieldsMap.get("isPrivacyConsent")));
					System.out.println(Boolean.parseBoolean(fieldsMap.get("isNewsletter")));				

				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}		
	}
	
	/**
	 * 
	 * @return l'id più in alto assegnato
	 * @throws IOException
	 */
	


	/**

	 * 
	 * Salva un oggetto user nel file user.csv:
	 * Se il file è vuoto, crea un nuovo utente con id=1
	 * Se il file non è vuoto, controlla che userId sia maggiore di getLastId() e che getAll() non
	 * contenga un utente con lo stesso userId: verificate le condizioni procede con lo store
	 * In caso contrario si può procedere con l'update, non implementato.
	 * L'implementazione dell'update richiede la possibilità di sovrascrivere una riga del file.
	 * Il metodo get(userId) non è ancora stato utilizzato.
	 * 
	 */
	
	/**
	 * Restituisce un nuovo oggetto User
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public TestUserGetThomas get() throws IOException {
		
		BufferedReader br = Files.newBufferedReader(GetFileResource.get("user.csv", "shoppinglist").toPath());
		
		
		String line = br.readLine();
		
		TestUserGetThomas user = null;
		
		while (line != null) {
			String[] fields = line.split(",");
			aggiornaMappa(fields);		
			BigInteger tmpUserId = new BigInteger(fieldsMap.get("userId"));
			if (tmpUserId.equals(this.getUserId())) {
				user = new TestUserGetThomas();
				user.setFirstName(fieldsMap.get("firstName"));
				user.setLastName(fieldsMap.get("lastName"));
				user.setEmail(fieldsMap.get("email"));					
				user.setMobilePhone(fieldsMap.get("mobilePhone"));
				user.setActive(Boolean.parseBoolean(fieldsMap.get("isActive")));
				user.setPrivacyConsent(Boolean.parseBoolean(fieldsMap.get("isPrivacyConsent")));
				user.setNewsletter(Boolean.parseBoolean(fieldsMap.get("isNewsletter")));				
				user.setUserId(tmpUserId);
			}
			
		}
		
		return new TestUserGetThomas();
	}
	
	/**
	 * Salva un oggetto user
	 */
  




	

}
