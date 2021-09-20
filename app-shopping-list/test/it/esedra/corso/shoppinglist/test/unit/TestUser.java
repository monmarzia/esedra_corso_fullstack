package it.esedra.corso.shoppinglist.test.unit;

import java.io.IOException;

public class TestUser {

	public static void main(String[] args) throws IOException {
		/*try {
			StringBuilder sb = new StringBuilder();
			InputStream inputUser = new FileInputStream(GetFileResource.get("user.json", "test"));
			User user = null;
			int i;
			while((i = inputUser.read()) != -1) {
				sb.append((char) i);
			}
			String jsonStr = sb.toString();
			
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userJson = reader.readObject();
			JsonArray userArr = userJson.get("users").asJsonArray();
			for(Object el: userArr) {
				JsonObject tmpUser = (JsonObject)(el);
				
				user = UserBuilder.builder()
						.firstName(tmpUser.getString("firstName"))
						.lastName(tmpUser.getString("lastName"))
						.email(tmpUser.getString("email"))
						.mobilePhone(tmpUser.getString("mobilePhone"))
						.active(Boolean.parseBoolean(tmpUser.getString("isActive")))
						.privacyConsent(Boolean.parseBoolean(tmpUser.getString("isPrivacyConsent")))
						.newsletter(Boolean.parseBoolean(tmpUser.getString("isNewsletter")))
						.build();
				user.newUserId();
				user.store();
				Map<BigInteger, User> users = user.getStoredUsers();
				for(Map.Entry<BigInteger, User> entry: users.entrySet()) {
					System.out.println("User id: " + entry.getKey() + " - Nome: " + entry.getValue().getFirstName());
				}
//				SortedSet<User> users = user.getAll();
//				for(User usr: users) {
//					if(usr != null) {
//						System.out.println(usr.getFirstName());
//					}
//				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
	}

}
