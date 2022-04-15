package edu.ucalgary.ensf409;

/**
 * enumeration that returns daily nutritional needs for the
 * specified client
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public enum NutritionalProfileClient{
  
  /**
   * the method reads from the database the given total calories and 
   * percentages for an adult male
   * @return int[] - returns an array of integers indicating the amount 
   * of daily calories an adult male requires, divided in each 
   * nutritional categories
   */
  ADULTMALE {
        public int[] theProfile() {
            NutritionalProfile theInfo = ourInven.getClientMap().get(1);
            int grains = theInfo.getGrainContent();
            int fv = theInfo.getFVContent();
            int protein = theInfo.getProContent();
            int other = theInfo.getOther();
            int calories = theInfo.getCalories();
            int[] profile = {grains, fv, protein, other, calories};
            return profile;
            //int[] profile = {400, 700, 650, 750, 2500};
        }
    },
    
  /**
   * the method reads from the database the given total calories and 
   * percentages for an adult female
   * @return int[] - returns an array of integers indicating the amount 
   * of daily calories an adult female requires, divided in each 
   * nutritional categories
   */
   ADULTFEMALE {
        public int[] theProfile() {
            NutritionalProfile theInfo = ourInven.getClientMap().get(2);
            int grains = theInfo.getGrainContent();
            int fv = theInfo.getFVContent();
            int protein = theInfo.getProContent();
            int other = theInfo.getOther();
            int calories = theInfo.getCalories();
            int[] profile = {grains, fv, protein, other, calories};
            //int[] profile = {320, 560, 520, 600, 2000};
            return profile;
        }
    },
  
  /**
   * the method reads from the database the given total calories and 
   * percentages for a child above 8
   * @return int[] - returns an array of integers indicating the amount 
   * of daily calories a child above 8 requires, divided in each 
   * nutritional categories
   */
   CHILDABOVE {
        public int[] theProfile() {
            NutritionalProfile theInfo = ourInven.getClientMap().get(3);
            int grains = theInfo.getGrainContent();
            int fv = theInfo.getFVContent();
            int protein = theInfo.getProContent();
            int other = theInfo.getOther();
            int calories = theInfo.getCalories();
            int[] profile = {grains, fv, protein, other, calories};
            //int[] profile = {462, 726, 682, 330, 2200};
            return profile;

        }
    },
  
  /**
   * the method reads from the database the given total calories and 
   * percentages for a child under 8
   * @return int[] - returns an array of integers indicating the amount 
   * of daily calories a child under 8 requires, divided in each 
   * nutritional categories
   */
   CHILDBELOW {
        public int[]theProfile() {
            NutritionalProfile theInfo = ourInven.getClientMap().get(4);
            int grains = theInfo.getGrainContent();
            int fv = theInfo.getFVContent();
            int protein = theInfo.getProContent();
            int other = theInfo.getOther();
            int calories = theInfo.getCalories();
            int[] profile = {grains, fv, protein, other, calories};
            //int[] profile = {294, 462, 434, 210, 1400};
            return profile;

        }
    };
  
    /** method **/
  
    /**
     * the method creates an inventory object, which reads data from
     * the given database and stores it in the inventory
     * @return int[] - returns an array of integers indicating the amount 
     * of daily calories the specified client requires, divided in each 
     * nutritional categories
     */
    public abstract int[] theProfile();
    Inventory ourInven = new Inventory();
} // End of enum declaration

