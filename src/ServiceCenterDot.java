import java.awt.*;

public class ServiceCenterDot extends Representations{

    private Location location;

    /**
     * Constructor with a specific start location within parameter
     */
    ServiceCenterDot(Location location) {
        super(location);
        this.location = location;

    }

    /**
     * Constructor without a specific start location
     */
    ServiceCenterDot() {
        Location location = new Location(500,500);
        this.location = location;

    }

    /**
     * Empty update(), as the service center will not need to be moved during operation
     */
    @Override
    public void update() {
    }

    /**
     * Places the service center on the map as a blue dot
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);

    }
}