package test;

import baseURL.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends DummyBaseURL {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.
    Expected Body
    {
    "status":"success",
    "data": {
            "id": 3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */


    @Test
    public void get01(){

        specDummy.pathParams("pp1","employee","pp2",3);

        TestDataDummy testDataDummy= new TestDataDummy();

        JSONObject expData= testDataDummy.expectedBodyOlusturJson();

        Response response= given().spec(specDummy).when().get("/{pp1}/{pp2}");

        TestDataJsonPlaceHolder testDataJsonPlaceHolder= new TestDataJsonPlaceHolder();

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());

        JsonPath resJP= response.jsonPath();

        Assert.assertEquals(expData.get("status"),resJP.get("status"));
        Assert.assertEquals(expData.get("message"),resJP.get("message"));
        Assert.assertEquals(expData.getJSONObject("data").get("id"),resJP.get("data.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        Assert.assertEquals(expData.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));

    }

}
