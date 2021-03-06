package com.luxoft.springioc.lab3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("person")
public class UsualPerson implements Person {
	
	public static int createdPersons = 0;

    @Value("${person.id}")
    private  int id;

    @Value("${person.name}")
    private String name;

    @Autowired
    private Country country;

    @Value("${person.age}")
    private int age;

    @Value("${person.height}")
    private float height;

    @Value("${person.isProgrammer}")
    private boolean isProgrammer;

    @Value("${person.isRegistered}")
    private  boolean isRegistered;

	private  List<String> contacts;

//    public UsualPerson(@Value("${person.id}") int id,
//                       @Value("${person.name}") String name,
//                       @Value("${person.age}")int age,
//                       @Value("${person.height}") float height,
//                       @Value("${person.isProgrammer}") boolean isProgrammer,
//                       @Value("${person.isRegistered}") boolean isRegistered)
//    {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.height = height;
//        this.isProgrammer = isProgrammer;
//        this.isRegistered = isRegistered;
//    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello(Person person) {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setProgrammer(boolean programmer) {
        isProgrammer = programmer;
    }
    
    public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        String s = "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Height: " + height + "\n"
                + "Country: " + country + "\n"
                + "Is Programmer?: " + isProgrammer + "\n"
                + "Is Registered?: " + isRegistered + "\n";
        if ((contacts != null) && (!contacts.isEmpty())) {
            s += "Contacts: ";
            for (String contact : contacts) {
                s += contact + ", ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsualPerson person = (UsualPerson) o;

        if (age != person.age) return false;
        if (Float.compare(person.height, height) != 0) return false;
        if (isProgrammer != person.isProgrammer) return false;
        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (isProgrammer ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

}