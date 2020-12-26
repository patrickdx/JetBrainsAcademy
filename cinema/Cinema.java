package cinema;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static int rows;
    public static int seats;
    public static int totalrows;
    public static int totalseats;
    public static int ticket=0;
    public static int currentIncome=0;
    public static Scanner scanner = new Scanner(System.in);
    public static String [][] screenroom1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        totalrows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        totalseats = sc.nextInt();

       String [] top = new String[totalseats+1];
       top[0] = " ";

       for (int i=1; i< totalseats+1; i++){
            top[i] = Integer.toString(i);
       }

         screenroom1 = new String [totalrows+1][totalseats+1];

        for (int row =1; row<screenroom1.length; row++){            // create cinema
            for (int col=0; col<screenroom1[row].length; col++){
                if (col==0){
                    screenroom1[row][col] = Integer.toString(row);
                }else{
                    screenroom1[row][col] = "S";
                }

            }

        }
        screenroom1[0] = top;

     while (true){       // menu
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int user = scanner.nextInt();
            if (user ==0){
                break;
            }

            else if (user == 1){
                print(screenroom1);
            }
            else if (user == 2){
                buyTicket();
            }
            else if (user==3){
                statistics();
            }
        }
    }

    public static void print(String [][] matrix){
        System.out.print("\nCinema:\n");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void statistics(){
        System.out.println("Number of purchased tickets: " + ticket );
        System.out.printf("Percentage: %.2f%s" , 100*(double)ticket/(totalseats*totalrows), "%");       // express as 2 decimal place
        System.out.println("\nCurrent income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome() + "\n");
    }
    public static int totalIncome(){
        int sum=0;
        int row=1;
        for (int i=0; i<totalseats*totalrows; i++){
            if (i%9 ==0 && i!=0){
                row++;
            }

            sum+=determinePrice(row);
        }
        return sum;

    }

    public static int currentIncome(){

        return currentIncome;
    }

    public static void buyTicket() throws IndexOutOfBoundsException{        // method can throw can exception


        while (true){       // if user enters a wrong coord
            input();
            try{
                if (screenroom1[rows][seats].equals("B")){                  // check if ticket is duplicate
                    System.out.println("That ticket has already been purchased!");

                }else{                                      // user buys ticket
                    int price = determinePrice(rows);
                    currentIncome += price;
                    System.out.println("\nTicket Price: $" + price);
                    screenroom1[rows][seats] = "B";
                    ticket++;
                    break;
                }

            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Wrong input!");

            }
        }





    }

    public static void input(){

        System.out.println("Enter a row number:");
         rows = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
         seats = scanner.nextInt();
    }


    public static int determinePrice(int rows){

        int size = totalrows*totalseats;
        int price =10;

        if (size <=60){
            price =10;
        }
        else{                                   // larger room with odd rows gives cheaper tickets to the larger row split. 7 = 4 and 3;  -> 4
            int fronthalf;
            int backhalf;

            if (totalrows % 2 !=0){      // rows is odd

                backhalf = totalrows/2+1;
                fronthalf = totalrows - backhalf;

            }else{
                fronthalf = totalrows/2;
                backhalf= fronthalf;

            }
            if (rows <= fronthalf){
                price = 10;
            }else if (rows > fronthalf){
                price =8;
            }


    }
        return price;
}

    public static void setSeat(String [][] screenroom){
        screenroom[rows][seats] = "B";
    }
        }

