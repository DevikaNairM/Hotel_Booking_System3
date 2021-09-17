package controller;

public class CustomerValidator {

    public double getObjects(String name, String type, int person, int days) {
        double billTotal = 0;
        AddCustomer obj = new AddCustomer();
        boolean roomValidate = obj.validateTypeofRoom(type);
        boolean daysValidate = obj.validateNumberOdStay(days);
        boolean noOfPerson = obj.validateNoofextraPersons(person);
        if (roomValidate == false)
            System.out.println("Enter a valid type of room");
        else if (daysValidate == false)
            System.out.println("You can stay only 15 days or minimum 1 day");
        else if (noOfPerson == false)
            System.out.println("Only 0-2 are allowed");
        else {
            int charge;
            if (type == "Standard")
                charge = 2500;
            else if (type == "Deluxe")
                charge = 3500;
            else
                charge = 5500;
            billTotal = obj.calculateBill(charge, days, person);


        }

        return billTotal;
    }


}
