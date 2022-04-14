package edu.ucalgary.ensf409;

import java.util.*;
import java.util.List;
import java.io.*;
import java.time.LocalDate;


public class OrderForm{
  
    //request will hold mutiple families
  private ArrayList<Family> request;
  private Family fam1;
  private int numOfFamilies = 0;
  private Hamper goodHamper; //I added this private var

  public OrderForm(int female, int male, int over, int under) throws IllegalArgumentException, FileNotFoundException{
      //this is just for 1 family
      //maybe for multiple families use for loop?
        this.fam1 = new Family(male, female, over, under);
        this.goodHamper = fam1.getHamper();
        //request.add(fam1);
        numOfFamilies++;
        writeToTextFile();
  }

  public Family getFamily(){
    return fam1;
  }
  
  public void writeToTextFile() throws FileNotFoundException{
    //an example of the final output: https://d2l.ucalgary.ca/d2l/le/content/425075/viewContent/5235566/View 
    //List<Client> ourFood = hamper1.getHamperProfile();
    Order order1 = goodHamper.getOrder();
    List<NutritionalProfile> best = order1.getBestCombo();
    try {
      FileWriter out = new FileWriter("output.txt");
      int[] members = fam1.getFamilyMembers();
      String familyMembers = new String(members[0]+"male, "+members[1]+"female, "+members[2]+"child above 8, "+members[3]+"child below 8");
      out.write("Name: " + "\t\n" + "Date: " + LocalDate.now() + "\t\n" + "Original Request: " + familyMembers + "\n");
      for(int i =0; i<best.size(); i++){
        out.write("ID: " + best.get(i).getID()+ " Name: "+ best.get(i).getName()+"\n");
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

            
           
}
