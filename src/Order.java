public class Order {

    private Address address;
    private TimeStamp timeStamp;

    public Order(Address address, TimeStamp timeStamp) {
        this.address = address;
        this.timeStamp = timeStamp;
    }

    public Address getAddress() {
        return this.address;
    }

    public TimeStamp getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return address.toString() + "," + timeStamp.toString();
    }
}
