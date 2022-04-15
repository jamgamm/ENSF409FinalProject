package edu.ucalgary.ensf409;

/**
 * A program that instantiates a NutritionalProfile object
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public class NutritionalProfile {
  private int ID;
  private String NAME;
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int otherContent;
  private int calories;
  
  /** Constructors **/
  
  /*
   * constructor for Nutritional Profile object for food items
   * @param itemID - the provided item ID number
   * @param itemName - the provided item name
   * @param wholeGrains - the percentage of whole grains in the food item
   * @param fruitVeggies - the percentage of fruit and veggies in the food item
   * @param protein - the percentage of protein in the food item
   * @param other - the percentage of other in the food item
   * @param calories - the total number of calories in the food item
   */
  public NutritionalProfile (int itemID, String itemName, int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.ID = itemID;
    this.NAME = itemName;
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

  /*
   * constructor for Nutritional Profile object for client
   * @param wholeGrains - the percentage of whole grains required for the client
   * @param fruitVeggies - the percentage of fruit and veggies required for the client
   * @param protein - the percentage of protein required for the client
   * @param other - the percentage of other required for the client
   * @param calories - the total number of calories required for the client
   */
  public NutritionalProfile (int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

 /** Getters **/
  
  /**
   * @return int - returns the ID of the NutritionalProfile object
   */
  public int getID(){
    return this.ID;
  }
  
  /**
   * @return int - returns the name of the NutritionalProfile object
   */
  public String getName(){
    return this.NAME;
  }

  /**
   * @return int - returns the grain content (calories) of the NutritionalProfile object
   */
  public int getGrainContent(){
    int grains = (int) ((grainContent/100.0) * calories);
    return grains;
  }

  /**
   * @return int - returns the fruits and veg content (calories) of the NutritionalProfile object
   */
  public int getFVContent(){
    int fv = (int) ((fvContent/100.0) * calories);
    return fv;
  }

  /**
   * @return int - returns the protein content (calories) of the NutritionalProfile object
   */
  public int getProContent(){
    int protein = (int) ((proContent/100.0) * calories);
    return protein;
  }

  /**
   * @return int - returns the other content (calories) of the NutritionalProfile object
   */
  public int getOther(){
    int other = (int) ((otherContent/100.0) * calories);
   return other;
  }

  /**
   * @return int - returns the total calories of the NutritionalProfile object
   */
  public int getCalories(){
   return this.calories;
  }


} // End of class declaration
