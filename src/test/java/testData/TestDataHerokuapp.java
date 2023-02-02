package testData;

import java.util.HashMap;
import java.util.Objects;

public class TestDataHerokuapp {


    public HashMap bookingDatesOlusturMap(){
        HashMap<String, Object> booklingDates= new HashMap<>();

        booklingDates.put("checkin","2021-06-01");
        booklingDates.put("checkout","2021-06-01");


        return booklingDates;
    }


    public HashMap bookingOlusturMap(){
        HashMap<String, Object> booking= new HashMap<>();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500.0);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingDatesOlusturMap());
        booking.put("additionalneeds","wi-fi");


        return booking;
    }

  public HashMap expBodyOlusturMap(){

        HashMap<String, Object> expData= new HashMap<>();

        expData.put("bookingid",24.0);
        expData.put("booking",bookingOlusturMap());


        return expData;
    }



}
