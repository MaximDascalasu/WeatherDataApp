/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mga
 */
public class City {
    private final int id;
    private String cityName;
    private String country;
    private List<YearData> yearDataCollection;
    
    private static int lastIdAllocated = 0;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    public City() {
        this.id = ++lastIdAllocated;
        this.cityName = "TBC";
        this.country = "TBC";
        this.yearDataCollection = new ArrayList<>();        
    }

    public City(String cityName, String country) {
        this.id = ++lastIdAllocated;
        this.cityName = cityName;
        this.country = country;
        this.yearDataCollection = new ArrayList<>();
    }

    public City(String cityName, String country, List<YearData> yearDataCollection) {
        this.id = ++lastIdAllocated;        
        this.cityName = cityName;
        this.country = country;
        this.yearDataCollection = yearDataCollection;
    }

    public City(int id, String cityName, String country, List<YearData> yearDataCollection) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.yearDataCollection = yearDataCollection;
        if (id > City.lastIdAllocated)
            City.lastIdAllocated = id;            
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }  
    public String getCityName(){
        return cityName;
    }
    public void setCityName(String cityName){
        this.cityName=cityName;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country=country;
    }
    public List<YearData> getYearDataCollection(){
        return yearDataCollection;
    }
    public void setYearDataCollection(List<YearData> yearDataCollection){
        this.yearDataCollection=yearDataCollection;
    }
    public void addYearData(YearData yearData) {
        this.yearDataCollection.add(yearData);
    } 
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return getId() * 31 + getCityName().hashCode() * 31 + getCountry().hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) {
            City c = (City) obj;
             return c.getId() == getId()&&
                    c.getCityName().equals(getCityName())&&
                    c.getCountry().equals(getCountry());
                    
          }else {
      return false;
        }
    }
         
    /**
     *
     */
    public static Comparator<City> 
           CityNameComparator = (City c1, City c2) -> {
               String city1 = c1.getCityName();
               String city2 = c2.getCityName();
               
               //ascending order
               return city1.compareTo(city2);
               
               //descending order
               // return city2.compareTo(city1);
    };
    
   public int compareTo(City compareCity) {
	
		int cityId = ((City) compareCity).getId(); 
		
		//ascending order
		return this.id - cityId;
		
		//descending order
		//return customerId - this.custId;
	
                
    }

// Methods required: getters, setters, add, hashCode, equals, compareTo, comparator

    @Override
    public String toString() {
        return "\nCity Id: " + id + " - City Name: " + cityName +            
                " - Country: " + country + "\nData: " + yearDataCollection + "\n";
    }
/*    
 public String toString(char delimiter) {
        final char EOLN = '\n';
        final String QUOTE = "\"";
        
        String output;
        output = Integer.toString(this.id) + delimiter +
                QUOTE + this.cityName + QUOTE + delimiter +
                this.country+ EOLN +delimiter+
                List<YearData>.toString(this.yearDataCollection)+EOLN;
         for (YearData yearData : this.yearDataCollection)
          output += yearData.toString(delimiter);
       return output;                
    }*/
    


}
   