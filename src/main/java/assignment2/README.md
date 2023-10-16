# Assignment 2

## 1. REFLECTIONS

### 1.1 Computer mouse

___Identify the types of testing you would perform on a computer mouse, to make sure
that it is of the highest quality.___

* I would test the individual components of the mouse, such as the buttons, the scroll wheel, the laser, etc.

* I would also test the mouse as a whole, by using it on a computer and checking if it works as expected.

* I would test the mouse on different surfaces, to make sure that it works on all surfaces.

### 1.2 Catastrophic failure

___Find a story where a software system defect had a bad outcome. Describe what
happened. Can you identify a test that would have prevented it?___

The Y2K bug is a good example of a software system defect that could have had a bad outcome. The Y2K bug was a bug in
the software
that caused the year to be stored as a two-digit number, which meant that the year 2000 would be stored as 00. This
caused a lot of problems, because the software would think that the year was 1900 instead of 2000.

The whole world feared that this would cause a major catastrophe, with planes falling from the sky, power plants
shutting down, etc.

Luckily, this did not happen, because the bug was discovered in time and fixed.

A test that would have prevented this bug would be a test that checked if the year was stored as a two-digit number or a
four-digit number.

## 2. Two katas

Complete the following using BDD.

### 2.1 String Utility

Use BDD to create a string utility with the following methods:

* Reverse string (aBc -> cBa)
* Capitalize string (aBc -> ABC)
* Lowercase string (aBc -> abc)
*

Don’t use any built-in string utility – create your own. Remember, the exercise here is to
use BDD, not to deliver a working utility without tests. If there are no tests in the
solution, it won’t be accepted.

#### src/test/resources/assignment2/string_utility.feature:

```
Feature: String utilities

  Scenario: Reverse string
    Given I have a string "aBc"
    When I reverse the string
    Then I get "cBa"


    Scenario: Capitalize string
    Given I have a string "aBc"
    When I capitalize the string
    Then I get "ABC"

    Scenario: Lowercase string
    Given I have a string "aBc"
    When I lowercase the string
    Then I get "abc"
```

#### src/test/java/assignment2/StringUtilitiesStepDefinitions.java:

```
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
```

#### src/main/java/assignment2/StringUtility.java:

```
class StringUtility {
    String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    String capitalizeString(String string) {
        return string.toUpperCase();
    }

    String lowerCaseString(String string) {
        return string.toLowerCase();
    }
}
```

### 2.2 Bowling Game

Complete the Bowling Game Kata using BDD. The slides can be found here:
http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt

I made the following features/scenarios:

#### src/test/resources/assignment2/bowling/play_game.feature:

```
Feature: Playing a game of bowling

  Scenario Outline: Play a game with <rolls> rolls and <pins> pins
    Given I roll the ball <rolls> times
    And I hit <pins> pins each time
    When I play a game of bowling
    Then I get a total of <points> points

    Examples:
      | rolls | pins | points |
      | 20    | 1    | 20     |
      | 21    | 5    | 150    |
      | 12    | 10   | 300    |


  Scenario: Play a game with 1 Strike
    Given I roll 1 Strike
    And I hit 3 and 4 on the next two rolls
    And I hit 0 pins on the remaining rolls
    When I play a game of bowling
    Then I get a total of 24 points

  Scenario: Play a game with 2 consecutive Strikes
    Given I roll 1 Spare
    And I hit 3 and 4 on the next two rolls
    And I hit 0 pins on the remaining rolls
    When I play a game of bowling
    Then I get a total of 20 points
```

#### src/test/resources/assignment2/bowling/roll_bowling_ball.feature:

```
Feature: Roll the ball

  Scenario Outline: Roll the ball
    Given I hit <pins> pins
    When I roll the ball
    Then I get <score> points



  Examples:
    | pins | score |
    | 0    | 0     |
    | 1    | 1     |
    | 2    | 2     |
    | 3    | 3     |
    | 4    | 4     |
    | 5    | 5     |
    | 6    | 6     |
    | 7    | 7     |
    | 8    | 8     |
    | 9    | 9     |
    | 10   | 10    |
```

#### src/test/java/assignment2/PlayGameStepDef.java:

