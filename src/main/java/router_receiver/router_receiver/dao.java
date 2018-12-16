package router_receiver.router_receiver;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class dao {
	MongoClient mongoClient;
	MongoDatabase database;
	public void connect() {		
		mongoClient = MongoClients.create("mongodb://14.63.168.58:27017");
		database = mongoClient.getDatabase("router_log");
		MongoCollection<Document> collection = database.getCollection("router_log");
		FindIterable<Document> doc = collection.find();
		MongoCursor<Document> cursor = doc.iterator();
		while (cursor.hasNext()) {
			String res = cursor.next().toJson();
			System.out.println(res);
		}
	}
	
	public void insertRow(String ip, String log) {		
		MongoCollection<Document> collection = database.getCollection("router_log");
		Document d1 = new Document("log", log);
		Document d2 = new Document("ip", ip);
		List<Document> d = new ArrayList<Document>();
		d.add(d1);
		d.add(d2);
		collection.insertMany(d);
	}
	
	public static void main(String[] args) {
		dao d = new dao();
		d.connect();
	}	
}
