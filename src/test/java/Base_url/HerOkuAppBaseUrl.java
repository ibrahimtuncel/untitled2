package Base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {
//base url baska sınıfta olusturulup kullanılır.


//RequestSpecification data tipinde bir obje olustrurus
   protected RequestSpecification spec;//interface obje olustrurulamas


    @Before // bu metod her @test metotundan önce calısır.
    public void setUp(){
            spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
            //login otomatik olarak kullanıcı sifre tanıma vb.
    }

}
