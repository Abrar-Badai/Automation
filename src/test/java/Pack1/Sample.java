package Pack1;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Sample{
	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		given().
			param("name","Automation").
			get("/subjects").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void  test_post() {
		
		JSONObject request = new JSONObject();
		request.put("FirstName", "Allu");
		request.put("LastName", "Arjun");
		request.put("SubjectId", 6);
		baseURI = "http://localhost:3000/";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();	
	}
	@Test
	public void test_patch() {
		
		
		JSONObject request = new JSONObject();
		request.put("LastName", "Khan");
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch("/users/1").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
		public void  test_put() {
			
			JSONObject request = new JSONObject();
			request.put("FirstName", "Pavan");
			request.put("LastName", "kumar");
			request.put("SubjectId", 1);
			baseURI = "http://localhost:3000/";
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type","application/json").
				body(request.toJSONString()).
			when().
				put("/users/2").
			then().
				statusCode(200).
				log().all();	
		}
		@Test
		public void test_delete() {
			
			baseURI = "http://localhost:3000/";
			when().
				delete("/subjects/2").
			then().
				statusCode(200);
		}
	
}