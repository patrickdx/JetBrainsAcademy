package battleship;

public class ShipCoords {

    private Part bow;     // front                              // back----front
    private Part stern;       // back

    public ShipCoords(Part front, Part back){
        this.stern = back;
        this.bow = front;
    }

    public boolean isHorizontal(){

        return stern.getRow() == bow.getRow();
    }

    public boolean isVertical(){
        return stern.getCol() == bow.getCol();
    }

    public int getRow(){    // for horizontal orientation
        return bow.getRow();
    }

    public int getCol(){    // for veritcal orientation

        return stern.getCol();
    }

    public int getSmallestCol(){ // take the smallest coord number.
        return Math.min(stern.getCol(), bow.getCol());
    }

    public int getSmallestRow(){
        return Math.min(bow.getRow(), stern.getRow());
    }

    public int getBiggestCol(){
        return Math.max(stern.getCol(), bow.getCol());
    }

    public int getBiggestRow(){
        return Math.max(stern.getRow(), bow.getRow());
    }

    public int calculatedLength(){

        if (isHorizontal()){
            return Math.abs(stern.getCol() - bow.getCol())+1;
        }

        else if (isVertical()){
            return Math.abs(stern.getRow() - bow.getRow())+1;
        }
        return 0;
    }


}
