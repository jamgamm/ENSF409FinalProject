package edu.ucalgary.ensf409

public class NutritionalProfile {
  private final int ID;
  private final String NAME;
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int other;
  private int calories;
  
  public NutritionalProfile (int itemID, string itemName, int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.ID = itemID;
    this.NAME = itemName;
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.other = other;
    this.calories = calories;
  }
  
  public String getID(){
    return this.ID;
  }
  
  public String getName(){
    return this.NAME;
  }

  public int getGrainContent(){
    return this.grainContent;
  }

  public int fvContent(){
    return this.fvContent;
  }

  public int proContent(){
    return this.proContent;
  }

  public int other(){
   return this.other;
  }

  public int calories(){
   return this.calories;
  }
 }

