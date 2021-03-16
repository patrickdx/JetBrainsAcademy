package tictactoe;

public class Grid {

    private final char [][] grid;
    private final int n;      // 3x3
    private int moveCount=0;

    public Grid(){     // guarantees methods like checkIfEmptyCells() work b/c it ensures input to be initalized.

        grid = new char[][]
                {{'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}};

        n = 3;

    }
    public void placeMove(int x, int y, char turn) {
        grid[x - 1][y - 1] = turn;
        moveCount++;
    }

    public char switchTurns(char turn){

        if (turn == ('O')){
            return 'X';
        }
        return 'O';
    }

    public boolean checkOccupied(int x, int y){

        return grid[x-1][y-1] != ('_');

    }

    public String whichSymbolWon(int x1, int y1,char symbol){       // winning row/col/diagonal can only come from the most recent move

        int x = x1-1;
        int y = y1-1;

        // check col
        for(int i = 0; i < n; i++){
            if(grid[x][i] != symbol)
                break;
            if(i == n-1){
                return (symbol + " wins");
            }
        }

        //check row
        for(int i = 0; i < n; i++){
            if(grid[i][y] != symbol)
                break;
            if(i == n-1){
                return(symbol + " wins");
            }
        }

        //check diag
        if(x == y){
            //on a diagonal
            for(int i = 0; i < n; i++){
                if(grid[i][i] != symbol)
                    break;
                if(i == n-1){       // if gets to end of loop
                    return(symbol + " wins");

                }
            }
        }

        //check anti diag
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(grid[i][(n-1)-i] != symbol)
                    break;
                if(i == n-1){
                    return(symbol + " wins");
                }
            }
        }

        //check draw
        if(moveCount == (Math.pow(n, 2))){
            return("Draw");
        }
        return "";
    }

    public void printGrid(){

        System.out.println("---------");
        System.out.printf("| %c %c %c | %n", grid[0][0], grid[0][1], grid[0][2]);
        System.out.printf("| %c %c %c | %n", grid[1][0], grid[1][1], grid[1][2]);
        System.out.printf("| %c %c %c | %n", grid[2][0], grid[2][1], grid[2][2]);
        System.out.println("---------");
    }

}
