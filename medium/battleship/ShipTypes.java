package battleship;

public enum ShipTypes {             // special data type that enables for a variable to be a SET of predefined constants.

    // ships are associtaed with length property
    // when a constant is created, (shipType xd = shipTypes.BATTLESHIP) its values are passed to the constructor, just like an object.

    AIRCRAFT_CARRIER(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3,"Cruiser"),
    DESTROYER(2, "Destroyer");

    private int length;
    private String name;

    ShipTypes(int length, String name){      // must be private
        this.length = length;
        this.name = name;
    }

    public int length(){
        return length;
    }
    public String toString(){
        return this.name;
    }



}
