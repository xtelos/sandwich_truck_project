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
     * @return x
     */
    int getX() {
            return x;
        }

    /**
     * returns y coordinate
     * @return y
     */
    int getY() {
            return y;
        }

    /**
     * sets destination for object to travel to from its location
     * @param x
     * @param y
     * @return location
     */
        public Location setLocation(int x, int y){
            this.x = x;
            this.y = y;
            return new Location(this.x, this.y);
        }

    /**
     * calculates distance between two locations
     * @param v1 First location
     * @param v2 Second location
     * @return double
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
     * @return boolean
     */
    @Override
        public boolean equals(Object obj) {
            Location other = (Location) obj;
            return x == other.x && y == other.y;
        }

    /**
     * Returns a with the location details
     * @return String
     */
    @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

    /**
     * returns the x value of the closest intersection's x value
     * @return int
     */
    public int getClosestIntersectionX() {
        int streetMod = this.x % 100;
        if (streetMod == 0)
            return x;
        else if (streetMod >= 50)
            return this.x + (100 - streetMod);
        else
            return this.x - streetMod;
    }

    /**
     * returns the y value of the closest intersection's x value
     * @return int
     */
    public int getClosestIntersectionY() {
        int streetMod = this.y % 100;
        if (streetMod == 0)
            return y;
        else if (streetMod >= 50)
            return this.y + (100 - streetMod);
        else
            return this.y - streetMod;
    }


    /**
     * converts street into c address to display
     * @param street
     * @return int
     */
    public String streetToLetter(int street)
    {
        if (street < 100)
            return "A ";

        else if (street < 200)
            return "B ";

        else if (street < 300)
            return "C ";

        else if (street < 400)
            return "D ";

        else if (street < 500)
            return "E ";

        else if (street < 600)
            return "F ";

        else if (street < 700)
            return "G ";

        else if (street < 800)
            return "H ";

        else if (street < 900)
            return "I ";

        else
            return "J ";
    }

}
