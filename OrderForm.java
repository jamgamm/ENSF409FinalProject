package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class OrderForm implements FormattedOutput{
  
    //request will hold mutiple families
  private ArrayList<Family> request = new ArrayList<Family>();
  private List<Hamper> allHampers = new ArrayList<Hamper>();

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

  public ArrayList<Family> getFamily(){
    return request;
  }

  public List<Hamper> getAllHampers(){
    return allHampers;
  }

  public void addHamper(int female, int male, int over, int under) throws IllegalArgumentException, OrderCannotBeValidatedException{
    Family nextFamily = new Family(male, female, over, under);
    request.add(nextFamily);
    nextFamily.calculateWeeklyFamilyNutritionalNeeds();
    nextFamily.makeHamper();
    allHampers.add(nextFamily.getHamper());
    nextFamily.getHamper().buildHamper();
    //System.out.println("Hamper created");
  }
  
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

  @Override
  public String getFormatted(int index) {
    Family currFam = getFamily().get(index);
    int [] members = currFam.getFamilyMembers();
    String familyMembers = new String(members[0]+" male, "+members[1]+" female, "+members[2]+" child above 8, "+members[3]+" child below 8");
    return familyMembers;
  }



            
           
}