```
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
```

#### When i run the tests: (All tests pass)

```
Scenario Outline: Play a game with 20 rolls and 1 pins # assignment2/bowling/play_game.feature:11
  Given I roll the ball 20 times                       # assignment2.bowling.PlayGameStepDef.i_roll_the_ball_times(java.lang.Integer)
  And I hit 1 pins each time                           # assignment2.bowling.PlayGameStepDef.i_hit_pins_each_time(java.lang.Integer)
  When I play a game of bowling                        # assignment2.bowling.PlayGameStepDef.i_play_a_game_of_bowling()
  Then I get a total of 20 points                      # assignment2.bowling.PlayGameStepDef.i_get_a_total_points(java.lang.Integer)

Scenario Outline: Play a game with 21 rolls and 5 pins # assignment2/bowling/play_game.feature:12
  Given I roll the ball 21 times                       # assignment2.bowling.PlayGameStepDef.i_roll_the_ball_times(java.lang.Integer)
  And I hit 5 pins each time                           # assignment2.bowling.PlayGameStepDef.i_hit_pins_each_time(java.lang.Integer)
  When I play a game of bowling                        # assignment2.bowling.PlayGameStepDef.i_play_a_game_of_bowling()
  Then I get a total of 150 points                     # assignment2.bowling.PlayGameStepDef.i_get_a_total_points(java.lang.Integer)

Scenario Outline: Play a game with 12 rolls and 10 pins # assignment2/bowling/play_game.feature:13
  Given I roll the ball 12 times                        # assignment2.bowling.PlayGameStepDef.i_roll_the_ball_times(java.lang.Integer)
  And I hit 10 pins each time                           # assignment2.bowling.PlayGameStepDef.i_hit_pins_each_time(java.lang.Integer)
  When I play a game of bowling                         # assignment2.bowling.PlayGameStepDef.i_play_a_game_of_bowling()
  Then I get a total of 300 points                      # assignment2.bowling.PlayGameStepDef.i_get_a_total_points(java.lang.Integer)

Scenario: Play a game with 1 Strike       # assignment2/bowling/play_game.feature:16
  Given I roll 1 Strike                   # assignment2.bowling.PlayGameStepDef.i_roll_Strike(java.lang.Integer)
  And I hit 3 and 4 on the next two rolls # assignment2.bowling.PlayGameStepDef.i_hit_and_on_the_next_two_rolls(java.lang.Integer,java.lang.Integer)
  And I hit 0 pins on the remaining rolls # assignment2.bowling.PlayGameStepDef.i_hit_pins_on_the_remaining_rolls(java.lang.Integer)
  When I play a game of bowling           # assignment2.bowling.PlayGameStepDef.i_play_a_game_of_bowling()
  Then I get a total of 24 points         # assignment2.bowling.PlayGameStepDef.i_get_a_total_points(java.lang.Integer)

Scenario: Play a game with 2 consecutive Strikes # assignment2/bowling/play_game.feature:23
  Given I roll 1 Spare                           # assignment2.bowling.PlayGameStepDef.i_roll_Spare(java.lang.Integer)
  And I hit 3 and 4 on the next two rolls        # assignment2.bowling.PlayGameStepDef.i_hit_and_on_the_next_two_rolls(java.lang.Integer,java.lang.Integer)
  And I hit 0 pins on the remaining rolls        # assignment2.bowling.PlayGameStepDef.i_hit_pins_on_the_remaining_rolls(java.lang.Integer)
  When I play a game of bowling                  # assignment2.bowling.PlayGameStepDef.i_play_a_game_of_bowling()
  Then I get a total of 20 points                # assignment2.bowling.PlayGameStepDef.i_get_a_total_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:12
  Given I hit 0 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 0 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:13
  Given I hit 1 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 1 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:14
  Given I hit 2 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 2 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:15
  Given I hit 3 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 3 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:16
  Given I hit 4 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 4 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:17
  Given I hit 5 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 5 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:18
  Given I hit 6 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 6 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:19
  Given I hit 7 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 7 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:20
  Given I hit 8 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 8 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:21
  Given I hit 9 pins            # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 9 points           # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)

Scenario Outline: Roll the ball # assignment2/bowling/roll_bowling_ball.feature:22
  Given I hit 10 pins           # assignment2.bowling.PlayGameStepDef.i_hit_pins(java.lang.Integer)
  When I roll the ball          # assignment2.bowling.PlayGameStepDef.i_roll_the_ball()
  Then I get 10 points          # assignment2.bowling.PlayGameStepDef.i_get_points(java.lang.Integer)
```

