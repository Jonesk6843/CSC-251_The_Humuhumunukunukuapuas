package group_project;

import java.util.*;

public class Group_Project {
    public static Scanner scnr = new Scanner(System.in);
    
    //Declaring global variables
    public static int numTables;
    public static int totalChairs;
    public static int numPeople;
    public static int extraChairs;
    public static double initialPrice;
    public static double discount;
    public static double taxValue;
    public static double priceTotal;
    
    public static void main(String[] args) 
    {
        //Get user inputs
        System.out.print("How many people are in your party?: ");
        while(!scnr.hasNextInt()) {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many people are in your party?: ");
        }
        numPeople = scnr.nextInt();
        
        //Calling calcluation methods and display results
        TableCalc();
        priceCalculations();
        DisplayResults();
    }
    
    public static void TableCalc(){
        if (numPeople >= 5)
        {
            numTables = (numPeople - 4) / 2 + 1;
            int extras = (numPeople - 4) % 2;
            if (extras == 1)
            {
                numTables++;
            }
            
            extraChairs = ExtraChairs(); 
            totalChairs = TotalChairs();
        }
        else
        {
            extraChairs = 4 - numPeople;
            totalChairs = 4;
            numTables = 1;
        }
        
    }
    
    public static int ExtraChairs()
    {
        if (numPeople % 2 == 0){ return 0; }
        else{ return 1; }
    }
    
    public static int TotalChairs()
    {
        return ((numTables - 1) * 2) + 4;
    }
    
    public static void priceCalculations()
    {
        initialPrice =  totalChairs * 20; //calculate initial Price
        taxValue = initialPrice * 0.07; //Calculate tax value
        priceTotal = initialPrice + taxValue; //Calculate total price
        
        //Calculate discount if user is event planner
        if (numTables >= 5 && numTables < 10)
        {
            discount = initialPrice * 0.05;
            priceTotal = priceTotal - discount; //Calculate total price afer discount
        }
        else if (numTables >= 10)
        {
            discount = initialPrice * 0.1;
            priceTotal = priceTotal - discount; //Calculate total price afer discount
        }
        
    }
      
    public static void DisplayResults()
    {
        System.out.println("Number of people in your group: " + numPeople);
        System.out.println("Number of tables: " + numTables);
        System.out.println("Number of chairs: " + totalChairs);
        System.out.println("Number of extra chairs: " + extraChairs);
        
        new Project_SaveInvoice_JForm().setVisible(true);
    }
}
