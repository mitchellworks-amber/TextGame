package model;
import java.io.Serializable;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Provision implements Serializable {
    private String name;
    private boolean perishable;
    
    public Provision (){
        //Empty constructor for JavaBeans
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public boolean isPerishable(){
        return perishable;
    }
    
    public void setPerishable(boolean perishable){
        this.perishable = perishable;
    }
    
    // toSting method
    @Override
    public String toString() {
        return "Provision{" 
                + "name=" + name 
                + ", perishable=" + perishable
                + '}';


    }
    
}
