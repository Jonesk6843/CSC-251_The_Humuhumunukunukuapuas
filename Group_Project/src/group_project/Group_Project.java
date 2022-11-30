package group_project;
import java.text.NumberFormat;
import java.util.*;
import java.io.*;

public class Group_Project 
{
    public static Scanner scnr = new Scanner(System.in);
    
    //Declaring global variables
    public static int numTables;
    public static int totalChairs;
    public static int NumPeople;
    public static int extraChairs;
    public static double initialPrice;
    public static double discount;
    public static double taxValue;
    public static double priceTotal;
    public static String Recipt;
    
    public static void main(String[] args) 
    {
        boolean keep_going = true;
        while(keep_going){
            System.out.print("How would you like to use this program?\n" +
                           "\t1. JFrame\n" +
                           "\t2. Console\n" +
                           ">");

            switch (scnr.next()) {
                case "1":
                    new Custom_Order_JF().setVisible(true);
                    keep_going = false;
                    break;
                case "2":
                    ConsoleQuestion();
                    keep_going = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }
    }
    
    public static void ConsoleQuestion(){
        boolean keep_going = true;
        while(keep_going){
            System.out.print("Is this a custom order (y or n)\n>");

            switch(scnr.next().toLowerCase()){
                case "y":
                    CustomOrderConsole();
                    keep_going = false;
                    break;
                case "n":
                    Console();
                    keep_going = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        } 
    }
    
    public static void Console(){
        //Get user inputs
        System.out.print("How many people are in your party?: ");
        while(!scnr.hasNextInt()) {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many people are in your party?: ");
        }
        NumPeople = scnr.nextInt();
        
        // Ask if the user has a promo code
        System.out.print("Do you have a promocode? (y or n)\n>");
            boolean keep_going = true;
            switch(scnr.next().toLowerCase())
            {
                case "y":
                    promoCodeConsole();
                    keep_going = false;
                    break;
                case "n":
                    keep_going = false;
                    //Calling calcluation methods and display results
                    TableCalc();
                    priceCalc();
                    GenerateRecipt();
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
    }
    
    public static void CustomOrderConsole()
    {
        //Get num people
        System.out.print("How many people are in your party?: ");
        while(!scnr.hasNextInt()) 
        {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many people are in your party?: ");
        }
        int numPeople = scnr.nextInt();
        
        // Get num tables
        System.out.print("How many tables do you need?: ");
        while(!scnr.hasNextInt()) 
        {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many tables do you need?: ");
        }
        int NumTables = scnr.nextInt();
        
        // Get num chairs
        System.out.print("How many chairs do you need?: ");
        while(!scnr.hasNextInt()) 
        {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many chairs do you need?: ");
        }
        int NumChairs = scnr.nextInt();
        
        CustomOrder(numPeople, NumTables, NumChairs);
        System.out.print("Do you have a promocode? (y or n)\n>");

        switch(scnr.next().toLowerCase())
        {
            case "y":
                promoCodeConsole();
                break;
            case "n":
                //Calling calcluation methods and display results
                TableCalc();
                priceCalc();
                GenerateRecipt();
                break;
            default:
                System.out.println("Please enter a valid option!");
                break;
            }
    }
    
    public static void promoCodeConsole()
    {
        try
        {
            System.out.println("What is your promo-code?: ");
            scnr.next();
            
            Scanner sc = new Scanner(new File("F:\\Promocodes.csv"));  
            sc.useDelimiter(",");   //sets the delimiter pattern  
            while (sc.hasNext())  //returns a boolean value  
            {  
                System.out.print(sc.next());  //find and returns the next complete token from this scanner  
            }   
            sc.close();  //closes the scanner  
            
            //Calling calcluation methods and display results
            TableCalc();
            priceCalc();
            GenerateRecipt();
        }
        catch(Exception e) 
        {
            System.out.print("An error has occured.");
        }
    }
    
    public static void TableCalc(){
        if (NumPeople >= 5)
        {
            numTables = (NumPeople - 4) / 2 + 1;
            int extras = (NumPeople - 4) % 2;
            if (extras == 1)
            {
                numTables++;
            }
            
            extraChairs = ExtraChairs(); 
            totalChairs = TotalChairs();
        }
        else
        {
            extraChairs = 4 - NumPeople;
            totalChairs = 4;
            numTables = 1;
        }
    }
    
    public static int ExtraChairs()
    {
        if (NumPeople % 2 == 0){ return 0; }
        else{ return 1; }
    }
    
    public static int TotalChairs()
    {
        return ((numTables - 1) * 2) + 4;
    }
    
    public static void priceCalc()
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
    
    public static void CustomOrder(int numPeople, int NumTables, int NumChairs)
    {
        NumPeople = numPeople;
        numTables = NumTables;
        totalChairs = NumChairs;
        
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

    public static void GenerateRecipt()
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        Recipt =  "Humu Table Services" + "\n" + "_________________" + "\n" + "\n" 
                + "Number of people in your group: " + NumPeople + "\n" 
                + "Number of tables: " + numTables + "\n" 
                + "Number of chairs: " + totalChairs + "\n"
                + "Number of extra chairs: " + extraChairs + "\n" + "\n"
                + "_________________" + "\n"
                + "Subtotal: " + formatter.format(initialPrice)+ "\n"
                + "Tax: " + formatter.format(taxValue) + "\n" 
                + "Discount: " + formatter.format(discount) + "\n"
                + "Total: " + formatter.format(priceTotal) + "\n";
        
        new Project_SaveInvoice_JF().setVisible(true);
    }
}
