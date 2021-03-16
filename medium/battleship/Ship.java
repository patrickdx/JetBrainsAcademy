package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship{                          // a ship has position, length, type ...

    private ShipTypes type;
    private Part parts[];                   // pieces that make up a ship
    private ShipCoords position;

    public Ship(ShipTypes type){
        this.type = type;
    }

    public Ship (ShipTypes type,ShipCoords coords){
        this.type = type;
        this.position = coords;
        this.parts = new Part [type.length()];
        initalizeParts();
    }


    public void initalizeParts(){       // splits ship into parts

        if (position.isHorizontal()){

            int smallestCol = position.getSmallestCol();

            for (int i=0; i<length(); i++){
                parts[i] = new Part(getRow(), smallestCol);
                smallestCol++;
            }
        }
        else if (position.isVertical()){
            int smallestRow = position().getSmallestRow();

            for (int i=0; i<length(); i++){
                parts[i] = new Part(smallestRow, getCol());
                smallestRow++;
            }
        }

    }

    public boolean isSunk(){ // if only 1 part of the ship is still alive, its still playing.

        for (Part p : parts){
            if (p.isHit() == false){
                return false;
            }
        }
        return true;
    }

    public String getOrientation(){

        if (position.isHorizontal()){
            return "Horizontal";
        }else if (position.isVertical()){
            return "Vertical";
        }
        return "";
    }

    public int calculatedLength(){

      return position.calculatedLength();

    }


    public Enum getShipType(){
        return this.type;
    }

    public int getRow(){
        return this.position.getRow();
    }

    public int getCol(){
        return this.position.getCol();
    }

    public int length(){
        return this.type.length();
    }

    public ShipCoords position(){
        return this.position;
    }

    public Part[] getParts(){   // returns coordinates of each "block" of the ship.
        return this.parts;
    }

    public String toString(){
        return this.type.name();
    }



}