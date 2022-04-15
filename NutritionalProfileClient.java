package edu.ucalgary.ensf409;

/**
 * 
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public enum NutritionalProfileClient{
  
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
    public abstract int[] theProfile();
    Inventory ourInven = new Inventory();
}

