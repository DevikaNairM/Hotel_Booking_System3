import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Guest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EventManager {



    static void filterGuest(List<Guest> guestList){

        Stream<Guest> guestStream=guestList.stream();
       List<Boolean> list1=guestStream.map(s-> Arrays.stream(s.getCountry()).anyMatch("Spain"::equals)).collect(Collectors.toList());
       Boolean value=list1.get(0);
        if(value==true){
            List<Boolean> list2=guestList.stream().map(s-> Arrays.stream(s.getHobbies()).anyMatch("Dance"::equals)).collect(Collectors.toList());
            if(list2.get(0)==true)
                guestList.stream().forEach(System.out::println);
        }

      //  value.forEach(System.out::println);
      //  guestStream.forEach(s-> System.out.println(s.getName()));
       //guestStream.filter(e->e.getName(),("Devika")).forEach(s-> System.out.println(s.getCountry()));
        // guestStream.forEach(System.out::println);

    }

    static List<Guest>  populateGuest(){
        LocalDate date1 = LocalDate.of(1998, 01, 13);
        String[] country=new String[] {"India","Spain","Japan"};
        String[] language=new String[] {"English","Malayalam"};
        String[] hobbies=new String[] {"Music","Dance"};
         Guest g1=new Guest("Devika",date1,country,language,hobbies);

          List<Guest> guestList=new ArrayList<>();
            guestList.add(g1);
        return guestList;
    }

    /*static void filterGuest(Guest value){
          List country=value.getCountry();
          List hobbies=value.getHobbies();
         // country.stream().filter(s->s.equals("Spain"))
        country.stream().filter(s->s.equals("Spain")).forEach(System.out::println);


    }*/
    public static void main(String[] args) {

         List<Guest> guestList= populateGuest();
        filterGuest(guestList);





    }
}
