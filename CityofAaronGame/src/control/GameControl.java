package control;

import java.util.ArrayList;
import java.util.Random;
import model.Animal;
import model.Condition;
import model.Game;
import model.InventoryItem;
import model.ItemType;
import model.Map;
import model.Player;
import model.Provision;
import model.Storehouse;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */

public class GameControl {
    
    private static Random randomGenerator = new Random();
    
    /**
     * Protected setter for tests to inject a mock random object.
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        randomGenerator = random;
    }
    
    public static Game createNewGame(String thePlayer) {
        Player player = new Player();
        player.setName(thePlayer);
        player.setRound(1);

        Game theGame = new Game();
        Storehouse theStorehouse = new Storehouse();
        theGame.setTheStorehouse(theStorehouse);
        theGame.setThePlayer(player);
        theGame.setCurrentPopulation(100);
        theGame.setAcresOwned(1000);
        theGame.setWheatInStorage(2700);
        theGame.setYear(1);
        
        // create the map (call MapControl)
        Map thisMap = new Map();
        thisMap = MapControl.createMap(thisMap);
        // set this map to this game
        theGame.setTheMap(thisMap);

//        // set up theStorehouse, pull it from theGame
        //Storehouse theStorehouse = theGame.getTheStorehouse();
//
//        // initialize Storehouse elements
        theStorehouse.setAnimals(new ArrayList<Animal>());
        theStorehouse.setTools(new ArrayList<InventoryItem>());
        theStorehouse.setProvisions(new ArrayList<Provision>());
//
//        //object{ type: ItemType.Animal, name:"Bears", quantity: 2, condition: Condition.Good, age: 30 }
//        // set up an animal (one type for now!)
        ArrayList<Animal> animals = theStorehouse.getAnimals(); // this is for the Storehouse class
        Animal cows = new Animal(); // this is for the InventoryItem class
        cows.setType(ItemType.Animal); // InventoryItem class...
        cows.setQuantity(2); // InventoryItem class...
        cows.setCondition(Condition.Good); // InventoryItem class...
//        // let's have two animals, ages as follows
        ArrayList<Integer> ages = new ArrayList<Integer>();
        ages.add(10);
        ages.add(12);
        cows.setAge(ages); // does this line even work?
        cows.setName("Cows"); // InventoryItem class, or Animal class?
        animals.add(cows); // now add it to the Storehouse!
//
//        // set up a provision (one for now!)
        ArrayList<Provision> provisions = theStorehouse.getProvisions(); // this is for the Storehouse class
        Provision bread = new Provision(); // this is for the Provision class
        bread.setType(ItemType.Provision); // InventoryItem class...
        bread.setQuantity(200); // InventoryItem class...
        bread.setCondition(Condition.Good); // InventoryItem class...
        bread.setName("Bread"); // Provision class...
        bread.setPerishable(true); // Provision class...
        provisions.add(bread); // now add it to the Storehouse!
//
//        // SECOND provision
//        // set up a provision (one for now!)
//        Provision corn = new Provision(); // this is for the Provision class
//        corn.setType(ItemType.Provision); // InventoryItem class...
//        corn.setQuantity(500); // InventoryItem class...
//        corn.setCondition(Condition.Good); // InventoryItem class...
//        corn.setName("Corn Ears (dried)"); // Provision class...
//        corn.setPerishable(false); // Provision class...
//        provisions.add(corn); // now add it to the Storehouse!
//        
//        // set up a tool (one for now!)
        ArrayList<InventoryItem> tools = theStorehouse.getTools(); // this is for the Storehouse class
        InventoryItem tool = new InventoryItem(); // this is for the InventoryItem class
        tool.setName("Shovel"); // InventoryItem class...
        tool.setType(ItemType.Tool); // InventoryItem class...
        tool.setQuantity(26); // InventoryItem class...
        tool.setCondition(Condition.Good); // InventoryItem class...
        tools.add(tool); // now add it to the Storehouse!
//
//        // END AMBER TESTS
        
        return theGame;
    }
    
    public static Player savePlayer(String name){
        System.out.println("*** savePlayer() called ***");
        return new Player();
    }
    
    /**
     * Generates a random integer between lowValue and highValue, inclusive.
     * <ul>Requirements:
     * <li>lowValue and highValue must be positive int (&gt;= 0) (return -1)</li>
     * <li>highValue must be greater than lowValue (return -2) </li>
     * <li>highValue cannot be equal to the max value for int (return -3)</li>
     * </ul>
     * @param lowValue
     * @param highValue
     * @return The random number
     */
    public static int getRandomNumber(int lowValue, int highValue) {
        // if low < 0 or high < 0 then return -1
        if (lowValue < 0 || highValue < 0) {
            return -1;
        }
        // if high <= low then return -2
        if (highValue <= lowValue) {
            return -2;
        }
        
        // if high is the max val for int, then return -3
        if (highValue == Integer.MAX_VALUE) {
            return -3;
        }
        
        // calc the size of the range; add one so Random() includes high val
        int range = (highValue - lowValue) + 1;
        
        
        // return low + random(range size)
        return lowValue + randomGenerator.nextInt(range);
        
    }

}
