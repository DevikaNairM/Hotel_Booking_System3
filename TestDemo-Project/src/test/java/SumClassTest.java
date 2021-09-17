import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SumClassTest {
    @Test
    public void AddTest(){
        SumClass s=new SumClass();
        int result=s.sum(5,2);
        assertEquals(7,result);
    }
    @Test
    public void ConcatTest(){
        SumClass s2=new SumClass();
        String result=s2.Concatinate("Devika","Nair");
        assertEquals("DevikaNair",result);
    }

}