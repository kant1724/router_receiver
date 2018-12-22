package router_receiver.router_receiver;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
        Date a = new Date();
        Date b = new Date();
        String date = sdf1.format(a);
        String time = sdf2.format(b);
		Document d1 = new Document();
		d1.put("ip", ip);
		d1.put("date", date);
		d1.put("hour", time.substring(0, 2));
		d1.put("minute", time.substring(2, 4));
		d1.put("seconds", time.substring(4, 6));
		d1.put("log", log);
		collection.insertOne(d1);
	}
	
	public static void main(String[] args) {
		dao d = new dao();
		d.connect();
	}	
}
