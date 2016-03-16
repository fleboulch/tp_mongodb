package entities;

import java.util.List;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("Article")
public class Article {
	@Id
	private ObjectId id;

	private String name;
	
	private int stars;
	
	@Reference
	private List<Person> buyers;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStars() {
		return stars;
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public List<Person> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<Person> buyers) {
		this.buyers = buyers;
	}

	private String printStars() {
		String resu = "";
		for (int i=1; i<=stars; i++) {
			resu += "*";
		}
		return resu;
	}
	
	public String toString() {
		return name + " "+printStars() + " "+ buyers;
	}

}
