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
