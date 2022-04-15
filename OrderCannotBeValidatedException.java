package edu.ucalgary.ensf409;

/**
 * An exception class that throws an exception when a hamper cannot be made
 * checks for this exception are made whenever a hamper object is being made
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public class OrderCannotBeValidatedException extends Exception{
    /** Constructor **/
    public OrderCannotBeValidatedException(){
        super("Order cannot be validated");
    }
} // End of class declaration
