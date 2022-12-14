package class01_get_http_request_method;

import Base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.AssertJUnit.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Dane&lastname=Dominguez
        When
            Kullanici GET requesti URL'e gonderir
        Then
            Status code : 200
	  	And
	  	    Data'lar arasinda ismi (firstname) “Dane” ve soyismi (lastname) “Dominguez” olan biri olmali
     */
//querryParam-s spesifik parametreleri secmek icin kullanılır. ? sonrası
    //pathParams ise resources-kaynak kucultmek icin kullanilir. ? öncesi
    @Test
    public void Get05() {
        spec.pathParam("first", "booking").queryParams("firstname","Dane", "lastname","Dominguez");

        Response response= given().spec(spec).when().get("/{first}");
        //response.prettyPrint();
        response.print();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("bookingid",hasItem(8933));

        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));

    }
}