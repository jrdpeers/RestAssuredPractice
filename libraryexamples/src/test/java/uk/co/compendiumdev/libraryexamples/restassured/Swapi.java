package uk.co.compendiumdev.libraryexamples.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Swapi{
	public Planet planet;
	public Person person;
	public Starship starship;
	public Vehicle vehicle;
	
	public Vehicle getVehicle(int id){
        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(
                "http://swapi.co/api/vehicles/" + id + "/?format=json").
                andReturn();

        String json = response.getBody().asString();
        Vehicle vehicle = new JsonPath(json).getObject("$", Vehicle.class);
		
		return vehicle;
	}
	
	public Person getPerson(int id){
        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(
                "http://swapi.co/api/people/" + id + "/?format=json").
                andReturn();

        String json = response.getBody().asString();
        Person person = new JsonPath(json).getObject("$", Person.class);
		Assert.assertEquals(200, response.getStatusCode());
		return person;
	}

	public Planet getPlanet(int id) {
        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(
                "http://swapi.co/api/planets/" + id + "/?format=json").
                andReturn();

        String json = response.getBody().asString();
        Planet planet = new JsonPath(json).getObject("$", Planet.class);
		
		return planet;
		}
	
		public Starship getStarship(int id) {
            // use RestAssured to make an HTML Call
            Response response = RestAssured.get(
                    "http://swapi.co/api/starships/" + id + "/?format=json").
                    andReturn();

            String json = response.getBody().asString();
            Starship starship = new JsonPath(json).getObject("$", Starship.class);
    		
    		return starship;
	}
}