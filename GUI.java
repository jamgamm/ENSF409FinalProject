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

    private String female;
    private String male;
    private String over;
    private String under;
    
    private JLabel adM;
    private JLabel adF;
    private JLabel chO;
    private JLabel chY;
    
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
        
        instructions = new JLabel("Please enter the number of family members to generate an order.");
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
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
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
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    
    public void actionPerformed(ActionEvent event){
        female = f.getText();
        male = m.getText();
        over = o.getText();
        under = y.getText();
        
        /*if(validateInput()){
            String petID = idProcessing();
            JOptionPane.showMessageDialog(this, "Your pet's clinic ID is " + petID);
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
    
    private String idProcessing(){

        String petID = new String(String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + String.valueOf(petName.charAt(0)) + String.valueOf(birthYear));
        
        return petID;
    }  * 
    
    
    //we will have to write this so that the only inputs allowed are integers (or we make it a dropdown menu)
    private boolean validateInput(){
        
        boolean allInputValid = true;
        
        if(!Character.isUpperCase(firstName.charAt(0)) || firstName.length() < 2 || firstName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, firstName + " is an invalid name input.");
        }
        
        if(!Character.isUpperCase(lastName.charAt(0)) || lastName.length() < 2 || lastName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, lastName + " is an invalid name input.");
        }

        if(!Character.isUpperCase(petName.charAt(0)) || petName.length() < 2 || petName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, petName + " is an invalid name input.");
        }

        if(birthYear < 1922 || birthYear > 2022){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, birthYear + " is an invalid birth year. Pets must be born between 1922 and 2022.");
        }
        
        return allInputValid;
        
    }

    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);        
        });
    }
        
}
