package Base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    @Before //eger metodun userinde before annotation eklenince bu methot her bir test metodundan önce calisir.
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
        System.out.println();
        //constructor kuruldu

    }
}