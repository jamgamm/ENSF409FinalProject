package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//any other libraries we need to import

public class Tests {
  //private Client sampleClient = new Client(400, 700, 650, 750, 2500);
  private Hamper sampleHamper = null;
  private Family sampleFamily = null;
  private Client sampleClient = new Client(0, "Adult male", 0, 0, 0, 0, 0);
  private NutritionalProfile sampleProfile = new NutritionalProfile(0,0,0,0,0);
  private Hamper badHamper = null;
  private NutritionalProfile testFood = new NutritionalProfile(1, "Banana", 0, 100, 0, 0, 100);
  //private Inventory sampleInventory = new Inventory();
  private Order sampleOrder = null;
  
  /* this section is for testing the methods in the family class 
  the first 4 tests under this comment are all for testing methods in family class */
  
  //this tests the family constructor for a family with all types of members in it
  @Test
  public void testFamilyConstructorFull(){
    //test the constructor when its given valid data( 1 adult male/female, 1 child under/over 8)
    sampleFamily = new Family(1,1,1,1);

    assertNotNull("Family constructor did not create an object when given valid data", sampleFamily);
  }
  
  //this tests the family constructor for a family with only 1 adult male
  @Test
  public void testFamilyConstructorSingle(){
    //test the constructor when its given valid data(1 adult male)
    sampleFamily = new Family(1,0,0,0);

    assertNotNull("Family constructor did not create an object when given valid data", sampleFamily);
  }
  
  @Test
  public void testFamilyGetters(){
    //test getters in family class
    sampleFamily = new Family(1,0,0,0);
    int sampleGetMembers = sampleFamily.getFamilyMembers()[0];
    int expectedMembers = 1;
    assertNotNull("Method getFamilyMembers did not return an int array", sampleGetMembers);
    assertEquals("Method getFamilyMembers did not return the expected result: ", expectedMembers, sampleGetMembers);
  }
  
  @Test
  public void testFamilyCalculation(){
    //test the calculation for weekly nutritional needs of the family
    sampleFamily = new Family(1,0,0,0);
    sampleClient = new Client(400, 700, 650, 750, 2500);
    sampleFamily.setWeeklyFamilyNutritionalNeeds(sampleClient);
    Client sampleCalculation = sampleFamily.getWeeklyFamilyNutritionalNeeds();
    int sample = sampleCalculation.getGrainContent();
    int expectedCalculation = 400;
    assertEquals("Method calculateWeeklyFamilyNutritionalNeeds did not return the expected result: ", expectedCalculation, sample);
  }

  /* this section is for testing the methods related to the client class */
  @Test
  public void testClientConstructor(){
    //test the constructor when given a client of category adult male
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    assertNotNull("Client constructor did not create an object when given valid data", sampleClient);
  }
  
  @Test
  public void testClientGetters(){
    //test the getters for the client class
    String sampleCategory = sampleClient.getName();
    String expectedCategory = "Adult male";
    assertEquals("Method getCategory did not return the expected result: ", expectedCategory, sampleCategory);
  }

  /* this section is for testing the methods related to the Nutritional Profile class */
  @Test
  public void testProfileConstructor(){
    //test the constructor for nutrtional profile given all valid int values
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    assertNotNull("NutritionalProfile constructor did not create an object when given valid data", sampleProfile);
  }
  
  @Test
  public void testProfileGetters(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int sampleGrains = sampleProfile.getGrainContent();
    int expectedGrains = 0;
    assertEquals("Method getGrainContent did not return the expected result: ", expectedGrains, sampleGrains);
    int sampleFV = sampleProfile.getFVContent();
    int expectedFV = 96;
    assertEquals("Method getFVContent did not return the expected result: ", expectedFV, sampleFV);
    int samplePro = sampleProfile.getProContent();
    int expectedPro = 12;
    assertEquals("Method getProContent did not return the expected result: ", expectedPro, samplePro);
    int sampleOther = sampleProfile.getOther();
    int expectedOther = 12;
    assertEquals("Method getOther did not return the expected result: ", expectedOther, sampleOther);
    int sampleCalories = sampleProfile.getCalories();
    int expectedCalories = 120;
    assertEquals("Method getCalories did not return the expected result: ", expectedCalories, sampleCalories);
  }
  
  
  /* this section is for testing the methods related to the Inventory class*/
  
  /*@Test
  public void testInventoryGetter(){
    //test the getter for inventory class
    int sampleInventoryID = sampleInventory.getItem(1).getID();
    int expectedInventoryID = 1;
    assertEquals("Method getItem did not return the expected result: ", expectedInventoryID, sampleInventoryID);
  }
    
  @Test
  public void testRemove(){
    //test the remove function by trying to remove tomato sauce
    sampleInventory.remove(1);
    int sampleInventoryID = sampleInventory.getItem(1).getID();
    String expectedInventoryID = null;
    assertEquals("Method remove did not return the expected result: ", expectedInventoryID, sampleInventoryID);
  }
  
  /* this section is for testing the methods related to the Hamper class */
  
  @Test
  public void testHamperConstructor(){
    //test the constructor when given a valid nutrtional profile
    Client sampleClient = new Client(400, 700, 650, 750, 2500);
    Hamper sampleHamper = new Hamper(sampleClient);
    assertNotNull("Hamper constructor did not create an object when given valid data", sampleHamper);
  }
  
  
  @Test
  public void testGetNutriNeeds(){
    //test getter
    Hamper sampleHamper = new Hamper(sampleClient);

    Client sampleNutriProfile = sampleHamper.getNutritionalNeedsFamily();
    assertNotNull("Method getNutritionalNeedsFamily did not return a Client object", sampleNutriProfile);
  }
   
    
 /* this section will test the methods related to the order class */
  
  @Test
  public void testOrderConstructor(){
    Order sampleOrder = new Order(sampleHamper);
    assertNotNull("Order constructor did not create an object when given valid data", sampleOrder);
  }
    
  @Test
  public void testFindBestCombo(){
    sampleClient = new Client(2741, 700, 650, 750, 2500);
    sampleHamper = new Hamper(sampleClient);
    sampleOrder = new Order(sampleHamper);
    sampleOrder.setBestHamper(sampleClient);
    Client sampleBestCombo = sampleOrder.getBestHamper();
    int bestCombo = sampleBestCombo.getGrainContent();
    int expectedBestCombo = 2741;
    assertEquals("Method findBestCombo did not return the expected result: ", expectedBestCombo, bestCombo);
  }
    
  /* this section will test the exceptions for various methods */
    
  @Test
  public void testFamilyConstructorException(){
    boolean passed = true;
    //test that an illegal arguement exception is thrown when invalid data is given
    
    try{
      new Family(1, 0, 0, 0);
    }
    catch (IllegalArgumentException e){
      passed = false;
    }
    catch (Exception e) { }
        assertTrue("Family constructor throws an IllegalArgumentException when given valid data", passed);
  }
    
   
  @Test
  public void testClientConstructorException(){
    //test that an illegal arguement exception is thrown when invalid data is given
    
    boolean passed = true;
     try{
      new Client(1,"Adult male",16,28,26,30,2500);
    }
    catch (IllegalArgumentException e){
      passed = false;
    }
    catch (Exception e) { }
        assertTrue("Client constructor throws IllegalArgumentException when given valid data", passed);
  } 

    
}
    
    
  

  
  
  
  
 
