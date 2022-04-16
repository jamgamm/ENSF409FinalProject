package edu.ucalgary.ensf409;

/**
 * Class that provides the Graphical User Interface information
 * the program is run from the GUI
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.9
 * @since 1.0 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import java.io.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener, MouseListener{ 

    private int female;
    private int male;
    private int over;
    private int under;
    
    private JLabel adM;
    private JLabel adF;
    private JLabel chO;
    private JLabel chY;
    
    private JLabel instructions;
    private JLabel instructions2;
    private JLabel instructions3;
    private JTextField m;
    private JTextField f;
    private JTextField o;
    private JTextField y;

    private OrderForm currentOrder = new OrderForm();
    private int orderNumber = 0;
    private String mobility = "No";
    private int numOfHampers = 0;
    
   
    /*
   * Constructor for the GUI object
   * there are no given parameters
   * the constructor provides the setup information for the GUI
   * including the size of the pop-up window, the heading, and information to close the operation 
   * upon closing the popup window (JFrame)
   */
    public GUI(){
        super("Create a Hamper");
        setupGUI();
        setSize(800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    
  
 /** Methods **/

    
/**
   * this method sets up the GUI by creating the progrma instructions at the top 
   * there are 4 entry boxes created for user (integer) input to list the number of each specific client
   * the entry boxes have example inputs preset that disappear once the entry box is engaged (ie clicked)
   * there are 3 buttons
   * the first button, submitInfo, handles order form submission once the order has been completed
   * if the order can be completed, there is a message shown and a text file created with the order form and hamper details
   * the next button, mobilityInfo, handles if mobility assistance is required and will detail this in the text file as well
   * the next button is the addInfo button which handles if multiple hampers are requested for a specific order
   * there are 5 panels created to handle the information with the headerPanel having a box layout to display the instructions easier
   * the panels are also specificed with their location on the page
*/
    public void setupGUI(){
        
        instructions = new JLabel("Please enter the number of family members to generate a hamper. Please enter 0 if no members.");
        instructions2 = new JLabel("If mobility is needed, click the mobility button. To add a hamper to an order, click Add Hamper to Order.");
        instructions3 = new JLabel("Once you are satisfied with your order, press the submit button");
        adF = new JLabel("Adult Female:");
        adM = new JLabel("Adult Male:");
        chO = new JLabel("Child Over 8:");
        chY = new JLabel("Child Under 8:");
        
        f = new JTextField("e.g. 1", 15);
        m = new JTextField("e.g. 0", 15);
        o = new JTextField("e.g. 0", 15);
        y = new JTextField("e.g. 0", 15);    
        
        f.addMouseListener(this);
        m.addMouseListener(this);
        o.addMouseListener(this);
        y.addMouseListener(this);

        JButton submitInfo = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    orderNumber++;
                    currentOrder.writeToTextFile(orderNumber, mobility);
                    currentOrder = new OrderForm();
                    numOfHampers = 0;
                    JOptionPane.showMessageDialog(null,"Order complete. Order Form file created.");
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JButton mobilityInfo = new JButton(new AbstractAction("Mobility") {
            @Override
            public void actionPerformed(ActionEvent e){
                mobility = "Yes";
            }
        });
        

        JButton addInfo = new JButton("Add hamper to order");
        addInfo.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel addInfoPanel = new JPanel();
        addInfoPanel.setLayout(new FlowLayout());

        JPanel mobilityInfoPanel = new JPanel();
        mobilityInfoPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        headerPanel.add(instructions2);
        headerPanel.add(instructions3);
        clientPanel.add(adF);
        clientPanel.add(f);
        clientPanel.add(adM);
        clientPanel.add(m);
        clientPanel.add(chO);
        clientPanel.add(o);
        clientPanel.add(chY);
        clientPanel.add(y);
        submitPanel.add(submitInfo);
        addInfoPanel.add(addInfo);
        mobilityInfoPanel.add(mobilityInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
        this.add(addInfoPanel, BorderLayout.EAST);
        this.add(mobilityInfoPanel, BorderLayout.WEST);
    }
    
    
 /**
   * this method handles actions that are peformed by the user
   * @param event - for the ActionEvent performed
   * when integers are entered in the entry boxes, there is valid input (otherwise there is a NumberFormatException and an error popup) 
   * with the correct input and the addInfo button pressed, the user can add more hampers to the order or they can submit the order using the order form
   * if more than 10 hampers are added to an order, an error popup is displayed
*/
    public void actionPerformed(ActionEvent event){
        try{
        female = Integer.parseInt(f.getText());
        male = Integer.parseInt(m.getText());
        over = Integer.parseInt(o.getText());
        under = Integer.parseInt(y.getText());
            if(validateInput()){
                try {
                    orderProcessor();
                    JOptionPane.showMessageDialog(this,"Hamper created. Enter new values to add another hamper (10 hampers max).\n Or press submit to complete order.");
                    //currentOrder.writeToTextFile();
                } catch (IllegalArgumentException | FileNotFoundException | OrderCannotBeValidatedException e) {
                    JOptionPane.showMessageDialog(this,"Your order cannot be validated.");
                    //  Auto-generated catch block
                    //e.printStackTrace();
                }
                //JOptionPane.showMessageDialog(this,"Your order is valid ");
            } 
        }  
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Please enter numbers only.");
        }
        
    }
    
     /**
   * this method handles actions when the user's mouse is clicked
   * @param event - for the MouseEvent performed
   * if the user clicks into the entry boxes, the preset information disappears and they are able to enter their information
*/
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(f))
            f.setText("");

        if(event.getSource().equals(m))
            m.setText("");

        if(event.getSource().equals(o))
            o.setText("");

        if(event.getSource().equals(y))
            y.setText("");
                
    }
    
 /**
   * this method handles actions when the user's mouse enters
   * @param event - for the MouseEvent performed
*/
    public void mouseEntered(MouseEvent event){
        
    }

 /**
   * this method handles actions when the user's mouse exits
   * @param event - for the MouseEvent performed
*/
    public void mouseExited(MouseEvent event){
        
    }

  /**
   * this method handles actions when the user's mouse is pressed
   * @param event - for the MouseEvent performed
*/
    public void mousePressed(MouseEvent event){
        
    }
    
 /**
   * this method handles actions when the user's mouse is released
   * @param event - for the MouseEvent performed
*/
    public void mouseReleased(MouseEvent event){
        
    }
    
 
 /**
   * this method processes the order input from the user
   * it uses numOfHampers to track the number of hampers in the order
   * if more than 10 hampers are entered, there is an IllegalArgumentException
   * otherwise each hamper is added to the order form using the family information (order form has an array list of the hampers requested for
   each order)
*/
    private void orderProcessor() throws IllegalArgumentException, FileNotFoundException, OrderCannotBeValidatedException{
        numOfHampers++;
        if (numOfHampers>10){
            throw new IllegalArgumentException();
        }
        currentOrder.addHamper(female, male, over, under);
    } 

    
    
  /**
   * @return boolean - returns true if the entry boxes have correct inputs 
   * this method checks if the entry box information is valid (for all 4)
   * only natural numbers are allowed - with a max number input of 10 for each client category
   * it will return false if any of the boxes have incorrect information and will show an error popup message
*/
    private boolean validateInput(){
        
        boolean allInputValid = true;
        
        if(female > 10 || female < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, female + " is an invalid input.");
        }
        
        if(male > 10 || male < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, male + " is an invalid input.");
        }

        if(under > 10 || under < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, under + " is an invalid input.");
        }

        if(over > 10 || over < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, over + " is an invalid input.");
        }
        
        return allInputValid;
        
    }

    
   /**
   * the main method runs the program by setting the GUI to be visible once the program is compiled and run
   * @param args
*/ 
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);        
        });
    }
        
} // End of class declaration
