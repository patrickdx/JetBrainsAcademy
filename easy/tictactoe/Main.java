package tictactoe;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner (System.in);
        String [] array = new String[2];
        int [] inputs = new int [array.length];
        int x=0;
        int y=0;
        char turn = 'O';

        Grid grid = new Grid();
        grid.printGrid();


        while (true){                                                  // user input
            System.out.print("Enter the coordinates: ");

            array = scanner.nextLine().split(" ");

            try{
                x = Integer.parseInt(array[0]);
                y = Integer.parseInt(array[1]);

            }
            catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
                continue;
            }
            if ((x < 1 || x > 3) || (y < 1 || y > 3 )){
                System.out.println("Coordinates should be from 1 to 3!");

            }
            else if (grid.checkOccupied(x, y)){
                System.out.println("This cell is occupied! Choose another one!");
            }
            else{       // when no input errors

                turn = grid.switchTurns(turn);
                grid.placeMove(x, y, turn);
                grid.printGrid();
                String result = grid.whichSymbolWon(x, y, turn);

                if (!result.isEmpty()){         // game is finished
                    System.out.println(result);
                    break;
                }
            }
        }

    }


}
