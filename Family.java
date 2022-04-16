package edu.ucalgary.ensf409;

/**
 * Class that provides family nutritional needs for use in hamper creation
 * Each family has their own hamper 
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.7
 * @since 1.0 
 */

public class Family {

  private int adultMale;
  private int adultFemale;
  private int childAbove;
  private int childBelow;
  private Hamper hamper = null;
  private Client nutritionalNeedsFamily;
  
	
/*
   * Constructor for the Family object
   * @param adultMale - the provided number of Adult Males in the family
   * @param adultFemal - the provided number of Adult Females in the family
   * @param childAbove - the provided number of Children Above 8 in the family
   * @param childBelow - the provided number of Children Below 8 in the family
   */
  public Family(int adultMale, int adultFemale, int childAbove, int childBelow){

    this.adultMale = adultMale;
    this.adultFemale = adultFemale;
    this.childAbove = childAbove;
    this.childBelow = childBelow;
    
  }
	
  
/** Methods **/

/**
   * this method makes a new hamper of the weekly nutritional needs of the family and
   * stores it in the hamper private variable
*/
  public void makeHamper() throws IllegalArgumentException, OrderCannotBeValidatedException{
    this.hamper = new Hamper(getWeeklyFamilyNutritionalNeeds());
  }
  

/**
   * this method calculates the weekly nutrional needs for the family
   * this method sums the caloric content for each category(grains, fruits and vegetables, protein, other, total calories)
   * using the number of each client in the family and the NutrionalProfileClient enumeration
   * the information is then used to create a new Client object which is stored in the nutrionalNeedsFamily private variable
*/
  public void calculateWeeklyFamilyNutritionalNeeds(){
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
  }
  

	
/** Getters and Setters **/

/**
   * @return int[] - returns an integer array of the number of clients in the family
   */
   public int[] getFamilyMembers() {
	   int[] familyMembers = {adultMale, adultFemale, childAbove, childBelow};
	   return familyMembers;
  }
  
/**
   * @return Client - returns a Client profile of the nutrional needs for the family (for the week)
   */
	public Client getWeeklyFamilyNutritionalNeeds(){ 
	  return nutritionalNeedsFamily;
  }
	
/**
   * @return Hamper - returns the Hamper stored in the hamper private variable

*/
  public Hamper getHamper(){
    return this.hamper;
  }

/**
   * @param weekNeeds - sets the nutrionalNeedsFamily variable to 
   * a Client profile for the weekly nutrional needs for the family
*/
  public void setWeeklyFamilyNutritionalNeeds(Client weekNeeds){
    this.nutritionalNeedsFamily = weekNeeds;
  }
  
} // End of class declaration


