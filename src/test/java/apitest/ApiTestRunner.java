package apitest;

import api.ApplicationConfig;
import api.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApiTestRunner extends TestBase {

    private static String baseURL;
    private  static String username;
    private static String password;
    private static String configFile="config.properties";


    @BeforeClass
    public void setup(){
        baseURL= ApplicationConfig.readFromConfigProperties(configFile,"api.baseurl");
        username= ApplicationConfig.readFromConfigProperties(configFile,"api.username") ;
        password=ApplicationConfig.readFromConfigProperties(configFile,"api.password");
    }
    @Test
    public void getPetTest(){
        //sending request to get response
        Response response= RestAssured.given().auth().basic(username,password)
                .when().get(baseURL+"/pet/3");
        System.out.println(response.getBody().prettyPrint());
        // check the status code
        int responseCode= response.getStatusCode();
        Assert.assertEquals(responseCode,200);

    }
    @Test
    public void addPetTest(){
        Response response=RestAssured.given().header("Content-Type","application/Json").and()
                .body(PayloadUtility.getPetPayload("doggie", Integer.parseInt("9"),
                        "available")).auth().basic(username,password)
                .when().post(baseURL+"/pet").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getString("name").contains("doggie"));

    }
    @AfterClass
    public void tearDown () {
        closeBrowser();
    }
}

