package Model;

public class RoomDetails<String> implements RoomBillComponent{
    private int billId;
    private String customerName;
    private String typeOfRoom;
    private int noOfDaysOfStay;
    private int noOfExtraPerson;
    private static int counter;
    float baseRoomFare = 0;
    public int getBillId() {
        return billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public int getNoOfDaysOfStay() {
        return noOfDaysOfStay;
    }

    public int getNoOfExtraPerson() {
        return noOfExtraPerson;
    }

    public RoomDetails(String customerName, String typeOfRoom, int noOfDaysOfStay, int noOfExtraPerson) {
        this.customerName = customerName;
        this.typeOfRoom = typeOfRoom;
        this.noOfDaysOfStay = noOfDaysOfStay;
        this.noOfExtraPerson = noOfExtraPerson;
    }
    public boolean validateNoOfDaysOfStay(){
        if (this.noOfDaysOfStay> 0 && this.noOfDaysOfStay< 16){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean validateNoOfExtraPerson(){
        if(this.noOfExtraPerson <= 2){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean validateTypeOfRoom(){
        if(this.typeOfRoom == "Standard" || this.typeOfRoom =="Deluxe" || this.typeOfRoom == "Cottage"){
            return true;
        }
        else{
            return false;
        }
    }
//    public double calculateBaseRoomFare(){
//        if(this.typeOfRoom == "Standard"){
//             baseRoomFare = 2500;
//        }
//        if(this.typeOfRoom == "Deluxe"){
//             baseRoomFare = 3500;
//        }
//        if(this.typeOfRoom == "Cottage"){
//             baseRoomFare = 5500;
//        }
//        return baseRoomFare;
//    }
    public void calculateBill(){
        float totalBill = 0;
        if(typeOfRoom == "Standard"){
            baseRoomFare = 2500;
        }
        if(typeOfRoom == "Deluxe") {
            baseRoomFare = 3500;
        }
        else{
            baseRoomFare= 5500;
        }
        totalBill = (float)(this.noOfDaysOfStay*(baseRoomFare + FOOD_CHARGE) + (EXTRA_PERSON_CHARGE * this.noOfExtraPerson)) ;
        totalBill = (float)(totalBill + TAX*totalBill/100);
        System.out.println("The total bill is: "  + totalBill);
    }

    public static void main(String[] args) {
        RoomDetails obj1 = new RoomDetails("Dipesh", "Cottage", 1, 0);

        if(obj1.validateTypeOfRoom()== false){
            System.out.println("Enter a valid type of Room.");
        }
        else if(obj1.validateNoOfExtraPerson()== false){
            System.out.println("Enter a valid number of Extra Person");
        }
        else if(obj1.validateNoOfDaysOfStay() == false){
            System.out.println("Days of stay should be between 1 and 15.");
        }
        else{
            obj1.calculateBill();
        }

    }


}
