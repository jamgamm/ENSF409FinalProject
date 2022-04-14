package edu.ucalgary.ensf409;

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
            int[] profile = {462, 726, 682, 330, 2200};
            return profile;
            //return new NutritionalProfile(3, "Child Over 8", 462, 726, 682, 330, 2200);
        }
    },
  
    CHILDBELOW {
        public int[]theProfile() {
            int[] profile = {294, 462, 434, 210, 1400};
            return profile;
            //return new NutritionalProfile(4, "Child Under 8", 294, 462, 434, 210, 1400);
        }
    
    };
    public abstract int[] theProfile();
    Inventory ourInven = new Inventory();
}
