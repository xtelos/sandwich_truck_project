import java.awt.*;

public class ServiceCenterDot extends Representations{

    private Location location;
    private Location destination;

    ServiceCenterDot(Location location, Location destination) {
        super(location, destination);
        this.location = location;
        this.destination = destination;

    }

    ServiceCenterDot() {
        Location location = new Location();
        this.location = location;

    }

    @Override
    public void update() {
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);

    }
}