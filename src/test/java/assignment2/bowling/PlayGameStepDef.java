package assignment2.bowling;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlayGameStepDef {

    private Game game = new Game();

    private int rolls;


    // Roll a ball
    @Given("I hit {int} pins")
    public void i_hit_pins(Integer int1) {
        game.roll(int1);
    }


    @When("I roll the ball")
    public void i_roll_the_ball() {
        game.score();
    }

    @Then("I get {int} points")
    public void i_get_points(Integer int1) {
        assert (game.score() == int1);
    }


    // Play a game

    @Given("I roll the ball {int} times")
    public void i_roll_the_ball_times(Integer int1) {
        rolls = int1;
    }

    @Given("I roll {int} Strike")
    public void i_roll_Strike(Integer int1) {
        for (int i = 0; i < int1; i++)
            game.roll(10);
    }

    @Given("I roll {int} Spare")
    public void i_roll_Spare(Integer int1) {
        game.roll(5);
        game.roll(5);

    }

    @And("I hit {int} pins each time")
    public void i_hit_pins_each_time(Integer int1) {
        for (int i = 0; i < rolls; i++) {
            game.roll(int1);
        }
    }

    @And("I hit {int} and {int} on the next two rolls")
    public void i_hit_and_on_the_next_two_rolls(Integer int1, Integer int2) {
        game.roll(int1);
        game.roll(int2);
    }

    @And("I hit {int} pins on the remaining rolls")
    public void i_hit_pins_on_the_remaining_rolls(Integer int1) {
        for (int i = 0; i < game.getRemainingRolls(); i++) {
            game.roll(int1);
        }
    }


    @When("I play a game of bowling")
    public void i_play_a_game_of_bowling() {
        game.score();
    }

    @Then("I get a total of {int} points")
    public void i_get_a_total_points(Integer int1) {
        assert (game.score() == int1);
    }

}
