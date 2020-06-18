/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdataapp;

import controllers.WeatherDataController;

/**
 *
 * @author mga
 */
public class WeatherDataApp {

    public static void run() {        
        System.out.println("Weather App\n===========\n\n");
        
        WeatherDataController weatherController = new WeatherDataController();  
        
        weatherController.run();
        
        System.out.println("Thank you for using Weather App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WeatherDataApp weatherApp = new WeatherDataApp();
        weatherApp.run();
    }
}
