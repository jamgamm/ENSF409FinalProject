package edu.ucalgary.ensf409;

public class Family {

  private int adultMale;
  private int adultFemale;
  private int childAbove;
  private int chidBelow;
  private LinkedList<Client> familyList;
  private Hamper hamper;
  private NutritionalProfile nutritionalNeedsFamily;
  
  Public String Family(int adultMale, int adultFemale, int childAbove, int childBelow, Hamper hamper)throws IllegalArgumentException{

    this.adultMale = adultMale;
    this.adultFemale = adultFemale;
    this.childAbove = childAbove;
    this.chidBelow = childBelow;
    this.hamper = hamper;
    
  }
   public int[] getFamilyMembers() { ////finish the method???
	   int[] familyMembers = {adultMale, adultFemale, childAbove, childBelow};
	   return familyMembers;
}
  
  public NutritionalProfile getFamilyNutritionalNeeds(){ ////finish the method???
	  return ;
  }
  
	public int[] convertPercent(){
		//access the nutritional profile for the desried person
		//then convert each part of the profile (grains fv etc) from percent to a number
		//store all these numbers into an int array
	}
	
  public NutritionalProfile calculateWeeklyFamilyNutrtionalNeeds(){ ////finish the method???
    //use the getter for family nutritional needs
    //then multiply by 7
    return ;
  }
  
}
