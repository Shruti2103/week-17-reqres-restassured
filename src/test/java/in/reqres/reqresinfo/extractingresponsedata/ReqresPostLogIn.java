package in.reqres.reqresinfo.extractingresponsedata;

import in.reqres.model.ReqresPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresPostLogIn extends TestBase {
    @Test
    public void createPostLogIn() {
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setName ("eve.holt@reqres.in");
        reqresPojo.setJob("cityslicka");

        Response response=given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }



}
