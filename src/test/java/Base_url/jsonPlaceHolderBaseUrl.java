package Base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class jsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    @Before //eger metodun userinde before annotation eklenince bu methot her bir tes metodundan önce calisir.
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
        //constructor kuruldu

    }
}