package class01_get_http_request_method;

import Base_url.HerOkuAppBaseUrl;
import Utils.JsonUtil;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetVeObjectMapper02 extends HerOkuAppBaseUrl {

/*
    Given
         https://restful-booker.herokuapp.com/booking/2
    When
         Url'e GET Request gonder
    Then
         Status code is 200
        {
            "firstname": "Mark",
            "lastname": "Ericsson",
            "totalprice": 726,
            "depositpaid": true,
            "bookingdates": {
                    "checkin": "2015-08-07",
                    "checkout": "2020-10-25"
                            },
            "additionalneeds": "Breakfast"
           }
 */

    @Test
    public void getWithObjectMapper02(){

        //1.Step: Set the url
        spec.pathParams("first", "booking", "second", 2);

        //2.Step: Set the expected data
        //1.Way
        String expectedData = "{\n" +
                "\"firstname\": \"Mary\",\n" +
                "\"lastname\": \"Jackson\",\n" +
                "\"totalprice\": 757,\n" +
                "\"depositpaid\": false,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2017-04-20\",\n" +
                "\"checkout\": \"2021-02-04\"\n" +
                "},\n" +
                "\"additionalneeds\": \"Breakfast\"\n" +
                "}";
        HashMap<String, Object> expectedDataMap = JsonUtil.jsonJavayaCevir(expectedData, HashMap.class);

        //2.Way: Create a setUp method to convert Json data to String dynamically ==> Homework


        //3.Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String, Object> actualDataMap = JsonUtil.jsonJavayaCevir(response.asString(), HashMap.class);

        //4.Step: Do Assertions
        assertEquals(200, response.getStatusCode());

        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));
    }

}