## Investigation of tools

### 3.1 JUnit 5

___Investigate JUnit 5 (Jupiter). Explain the following, and how they are useful.___

* @Tag
* @Disabled
* @RepeatedTest
* @BeforeEach, @AfterEach
* @BeforeAll, @AfterAll
* @DisplayName
* @Nested
* assumeFalse, assumeTrue

### @Tag

Tags are used to filter tests. This is useful if you want to run only a specific set of tests, for example if you want
to run only the tests that are related to a specific feature.

### @Disabled

This annotation is used to disable a test. This is useful if you want to disable a test temporarily, for example if you
want to disable a test that is failing, so that you can focus on fixing the other tests first.

### @RepeatedTest

This annotation is used to repeat a test a specified number of times. This is useful if you want to test a method with
different inputs.

### @BeforeEach, @AfterEach

These annotations are used to run a method before/after each test. This is useful if you want to set up some data
before each test, or clean up after each test.

### @BeforeAll, @AfterAll

These annotations are used to run a method before/after all tests. This is useful if you want to set up some data
before all tests, or clean up after all tests.

### @DisplayName

This annotation is used to set a custom display name for a test. This is useful if you want to give a test a more
descriptive name.

### @Nested

This annotation is used to create a nested test class. This is useful if you want to group tests together.

### assumeFalse, assumeTrue

These methods are used to skip a test if a condition is not met. This is useful if you want to skip a test if a
condition is not met.

### 3.2 Mocking frameworks

___Investigate mocking frameworks for your preferred language. Choose at least two
frameworks, and answer the questions. (One could be Mockito, which we saw in class.)___

* What are their similarities?
* What are their differences?
* Which one would you prefer, if any, and why?

I chose to investigate Mockito and EasyMock.

Link https://www.javatpoint.com/mockito-vs-easymock

#### Similarities

* Create mock objects.
* Test code that depends on other code.
* Test code that is hard to test.
* Test code that has external dependencies.
* Test code that has non-deterministic behavior.
* Test code that has slow performance.
* Test code that has a complex setup.

#### Differences

| Parameters          | Mockito                                                                                                                                                                                                    | EasyMock                                                                                                                                                     |
|---------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| License             | Mockito framework was released under the MIT (Massachusetts Institute of Technology) License.                                                                                                              | The EasyMock framework was released under the Apache License.                                                                                                |
| Support test spies  | Mockito supports both mocks as well as spies. Both spies and mocks perform different functions. Spy creates a partial mock object, whereas mock creates a dummy/ fake (fully mock) object of the real one. | Whereas EasyMock supports only mocks. It does not support spies.                                                                                             |
| Mocked method calls | In Mockito, we use Mockito.when(mock.method(args)).thenReturn(value) method for mocking a method calls.                                                                                                    | In EasyMock, the EasyMock.expect(mock.method(args)).andReturn(Value) method for mocking a method call.                                                       |
| Verifying calls     | In Mockito, the Mockito.verify(mock).method(args) is used for verifying calls to a mock.                                                                                                                   | In EasyMock, the EasyMock.verify(mock) is used for verifying calls to a mock, but this method is always used after calling the EasyMock.replay(mock) method. |
| Exception Throwing  | In Mockito, throwing exception can be mocked using .thenThrow(ExceptionClass.class) after calling the Mockito.when(mock.method(args)) method.                                                              | In EasyMock, throwing exception can be mocked using .andThrow(new ExceptionClass()) after calling the EasyMock.expect(..) method.                            |


Mockito is the most popular mocking framework used for testing Java applications. It is better than any other testing and mocking framework, such as EasyMock.

#### Which one would you prefer, if any, and why?

I prefer to use Mockito because i use Java, and Mockito is the most popular mocking framework for that.