Feature: US_13 Ads for phones

  As a phone brand
  I want to create an advertising film
  So that i can promote my phones

  Scenario Outline: creation of an advertising film on a phone
    Given a scenario which is titled <origTitle>
    And a phone named <phoneName>
    And the scenario contains an advertising film named <title1> and <director1> as director
    When the phone brand demands the creation of a film for a given scenario
    Then the production for the advertising film starts and the system updates the scenario information (number of ads for the scenario: <result>).

    Examples:
      | origTitle          | title1              | director1        | phoneName      | result |
      | "An awesome phone" | "iPhone"            | "David Lynch"    | "iPhoneX"      | 1      |
      | "Matrix"           | "iPhone for Matrix" | "Chris Columbus" | "iPhoneMatriX" | 1      |


  Scenario Outline: creation of ads for multiple phones
    Given a scenario which is titled <scenario1>
    And a second scenario which is titled <scenario2>
    And a phone named <phoneName1>
    And a second phone named <phoneName2>
    And the first scenario contains an advertising film named <title1> with <director1> as director for the first phone
    And the second scenario contains an advertising film named <title21> with <director21> as director for the second phone
    And the second scenario contains an advertising film named <title22> with <director22> as director for the second phone
    When the phone brand demands the creation of the films for the scenarios
    Then the production for the advertising film starts and the system updates the scenario information (number of ads for the scenarios: <result1> <result2>)


    Examples:
      | scenario1    | scenario2               | phoneName1 | phoneName2  | title1           | director1     | title21        | director21 | title22         | director22   | result1 | result2 |
      | "A scenario" | "Just another scenario" | "Honor 10" | "Huawei X1" | "Unsuable phone" | "Daenerys T." | "Banned phone" | "Jon Snow" | "Useless phone" | "Arya Stark" | 1       | 2       |



