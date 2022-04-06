package edu.ucalgary.ensf409

public class NutritionalProfile {
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int other;
  private int calories;
  
  public NutritionalProfile (int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.grainContent = wholeGrains;
    thisfvContent = fruitVeggies;
    this.proContent = protein;
    this.other = other;
    this.calories = calories;
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

