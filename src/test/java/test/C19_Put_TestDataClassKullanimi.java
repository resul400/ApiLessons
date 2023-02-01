package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;


public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */

    @Test
    public void putt01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder= new TestDataJsonPlaceHolder();

        JSONObject reqBody= testDataJsonPlaceHolder.requestBodyOlusturJSON();

        JSONObject expData= testDataJsonPlaceHolder.requestBodyOlusturJSON();

        Response response= given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody.toString()).
                put("/{pp1}/{pp2}");

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlaceHolder.contentType,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlaceHolder.connectionHeaderDegeri,response.getHeader("Connection"));

        JsonPath resJP= response.jsonPath();
        Assert.assertEquals(expData.get("title"),resJP.get("title"));
        Assert.assertEquals(expData.get("body"),resJP.get("body"));
        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expData.get("id"),resJP.get("id"));












    }




}
