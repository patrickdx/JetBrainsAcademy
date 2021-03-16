package battleship;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(BattleField field, String name) {
        super(field, name);
        scanner = new Scanner(System.in);
    }


    @Override
    public Ship inputShip(ShipTypes name) {

        String[] array = scanner.nextLine().split(" ");
        ShipCoords coords = new ShipCoords(new Part(array[0]), new Part(array[1]));
        return new Ship(name, coords);
    }

    @Override
    public Part inputShoot(){       // finds ship that was hit and set it's part to hit.

        String coord = scanner.nextLine();

       return new Part(coord);
    }



}
