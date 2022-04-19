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
     * @param intersection
     * @param upDown
     * @param leftRight
     */
    public void move(Location destination, Location intersection, boolean upDown, boolean leftRight)
    {
        if(location.equals(destination)) {
            destinations.removeFirst();
            truck.update();
        }

        else {

            if (destination.getY() > location.getY() && upDown)
                truckMoveDown();

            else if(destination.getY() > location.getY() && !upDown)
            {
                if (destination.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(intersection);

            }


            else if (destination.getY() < location.getY() && upDown)
                truckMoveUp();

            else if(destination.getY() < location.getY() && !upDown)
            {
                if (destination.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(intersection);

            }


            else if (destination.getX() > location.getX() && leftRight)
                truckMoveRight();

            else if(destination.getX() > location.getX() && !leftRight)
            {
                if (destination.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(intersection);

            }


            else if (destination.getX() < location.getX() && leftRight)
                truckMoveLeft();

            else if(destination.getX() < location.getX() && !leftRight)
            {
                if (destination.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(intersection);
            }
        }
    }

    /**
     *
     * @return distanceTravelled
     */
    public double getDistanceTravelled()
    {
        return distanceTravelled;
    }


    private void truckMoveUp(){
        location.setLocation(location.getX(), location.getY()-10);
        distanceTravelled += 0.01;
    }


    private void truckMoveDown(){
        location.setLocation(location.getX(), location.getY()+10);
        distanceTravelled += 0.01;
    }


    private void truckMoveLeft(){
        location.setLocation(location.getX()-10, location.getY());
        distanceTravelled += 0.01;
    }

    private void truckMoveRight(){
        location.setLocation(location.getX()+10, location.getY());
        distanceTravelled += 0.01;
    }


}
