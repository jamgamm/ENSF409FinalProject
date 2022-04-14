package edu.ucalgary.ensf409;

public class NutritionalProfile {
  private int ID;
  private String NAME;
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int otherContent;
  private int calories;
  
  public NutritionalProfile (int itemID, String itemName, int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.ID = itemID;
    this.NAME = itemName;
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

  public NutritionalProfile (int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

  
  public int getID(){
    return this.ID;
  }
  
  public String getName(){
    return this.NAME;
  }

  public int getGrainContent(){
    int grains = (int) ((grainContent/100.0) * calories);
    return grains;
  }

  public int getFVContent(){
    int fv = (int) ((fvContent/100.0) * calories);
    return fv;
  }

  public int getProContent(){
    int protein = (int) ((proContent/100.0) * calories);
    return protein;
  }

  public int getOther(){
    int other = (int) ((otherContent/100.0) * calories);
   return other;
  }

  public int getCalories(){
   return this.calories;
  }


 }
