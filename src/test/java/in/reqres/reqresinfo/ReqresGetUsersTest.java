package in.reqres.reqresinfo;


import in.reqres.testbase.TestBase;
import io.restassured.response.Response;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


/*
 *  Created by Jay
 */
public class ReqresGetUsersTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response = given()
                .queryParams("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

        int page = response.then().extract().path("page");
        System.out.println("Page: " + page);

        int perPage = response.then().extract().path("per_page");
        System.out.println("Per Page :" + perPage);

        int id = response.then().extract().path("data[1].id");
        System.out.println("Id from data :" + id);

        String firstname = response.then().extract().path("data[3].first_name");
        System.out.println("First name :" + firstname);

        List<?> listofdata =  response.then().extract().path("data");
        System.out.println("List of data : " +listofdata.size());

       String avataar=response.then().extract().path("data[5].avatar");
        System.out.println("Get Avatar :"+avataar);

        String url=response.then().extract().path(" support.url");
        System.out.println("Get URL :"+url);

        String supporttext=response.then().extract().path("support.txt");
        System.out.println("Get support text :"+supporttext);
    }


}
