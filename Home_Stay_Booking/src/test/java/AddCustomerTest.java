import controller.AddCustomer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

class AddCustomerTest {

private AddCustomer addCustomer;

    @BeforeEach
    void objectCreater(){
        addCustomer =new AddCustomer();
    }
    @Test
    void validateNoofextraPersons() {
        //AddCustomer obj1=new AddCustomer();
        assertTrue( addCustomer.validateNoofextraPersons(3));
    }
    @Test
    void validateTypeOfRoom(){
        assertTrue(addCustomer.validateTypeofRoom("Standard"));
    }

        @ParameterizedTest
        @ValueSource(strings= {"Standard","Deluxe","Cottage"} )
        public void validateTypeOfRoom(String type){
            System.out.println("Type "+type);
            assertTrue(addCustomer.validateTypeofRoom(type));
        }




}