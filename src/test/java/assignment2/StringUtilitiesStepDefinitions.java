package assignment2;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilitiesStepDefinitions {

    private final StringUtility StringUtility = new StringUtility();
    private String string;
    private String actualAnswer;

    @Given("I have a string {string}")
    public void string_is(String string) {
        this.string = string;
    }

    @When("I reverse the string")
    public void i_reverse_the_string() {
        actualAnswer = StringUtility.reverseString(string);
    }

    @When("I capitalize the string")
    public void i_capitalize_the_string() {
        actualAnswer = StringUtility.capitalizeString(string);
    }

    @When("I lowercase the string")
    public void i_lowercase_the_string() {
        actualAnswer = StringUtility.lowerCaseString(string);
    }

    @Then("I get {string}")
    public void i_get(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}