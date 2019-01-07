/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    private static final String OPERATION_FIND_CITY = "CITY";
    private static final String OPERATION_FIND_ID = "ID";
    public static ArrayList<Person> readInput(String filename) {
        // TODO code application logic here
        
        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<Person> people = new ArrayList<Person>();
        char currentFormat = Person.FIRST_FORMAT;
        try{
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                if(currentLine.charAt(0) == 'F'){
                    if(currentLine.charAt(1) == Person.FIRST_FORMAT){
                        currentFormat = Person.FIRST_FORMAT;
                    }
                    else{
                        currentFormat = Person.SECOND_FORMAT;
                    }
                }
                else{
                    people.add(new Person(currentFormat, currentLine));
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(br != null)
                    br.close();
                
                if(fr != null)
                    fr.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return people;
    }
    
    public static void printCities(ArrayList<Person> people, String personID) {
        ArrayList<String> cities = new ArrayList<String> ();
        for(Person person: people){
            if (person.compareId(personID) && !cities.contains(person.getCity())) {
                cities.add(person.getCity());
            }
        }
        for(String city: cities){
            System.out.println(city);
        }
    }
    
    public static void printPeopleToCity(ArrayList<Person> people, String city) {
        ArrayList<String> cityPeople = new ArrayList<String> ();
        for(Person person: people){
            if (person.compareCity(city) && !cityPeople.contains(person.getNameAndId())) {
                cityPeople.add(person.getNameAndId());
            }
        }
        for(String name: cityPeople){
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        String operationType = args[1];
        if (operationType.equals(OPERATION_FIND_CITY)) {
            String cityName = args[2];
            ArrayList<Person> people = readInput(filename);
            printPeopleToCity(people, cityName);
        }
        else if(operationType.equals(OPERATION_FIND_ID)){
            String id = args[2];
            ArrayList<Person> people = readInput(filename);
            printCities(people, id);
        }
        else{
            System.out.println(operationType);
            System.out.println(args);
            System.out.println("Invalid command");
        }
    }
}