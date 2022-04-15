package edu.ucalgary.ensf409;

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
    
    public GUI(){
        super("Create a Hamper");
        setupGUI();
        setSize(800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    
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
        
        //JButton submitInfo = new JButton("Submit");
        //submitInfo.addActionListener(this);

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
        //need to change placement because we can't see it on pop up window right now
        this.add(addInfoPanel, BorderLayout.EAST);
        this.add(mobilityInfoPanel, BorderLayout.WEST);
    }
    
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
        
        /*if(validateInput()){
            try {
                orderProcessor();
            } catch (IllegalArgumentException | FileNotFoundException e) {
                //  Auto-generated catch block
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog( this,"Your order is valid ");
        }*/
    }
    
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
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    
    //we will have to write this so that it stores them in client
    
    private void orderProcessor() throws IllegalArgumentException, FileNotFoundException, OrderCannotBeValidatedException{
        numOfHampers++;
        if (numOfHampers>10){
            throw new IllegalArgumentException();
        }
        currentOrder.addHamper(female, male, over, under);
        //new OrderForm(female, male, over, under);
    } 

    
    
    
    //we will have to write this so that the only inputs allowed are integers (or we make it a dropdown menu)
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

    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);        
        });
    }
        
}
