package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
	public void getMethod01() {
		
		Response response = given().
				            when().
				               get("https://restful-booker.herokuapp.com/booking");
		
		//To see response body on the console use prettyPrint() method
		response.prettyPrint();
		//To see status code on the console use getStatusCode() or statusCode()
		System.out.println(response.getStatusCode());//200
		
		//To assert status code type the following
		//Assert the format of response body, it should be in Json format
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     contentType(ContentType.JSON);//"application/json" is possible as well
	
	}
	
	@Test
	public void getMethod02() {
		
		Response response = given().when().get("https://restful-booker.herokuapp.com/booking/3");
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
		
		//Assert the status code
		//Assert the format of response body, it should be in Json format
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON);//"application/json" is possible as well
		
	}

}