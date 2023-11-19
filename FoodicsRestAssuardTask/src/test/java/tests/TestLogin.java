package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class TestLogin {
String token = "";
	
	String body = "{\r\n"
			+ "  \"email\": \"merchant@foodics.com\",\r\n"
			+ "  \"password\": \"123456\",\r\n"
			+ "  \"token\":\"Lyz22cfYKMetFhKQybx5HAmVimF1i0xO\"\r\n"
			+ "}\r\n"
			+ "";
	
	@Test
	public void loginTest(){
		
		Response login = given().header("Content-Type", "application/json")
				.body(body)
				.post("https://pay2.foodics.dev/cp_internal/login");
		
		login.prettyPrint();
		Assert.assertEquals(login.statusCode(), 200, "response status code is not 200 as expected");
		token = login.body().jsonPath().get("token");
	}
	
	@Test
	public void whoAMITest(){
		
		Response WhoAMI = given().auth().oauth2(token)
				.when().get("https://pay2.foodics.dev/cp_internal/whoami");
		System.out.println(WhoAMI.statusCode());
	    WhoAMI.prettyPrint();
	    Assert.assertEquals(WhoAMI.statusCode(), 200, "response status code is not 200 as expected");
	}
	
	@Test
	public void whoAMITestWithoutToken(){
		
		Response WhoAMI = given()
				.when().get("https://pay2.foodics.dev/cp_internal/whoami");
		System.out.println(WhoAMI.statusCode());
	    WhoAMI.prettyPrint();
	    Assert.assertEquals(WhoAMI.statusCode(), 200, "response status code is not 200 as expected");
	}
	
	@Test
    public void incorrectLoginCredentials() {
        String invalidCredentials = "{\r\n"
                + "  \"email\": \"invalid@foodics.com\",\r\n"
                + "  \"password\": \"Abcdefg123\",\r\n"
                + "  \"token\":\"HHGDHBNIID55765567BHSJND\"\r\n"
                + "}\r\n";

        Response response = given().header("Content-Type", "application/json")
                .body(invalidCredentials)
                .post("https://pay2.foodics.dev/cp_internal/login");

        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 302, "response status code is not 302 as expected");
    }
	
	@Test
	public void invalidEmailLogin() {
	    String invalidEmailBody = "{\r\n"
	            + "  \"email\": \"invalid_email\",\r\n"
	            + "  \"password\": \"123456\",\r\n"
	            + "  \"token\":\"Lyz22cfYKMetFhKQybx5HAmVimF1i0xO\"\r\n"
	            + "}\r\n";

	    Response response = given().header("Content-Type", "application/json")
	            .body(invalidEmailBody)
	            .post("https://pay2.foodics.dev/cp_internal/login");

	    response.prettyPrint();
	    Assert.assertEquals(response.statusCode(), 302, "response status code is not 302 as expected");
	}
	
	@Test
	public void invalidPasswordLogin() {
	    String invalidPasswordBody = "{\r\n"
	            + "  \"email\": \"merchant@foodics.com\",\r\n"
	            + "  \"password\": \"Abcdefg123\",\r\n"
	            + "  \"token\":\"Lyz22cfYKMetFhKQybx5HAmVimF1i0xO\"\r\n"
	            + "}\r\n";

	    Response response = given().header("Content-Type", "application/json")
	            .body(invalidPasswordBody)
	            .post("https://pay2.foodics.dev/cp_internal/login");

	    response.prettyPrint();
	    Assert.assertEquals(response.statusCode(), 500, "response status code is not 500 as expected");
	}
	
}
