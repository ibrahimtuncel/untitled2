package class02_post_http_request_method;

import Base_url.JsonPlaceHolderBaseUrl;
import Utils.JsonUtil;
import class06_pojos.JsonPlaceHolderPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostVeObjectMapperVePojo extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test

    public void postWithObjectMapperAndPojo01(){
//1.step: set the url
        spec.pathParam("first", "todos");

//2.step
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();
        String expectedData = expected.expectedDataInString(55, "Tidy your room", false);

        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.jsonJavayaCevir(expectedData, JsonPlaceHolderPojo.class);
        System.out.println(expectedDataPojo);

//3.step: send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataPojo).when().post("/{first}");
        response.prettyPrint();

        JsonPlaceHolderPojo actualDataPojo = JsonUtil.jsonJavayaCevir(response.asString(), JsonPlaceHolderPojo.class);

//4. Do assertion
        assertEquals(201, response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(), actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(), actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(), actualDataPojo.getCompleted());

    }
}
