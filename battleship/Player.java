package battleship;
                    // human player that takes input from console.
public abstract class Player {   // for easier future implementations, ie: computer players
    // needed these getters and setters whilst needing interface for placeship and shoot, so abstract class.
    protected BattleField field;
    protected ShipTypes ships[];
    protected String name;

    public Player(BattleField field, String name){
        this.field = field;
        this.name = name;
        this.ships = new ShipTypes[]{ShipTypes.AIRCRAFT_CARRIER, ShipTypes.BATTLESHIP, ShipTypes.SUBMARINE, ShipTypes.CRUISER, ShipTypes.DESTROYER};
    }

    public BattleField getField(){
        return field;
    }

    public String name(){
        return this.name;
    }

    public ShipTypes[] getShips(){
        return ships;
    }

    //reasoning for having this implementation: all classes that extend this class shoot the same way, just input may differ.

    public void shot(Part coord, Player opponent){       // finds ship that was hit and set it's part to hit.

        BattleField field = opponent.getField();

        for (Ship p : field.placedShips()){

            Part[] shipParts = p.getParts();
            for (int i=0; i<shipParts.length; i++) {

                if (shipParts[i].equals(coord)) {    // hit

                    shipParts[i].setHit();
                    field.updateField(coord, "X");

                    if (p.isSunk()){

                        if (field.isGameOver()){
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            System.exit(0);
                        }

                        else System.out.println("You sank a Ship!");
                    }
                    else System.out.println("\nYou hit a ship!");      // can also print which ship it hit...

                    return;

                }
            }
        }
        // miss

        field.updateField(coord, "M");
        System.out.println("\nYou missed!");

    }

    public void placeShips(){ //  rules of the game does not change, thus this code is valid for different players

        BattleField playerField = getField();

        System.out.println("Player " + name() + ", place your ships on the game field");
        playerField.printField();

        ShipTypes ships[] = getShips();

        for (int i = 0; i < ships.length; i++) {
            System.out.println("\nEnter the coordinates of the " + ships[i] + " (" + ships[i].length() + " cells):");

            while (true) {

                Ship ship = inputShip(ships[i]); // can be any class that implemnts playear interface


                if (!ship.getOrientation().equals("Horizontal") && !ship.getOrientation().equals("Vertical")) {
                    System.out.println("Error! Wrong ship location! Try again:");
                } else if (ship.calculatedLength() != ship.length()) {
                    System.out.println("Error! Wrong length of the " + ship + "! Try again:");
                } else if (playerField.isSpaceOccupied(ship.getParts()) || playerField.emptyShipNeighbourhood(ship.position()) == false) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                } else {

                    playerField.placeShip(ship);
                    playerField.printField();
                    break;
                }
            }
        }
    }

    abstract Ship inputShip(ShipTypes type);
    abstract Part inputShoot();

}
