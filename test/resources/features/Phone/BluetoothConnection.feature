#Author: @raphabiz
@US007
Feature: Connect wireless headphone

  As an user
  I want to connect wireless headphone to my phone
  In order to use it

  Scenario Outline: Connect wireless headphone to a phone
    Given wireless headphone is <available>
    And phone is : <phoneavailable>
    When user connect wireless headphone
    Then user message : <message>

    Examples:
      | available    | phoneavailable | message        |
      | available    | available      | successmessage |
      | available    | notavailable   | errormessage   |
      | notavailable | notavailable   | errormessage   |
      | notavailable | available      | errormessage   |
