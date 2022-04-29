import java.util.LinkedList;

public class TruckMovement {

    public Truck truck;
    public LinkedList<Location> destinations;
    public Location location;
    public double distanceTravelled;

    public TruckMovement(Truck truck, LinkedList<Location> destinations)
    {
        this.truck = truck;
        this.location = truck.location;
        this.destinations = destinations;
        this.distanceTravelled = 0;
    }

    /**
     * logic for the movement of the truck
     * @param destination
     * @param upDown
     * @param leftRight
     */
    public void move(Location destination, boolean upDown, boolean leftRight)
    {
        if(location.equals(destination)) {
            destinations.removeFirst();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
            }
        }

        else {
            if (Math.abs(destination.getX() - location.getX()) > Math.abs(destination.getY() - location.getY())) {
                if (destination.getX() > location.getX() && leftRight)
                    truckMoveRight();

                else if (destination.getX() > location.getX() && !leftRight)
                    moveUpOrDown(destination);

                else if (destination.getX() < location.getX() && leftRight)
                    truckMoveLeft();

                else if (destination.getX() < location.getX() && !leftRight)
                    moveUpOrDown(destination);
            }
            else
                {
                    if (destination.getY() > location.getY() && upDown)
                        truckMoveDown();

                    else if (destination.getY() > location.getY() && !upDown)
                        moveLeftOrRight(destination);

                    else if (destination.getY() < location.getY() && upDown)
                        truckMoveUp();

                    else if (destination.getY() < location.getY() && !upDown)
                        moveLeftOrRight(destination);
                }
            }
        }


    /**
     * moves truck up or down based on condition and destination
     * @param destination
     */
    private void moveUpOrDown(Location destination) {
        if (destination.getClosestIntersectionY() > location.getY())
            truckMoveDown();
        else
            truckMoveUp();
    }
    /**
     * moves truck left or right based on condition and destination
     * @param destination
     */
    private void moveLeftOrRight(Location destination) {
        if (destination.getClosestIntersectionX() > location.getX())
            truckMoveRight();
        else
            truckMoveLeft();
    }

    /**
     *
     * @return distanceTravelled
     */
    public double getDistanceTravelled()
    {
        return distanceTravelled;
    }


    /**
     * moves truck up
     */
    private void truckMoveUp(){
        location.setLocation(location.getX(), location.getY()-10);
        distanceTravelled += 0.01;
    }


    /**
     * moves truck down
     */
    private void truckMoveDown(){
        location.setLocation(location.getX(), location.getY()+10);
        distanceTravelled += 0.01;
    }


    /**
     * moves truck left
     */
    private void truckMoveLeft(){
        location.setLocation(location.getX()-10, location.getY());
        distanceTravelled += 0.01;
    }

    /**
     * moves truck right
     */
    private void truckMoveRight(){
        location.setLocation(location.getX()+10, location.getY());
        distanceTravelled += 0.01;
    }


}