package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//any other libraries we need to import

public class Test {
  private Hamper exampleHamper = null;
  private Family sampleFamily = new Family(1,2,3,4, exampleHamper);
  Client sampleClient = new Client("Adult male");
  
  /* this section is for testing the methods in the family class 
  the first 4 tests under this comment are all for testing methods in family class */
  
  //this tests the family constructor for a family with all types of members in it
  @Test
  public void testFamilyConstructorFull(){
    //test the constructor when its given valid data( 1 adult male/female, 1 child under/over 8)
    Family sampleFamily = new Family(1,2,3,4, exampleHamper);
    assertNotNull("Family constructor did not create an object when given valid data", sampleFamily);
  }
  
  //this tests the family constructor for a family with only 1 adult male
  @Test
  public void testFamilyConstructorSingle(){
    //test the constructor when its given valid data(1 adult male)
    Family sampleFamily = new Family(1,0,0,0, exampleHamper);
    assertNotNull("Family constructor did not create an object when given valid data", sampleFamily);
  }
  
  @Test
  public void testFamilyGetters(){
    //test getters in family class
    int[] sampleGetMembers = sampleFamily.getFamilyMembers();
    int[] expectedMembers = [1,2,3,4];
    assertNotNull("Method getFamilyMembers did not return an int array", sampleGetMembers);
    assertEquals("Method getFamilyMembers did not return the expected result: ", expectedMembers, sampleGetMembers);
    NutritionalProfile sampleGetFamilyNeeds = sampleFamily.getFamilyNutritionalNeeds();
    assertNotNull("Method getFamilyNutritionalNeeds did not return a NutritionalProfile object", sampleGetFamilyNeeds);  
  }
  
  @Test
  public void testFamilyCalculation(){
    //test the calculation for weekly nutritional needs of the family
    int[][] sampleCalculation = sampleFamily.calculateWeeklyFamilyNutritionalNeeds();
    int[][] expectedCalculation = //this will be some sort of value we calculate ourselves
    assertEquals("Method calculateWeeklyFamilyNutritionalNeeds did not return the expected result: ", expectedCalculation, sampleCalculation);
  }

  /* this section is for testing the methods related to the client class */
  @Test
  public void testClientConstructor(){
    Client sampleClient = new Client("Adult male");
    assertNotNull("Client constructor did not create an object when given valid data", sampleClient);
  }
  
  @Test
  public void testClientGetters(){
    String sampleCategory = sampleClient.getCategory();
    String expectedCategory = "Adult male";
    assertEquals("Method getCategory did not return the expected result: ", expectedCategory, sampleCategory);
    NutritionalProfile sampleProfile = sampleClient.getNutritionalProfile();
    assertNotNull("Method getNutritionalProfile did not return a NutritionalProfile object", sampleProfile);  
  }

  /* this section is for testing the methods related to the Nutritional Profile class */
  @Test
  public void testProfileConstructor(){
    NutritionalProfile sampleProfile = new NutritionalProfile(400,700,650,750,2500);
    assertNotNull("NutritionalProfile constructor did not create an object when given valid data", sampleProfile);
  }
  
  @Test
  public void testProfileGetters(){
    int sampleGrains = sampleProfile.getGrainContent();
    int expectedGrains = 400;
    assertEquals("Method getGrainContent did not return the expected result: ", expectedGrains, sampleGrains);
    int sampleFV = sampleProfile.getFVContent();
    int expectedFV = 700;
    assertEquals("Method getFVContent did not return the expected result: ", expectedFV, sampleFV);
    int samplePro = sampleProfile.getProContent();
    int expectedPro = 650;
    assertEquals("Method getProContent did not return the expected result: ", expectedPro, samplePro);
    int sampleOther = sampleProfile.getOther();
    int expectedOther = 750;
    assertEquals("Method getOther did not return the expected result: ", expectedOther, sampleOther);
    int sampleCalories = sampleProfile.getCalories();
    int expectedCalories = 2500;
    assertEquals("Method getCalories did not return the expected result: ", expectedCalories, sampleCalories);
  }
  
  /* this section is for testing the methods related to the Food class */
  
  @Test
  public void testFoodConstructor(){
    Food sampleFood = new Food("1", "Tomato Sauce, jar");
    assertNotNull("Food constructor did not create an object when given valid data", sampleFood);
  }
  
  @Test
  public void testFoodGetters(){
    String sampleID = sampleFood.getID();
    String expectedID = "1";
    assertEquals("Method getID did not return the expected result: ", expectedID, sampleID);
    String sampleName = sampleFood.getName();
    String expectedName = "Tomato Sauce, jar";
    assertEquals("Method getName did not return the expected result: ", expectedName, sampleName);
    NutritionalProfile sampleProfile = sampleFood.getNutritionalProfile();
    assertNotNull("Method getNutritionalProfile did not return a NutritionalProfile object", sampleProfile); 
  }
  
  /* this section is for testing the methods related to the Inventory class*/
  
  @Test
  public void testInventoryGetter(){
    String sampleInventoryID = sampleInventory.getItem();
    String expectedInventoryID = "1";
    assertEquals("Method getItem did not return the expected result: ", expectedInventoryID, sampleInventoryID);
  }
    
  @Test
  public void testRemove(){
    sampleInventory.remove("1", "Tomato Sauce, jar");
    String sampleInventoryID = sampleInventory.getItem();
    String expectedInventoryID = null;
    assertEquals("Method remove did not return the expected result: ", expectedInventoryID, sampleInventoryID);
  }
  
  /* this section is for testing the methods related to the Hamper class */
  
  @Test
  public void testHamperConstructor(){
    Hamper sampleHamper = new Hamper(new NutritionalProfile(400,700,650,750,2500));
    assertNotNull("Hamper constructor did not create an object when given valid data", sampleHamper);
  }
  
  @Test
  public void testAdd(){
    sampleHamper.addToFoodList(sampleFood);
    Food theFood = foodList.last();
    String theFoodID = theFood.getID();
    String expectedFoodID = "1";
    assertEquals("Method addToFoodList did not return the expected result: ", expectedFoodID, theFoodID);
  }
  
  @Test
  public void testSetNutriNeeds(){
    sampleHamper.setNutritionalNeedsFamily(new NutrionalProfile(400,700,650,750,2501));
    NutritionalProfile sampleNutriProfile = sampleHamper.getNutritionalNeedsFamily;
    assertNotNull("Method setNutritionalNeedsFamily did not create a NutritionalProfile object", sampleNutriProfile);
  }
  
  @Test
  public void testGetNutriNeeds(){
    NutritionalProfile sampleNutriProfile = sampleHamper.getNutritionalNeedsFamily;
    assertNotNull("Method getNutritionalNeedsFamily did not return a NutritionalProfile object", sampleNutriProfile);
  }
   
  
  
  
  
  
  
  //for testing the formatted output interface, how??? work on later
  @Test
  public void testFormatGetter(){
    



}
