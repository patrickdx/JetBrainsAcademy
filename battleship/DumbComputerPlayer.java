package battleship;

import java.util.Random;
// computer that randomly generates position for placement of ship, and shot. (brute force)
public class DumbComputerPlayer extends  Player{


    public DumbComputerPlayer(BattleField field, String name){
        super(field, name);
    }

    public String randomCoord(){

        Random r = new Random();
        char c = (char)(r.nextInt(10) + 'A');
        int d = r.nextInt(10) +1;
        return c + Integer.toString(d);

    }

    @Override
    Ship inputShip(ShipTypes type) {

        String [] array = new String [2];
        for (int i=0; i<2; i++){
            array[i] =randomCoord();
        }

        ShipCoords coords = new ShipCoords(new Part(array[0]), new Part(array[1]));
        return new Ship(type, coords);

    }

    @Override
    Part inputShoot() {

        return new Part(randomCoord());
    }

}
