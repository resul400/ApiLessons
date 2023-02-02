package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {

/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */


    @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder= new TestDataJsonPlaceHolder();

        HashMap<String,Object> reqBody= testDataJsonPlaceHolder.requestBodyOlusturMap();

        HashMap<String,Object> expDataMap= testDataJsonPlaceHolder.requestBodyOlusturMap();

        Response response= given().
                                   spec(specJsonPlace).
                                   contentType(ContentType.JSON).
                           when().
                                   body(reqBody).put("/{pp1}/{pp2}");

        HashMap<String,Object> respMap= response.as(HashMap.class);

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expDataMap.get("title"),respMap.get("title"));
        Assert.assertEquals(expDataMap.get("body"),respMap.get("body"));
        Assert.assertEquals(expDataMap.get("userId"),respMap.get("userId"));
        Assert.assertEquals(expDataMap.get("id"),respMap.get("id"));

    }

}
