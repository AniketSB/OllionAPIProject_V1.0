package com.example.stackExchange.stepdefs;

import com.example.stackExchange.util.Util;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralSteps {
    private Response response;
    Util Util = new Util();
    Faker faker = new Faker(new Locale("en-GB"));


    @Given("user call the get endpoint to get badges {string} for {string}")
    public void usercallthegetendpointtotogetbadges(String badge, String identifier)
    {
            response = Util.get(Util.getServiceUrlWithPath(badge,identifier));
    }

    @When("user receive a {int} HTTP response")
    public void userreceivehttpresponse(Integer statuscode) {

        if (statuscode.equals(200)) {

            Assertions.assertThat(response.statusCode()).isEqualTo(statuscode);
            assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

        } else if (statuscode.equals(404)) {

            Assertions.assertThat(response.statusCode()).isEqualTo(statuscode);
            assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
        }
        else if (statuscode.equals(400)) {

            Assertions.assertThat(response.statusCode()).isEqualTo(statuscode);
            assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);

        }
    }

    @Then("verify response parameters are available")
    public void verifyresponseparametersavailable(List<List<String>> outputParam) {

        JsonPath jsonPathEvaluator = response.jsonPath();
        for (int i = 0; i < outputParam.size(); i++) {

            if ((jsonPathEvaluator.getJsonObject("$").toString().contains("["))) {
                Assert.assertEquals(outputParam.get(1).get(i), ((java.util.ArrayList) jsonPathEvaluator.get((outputParam.get(0).get(i)))).get(0).toString());

            } else {
                Assert.assertEquals(outputParam.get(1).get(i), jsonPathEvaluator.get(outputParam.get(0).get(i)).toString());

            }
        }
    }

    @Then("verify error response body")
    public void verifyerrorresponsebody() {
        if (!response.asString().contains("Invalid controller specified")) {
            Assert.fail();
        }
    }


}
