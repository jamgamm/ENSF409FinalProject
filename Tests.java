package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//another other libraries we need to import

public class Test {
  private Hamper exampleHamper = null;
  
  /* this section is for testing the methods in the family class */
  @Test
  public void testFamilyMethods(){
    //test the constructor when its given valid data
    Family sampleFamily = new Family(1,2,3,4, exampleHamper);
    assertNotNull("Family constructor did not create an object when given valid data", sampleFamily);
    //test getters in family class
    int[] sampleGetMembers = sampleFamily.getFamilyMembers();
    assertNotNull("Method getFamilyMembers did not return an int array", sampleGetMembers);
    NutritionalProfile sampleGetFamilyNeeds = sampleFamily.getFamilyNutritionalNeeds();
    assertNotNull("Method getFamilyNutritionalNeeds did not return a NutritionalProfile object", sampleGetFamilyNeeds);
    //test the calculation for weekly nutritional needs of the family
    ?? return type for this method?? sampleCalculation = sampleFamily.calculateWeeklyFamilyNutritionalNeeds();
    ??type?? expectedCalculation = **something**;
    assertEquals("Method calculateWeeklyFamilyNutritionalNeeds did not return the expected result: ", expectedCalculation, sampleCalculation);
    
  }
  
  @Test
  public void **name of test**(){
  
  }
  
  @Test
  public void **name of test**(){
  
  }






}
