package edu.ucalgary.ensf409;

public enum NutritionalProfileClient{
  
  ADULTMALE {
        public String asString() {
            return "Adult Male";
        }
    },
    
    ADULTFEMALE {
        public String asString() {
            return "Adult Female";
        }
    },
  
    CHILDABOVE {
        public String asString() {
            return "Child Above";
        }
    },
  
    CHILDBELOW {
        public String asString() {
            return "Child Under";
        }
    
    };
    public abstract String asString();
  //do we keep it as strong or string[]
}
