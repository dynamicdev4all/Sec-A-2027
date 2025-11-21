package com.app.database;

import com.app.config.AppSecretReader;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import shadow.org.bson.Document;

public class DatabaseConnection {
	static String DB_USERNAME=AppSecretReader.getPropertiesData("MONGO_DB_USERNAME","en", "US");
	static String DB_PASSWORD=AppSecretReader.getPropertiesData("MONGO_DB_PASSWORD","en", "US");
	
	static String connectionString = "mongodb+srv://"+DB_USERNAME+":"+DB_PASSWORD+"@cluster0.khi39l2.mongodb.net/?appName=Cluster0";

    static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

    static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
	static MongoClient mongoClient = MongoClients.create(settings);
	static String DB_NAME=AppSecretReader.getPropertiesData("MONGO_DB_NAME","en", "US");
	static String COL_NAME=AppSecretReader.getPropertiesData("MONGO_COL_NAME","en", "US");
	static MongoDatabase database = mongoClient.getDatabase(DB_NAME);
	static MongoCollection<Document> c = database.getCollection(COL_NAME);
	
	
	
	public static Document findUserInDB(String email) {
		Document user = new Document("userEmail", email);
		Document userFound = c.find(user).first();
		if(userFound != null) {
			return userFound;
		}
		return null;
	}
	
	
	public static boolean verifyUser(String mail) {
		try {
			Document user = findUserInDB(mail);
			if(user !=null) {
				Document updatedData = new Document("$set", new Document("isVerified", true));
				c.findOneAndUpdate(user, updatedData);
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	
	}
	
	
	public static boolean insertUserData(String fName, String lName, String userMail, String userPwd) {	 
		try {
			
			Document user = findUserInDB(userMail);
			if(user != null) {
				return false;
			}
			c.insertOne(new Document("firstName", fName)
					.append("lastName", lName)
					.append("userEmail", userMail)
					.append("userPassword", userPwd)
					.append("isVerified", false));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

