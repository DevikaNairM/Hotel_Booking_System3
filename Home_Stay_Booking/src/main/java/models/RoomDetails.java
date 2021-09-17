package models;

public class RoomDetails {

    private int billId;
    private String customerName;
    private String typeOfRoom;
    private int noOfExtraPerson;
    private int noOfExtraDays;
    static int counter;

    public RoomDetails(int billId, String customerName, String typeOfRoom, int noOfExtraPerson, int noOfExtraDays) {
        this.billId = billId;
        this.customerName = customerName;
        this.typeOfRoom = typeOfRoom;
        this.noOfExtraPerson = noOfExtraPerson;
        this.noOfExtraDays = noOfExtraDays;
    }

    public int getBillId() {
        return billId;
    }



    public String getCustomerName() {
        return customerName;
    }
    public int getNoOfExtraPerson() {
        return noOfExtraPerson;
    }
    public int getNoofExtraDays() {
        return noOfExtraDays;
    }

    public void setNoofExtraDays(int noofExtraDays) {
        this.noOfExtraDays = noofExtraDays;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        RoomDetails.counter = counter;
    }
}
