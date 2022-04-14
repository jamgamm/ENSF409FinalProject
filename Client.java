package edu.ucalgary.ensf409;

import java.io.*;
import java.util.*;

public class Client {
  
  private int ID;
  private String NAME;
  private int grainContent;
  private int fvContent;
  private int proContent;
  private int otherContent;
  private int calories;
  
  public Client (int itemID, String itemName, int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.ID = itemID;
    this.NAME = itemName;
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

  public Client (int wholeGrains, int fruitVeggies, int protein, int other, int calories){
    this.grainContent = wholeGrains;
    this.fvContent = fruitVeggies;
    this.proContent = protein;
    this.otherContent = other;
    this.calories = calories;
  }

  public Client(){
    
  }

  public int getID(){
    return this.ID;
  }
  
  public String getName(){
    return this.NAME;
  }

  public int getGrainContent(){
    return this.grainContent;
  }

  public int getFVContent(){
    return this.fvContent;
  }

  public int getProContent(){
    return this.proContent;
  }

  public int getOther(){
   return this.otherContent;
  }

  public int getCalories(){
   return this.calories;
  }

}
