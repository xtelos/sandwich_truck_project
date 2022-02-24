import java.awt.*;

public abstract class Representations {

    protected Location location;
    protected Location destination;

    protected static final int RADIUS = 10;

    /**
     * Constructor with a location and a destination for the representation
     */
    Representations(Location location, Location destination) {
        this.location = location;
        this.destination = destination;

    }

    /**
     * Creates a representation with only a location
     * @param location
     */
    Representations(Location location)
    {
        this(location, new Location());
    }

    /**
     * Method with returns true if truck (location) has arrived at destination
     * @return
     */
    public boolean hasArrived(){
        return true;
    }

    /**
     * Constructor for representation demo
     */
    Representations()
    {

    }

    /**
     * returns turcks location
     * @return
     */
    public Location getLocation() {
        return location;
    }

    /**
     * updates representations location on the map
     */
    public abstract void update();

    /**
     * paints representation on the map
     * @param g
     */
    public abstract void paint(Graphics g);

}
