package edu.ucalgary.ensf409;

public class OrderCannotBeValidatedException extends Exception{
    public OrderCannotBeValidatedException(){
        super("Order cannot be validated");
    }
}
