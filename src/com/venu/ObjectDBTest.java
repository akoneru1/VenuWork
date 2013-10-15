package com.venu;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class ObjectDBTest {

	public static void main(String args[]){
		EntityManagerFactory emf = null;
		try{
			emf = Persistence.createEntityManagerFactory("db/modivapp.odb");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			for(int i = 0; i < 10; i++){
				Customer c = new Customer();
				c.setCredential("Credential " + i);
				c.setAlternateId("AlternateID " + i);
				c.setCcName("CCName : " + i);
				c.setEmailAddress("email@email.com : " + i);
				c.setLastName("Last Name : " + i);
				c.setFirstName("first name : " + i);
				c.setPersonId(i);
				Address add = new Address();
				add.setAptNumber("AptNum " + i);
				add.setState("state " + i);
				add.setStreetName("streetName " + i);
				add.setZipCode("zipCode " + i);
				c.setAddress(add);
				System.out.println(c.toString());
				em.persist(c);
			}
			em.getTransaction().commit();
			TypedQuery<Customer> query =
		            em.createQuery("SELECT a FROM Customer a", Customer.class);
		        List<Customer> results = query.getResultList();
		        for (Customer p : results) {
		            System.out.println(p);
		        }
		}catch(Exception e){
			
		}finally{
			if(emf != null){
				emf.close();
			}
		}
			
		
	}
}
