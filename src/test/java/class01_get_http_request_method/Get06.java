package class01_get_http_request_method;

import Base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.*;

public class Get06 extends HerOkuAppBaseUrl{
/*
        Given
            https://restful-booker.herokuapp.com/booking/141
        When
            Kullanici GET request gonderir => URL
        Then
            HTTP Status Code: 200
        And
            Response content type : “application/json”
        And
            Response body asagidaki gibi olmali;
            {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"

     */
    @Test
    public void Get06(){

        //1.set the url
        spec.pathParams("first","booking", "second",141);

        // 2 beklenen detayı set et

        //3 request gönder get response al.

        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4 adım assertion dogrulama
        //1. yol
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Rachel")).
                body("lastname", equalTo("Anderson")).
                body("totalprice", equalTo(84)).
                body("depositpaid", equalTo(true)).
                body("bookingdates.checkin", equalTo("2023-03-17")).
                body("bookingdates.checkout",equalTo("2023-03-18")).
                body("additionalneeds", equalTo(null));



        //2.yol JsonPath kullanarak assertion yapariz
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath json = response.jsonPath();
        assertEquals( "Soyisimler eslesmiyor","Rachel", json.getString("firstname") );
        assertEquals("Soyisimler eslesmiyor", "Anderson", json.getString("lastname") );
        assertEquals("total price eslesmiyor", 84, json.getInt("totalprice") );
        assertEquals("depositpaid eslesmiyor", true, json.getBoolean("depositpaid") );
        assertEquals("Checkin date eslesmiyor", "2023-03-17", json.getString("bookingdates.checkin") );
        assertEquals("Checkout date eslesmiyor", "2023-03-18", json.getString("bookingdates.checkout") );

        //3.yol SoftAssert
        //i- SoftAssert objesini olusturma
        SoftAssert softAssert = new SoftAssert();

        //ii- SoftAssert objesini kullanarak Assertion yapmak
        softAssert.assertEquals(json.getString("firstname"),"Rachel", "isimler eslesmiyor");
        softAssert.assertEquals(json.getString("lastname"),"Anderson", "Soyisimler eslesmiyor");


        //iii-MUTLAKA EN SONDA assertAll() yapilmali. Eger assertAll() kullanmazsaniz her zaman testiniz gecti gorunur fakat bu anlamli olmayabilir
        softAssert.assertAll();

    }


}



