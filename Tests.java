package edu.ucalgary.ensf409;

/**
 * Class that provides nutritional information for a given client
 * Each client is part of a family 
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.9
 * @since 1.0 
 */


import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.*;
import java.util.*;
//any other libraries we need to import

public class Tests {
  private Hamper sampleHamper = null;
  private Family sampleFamily = null;
  private Client sampleClient = new Client(0, "Adult male", 0, 0, 0, 0, 0);
  private NutritionalProfile sampleProfile = new NutritionalProfile(0,0,0,0,0);
  private List<Client> possibleHampers = new ArrayList<Client>();
  private Order sampleOrder = null;
  private List<List<NutritionalProfile>> sampleFoodList= new ArrayList<List<NutritionalProfile>>();
  private List<NutritionalProfile> sampleFoodCombo = new ArrayList<NutritionalProfile>();
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
    int[] actualMembers = sampleFamily.getFamilyMembers();
    int[] expectedMembers = {1,0,0,0};
    boolean equal = true;
    for(int i = 0; i<expectedMembers.length; i++){
      if(actualMembers[i]!=expectedMembers[i]){
        equal = false;
      }
    }
    assertNotNull("Method getFamilyMembers did not return an int array", actualMembers);
    assertTrue("Method findBestCombo did not return the expected result", equal);
  }
  
  @Test
  public void testFamilyCalculation(){
    //test the calculation for weekly nutritional needs of the family
    sampleFamily = new Family(1,0,0,0);
    sampleClient = new Client(400, 700, 650, 750, 2500);
    sampleFamily.setWeeklyFamilyNutritionalNeeds(sampleClient);
    Client actualCalculation = sampleFamily.getWeeklyFamilyNutritionalNeeds();
    int[] actualCalculationValues = {actualCalculation.getGrainContent(),actualCalculation.getFVContent(),actualCalculation.getProContent(),actualCalculation.getOther(),actualCalculation.getCalories()};
    int[] expectedCalculation = {400,700,650,750,2500};
    boolean equal = true;
    for(int i = 0; i<expectedCalculation.length; i++){
      if(actualCalculationValues[i]!=expectedCalculation[i]){
        equal = false;
      }
    }
    assertTrue("Method findBestCombo did not return the expected result", equal);
  }

  /* this section is for testing the methods related to the client class */
  @Test
  public void testClientConstructor(){
    //test the constructor when given a client of category adult male
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    assertNotNull("Client constructor did not create an object when given valid data", sampleClient);
  }
  
  @Test
  public void testClientCategoryGetters(){
    //test the getters for the client class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    String actualCategory = sampleClient.getName();
    String expectedCategory = "Adult male";
    assertEquals("Method getCategory did not return the expected result: ", expectedCategory, actualCategory);
  }

  @Test
  public void testClientIDGetters(){
    //test the getters for the client class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualID = sampleClient.getID();
    int expectedID = 1;
    assertEquals("Method getCategory did not return the expected result: ", expectedID, actualID);
  }

  @Test
  public void testClientGrainGetters(){
    //test the getters for the client class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualGrain = sampleClient.getGrainContent();
    int expectedGrain = 16;
    assertEquals("Method getCategory did not return the expected result: ", expectedGrain, actualGrain);
  }

  @Test
  public void testClientProGetter(){
    //test the getters for the nutritional profile class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualPro = sampleClient.getProContent();
    int expectedPro = 26;
    assertEquals("Method getProContent did not return the expected result: ", expectedPro, actualPro);
  }
  
  @Test
  public void testClientFVGetter(){
    //test the getters for the nutritional profile class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualFV = sampleClient.getFVContent();
    int expectedFV = 28;
    assertEquals("Method getProContent did not return the expected result: ", expectedFV, actualFV);
  }

  @Test
  public void testClientOtherGetter(){
    //test the getters for the nutritional profile class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualOther = sampleClient.getOther();
    int expectedOther = 30;
    assertEquals("Method getProContent did not return the expected result: ", expectedOther, actualOther);
  }

  @Test
  public void testClientCalorieGetter(){
    //test the getters for the nutritional profile class
    sampleClient = new Client(1, "Adult male", 16, 28, 26, 30, 2500);
    int actualCalories = sampleClient.getOther();
    int expectedCalories = 30;
    assertEquals("Method getProContent did not return the expected result: ", expectedCalories, actualCalories);
  }

  /* this section is for testing the methods related to the Nutritional Profile class */
  @Test
  public void testProfileConstructor(){
    //test the constructor for nutrtional profile given all valid int values
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    assertNotNull("NutritionalProfile constructor did not create an object when given valid data", sampleProfile);
  }
  
  @Test
  public void testIDGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(1,"Banana",0,80,10,10,120);
    int actualID = sampleProfile.getID();
    int expectedID = 1;
    assertEquals("Method getGrainContent did not return the expected result: ", expectedID, actualID);
  }

  @Test
  public void testNameGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(1,"Banana",0,80,10,10,120);
    String actualName = sampleProfile.getName();
    String expectedName = "Banana";
    assertEquals("Method getGrainContent did not return the expected result: ", expectedName, actualName);
  }

  @Test
  public void testGrainGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int actualGrains = sampleProfile.getGrainContent();
    int expectedGrains = 0;
    assertEquals("Method getGrainContent did not return the expected result: ", expectedGrains, actualGrains);
  }

  @Test
  public void testFVGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int actualFV = sampleProfile.getFVContent();
    int expectedFV = 96;
    assertEquals("Method getFVContent did not return the expected result: ", expectedFV, actualFV);

  }

  @Test
  public void testOtherGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int actualOther = sampleProfile.getOther();
    int expectedOther = 12;
    assertEquals("Method getOther did not return the expected result: ", expectedOther, actualOther);
  }

  @Test
  public void testProGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int actualPro = sampleProfile.getProContent();
    int expectedPro = 12;
    assertEquals("Method getProContent did not return the expected result: ", expectedPro, actualPro);
  }

  @Test
  public void testCalorieGetter(){
    //test the getters for the nutritional profile class
    sampleProfile = new NutritionalProfile(0,80,10,10,120);
    int actualCalories = sampleProfile.getCalories();
    int expectedCalories = 120;
    assertEquals("Method getCalories did not return the expected result: ", expectedCalories, actualCalories);
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
  
  @Test
  public void testCreateHamperFoodList(){
    HashMap<Integer,NutritionalProfile> sampleMap = new HashMap<Integer, NutritionalProfile>();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2000, 400, 350, 1250, 2500);
    sampleMap.put(1, sampleProfile);

    NutritionalProfile sampleProfile2 = new NutritionalProfile(2, "Banana", 0, 4000, 0, 1250, 2500);
    sampleMap.put(2, sampleProfile2);

    sampleFamily = new Family(1,1,1,1);
    sampleClient = new Client(400, 700, 650, 750, 2500);
    sampleHamper = new Hamper(sampleClient);
    sampleFamily.setWeeklyFamilyNutritionalNeeds(sampleClient);
    List<NutritionalProfile> actualList = sampleHamper.create(sampleFamily.getWeeklyFamilyNutritionalNeeds(), 1, sampleMap);
    List<NutritionalProfile> expectedList = new ArrayList<NutritionalProfile>();
    expectedList.add(sampleProfile);
    expectedList.add(sampleProfile2);
    boolean equal = true;
    for(int i = 0; i<actualList.size();i++){
      if(actualList.get(i).getName()!=expectedList.get(i).getName()){
        equal = false;
      }
    }
    assertTrue("Method create did not create the expected values", equal);


  }
   
    
 /* this section will test the methods related to the order class */
  
  @Test
  public void testOrderConstructor(){
    Order sampleOrder = new Order(sampleHamper);
    assertNotNull("Order constructor did not create an object when given valid data", sampleOrder);
  }
    
  @Test
  public void testFindBestCombo(){
    sampleProfile = new NutritionalProfile(67, "Banana, bunch 5", 0, 4054, 0, 4642, 7000);
    sampleFoodCombo.add(sampleProfile);
    sampleProfile = new NutritionalProfile(62, "Salmon, 5 filets", 2741, 0, 3644, 0, 7000);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleFoodCombo.clear();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2000, 400, 350, 1250, 2500);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleFoodCombo.clear();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2899, 5500, 3700, 4848, 16947);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleClient = new Client(2741, 4054, 3644, 4642, 14000);
    possibleHampers.add(sampleClient);
    sampleClient = new Client(2000, 400, 350, 1250, 2500);
    possibleHampers.add(sampleClient);
    sampleClient = new Client(2899, 5500, 3700, 4848, 16947);
    possibleHampers.add(sampleClient);


    sampleHamper = new Hamper(sampleClient);
    sampleOrder = new Order(sampleHamper);
    sampleHamper.setHamperProfile(possibleHampers);
    sampleHamper.setPossible(sampleFoodList);

    try{
      sampleOrder.bestCombo(possibleHampers);
    }
    catch(OrderCannotBeValidatedException e){

    }
    Client actualBestCombo = sampleOrder.getBestHamper();
    int[] actualBestComboValues = {actualBestCombo.getGrainContent(), actualBestCombo.getFVContent(),actualBestCombo.getProContent(),actualBestCombo.getOther(),actualBestCombo.getCalories()};
    int[] expectedBestComboValues = {2741,4054,3644,4642,14000};
    boolean equal = true;
    for(int i=0; i<expectedBestComboValues.length; i++){
      if(actualBestComboValues[i]!=expectedBestComboValues[i]){
        equal = false;
      }
    }
    assertTrue("Method findBestCombo did not return the expected result", equal);
    //assertEquals("Method findBestCombo did not return the expected result: ", expectedBestCombo, bestCombo);
  }

  @Test
  public void testFindBestComboItems(){
    sampleProfile = new NutritionalProfile(67, "Banana, bunch 5", 0, 4054, 0, 4642, 7000);
    sampleFoodCombo.add(sampleProfile);
    sampleProfile = new NutritionalProfile(62, "Salmon, 5 filets", 2741, 0, 3644, 0, 7000);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleFoodCombo.clear();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2000, 400, 350, 1250, 2500);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleFoodCombo.clear();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2899, 5500, 3700, 4848, 16947);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleClient = new Client(2741, 4054, 3644, 4642, 14000);
    possibleHampers.add(sampleClient);
    sampleClient = new Client(2000, 400, 350, 1250, 2500);
    possibleHampers.add(sampleClient);
    sampleClient = new Client(2899, 5500, 3700, 4848, 16947);
    possibleHampers.add(sampleClient);


    sampleHamper = new Hamper(sampleClient);
    sampleOrder = new Order(sampleHamper);
    sampleHamper.setHamperProfile(possibleHampers);
    sampleHamper.setPossible(sampleFoodList);

    try{
      sampleOrder.bestCombo(possibleHampers);
    }
    catch(OrderCannotBeValidatedException e){

    }
    List<NutritionalProfile> actualFoods = sampleOrder.getBestCombo();
    List<NutritionalProfile> expectedFoods = sampleFoodList.get(0);
    boolean equal = true;
    for(int i=0; i<expectedFoods.size(); i++){
      if(actualFoods.get(i).getName()!=expectedFoods.get(i).getName()){
        equal = false;
      }
    }
    assertTrue("Method findBestCombo did not return the expected result", equal);
  }
    
  /* this section will test the exceptions for various methods */
  
    @Test
  public void testCannotBeValidated(){
    sampleProfile = new NutritionalProfile(67, "Banana, bunch 5", 0, 100, 0, 120, 300);
    sampleFoodCombo.add(sampleProfile);
    sampleProfile = new NutritionalProfile(62, "Salmon, 5 filets", 170, 0, 320, 0, 300);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleFoodCombo.clear();
    sampleProfile = new NutritionalProfile(12, "Celariac, 1 kg", 2000, 400, 350, 1250, 2500);
    sampleFoodCombo.add(sampleProfile);
    sampleFoodList.add(sampleFoodCombo);

    sampleClient = new Client(170, 100, 320, 120, 600);
    possibleHampers.add(sampleClient);
    sampleClient = new Client(2000, 400, 350, 1250, 2500);
    possibleHampers.add(sampleClient);



    sampleHamper = new Hamper(sampleClient);
    sampleOrder = new Order(sampleHamper);
    sampleHamper.setHamperProfile(possibleHampers);
    sampleHamper.setPossible(sampleFoodList);

    boolean passed = false;
    try{
      sampleOrder.bestCombo(possibleHampers);
    }
    catch(OrderCannotBeValidatedException e){
      passed = true;
    }

    assertTrue("Method findBestCombo does not throw an OrderCannotBeValiedException when hamper does not meet requirements", passed);
  }
  
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
    boolean passed = false;
    try{
      Client badClient = new Client(1, 12, Integer.parseInt("six"),400,2500);
    }
    catch(IllegalArgumentException e){
        passed = true;
    }
    assertTrue("Client constructor does not throw IllegalArgumentException when given invalid data", passed);
    passed = true;
     try{
      new Client(1,"Adult male",16,28,26,30,2500);
    }
    catch (IllegalArgumentException e){
      passed = false;
    }
    catch (Exception e) { }
        assertTrue("Client constructor throws IllegalArgumentException when given valid data", passed);
  } 

  @Test
  public void testHamperConstructorException(){
    boolean passed = false;
    try{
      Client badClient = new Client(1, 12, Integer.parseInt("six"),400,2500);
      new Hamper(badClient);
    }
    catch(IllegalArgumentException e){
        passed = true;
    }
    assertTrue("Hamper constructor does not throw IllegalArgumentException when given invalid data", passed);
    passed = true;
     try{
      Client goodClient = new Client(1,"Adult male",16,28,26,30,2500);
      new Hamper(goodClient);
    }
    catch (IllegalArgumentException e){
      passed = false;
    }
    catch (Exception e) { }
        assertTrue("Hamper constructor throws IllegalArgumentException when given valid data", passed);
  }
}
// End of test class declaration
    
    
  

  
  
  
  
 
