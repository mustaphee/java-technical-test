/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Lenovo
 */
public class Person {
    
    public static final char FIRST_FORMAT = '1';
    public static final char SECOND_FORMAT = '2';
   
    public static final String FIRST_FORMAT_SPLIT_STRING = ",";
    public static final String SECOND_FORMAT_SPLIT_STRING = " ; ";
    
    private final String name;
    private final String city;
    private final String id;
    public Person(char format, String line){
        line = line.substring(2);
        String splitString;
        if(format == FIRST_FORMAT) {
            splitString = FIRST_FORMAT_SPLIT_STRING;
        }
        else {
            splitString = SECOND_FORMAT_SPLIT_STRING;
        }
        String[] userData = line.split(splitString);
        this.name = userData[0];
        this.city = userData[1];
        this.id = userData[2].replace("-", "");;
    }
    
    public boolean compareId(String id){
        return this.id.equals(id);
    }

    @Override
    public boolean equals(Object obj) {
        Person other = (Person) obj;
        return (this.id == other.id);
    }
    
    public String toString() {
        return this.name + " " + this.city + " " + this.id;
    }

    public String getCity() {
        return this.city;
    }

    public boolean compareCity(String city) {
        
        return this.city.equals(city);
    }

    public String getName() {
        return this.name;
    }

    String getId() {
        return this.id;
    }

    String getNameAndId() {
        return this.name + "," + this.id;
    }
}
