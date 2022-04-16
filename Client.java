package edu.ucalgary.ensf409;
/**
 * Class that provides nutritional information for a given client
 * Each client is part of a family 
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.5
 * @since 1.0 
 */



public class Client {
  
  private int ID;
  private String NAME;
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int otherContent;
  private int calories;
  
  
  /*
   * Constructor for the Client object
   * @param itemID - the provided client ID number
   * @param itemName - the provided item name (ex "Family")
   * @param wholeGrains - the number of whole grain calories in the food item
   * @param fruitVeggies - the number of fruit and veggie calories in the food item
   * @param protein - the number of protein calories in the food item
   * @param other - the number of other calories in the food item
   * @param calories - the total number of calories in the food item
   */
  public Client (int itemID, String itemName, int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.ID = itemID;
    this.NAME = itemName;
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

    /*
   * Constructor for the Client object
   * @param wholeGrains - the number of whole grain calories in the food item
   * @param fruitVeggies - the number of fruit and veggie calories in the food item
   * @param protein - the number of protein calories in the food item
   * @param other - the number of other calories in the food item
   * @param calories - the total number of calories in the food item
   */
  public Client (int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

    /*
   * Empty constructor for the Client object
   */
  public Client(){
    
  }

  /** Getters **/
  
  
  /**
   * @return int - returns the ID of the Client
   */
  public int getID(){
    return this.ID;
  }
  
   /**
   * @return String - returns the NAME of the Client
   */
  public String getName(){
    return this.NAME;
  }

  /**
   * @return int - returns the grainContent (the grain calories number)
   */
  public int getGrainContent(){
    return this.grainContent;
  }

   /**
   * @return int - returns the fvContent (the fruit and veggies calories number)
   */
  public int getFVContent(){
    return this.fvContent;
  }

  /**
   * @return int - returns the proContent (the protein calories number)
   */
  public int getProContent(){
    return this.proContent;
  }

  /**
   * @return int - returns the otherContent (the other calories number)
   */
  public int getOther(){
   return this.otherContent;
  }

  /**
   * @return int - returns the calories (total calories number)
   */
  public int getCalories(){
   return this.calories;
  }

}// End of class declaration
