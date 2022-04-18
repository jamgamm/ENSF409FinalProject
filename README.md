# ENSF409FinalProject

Group Number: 20
Team Members: Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim

To compile the program, use javac -cp .;lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/*.java

You may encounter an error in compiling if the Tests.java file is still in the path edu/ucalgary/ensf409 so please
move the Tests.java file to the 20 folder if this problem occurs.

To run the program, use java -cp .;lib/mysql-connector-java-8.0.23.jar edu.ucalgary.ensf409.GUI

Instructions on running the code through the GUI
... after compiling and running ...

1. Entering the values in the text fields
   Make sure to fill all 4 of the text fields with integer input values
   If a certain category is 0 (i.e no female adult in the family) then enter 0
2. Mobility Requirements
   If someone in the order has mobility requirements then click on the button
   to add the specification to the order (it will be printed on the order form text file)
3. Adding a hamper to an order
   Once all the members in a family have been entered, click the button "Add Hamper To 
   Order", to add the hamper to the overall order
   If placing an order for just one family then proceed to step 5
4. Creating hampers for different families in one order (10 hampers max for 1 order)
   If placing an order for more than 1 family then repeat step 3
   Repeat until satisfied then proceed to step 5
5. Click on submit to finalise the order
6. You may create multiple orders as well before quitting the program (continue through steps 3-5 until satisfied) 
7. On receipt of successful order completion, proceed to check on the
   txt files created in your working directory to see the list of food added to each order

If you wish to run the Tests.java file, use the following prompts:

Move the Tests.java file back to edu/ucalgary/ensf409 if it was previously not in that location.

Then to compile use javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar edu/ucalgary/ensf409/*.java

To run the tests use java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.Tests
