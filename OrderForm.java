package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;

public class OrderForm{
  
  private ArrayList<Family> request;
  private Hamper goodHamper; //I added this private var
  
  public void writeToTextFile() throws FileIOException{
    //an example of the final output: https://d2l.ucalgary.ca/d2l/le/content/425075/viewContent/5235566/View 
    try {
      FileWriter out = new FileWriter();
      out.write("Name: " + "\t\n" + "Date: " + "\t\n" + "Original Request" + "\n");
      for(i=1; i<; i++){ //I'm not sure what the loop criteria should be (it's for the requested hampers)
         out.write("Hamper " + i + ":")
         out.write(the clients)//fix
       }
            
       for(i=1; i<; i++){ //I'm not sure what the loop criteria should be (for the final hampers -- with the food)
         out.write("Hamper " + i + " Items:")
         out.write(hamper)//fix and output each item + its id -- might need to iterate
           //I might need to write a second loop for each item of each hamper (nested for loops)
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
  
  public static void getUserInput(String args[]) throws IllegalArgumentException{ //I think we need to add this exception to the UML
    //we also need to figure out the gui stuff I think for this (I'm not sure how to connect the user input)
    //I'm not sure if we would even need this if we are doing the gui stuff
    //I might add a gui class because it might just be a bit easier
    
    /*

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("My First Frame");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel buttonsPanel = new JPanel();
            JButton myButton = new JButton("Click here!");
            buttonsPanel.add(myButton);
            frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel);
            frame.setVisible(true);
        });

    }
    
    /*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

            
           
    }
}
}*/
    try{
      String 
    }
    catch(){
    }
    
  }
  
  public boolean checkValid(Hamper finalHamper) throws IllegalArgumentException{
    if(finalHamper){ //finish writing criteria
      this.goodHamper = finalHamper;
      return true;
  } 
    else{ return false;}

}
