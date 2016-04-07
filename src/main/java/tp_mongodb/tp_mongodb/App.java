package tp_mongodb.tp_mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import entities.Address;
import entities.Article;
import entities.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws UnknownHostException
    {
        System.out.println( "Hello World!" );
       
        Morphia morphia = new Morphia();    
        Mongo mongo = new Mongo();
        
        morphia.map(Person.class).map(Address.class);
        
        String dbName = "my_database";
        Datastore ds = morphia.createDatastore(mongo, dbName);
        
        mongo.dropDatabase(dbName); // drop the db
        
        List<Address> addresses = fillBaseWithAddresses();
        for (Address addr : addresses) {
        	ds.save(addr);
        }
        
        // save persons
        List<Person> persons = fillBaseWithPersons(addresses);
        for (Person p : persons) {
        	ds.save(p);
        }
        
        List<Article> articles = fillBaseWithArticles(persons);
        for (Article art : articles) {
        	ds.save(art);
        }
        
        System.out.println("-------------- PERSON --------------");
        for (Person e : ds.find(Person.class))
             System.out.println(e);
        
        System.out.println("-------------- ARTICLE --------------");
        for (Article a : ds.find(Article.class))
            System.out.println(a);

    }
    
    private static List<Address> fillBaseWithAddresses() {
        List<Address> addresses = new ArrayList<Address>();
    	
    	Address address = new Address();
        address.setStreet("rue Duhamel");
        address.setCity("Rennes");
        address.setPostCode("35000");
        address.setCountry("France");
        
        addresses.add(address);
        
        Address address2 = new Address();
        address2.setStreet("rue Anatole France");
        address2.setCity("Levallois-Perret");
        address2.setPostCode("92300");
        address2.setCountry("France");
        
        addresses.add(address2);
        
        return addresses;
    }
    
    private static List<Person> fillBaseWithPersons(List<Address> addresses) {
    	List <Person> persons = new ArrayList<Person>(); 
    	Person p = new Person();
        p.setName("Florent");
         
        //set address
        ArrayList<Address> addressesOfP = (ArrayList<Address>) ((ArrayList<Address>) addresses).clone();
        addressesOfP.remove(0);
        
        p.setAddresses(addressesOfP);
        
        persons.add(p);
        
        Person p2 = new Person();
        p2.setName("Rémi");
         
        //set address
        ArrayList<Address> addressesOfP2 = (ArrayList<Address>) ((ArrayList<Address>) addresses).clone();
        addressesOfP2.remove(1);
        p2.setAddresses(addressesOfP2);
        
        persons.add(p2);
        
        return persons;
         
    }
    
    private static List<Article> fillBaseWithArticles(List<Person> buyers) {
    	List<Article> articles = new ArrayList<Article>();
    	
    	Article a1 = new Article();
    	a1.setName("Vélo");
    	a1.setStars(2);
    	
    	ArrayList<Person> buyersOfA1 = (ArrayList<Person>) ((ArrayList<Person>) buyers).clone();
        buyersOfA1.remove(0);
    	a1.setBuyers(buyersOfA1);
    	
    	articles.add(a1);
    	
    	Article a2 = new Article();
    	a2.setName("Ordinateur");
    	a2.setStars(5);
    	
    	ArrayList<Person> buyersOfA2 = (ArrayList<Person>) ((ArrayList<Person>) buyers).clone();
        buyersOfA2.remove(1);
    	a2.setBuyers(buyersOfA2);
    	
    	articles.add(a2);
    	
    	return articles;
    }
    
}
