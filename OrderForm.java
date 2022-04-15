package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

/**
 * A program that creates an order when user inputs the amount of families
 * including the amount of specific family members in each family
 * The program will then create client objects to create hampers,
 * choosing the best hamper for each family and writing the outut to text file
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public class OrderForm implements FormattedOutput{
  
    //request will hold mutiple families
  private ArrayList<Family> request = new ArrayList<Family>();
  private List<Hamper> allHampers = new ArrayList<Hamper>();

  /** Constructors **/
  
  /** 
   * 
   * @param female - gives the number of adult females in the family
   * @param male - gives the number of adult males in the family
   * @param over - gives the number of children over 8 in the family
   * @param under - gives the number of children under 8 in the family
   * @exception IllegalArgumentException when invalid values are entered 
   * for male, female, over and under
   * @exception FileNotFoundException for when the output file cannot be found or created
   * @exception OrderCannotBeValidatedException whenever an order cannot be completed,
   * a reason could be too many hampers (more than 10)
   */
  public OrderForm(int female, int male, int over, int under) throws IllegalArgumentException, FileNotFoundException, OrderCannotBeValidatedException{
      /*fam1 = new Family(male, female, over, under);
      request.add(fam1);
      this.goodHamper = fam1.getHamper();
      allHampers.add(goodHamper);*/
      //System.out.println("Hampers made");
      addHamper(female, male, over, under);
  }

  public OrderForm(){

  }

  /** Getters **/
  /** 
   * getter method to return the list of families in the order
   * @return ArrayList<Family> - returns an ArrayList of Family objects
   * which are created when order is submitted by user
   */
  public ArrayList<Family> getFamily(){
    return request;
  }

  /** 
   * getter method to return the list of Hampers created
   * @return List<Hamper> - returns an ArrayList of Hamper objects
   * which are created when order is submitted by user
   */
  public List<Hamper> getAllHampers(){
    return allHampers;
  }

  /** Helper Methods **/
  
  /**
   * this method takes in the following 4 parameters and adds
   * a new family to the lsit of families (request) in the current order
   * it also calls on the method calculateWeeklyFamilyNutritionalNeeds to obtain the
   * nutrtional profile of the family that contains the toal requirements of each categories
   * from there the program also calls the method makeHamper to actually build several
   * possible combination of hampers
   * @param female - number of adult females in the family
   * @param male - number of adult males in the family
   * @param over - number of children over 8 in the family
   * @param under - number of children under 8 in the family
   * @exception IllegalArgumentException
   * @exception OrderCannotBevAlidatedException
   * @see IllegalArgumentException
   * @see OrderCannotBeValidatedException
   */ 
  public void addHamper(int female, int male, int over, int under) throws IllegalArgumentException, OrderCannotBeValidatedException{
    Family nextFamily = new Family(male, female, over, under);
    request.add(nextFamily);
    nextFamily.calculateWeeklyFamilyNutritionalNeeds();
    nextFamily.makeHamper();
    allHampers.add(nextFamily.getHamper());
    nextFamily.getHamper().buildHamper();
    //System.out.println("Hamper created");
  }
  
  /**
   * method takes as arguments orderNumber and mobility,
   * also has access to other data related to the order
   * so that a text file can be written to with all information
   * related to the order
   * @param orderNumber - used to keep track of total number of separate orders
   * @param mobility - determines whether the user or someone in the family of the user
   * has mobility requirements which would need to be considered
   * @exception FileNotFoundException - thrown if the output file cannot be created
   * for some reason
   * @see FileNotFoundException
   */
  public void writeToTextFile(int orderNumber, String mobility) throws FileNotFoundException{
    //an example of the final output: https://d2l.ucalgary.ca/d2l/le/content/425075/viewContent/5235566/View 
    try {
      FileWriter out = new FileWriter("OrderForm" +orderNumber+".txt");
      for(int i = 0; i<getFamily().size(); i++){
        /*Family currFam = getFamily().get(i);
        int [] members = currFam.getFamilyMembers();
        String familyMembers = new String(members[0]+" male, "+members[1]+" female, "+members[2]+" child above 8, "+members[3]+" child below 8");*/
        String familyMembers = getFormatted(i);
        out.write("Name: " + "\t\n" + "Date: " + "\t\n" + "Original Request: " + familyMembers + "\n");
        out.write("Mobility Needed: "+ mobility+"\n");
        Order currHamper = getAllHampers().get(i).getOrder();
        out.write("Excess: "+currHamper.getExcess()+"\n");
        List<NutritionalProfile> bestFoods = currHamper.getBestCombo();
        for(int j=0; j<bestFoods.size(); j++){
          out.write("ID: " + bestFoods.get(j).getID()+ " Name: "+ bestFoods.get(j).getName()+"\n");
        }
      }
            
            
       out.close();
       }
        //check for io or regular exceptions (and print if necessary)
        catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("Exception: " + e.getStackTrace()); //throws if there is some other exception
        }
  }

  /**
   * interface method to format the output to write to file
   * @param index - indicates the current family in the list
   */
  @Override
  public String getFormatted(int index) {
    Family currFam = getFamily().get(index);
    int [] members = currFam.getFamilyMembers();
    String familyMembers = new String(members[0]+" male, "+members[1]+" female, "+members[2]+" child above 8, "+members[3]+" child below 8");
    return familyMembers;
  }      
           
} // End of class declaration
