package com.app.database;

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
	
	static String connectionString = "mongodb+srv://piebytwo014:piebytwo014@cluster0.khi39l2.mongodb.net/?appName=Cluster0";

    static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

    static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
	static MongoClient mongoClient = MongoClients.create(settings);
	static MongoDatabase database = mongoClient.getDatabase("sec_a");
	static MongoCollection<Document> c = database.getCollection("userdata");
	
	
	
	public static Document loginUser(String email) {
		Document user = new Document("userEmail", email);
		Document userFound = c.find(user).first();
		if(userFound != null) {
			return userFound;
		}
		return null;
	}
	
	public static boolean verifyUser(String mail) {
		try {
			Document userToBeSearched = new Document("userEmail", mail);
			Document userFound = c.find(userToBeSearched).first();
			if(userFound != null) {
				Document updatedData = new Document("$set", new Document("isVerified", true));
				c.findOneAndUpdate(userFound, updatedData);
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

