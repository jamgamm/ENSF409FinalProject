package edu.ucalgary.ensf409;

import java.io.*;
import java.util.*;

public class Client {
  
  private String category;
  private final NutrionalProfile NUTRITIONALPROFILE;
  
  public Client(String category) throws IllegalArgumentException{
    this.category = category;
    //I think this one uses the enum right?
  }
  
  public String getCategory(){
    return this.category;
  }
  
  public NutrionalProfile getNutrionalProfile(){
    return this.NUTRITIONALPROFILE;
  }

}
