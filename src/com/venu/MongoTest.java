package com.venu;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.cuesol.cc.customer.data.impl.CustomerDaoBase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoTest {

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException{
		Datastore ds = null;
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost");
			Mongo mongo = new MongoClient("localhost");
			ds = new Morphia().createDatastore(mongo, "mydb");
			DB db = mongoClient.getDB("mydb");
			Set<String> dbCollectionNames = db.getCollectionNames();
			//List<Customer> customerList = getCustomers();
			ObjectMapper mapper = new ObjectMapper();
			Long beforeTime = System.currentTimeMillis();
			DBCollection coll = db.getCollection("customer");
			coll.drop();
			for(int i = 0; i < 2; i++){
				Customer c = new Customer();
				c.setCredential("Credential " + i);
				c.setAlternateId("AlternateID " + i);
				c.setCcName("CCName : " + i);
				c.setEmailAddress("email@email.com : " + i);
				c.setLastName("Last Name : " + i);
				c.setFirstName("first name : " + i);
				c.setPersonId(i);
				Address address = new Address();
				address.setAptNumber("10"+i);
				address.setState("USState " + i);
				c.setAddress(address);
				ds.save(c);
			}
			/*for(Customer customer : customerList){
				
			}*/
			Long number = ds.createQuery(Customer.class).countAll();
			//Customer customer = ds.find(Customer.class).get();
			
			Long AfterTime = System.currentTimeMillis();
			System.out.println("Time taken for inserting data : " + ((AfterTime - beforeTime)/60) + " in ms");
			System.out.println("Customer : " + number);
			//List<Customer> customer = ds.find(Customer.class).asList().subList(0,1);
			//DBCursor cusror = db.getCollectionFromString("customer").find();
			int i = 0;
			/*while(cusror.hasNext()){
				i++;
				System.out.println(cusror.next());
				if(i >500){
					break;
				}
			}*/
			
			//System.out.println("NUmber of customers in db : " + customer.size());
			//System.out.println("Customer : " + customer.toString());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknow host");
		}
		finally{
			if(mongoClient != null){
				mongoClient.close();
			}
		}
		
	}
	
	private static List<Customer> getCustomers(){
		List<Customer> customer = new ArrayList<Customer>();
		Long beforeTime = System.currentTimeMillis();
		for(int i = 0; i < 5000000; i++){
			Customer c = new Customer();
			c.setCredential("Credential " + i);
			c.setAlternateId("AlternateID " + i);
			c.setCcName("CCName : " + i);
			c.setEmailAddress("email@email.com : " + i);
			c.setLastName("Last Name : " + i);
			c.setFirstName("first name : " + i);
			c.setPersonId(i);
			Address address = new Address();
			address.setAptNumber("10"+i);
			address.setState("USState " + i);
			c.setAddress(address);
			customer.add(c);
		}
		Long afterTime = System.currentTimeMillis();
		System.out.println("Time Spent creating objects : " + (afterTime - beforeTime) + " in ms");
		return customer;
	}
}
