package router_receiver.router_receiver;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class dao {
	public void connect() {		
		MongoClient mongoClient = MongoClients.create("mongodb://14.63.168.58:27017");
		MongoDatabase database = mongoClient.getDatabase("router_log");
		MongoCollection<Document> collection = database.getCollection("router_log");
		FindIterable<Document> doc = collection.find(eq("1", "a"));
		MongoCursor<Document> cursor = doc.iterator();
		while (cursor.hasNext()) {
			String res = cursor.next().toJson();
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		dao d = new dao();
		d.connect();
	}	
}
