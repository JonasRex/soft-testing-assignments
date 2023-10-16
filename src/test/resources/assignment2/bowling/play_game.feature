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