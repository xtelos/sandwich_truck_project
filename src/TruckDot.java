import java.awt.*;

public class TruckDot extends Representations{

    private Location location;
    private Location destination;
    private boolean hasArrived;

    /**
     * creates a truck with a specific location and a target destination to drive to
     * @param location
     * @param destination
     */
    TruckDot(Location location, Location destination) {
        super(location, destination);
        this.location = location;
        this.destination = destination;

    }

    /**
     * Constructor without a specific start location
     */
    TruckDot() {
        Location location = new Location();
        this.location = location;

    }

    public boolean isArrived(){
        return hasArrived;
    }

    /**
     * when truck is moving, if truck arrives, it stops. If not, update is called until it has arrived
     */
    @Override
    public void update() {
        if(location.equals(destination))
            hasArrived = true;
        else
        {
           //code that would make the truck move along the road
        }
    }

    /**
     * paints the truck onto the grid
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);

    }
}
