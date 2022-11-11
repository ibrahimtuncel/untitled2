package class01_get_http_request_method;

import Base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
   Given
       https://jsonplaceholder.typicode.com/todos/23
   When
       Kullanici GET Request'i Url'e (APi) gonderir
   Then
       HTTP Status Code 200 olmali
   And
       Response formati "application/json" olmali
   And
       "title", "et itaque necessitatibus maxime molestiae qui quas velit" olmali,
   And
       "completed" is false
   And
       "userId"  2 olmali
*/
    @Test
    public void Get03(){
        //1.adım url set et
        spec.pathParams("ilk","todos", "ikinci",23);

        // 2 beklenen detayı set et

        //3 get request gönder get response al.

        //Response response= given().when().get(url);
        //response.prettyPrint();

        Response response= given().spec(spec).when().get("/{ilk}/{ikinci}");
        //response.prettyPrint();
        response.print();

        //4 assertion dogrulama yap
        //1.YOL=
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body( "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId", equalTo(2));

        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        //System.out.println(response.getBody().toString());

       //2.yol
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId", equalTo(2));
    }

}
