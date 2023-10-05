package com.mycompany.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    //making the below arrays, arrayLists and variable accesible everywhere
    private static int[] row1 = new int[12];
    private static int[] row2 = new int[16];
    private static int[] row3 = new int[20];
    private static int rowNumber;
    private static int seatNumber;
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static ArrayList<Double> prices = new ArrayList<Double>();

    public static void main(String[] args) {
        System.out.println("\n            Welcome to the New Theatre");

        //making each row array filled with the value 0
        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);

        //calling on the menu() function
        menu();
    }

    private static void menu() {
        System.out.println("***********************MENU***********************");
        System.out.println("\n    1. Buy a ticket");
        System.out.println("    2. Print seating area");
        System.out.println("    3. Cancel ticket");
        System.out.println("    4. List available seats");
        System.out.println("    5. Save to file");
        System.out.println("    6. Load from file ");
        System.out.println("    7. Print ticket information and total price");
        System.out.println("    8. Sort tickets by price");
        System.out.println("    0. Quit");
        System.out.println("\n**************************************************");

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter option :");
        int optionSelected = userInput.nextInt();
        
        switch (optionSelected) {
            case 1:
                buyTickets();
                System.out.println();
                menu();
                break;
            case 2:
                printSeatingArea();
                System.out.println();
                menu();
                break;
            case 3:
                cancelTicket();
                System.out.println();
                menu();
                break;
            case 4:
                showAvailable();
                System.out.println();
                menu();
                break;
            case 5:
                save();
                System.out.println();
                menu();
                break;
            case 6:
                load();
                System.out.println();
                menu();
                break;
            case 7:
                printTicketsInfo();
                System.out.println();
                menu();
                break;
            case 8:
                sortPrices();
                System.out.println();
                menu();
                break;
            case 0:
                System.out.println("Goodbye!");
        }      
    }

    private static void buyTickets() {
        Scanner userInput2 = new Scanner(System.in);

        System.out.println("\n******************Ticket Purchase*****************");
    
        do {
        System.out.print("Enter row number: ");
        int rowNumber = userInput2.nextInt();
        }
        while (rowNumber > 3 || rowNumber < 1);
        
        
        //a switch case to navigate between rows
        switch (rowNumber) {
            case 1:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput2.nextInt();
                seatNumber = seatNumber - 1;
            }
            //makes sure the seatNumber is within the correct range
            while (seatNumber > row1.length || seatNumber < 0);
                
                if (row1[seatNumber] == 0) {
                    System.out.print("Seat available. Now Booking");
                    row1[seatNumber] = 1;
                    //calling the constructor
                    Person person = new Person();
                    System.out.print("Enter price: ");
                    double price = userInput2.nextDouble();
                    //adding price and ticket to the ticket constructor
                    prices.add(price);
                    Ticket ticket = new Ticket(rowNumber, seatNumber + 1, price, person);
                    tickets.add(ticket);
                    break;
                }
                else {
                    System.out.print("Sorry this seat is unavailable.");
                    break;
                }
            

            case 2:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput2.nextInt();
                seatNumber = seatNumber - 1;
            }
            while (seatNumber > row2.length || seatNumber < 0);
                
                if (row2[seatNumber] == 0) {
                    System.out.print("Seat available. Now Booked");
                    row2[seatNumber] = 1;
                    Person person = new Person();
                    System.out.print("Enter price: ");
                    double price = userInput2.nextDouble();
                    prices.add(price);
                    Ticket ticket = new Ticket(rowNumber, seatNumber + 1, price, person);
                    tickets.add(ticket);
                    break;
                }
                else {
                    System.out.print("Sorry this seat is unavailable.");
                    break;
                }
            
            case 3:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput2.nextInt();
                seatNumber = seatNumber - 1;
            }
            while (seatNumber > row3.length || seatNumber < 0);

                if (row3[seatNumber] == 0) {
                    System.out.print("Seat available. Now Booked");
                    row3[seatNumber] = 1;
                    Person person = new Person();
                    System.out.print("Enter price: ");
                    double price = userInput2.nextDouble();
                    prices.add(price);
                    Ticket ticket = new Ticket(rowNumber, seatNumber + 1, price, person);
                    tickets.add(ticket);
                    break;
                }
                else {
                    System.out.print("Sorry this seat is unavailable.");
                    break;
                }
        }        
    }
    
    private static void printSeatingArea() {
        System.out.println("\n*******************Seating Area*******************\n");
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");

        for (int i = 0; i < row1.length; i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println("");
        for (int i = 0; i < row2.length; i++) {
            if (i== 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println("");
        for (int i = 0; i < row3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }  
        System.out.print("\n\nO - Seat is available\nX - Seat is unavailable"); 
    }

    private static void cancelTicket() {
        Scanner userInput4 = new Scanner(System.in);
        System.out.println("\n*******************Cancel Ticket*******************\n");

        //keeps asking for the user to input rows until a valid row in entered
        do {
            System.out.print("Enter row number:");
            rowNumber = userInput4.nextInt();
        }
        //makes sure the row number is in the correct range
        while (rowNumber < 1 || rowNumber > 3);

        switch (rowNumber) {
            case 1:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput4.nextInt();
                seatNumber = seatNumber - 1;

                //if row is not booked this message will be displayed
                if (row1[seatNumber] == 0) {
                    System.out.print("Available. Wrong seat selected");
                    break;
                }
                else {
                    //if seatnumber in the row has a value of 1 these lines of code run to change its value to 0 and remove the ticket
                    System.out.print("Now cancelling ticket");
                    row1[seatNumber] = 0;
                    for (int i = 0; i < tickets.size(); i++) {
                        Ticket ticket = tickets.get(i);
                        if (ticket.getRow() == rowNumber && ticket.getSeat() == seatNumber) {
                            tickets.remove(i + 1);
                            System.out.println("\nTicket cancelled successfully.");
                            return; 
                        }
                    break;
                    }
                }
            } 
            while (seatNumber > row1.length || seatNumber < 0);
            
           

            case 2:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput4.nextInt();
                seatNumber = seatNumber - 1;
            } 
            while (seatNumber > row2.length || seatNumber < 0);
            
            if (row2[seatNumber] == 0) {
                System.out.print("Available. Wrong seat selected");
                break;
            }
            else {
                System.out.print("Now cancelling ticket");
                row2[seatNumber] = 0;
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    if (ticket.getRow() == rowNumber && ticket.getSeat() == seatNumber) {
                        tickets.remove(i + 1);
                        System.out.println("\nTicket cancelled successfully.");
                        return; }
                break;
                }
            }
            case 3:
            do {
                System.out.print("Enter seat number: ");
                seatNumber = userInput4.nextInt();
                seatNumber = seatNumber - 1;
            } 
            while (seatNumber > row3.length || seatNumber < 0);
            
            if (row3[seatNumber] == 0) {
                System.out.print("Available. Wrong seat selected");
                break;
            }
            else if (row3[seatNumber] == 1){
                System.out.print("Now cancelling ticket");
                row3[seatNumber] = 0;
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    if (ticket.getRow() == rowNumber && ticket.getSeat() == seatNumber) {
                        tickets.remove(i + 1);
                        System.out.println("\nTicket cancelled successfully.");
                        return; }
                break;
                }
            }
        }
    }

    private static void showAvailable() {
        System.out.println("\n*******************Available Seats*******************\n");
        System.out.print("Seats available in row 1: ");
        //using a for loop to go through each element in the arrays and then printing them if they are still available as a number
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.print("\nSeats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print(i + 1 +",");
            }
        }
        System.out.print("\nSeats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print(i + 1 + ",");
            }
        }
    }

    private static void save() {
        try {
            //shows the directory
            FileWriter myWriter = new FileWriter("/Users/ibrahimharoon/Documents/Software development II/Coursework/test/rowInformation.txt");
            myWriter.write("Seats available in row 1: ");
            //for each element in the array it writes it to the file
            for (int i = 0; i < row1.length; i++) {
                if (row1[i] == 0) {
                    myWriter.write(i + 1 +",");
                }
            }
            myWriter.write("\nSeats available in row 2: ");
            for (int i = 0; i < row2.length; i++) {
                if (row2[i] == 0) {
                    myWriter.write(i + 1 +",");
                }
            }
            myWriter.write("\nSeats available in row 3: ");
            for (int i = 0; i < row3.length; i++) {
                if (row3[i] == 0) {
                    myWriter.write(i + 1 +",");
                }
            }
            myWriter.close();
            System.out.print("\nNow Saved");

            //catches any errors
        } catch (IOException i) {
            System.out.print("An error occured.");
            i.printStackTrace();
        }
    }

    private static void load() {
        //opens the file and displays its contents
        try {
            File myFile = new File("/Users/ibrahimharoon/Documents/Software development II/Coursework/test/rowInformation.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
              }
              myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void printTicketsInfo() {
        //iterates through ticket and prints its contents
        for (Ticket ticket : tickets) {
            ticket.print();
            System.out.println();
        }

        totalPrice();
}

    private static void totalPrice() {
        //adds each price to the variable totalPrice and then displays it
        double totalPrice = 0;
        for (int i = 0; i < prices.size(); i++) {
            totalPrice += prices.get(i);
        }
        System.out.print(totalPrice);
    }

    private static void sortPrices() {
        //bubble sort the prices in ascending order using for loops
        int pricesSize = prices.size();
        boolean exchanged;
        for (int i = 0; i < pricesSize - 1; i++) {
            exchanged = false;
            for (int j = 0; j < pricesSize - i - 1; j++) {
                if (prices.get(j) > prices.get(j + 1)) {
                    double temp = prices.get(j);
                    prices.set(j, prices.get(j + 1));
                    prices.set(j + 1, temp);
                    exchanged = true;
                }
            }
            if (!exchanged) {
                break;
            }
        }
    }    
}



//References
//https://www.w3schools.com/java/java_methods.asp
//https://www.w3schools.com/java/java_constructors.asp
//https://www.w3schools.com/java/java_arraylist.asp
//https://www.w3schools.com/java/java_files.asp
//https://www.w3schools.com/java/java_files_create.asp
//https://www.w3schools.com/java/java_files_read.asp
//https://www.w3schools.com/java/java_methods_param.asp
//https://www.w3schools.com/java/java_user_input.asp
//https://www.w3schools.com/java/java_try_catch.asp
//https://www.w3schools.com/java/java_encapsulation.asp