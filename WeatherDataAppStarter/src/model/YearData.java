 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class YearData {
    
    private String year;
    private float precipitation;
    private int maxTemp;
    private int minTemp;
    private int windSpeed;
    private String windDirection;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    public YearData() {
        this.year = "TBC";
        this.precipitation = 0;
        this.maxTemp = 0;
        this.minTemp = 0;
        this.windSpeed = 0;
        this.windDirection = "TBC";
    }

    public YearData(String year, float precipitation, int maxTemp, int minTemp, int windSpeed, String windDirection) {
        this.year = year;
        this.precipitation = precipitation;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }
    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year=year;
    }
    public float getPrecipitation(){
        return precipitation;
    }
    public void setPrecipitation(float precipitation){
        this.precipitation=precipitation;
    }
    public int getMaxTemp(){
        return maxTemp;
    }
    public void setMaxTemp(int maxTemp){
        this.maxTemp=maxTemp;
    }
    public int getMinTemp(){
        return minTemp;
    }
    public void setMinTemp(int minTemp){
        this.minTemp=minTemp;
    }
    public String getWindDirection(){
        return windDirection;
    }
    public void setWindDirection(String windDirection){
        this.windDirection=windDirection;
    }
    public int getWindSpeed(){
        return windSpeed;
    }
    public void setWindSpeed(int windSpeed){
        this.windSpeed=windSpeed;
    }
    
    // Methods required: getters, setters

    @Override
    public String toString() {
        return "YearData{" + "year=" + year + ", precipitation=" + precipitation + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + '}';
    }
    
}
