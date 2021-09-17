package models;

public interface RoomBillComponent {
    double tax = 0;
    double extraPersonCharge = 0;
    double foodCharge = 800;

    double calculateBill(int roomcharge, int noOfdays, int noofExtraPerson);

}
