package test;

import baseURL.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;
import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class C23_Get_DeSerialization extends DummyBaseURL {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
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

        HashMap<String, Object> expData= testDataDummy.expectedBodyOlusturMap();



        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        Assert.assertEquals(testDataDummy.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataDummy.contentType,response.getContentType());
        HashMap<String, Object> respMap= response. as(HashMap.class);

        Assert.assertEquals(expData.get("status"),respMap.get("status"));
        Assert.assertEquals(expData.get("message"),respMap.get("message"));

        Assert.assertEquals(((Map)(expData.get("data"))).get("id"),              ((Map)respMap.get("data")).get("id"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_name"),   ((Map)respMap.get("data")).get("employee_name"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_salary"), ((Map)respMap.get("data")).get("employee_salary"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_age"),    ((Map)respMap.get("data")).get("employee_age"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("profile_image"),    ((Map)respMap.get("data")).get("profile_image"));

    }
}
