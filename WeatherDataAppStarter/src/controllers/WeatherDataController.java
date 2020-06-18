/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import model.City;
import model.YearData;
import repositories.Repository;


/**
 *
 * @author mga
 */
public class WeatherDataController {
 
    private final Repository repository;
    
    
    public WeatherDataController() {
        
       // to be completed
       InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing File(Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter File Name: ");               
            this.repository = new Repository(fileName);
        }
        else {
            this.repository = new Repository();
        }
    }
   
    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A': 
                    addCity();
                    break;
                case 'B':  
                    addYearData();
                    break;
                case 'C': 
                    listCountryCityWeatherDataInCityNameOrder();
                    break;                    
                case 'D': 
                    listCityAverages();
                    break;
                case 'Q': 
                    finished = true;
            }
        } while (!finished);
    }
    
    private char displayMenu() {
        listCityWeatherDataInCityIdOrder();
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add City");
        System.out.print("\tB. Add new year data");        
        System.out.print("\tC. List Country Data In City Name Order");
        System.out.print("\tD. List City Average Data");       
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }    
    
    private void addCity() {
        InputHelper inputHelper = new InputHelper();
        String cityName = inputHelper.readString("Enter city name");
        String country = inputHelper.readString("Enter Country");    
        City newCity = new City(cityName, country);               
        repository.add(newCity);
       
    }
    
    private void addYearData() {        
       InputHelper inputHelper = new InputHelper();
        boolean validId = false;
        City requiredCity=null;
        do {
            int Id = inputHelper.readInt("Enter City Id");
            requiredCity = repository.getItem(Id);           
            if (requiredCity != null) {
                validId = true;
            }
        } while (!validId);
        System.out.println("City \n========\n" + requiredCity);
        String year = inputHelper.readString("Enter Year");
        float precipitation = inputHelper.readFloat("Enter Precipitation");
        int maxTemp  = inputHelper.readInt("Enter max Temp");
        int minTemp  = inputHelper.readInt("Enter min Temp");
        int windSpeed = inputHelper.readInt("Enter wind speed");
        String windDirection = inputHelper.readString("Enter wind direction");
        YearData newYearData = new YearData(year,precipitation,maxTemp,minTemp,windSpeed,windDirection);               
        requiredCity.addYearData(newYearData);
    }

    private void listCountryCityWeatherDataInCityNameOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "City Name Order");
        System.out.format("\033[31m%s\033[0m%n", "===============");
        Set <City> newSet = new TreeSet(City.CityNameComparator);           
        newSet.addAll(repository.getItems());
        System.out.println(newSet);
 

        
}    
    
    private void listCityAverages() {
        System.out.format("\033[31m%s\033[0m%n", "City Average Data");
        System.out.format("\033[31m%s\033[0m%n", "================="); 
       
   /* Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            if();


// List<City> p = new ArrayList<>();
        //Double average = p.stream().mapToDouble(val -> val).average().orElse(0.0);
             
            
         
            System.out.println("Precipitation average: " + average());
            System.out.println("Max temperature average: " + ());
            System.out.println("Min temperature average: " + ());
   */ 
    }
      
    // float precipitation,   int max temp, int min temp 
    private void listCityWeatherDataInCityIdOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "City Id Order");
        System.out.format("\033[31m%s\033[0m%n", "=============");
      Iterator it = repository.getItems().listIterator();
         while (it.hasNext()) {
             City c = (City) it.next();
            System.out.println(c);
       
    }     
}
}
