package battleship;

import java.util.Scanner;

public class Main {


    private Scanner scanner;

    private Player currentPlayer;
    private Player otherPlayer;
    private Player player1;
    private Player player2;


    public Main(Scanner scanner, BattleField field1, BattleField field2, Player player1, Player player2) {
        this.scanner = scanner;

        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = this.player1;  // player 1 starts
        this.otherPlayer = this.player2;
    }


    public void changeTurn() {

        if (currentPlayer instanceof HumanPlayer){
            System.out.println("Press Enter and pass the move to another player\n");
            scanner.nextLine();
        }


        if (currentPlayer.name().equals("1")) {
            currentPlayer = player2;
            otherPlayer = player1;

        } else {
            currentPlayer = player1;
            otherPlayer = player2;
        }
    }

    public void printBoard() {

        System.out.println();
        currentPlayer.getField().printBog();        // prints user's view of the opponent (fog of war)
        System.out.println("---------------------");
        currentPlayer.getField().printField();
        System.out.println();


    }

    public void fight() {

        while (true) {   // take a shot
            printBoard();
            System.out.println("Player " + currentPlayer.name() + ", it's your turn:");

            Part coord = currentPlayer.inputShoot();

            if (coord.isOutOfBounds()) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");

            } else {
                currentPlayer.shot(coord, otherPlayer);
                changeTurn();

            }

        }

    }


        public void gameStart () {

            currentPlayer.placeShips();
            changeTurn();
            currentPlayer.placeShips();
            changeTurn();
            fight();


        }


        public static void main (String[]args){

            BattleField field1 = new BattleField();
            BattleField field2 = new BattleField();

            // specify which players
            Player player1 = new HumanPlayer(field1, "1");
            Player player2 = new HumanPlayer(field2, "2");


            Scanner scanner = new Scanner(System.in);
            Main main = new Main(scanner, field1, field2, player1, player2);

            main.gameStart();

        }

    }


