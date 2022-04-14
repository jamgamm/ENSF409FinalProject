package edu.ucalgary.ensf409;

import java.util.LinkedList;

public class Family {

  private int adultMale;
  private int adultFemale;
  private int childAbove;
  private int childBelow;
  //private LinkedList<Client> familyList;
  private Hamper hamper;
  private Client nutritionalNeedsFamily;
  
  public Family(int adultMale, int adultFemale, int childAbove, int childBelow /*Hamper hamper*/)throws IllegalArgumentException{

    this.adultMale = adultMale;
    this.adultFemale = adultFemale;
    this.childAbove = childAbove;
    this.childBelow = childBelow;
    this.hamper = new Hamper(getWeeklyFamilyNutritionalNeeds());
    
  }
   public int[] getFamilyMembers() { ////finish the method???
	   int[] familyMembers = {adultMale, adultFemale, childAbove, childBelow};
	   return familyMembers;
}
  
  public Client getWeeklyFamilyNutritionalNeeds(){ ////finish the method???
      int totalGrain = this.adultMale*NutritionalProfileClient.ADULTMALE.theProfile()[0]
                     + this.adultFemale*NutritionalProfileClient.ADULTFEMALE.theProfile()[0]
                     + this.childBelow*NutritionalProfileClient.CHILDBELOW.theProfile()[0]
                     + this.childAbove*NutritionalProfileClient.CHILDABOVE.theProfile()[0];
      int totalFV = this.adultMale*NutritionalProfileClient.ADULTMALE.theProfile()[1]
                    + this.adultFemale*NutritionalProfileClient.ADULTFEMALE.theProfile()[1]
                    + this.childBelow*NutritionalProfileClient.CHILDBELOW.theProfile()[1]
                    + this.childAbove*NutritionalProfileClient.CHILDABOVE.theProfile()[1];
      int totalPro = this.adultMale*NutritionalProfileClient.ADULTMALE.theProfile()[2]
                    + this.adultFemale*NutritionalProfileClient.ADULTFEMALE.theProfile()[2]
                    + this.childBelow*NutritionalProfileClient.CHILDBELOW.theProfile()[2]
                    + this.childAbove*NutritionalProfileClient.CHILDABOVE.theProfile()[2];
      int totalOther = this.adultMale*NutritionalProfileClient.ADULTMALE.theProfile()[3]
                    + this.adultFemale*NutritionalProfileClient.ADULTFEMALE.theProfile()[3]
                    + this.childBelow*NutritionalProfileClient.CHILDBELOW.theProfile()[3]
                    + this.childAbove*NutritionalProfileClient.CHILDABOVE.theProfile()[3];
      int totalCal = this.adultMale*NutritionalProfileClient.ADULTMALE.theProfile()[4]
                    + this.adultFemale*NutritionalProfileClient.ADULTFEMALE.theProfile()[4]
                    + this.childBelow*NutritionalProfileClient.CHILDBELOW.theProfile()[4]
                    + this.childAbove*NutritionalProfileClient.CHILDABOVE.theProfile()[4];
      this.nutritionalNeedsFamily = new Client(5, "Family", totalGrain*7, totalFV*7, totalPro*7, totalOther*7, totalCal*7);
      System.out.println("Total Grain: " + totalGrain + "Total FV: "+ totalFV);
	  return nutritionalNeedsFamily;
  }
  
  public Hamper getHamper(){
    return this.hamper;
  }

	
  
}

