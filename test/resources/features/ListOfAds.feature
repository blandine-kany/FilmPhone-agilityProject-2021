Feature: US_14 Multiple ads same scenario

  As a phone brand
  I want to create multiple advertising films with the same scenario
  So that i can promote a unique soon to be released phone and have multiple options on the ad

  Scenario Outline: creation of a list of advertising films on a single phone
    Given a unique scenario which is titled <origTitle>
    And a list of advertising films
    And the list contains an advertising film named <title1> and <director1> as director
    And the list contains an advertising film named <title2> and <director2> as director
    And the list contains an advertising film named <title3> and <director3> as director
    And a soon to be released phone named <phoneName>
    When the phone brand demands the creation of various advertising films for a given scenario and phone
    Then the production for the advertising films starts and the system updates the scenario information (number of ads for the scenario: <result>).

    Examples:
      | origTitle          | phoneName      | title1              | director1        | title2              | director2           | title3                | director3     | result |
      | "An awesome phone" | "iPhoneX"      | "iPhone"            | "David Lynch"    | "The perfect phone" | "Raphael Abizmil"   | "The phone you want"  | "Lina Zerraf" | 3      |
      | "Matrix"           | "iPhoneMatriX" | "iPhone for Matrix" | "Chris Columbus" | "The MatriX phone"  | " Lana Wachakowski" | "Matrix in your hand" | "Trinity"     | 3      |
