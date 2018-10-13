/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

import java.util.*;
import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;
import model.Animal;
import model.Author;
import model.Provision;
import model.InventoryItem;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        Game theGame = new Game();
        theGame.setThePlayer(new Player());
        theGame.setTheMap(new Map());
        //theGame.setTheStorehouse(new Storehouse());
        theGame.setCurrentPopulation(105);
        theGame.setAcresOwned(2000);
        theGame.setWheatInStorage(3000);
        
       System.out.println(theGame.toString());
       //end of game test
       
        //Amy Test
        Storehouse theStorehouse = new Storehouse();
        
        ArrayList<String> animals = new ArrayList<String>();
        animals.add("Cow");
        theStorehouse.setAnimals(animals);
      
      //Provisions
               
               
       
        
        
        
       System.out.println(theStorehouse.toString());
        
        

    }

}