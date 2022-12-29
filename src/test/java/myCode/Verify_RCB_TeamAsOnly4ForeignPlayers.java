package myCode;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import payloads.payloads;

public class Verify_RCB_TeamAsOnly4ForeignPlayers {

	@Test
	public void verifyTeamAsOnly4ForeignPlayers() {
		payloads p = new payloads();
		JsonPath js = new JsonPath(p.rcbTeams());
		
		
		int teamSize = js.getInt("player.size()");
		System.out.println(teamSize);
		String Country="India";
		int count = 0;
		for (int i = 0; i < teamSize; i++) {
			String country = js.getString("player[" + i + "].country");

			if (!Country.equalsIgnoreCase(country)) {
				//System.out.println(js.getString("player[" + i + "].name"));
				count++;
			}

		}
		System.out.println(count);

		if (count >4) {
			System.out.println("Teams contains more than 4 Foreign players");
		} else {
			System.out.println("Teams contains 4 Foreign players");
		}
	}

}
