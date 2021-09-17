package controller;

import models.RoomBillComponent;

public class AddCustomer implements RoomBillComponent {

    public double calculateBill(int roomcharge, int noOfdays, int noofExtraPerson) {

        double totalBill = (noOfdays * roomcharge) + (noOfdays * RoomBillComponent.foodCharge) + (extraPersonCharge * noOfdays);
        totalBill = totalBill + totalBill * RoomBillComponent.tax;
        return totalBill;
    }

    public boolean validateNoofextraPersons(int noOfPeople) {
        if (noOfPeople > 3)
            return false;
        else
            return true;

    }

    public boolean validateTypeofRoom(String type) {
        if (type == "Standard" || type == "Deluxe" || type == "Cottage")
            return true;
        else
            return false;
    }

    public boolean validateNumberOdStay(int days) {
        if (days < 2 || days > 16) {
            return false;
        } else
            return true;

    }
}
