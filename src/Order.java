public class Order {

    private Address address;
    private TimeStamp timeStamp;

    public Order(Address address, TimeStamp timeStamp) {
        this.address = address;
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return address.toString() + ", " + timeStamp.toString();
    }
}
