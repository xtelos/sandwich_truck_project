public class Location {

        private int x;
        private int y;


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
        public Location setLocation(int x, int y){
            this.x = x;
            this.y = y;
            return new Location(this.x, this.y);
        }

    /**
     * calculates distance between two locations
     * @param v1
     * @param v2
     * @return
     */
        public double distance(Location v1, Location v2)
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

    /**
     * returns the x value of the closest intersecrtion's x value
     * @return
     */
    public int getClosestIntersectionX() {
        int streetMod = this.x % 100;
        if (streetMod >= .5)
            return this.x + (1 - streetMod)* 100;
        else
            return this.x - (streetMod * 100);
    }

    /**
     * returns the y value of the closest intersecrtion's x value
     * @return
     */
    public int getClosestIntersectionY() {
        int streetMod = this.y % 100;
        if (streetMod >= .5)
            return this.y + (1 - streetMod)* 100;
        else
            return this.y - (streetMod * 100);
    }

    public Location getClosestIntersection(){
        return new Location(getClosestIntersectionX(),getClosestIntersectionY());
    }

}
