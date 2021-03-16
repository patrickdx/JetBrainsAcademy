package battleship;

import java.sql.SQLOutput;
import java.util.*;

public class BattleField {

    private String[][] battlefield;
    private String [][] bog;
    private List<Ship> playerShips;

    public BattleField() {
        battlefield = new String[][]{

                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        };



        bog =  new String[][]{      // fog of war

                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        };


        playerShips = new ArrayList<>();
    }

    public void printField() {

        System.out.println();
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {

                System.out.print(battlefield[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void printBog(){
        System.out.println();
        for (int i = 0; i < bog.length; i++) {
            for (int j = 0; j < bog[i].length; j++) {

                System.out.print(bog[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<Ship> placedShips(){
        return playerShips;
    }

    public void placeShip(Ship ship) {

        for (Part i : ship.getParts()) {
            battlefield[i.getRow()][i.getCol()] = "O";
        }
        playerShips.add(ship);    // add to ship  databse
    }


    public boolean isSpaceOccupied(Part[] parts){

       for (Ship p  : playerShips){

           for (int i=0; i< parts.length; i++){
                                                            // uses .equals
               if (Arrays.asList(p.getParts()).contains(parts[i])){    // checks if positions for parts of the ship are already taken
                   return true;
               }
           }
       }
       return false;

    }


    public boolean emptyShipNeighbourhood(ShipCoords coords) {      // check neighbours of ship u want to place

        int minRow = coords.getSmallestRow();
        int maxRow = coords.getBiggestRow();
        int minCol = coords.getSmallestCol();
        int maxCol = coords.getBiggestCol();


        //~~~~~~~~~
        //~OOOOOOO~
        //~~~~~~~~~

        for (int rowNum=minRow-1; rowNum<=maxRow+1; rowNum++) {
            for (int colNum=minCol-1; colNum<=maxCol+1; colNum++) {
                try {
                    if (battlefield[rowNum][colNum].equals("O")){       // ship occupied
                        return false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    // ship placed at edge of board...
                }

            }
        }
        return true;
    }


    public void updateField(Part coord, String symbol){     // M = MISS, X = HIT

        battlefield[coord.getRow()][coord.getCol()] = symbol;

    }

    public boolean isGameOver(){

        for (Ship i : playerShips){
            if (!i.isSunk()){
                return false;
            }
        }
        return true;

    }

    }

