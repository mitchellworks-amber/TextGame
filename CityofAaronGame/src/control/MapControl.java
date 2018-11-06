package control;

import app.CityOfAaron;
import model.Location;
import model.Map;
import model.Point;
import model.Game;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class MapControl extends Map {

    public static Map createMap(Map mainMap) {
        //Initialize the map and locations
        Location[][] allLocations = new Location[5][5];

        // start filling the locations array
        Location theRiver = new Location();
        theRiver.setName("River");
        theRiver.setDescription("The lifeblood of the City of Aaron.");
        theRiver.setMapSymbol("\u021c");
        theRiver.setGameTip("The river keeps our population healthy! This is why all the villages are near the river.");
        // set the river locations in their spots in the 5x5 grid
        allLocations[0][0] = theRiver;
        allLocations[1][1] = theRiver;
        allLocations[3][3] = theRiver;
        allLocations[4][4] = theRiver;

        Location theGrasslands = new Location();
        theGrasslands.setName("Grasslands");
        theGrasslands.setDescription("For grazing flocks and herds.");
        theGrasslands.setMapSymbol("\u04c2");
        theGrasslands.setGameTip("The grasslands and stables are part of our Storehouse, \nproviding much needed field plow help and meat and dairy.");
        // set the locations in their spots in the 5x5 grid
        allLocations[0][1] = theGrasslands;
        allLocations[1][0] = theGrasslands;
        allLocations[4][2] = theGrasslands;
        allLocations[4][3] = theGrasslands;

        Location theWheat = new Location();
        theWheat.setName("Wheat fields");
        theWheat.setDescription("The staff of life.");
        theWheat.setMapSymbol("\u0482");
        theWheat.setGameTip("Wheat sustains our population. It takes 20 bushels per year to feed a person.");
        // set the locations in their spots in the 5x5 grid
        allLocations[0][2] = theWheat;
        allLocations[0][3] = theWheat;
        allLocations[0][4] = theWheat;
        allLocations[1][4] = theWheat;
        allLocations[2][4] = theWheat;
        allLocations[3][4] = theWheat;

        Location theVillages = new Location();
        theVillages.setName("Village");
        theVillages.setDescription("There are four villages in the City of Aaron.");
        theVillages.setMapSymbol("\u04c2");
        theVillages.setGameTip("When people in our villages are faithful, they are blessed of the Lord.");
        // set the locations in their spots in the 5x5 grid
        allLocations[1][2] = theVillages;
        allLocations[2][1] = theVillages;
        allLocations[2][3] = theVillages;
        allLocations[3][2] = theVillages;

        Location theCourt = new Location();
        theCourt.setName("Ruler's Court");
        theCourt.setDescription("This is the seat of rule for the City of Aaron.");
        theCourt.setMapSymbol("\u0524");
        theCourt.setGameTip("Are you a wise ruler? One who makes sure his people are well-fed?");
        // set the locations in their spots in the 5x5 grid
        allLocations[2][2] = theCourt;

        Location theGranary = new Location();
        theGranary.setName("The Storehouse");
        theGranary.setDescription("This area serves as granary and other storage for our people.");
        theGranary.setMapSymbol("\u0524");
        theGranary.setGameTip("The robbers sometimes raid this area, but those who pay full tithes have a lower chance of losing grain.");
        // set the locations in their spots in the 5x5 grid
        allLocations[1][3] = theGranary;

        Location theUndev = new Location();
        theUndev.setName("Undeveloped");
        theUndev.setDescription("This area has not been developed.");
        theUndev.setMapSymbol("\u04c2");
        theUndev.setGameTip("Maybe this would be a good area to add more wheat fields?\n A person can tend 200 acres of wheat per year.");
        // set the locations in their spots in the 5x5 grid
        allLocations[2][0] = theUndev;
        allLocations[3][1] = theUndev;

        Location theBorder = new Location();
        theBorder.setName("Borderland");
        theBorder.setDescription("This area is left as a buffer between the City of Aaron and Lamanite land.");
        theBorder.setMapSymbol("\u03fd");
        theBorder.setGameTip("Did you know the blessing of protection comes to those who pay full tithes?");
        // set the locations in their spots in the 5x5 grid
        allLocations[3][0] = theBorder;
        allLocations[4][0] = theBorder;
        allLocations[4][1] = theBorder;

        mainMap.setLocations(allLocations);
        return mainMap;
    }

    public Location moveLocation(Game game, Point newLocation) {
        //get the map 
        Map theMap = game.getTheMap();
        Location[][] theLocations = theMap.getLocations();

        //get the coordinates
        int row = newLocation.getRow();
        int col = newLocation.getColumn();
        
        //look up the new location details.
        Location thisLocation = theLocations[row][col];

        // set the new location Map.setCurrentLocation()
        Point newPoint = new Point();
        newPoint.setRow(row);
        newPoint.setColumn(col);
        theMap.setCurrentLocation(newPoint);
                
        
        // Return location details for display to user.
        return thisLocation;
    }
    
}