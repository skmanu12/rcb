package myCode;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import payloads.payloads;

public class Verify_RCB_TeamAsAtleastOneWicketKeeper {

	@Test
	public void verifyTeamAsOnly4ForeignPlayers() {

		payloads p = new payloads();
		JsonPath js = new JsonPath(p.rcbTeams());

		int teamSize = js.getInt("player.size()");
		System.out.println(teamSize);
		String wicketKeeper = "Wicket-keeper";
		int count = 0;
		for (int i = 0; i < teamSize; i++) {
			String role = js.getString("player[" + i + "].role");

			if (wicketKeeper.equalsIgnoreCase(role)) {
				// System.out.println(js.getString("player[" + i + "].name"));
				count++;
			}

		}
		Assert.assertEquals(count, 1);

		if (count > 1) {
			System.out.println("Teams contains more than 1 wicket-keeper");
		} else {
			System.out.println("Teams contains atleast one wicket keper");
		}
	}

}
