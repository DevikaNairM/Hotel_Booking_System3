package controller;

import models.RoomDetails;

public class HomeStay {
    public static void main(String[] args) {
        String CustomerName = "Devika";
        String typeOfRoom = "Standard";
        int noOfPersons = 3;
        int numberOfDays = 5;
        int id = 100;
        CustomerValidator obj = new CustomerValidator();
        double billAmount = obj.getObjects(CustomerName, typeOfRoom, noOfPersons, numberOfDays);
        RoomDetails obj2 = new RoomDetails(id, CustomerName, typeOfRoom, noOfPersons, numberOfDays);
        if (billAmount > 0.0) {
            System.out.println("id:\t" + obj2.getBillId());
            System.out.println("Name:\t" + obj2.getCustomerName());
            System.out.println("No of Days:\t" + obj2.getNoofExtraDays());
            System.out.println("No of persons:\t" + obj2.getNoOfExtraPerson());
            System.out.println("Total Bill:\t" + billAmount);
        }
    }
}
