package group_project;
import static group_project.promo_Code.discountValue;
import static group_project.promo_Code.userCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JOptionPane;


public class Group_Project {
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
    
    public static String userTier;
    
    public static String Recipt;
    
    public static void main(String[] args) 
    {
//        new Login_JF().setVisible(true);
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
    
    public static void Console()
    {
        //Get user inputs
        System.out.print("How many people are in your party?: ");
        while(!scnr.hasNextInt()) 
        {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many people are in your party?: ");
        }
        NumPeople = scnr.nextInt();
        
        // Call table and price calculation methods
        TableCalc();
        priceCalc();
        
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
                    // Call GenerateRecipt method and display SaveInvoiceMethod
                    GenerateRecipt();
                    new Project_SaveInvoice_JF().setVisible(true);
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
    }
    
    public static void promoCodeConsole()
    {
        //Declaring variables
        boolean codeValidation = false;
        List<Code> codeList = readCSVIntoCode();
        discountValue = 0.0;
        
        // Ask the user for their promocode
        System.out.println("What is your promo-code?: ");
        userCode = scnr.next();
        for (Code code : codeList)
        {
            if (code.codeName.toLowerCase().equals(userCode.toLowerCase()))
            {
                if (!code.LoginRequired) 
                {
                    codeValidation = true;
                    discountValue = code.codeDiscount;
                    
                    //Calling calcluation methods and display results
                    GenerateRecipt();
                    GeneratePromoRecipt();
                    new Project_SaveInvoice_JF().setVisible(true);
                }
            }
        }
        if (codeValidation == false)
        {
            JOptionPane.showMessageDialog(null, "Sorry, that code is not valid!");
            GenerateRecipt();
            new Project_SaveInvoice_JF().setVisible(true);
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
        
        // Calling customOrder calcluation methods
        CustomOrder(numPeople, NumTables, NumChairs);
        
        // Ask if the user has a promocode.
        System.out.print("Do you have a promocode? (y or n)\n>");
        switch(scnr.next().toLowerCase())
        {
            case "y":
                promoCodeConsole();
                break;
            case "n":
                //Calling calcluation methods and display results
                
                GenerateRecipt();
                new Project_SaveInvoice_JF().setVisible(true);
                break;
            default:
                System.out.println("Please enter a valid option!");
                break;
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
    }
    public static void GeneratePromoRecipt()
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double newDiscount = initialPrice * discountValue;
        double newTotal = priceTotal - newDiscount;
        
        Recipt += "_________________" + "\n" + "\n" + 
                "Promocode: " + userCode + "\n"
                + "Procode Discount: " + formatter.format(newDiscount) + "\n"
                + "New Total: " + formatter.format(newTotal);
    }
    // Code class
    public static class Code {
        private String codeName;
        private String codeType;
        private int codeChair;
        private int codeTable;
        private double codeDiscount;
        private boolean LoginRequired;
        public Code (String name, String type, int chair, int table, double discount, boolean loginRequired)
        {
            codeName = name;
            codeType = type;
            codeChair = chair;
            codeTable = table;
            codeDiscount = discount;
            LoginRequired = loginRequired;
        }
    }
    
    //Reading Promocodes.csv file to array
    public static List<Code> readCSVIntoCode()
    {
        List<Code> codeList = new ArrayList<>();   
        String line;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Promocodes.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] split = line.split(",");
                boolean logreq = false;
                if (split[5].toLowerCase().equals("t")){
                    logreq = true;
                }
                Code tempCode = new Code(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]), logreq);
                codeList.add(tempCode); 
            }
        }
         catch(IOException e) 
         {
            System.out.print(e);
         }
        return codeList;
    }
}
