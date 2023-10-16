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