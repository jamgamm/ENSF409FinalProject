package edu.ucalgary.ensf409

public class Hamper {
  private NutrionalProfile nutritionalNeedsFamily;
  private LinkedList<Food> foodList = new LinkedList<Food>();
  
  public Hamper(NutritionalProfile familyNeeds){
    this.nutritionalNeedsFamily = familyNeeds;
  }
  
  public void addToFoodList(Food foodItem){
  
  }
  
  public NutritionaProfile getNutritionalNeedsFamily(){
    return nutritionalNeedsFamily;
  
  }
  
  public void setNutritionalNeedsFamily(NutritionalProfile nutritionalNeedsFamily){
  
  }

}
