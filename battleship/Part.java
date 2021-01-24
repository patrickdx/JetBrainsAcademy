package battleship;

import java.util.Objects;

public class Part {

    private final int row;
    private final int col;
    private boolean hit;

    public Part(String coord){   // 1 coord           // A10

        this.row = coord.charAt(0)-'A'+1;                       // A in row index
        this.col = Integer.parseInt(coord.substring(1));        // 10

    }
    public Part(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return row == part.row && col == part.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public int getRow(){
        return row;

    }
    public int getCol(){
        return col;
    }

    public String toString(){
        return "(" + row + ", " + col +")";
    }

    public void setHit(){
        hit = true;
    }
    public boolean isHit(){
        return hit;
    }

    public boolean isOutOfBounds(){
        if (row > 10 || (col > 10)){
            return true;
        }
        return false;
    }


}
