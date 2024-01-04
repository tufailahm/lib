package com.training.cms.restapitesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ProductAPITest {

	private String uri = "http://localhost:3000";
	int productId = 617161;
	
	@Test (priority = 2)
	void getRequest1()
	{
			RestAssured.baseURI = uri;
		//	RestAssured.basePath ="product/20";
			given()
				.when()
					.get("product/"+productId)	//617161
						.then()
							.log()
								.all()
									.statusCode(200)
										.body("productName", equalTo("Powercable"));
			
	}
	
	/*
	 * @Test(priority = 2) void getRequestReqRes2() { RestAssured.baseURI =
	 * "http://reqres.in"; RestAssured.basePath ="api/users";
	 * given().queryParam("page",3).body("")
	 * .when().get().then().assertThat().statusCode(200) .body("page", equalTo(3));
	 * }
	 */
	

	
	//testing product save functionality	- save
	@Test(priority = 1)
	
	void postRequestProduct1()
	{
		RestAssured.baseURI = uri;

		RequestSpecification request = RestAssured.given();
		
		JSONObject productObject = new JSONObject();
		productObject.put("productId", productId);		//617161
		productObject.put("productName", "Powercable");
		productObject.put("quantityOnHand", "1");
		productObject.put("price", "1");
		
		request.header("Content-Type","application/json");
		request.body(productObject.toJSONString());
		
			
		request.post("/product").then().assertThat().statusCode(201);
		
	}
	
	
	
	//testing product update functionality
	@Test(priority = 3)
	void putRequestProduct1()
	{
		RestAssured.baseURI = uri;
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject productObject = new JSONObject();
		productObject.put("productId", productId);
		productObject.put("productName", "LatestPowercable");
		productObject.put("quantityOnHand", "100");
		productObject.put("price", "1111");
		
		request.header("Content-Type","application/json");
		request.body(productObject.toJSONString());
			
		request.put("/product/"+productId).then().assertThat().statusCode(200);

	}
	//testing product delete functionality
	@Test(priority = 4)
	
	void deleteRequestProduct1()
	{
		RestAssured.baseURI = uri;
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
	
		request.delete("/product/"+productId).then().assertThat().statusCode(200);

	}
	
	
}
