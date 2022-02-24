public class Location {

        private int x;
        private int y;

    /**
     * creates basic location of (0,0)
     */
    Location() {
            x = y = 0;
        }

    /**
     * creates location based on input coordinates
     * @param x
     * @param y
     */
    Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    /**
     * returns x coordinate
     * @return
     */
    int getX() {
            return x;
        }

    /**
     * returns y coordinate
     * @return
     */
    int getY() {
            return y;
        }

    /**
     * sets destination for object to travel to from its location
     * @param x
     * @param y
     * @return
     */
        public Location setDestination (int x, int y){
            this.x = x;
            this.y = y;
            Location destination = new Location(this.x, this.y);
            return destination;
        }

    /**
     * calculates distance between two locations
     * @param v1
     * @param v2
     * @return
     */
        public static double distance(Location v1, Location v2)
        {
            double result;
            result = Math.pow((v1.getX() - v2.getX()), 2) + Math.pow((v1.getY() - v2.getY()), 2);
            result = Math.pow(result, 0.5);
            return result;
        }

    /**
     * true if truck location is equal to house location
     * @param obj
     * @return
     */
    @Override
        public boolean equals(Object obj) {
            Location other = (Location) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
