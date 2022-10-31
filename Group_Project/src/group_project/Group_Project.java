package group_project;

import java.util.*;

public class Group_Project {
    public static Scanner scnr = new Scanner(System.in);
    
    public static int numTables;
    public static int totalChairs;
    public static int numPeople;
    public static int extraChairs;
    
    public static void main(String[] args) {
        System.out.print("How many people are in your party?: ");
        
        while(!scnr.hasNextInt()) {
            System.out.println("Please enter a valid number!\n");
            scnr.next();
            System.out.print("How many people are in your party?: ");
        }
        numPeople = scnr.nextInt();

        TableCalc();
        DisplayResults();
    }
    
    public static void TableCalc(){
        if (numPeople >= 5){
            numTables = (numPeople - 4) / 2 + 1;
            int extras = (numPeople - 4) % 2;
            if (extras == 1){
                numTables++;
            }
            
            extraChairs = ExtraChairs(); 
            totalChairs = TotalChairs();
        }else{
            extraChairs = 4 - numPeople;
            totalChairs = 4;
            numTables = 1;
        }
    }
    
    public static int ExtraChairs(){
        if (numPeople % 2 == 0){ return 0; }
        else{ return 1; }
    }
    
    public static int TotalChairs(){
        return ((numTables - 1) * 2) + 4;
    }
    
    public static void DisplayResults(){
        System.out.println("Number of people in your group: " + numPeople);
        System.out.println("Number of tables: " + numTables);
        System.out.println("Number of chairs: " + totalChairs);
        System.out.println("Number of extra chairs: " + extraChairs);
    }
}
