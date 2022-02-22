import java.awt.*;

public class ServiceCenterDot extends Representations{

    private Location location;

    //uses the location parameter to gain the coordinate for where the service center should be placed upon the map.
    ServiceCenterDot(Location location) {
        super(location);
        this.location = location;

    }

    //places the service center at the 500,500 starting location on the map
    ServiceCenterDot() {
        Location location = new Location(500,500);
        this.location = location;

    }

    //empty update(), does not need to be filled as the service center does not need to be moved following its placement
    @Override
    public void update() {
    }

    //paints the dot for the service center on the truck map and uses location to determine where the dot will be placed.
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);

    }
}