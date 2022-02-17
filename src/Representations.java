import java.awt.*;

public abstract class Representations {

    protected Location location;
    protected Location destination;

    protected static final int RADIUS = 10;

    Representations(Location location, Location destination) {
        this.location = location;
        this.destination = destination;

    }

    Representations(Location location)
    {
        this(location, new Location());
    }

    public boolean hasArrived(){
        return true;
    }

    Representations()
    {

    }

    public Location getLocation() {
        return location;
    }

    public abstract void update();

    public abstract void paint(Graphics g);

}
