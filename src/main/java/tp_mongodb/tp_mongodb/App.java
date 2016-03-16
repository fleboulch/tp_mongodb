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
        
        Person p = new Person();
        p.setName("Florent");

        Address address = new Address();
        address.setStreet("rue Duhamel");
        address.setCity("Rennes");
        address.setPostCode("35000");
        address.setCountry("France");
        
        List<Address> addresses = new ArrayList<Address>();
        
        addresses.add(address);
        
        //set address
        p.setAddresses(addresses);
        
        List<Article> articles = fillBaseWithArticles();
        for (Article art : articles) {
        	ds.save(art);
        }
        
        // Save the POJO
        ds.save(address);
        ds.save(p);
        
        System.out.println("-------------- PERSON --------------");
        for (Person e : ds.find(Person.class))
             System.out.println(e);
        
        System.out.println("-------------- ARTICLE --------------");
        for (Article a : ds.find(Article.class))
            System.out.println(a);

    }
    
    private static List<Article> fillBaseWithArticles() {
    	List<Article> articles = new ArrayList<Article>();
    	
    	Article a1 = new Article();
    	a1.setName("Vélo");
    	a1.setStars(4);
//    	a1.setBuyers(buyers);
    	
    	articles.add(a1);
    	
    	return articles;
    }
    
//    private static List<Person> fillBaseWithPersons() {
//    	
//    }
}
