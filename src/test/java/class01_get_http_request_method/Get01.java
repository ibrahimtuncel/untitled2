package class01_get_http_request_method;
import io.restassured.response.Response;
import org.junit.Test;//cerceve testi kolaylastirir.

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    API de Gherkin dili kullanılır.
    anahtar kavramlar kullanılır. given-when-then-and

     */


    /*         test case olusturma
   Given
       https://restful-booker.herokuapp.com/booking/3
   When
       Kullanici GET Request'i Url'e (APi) gonderir
       User send a GET Request to the url (API)
   Then
        HTTP Statu Kodu 200 olmali
       HTTP Status Code should be 200
   And
       Content Type'i JSON olmali
       Content Type should be JSON
   And
       Statu Line(duzeyi) HTTP/1.1 200 OK olmali
       Status Line should be HTTP/1.1 200 OK*/

    @Test
    public void Get01() {
        //1.adim  set the url
        String url = "https://restful-booker.herokuapp.com/booking/5";

        //2. adim  BEKLENEN data -expected data- set et

        //3.adim get request gönderilir get response alinir.

        Response response = given().when().get(url);
        response.prettyPrint();

        //4.adim assertion- dogrulama yap
        //coklu hata var ise ilk hatada durur diğer kodlar calismas.buna hard assortion denir
        //soft assortion(verification-varidation) ise tüm hatalari gösterir rapor verir.


        response.then().assertThat().statusCode(200).contentType("application" +
                "/Json").statusLine("HTTP/1.1 200 OK");
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+ response.getContentType());
        System.out.println("Status Line "+ response.getStatusLine());

        System.out.println("Headers: \n "+ response.getHeaders());
        System.out.println("Via: " + response.getHeader("Via"));
        System.out.println("Date: "+response.getHeader("Date"));
        System.out.println("Time: "+response.getTime());


    }
}

