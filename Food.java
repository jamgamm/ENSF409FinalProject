package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class Food {

  private final String ID;
  private final String NAME;
  private NutritionalProfile nutritionalProfile;
  
  public Food(String ID, String name) throws IllegalArgumentException{
    this.ID = ID;
    this.NAME = name;
  }
  
  public String getID(){
    return this.ID;
  }
  
  public String getName(){
    return this.NAME;
  }
  
  public NutrionalProfile getNutritionalProfile(){
    return this.nutritionalProfile;
  }
  
  public void setNutrionalProfile(String profile){
    this.nutrionalProfile = profile;
  }
  
}
