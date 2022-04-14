//I created a class to handle our gui stuff but I have just copied the one they used for the pet id, so I will change it later
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
    private JTextField m;
    private JTextField f;
    private JTextField o;
    private JTextField y;
    
    public GUI(){
        super("Create a Hamper");
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    
    public void setupGUI(){
        
        instructions = new JLabel("Please enter the number of family members to generate an order. Please enter 0 if no members");
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
        
        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JButton addInfo = new JButton("Add a new order");
        addInfo.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel addInfoPanel = new JPanel();
        addInfoPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
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
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
        //need to change placement because we can't see it on pop up window right now
        this.add(addInfoPanel, BorderLayout.EAST);
    }
    
    public void actionPerformed(ActionEvent event){
        female = Integer.parseInt(f.getText());
        male = Integer.parseInt(m.getText());
        over = Integer.parseInt(o.getText());
        under = Integer.parseInt(y.getText());
        
        if(validateInput()){
            try {
                orderProcessor();
            } catch (IllegalArgumentException | FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog( this, "Your order is valid ");
        }
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
    
    private void orderProcessor() throws IllegalArgumentException, FileNotFoundException{
        new OrderForm(female, male, over, under);
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
