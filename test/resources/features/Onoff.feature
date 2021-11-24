#Author: @raphabiz
@US002
Feature: On/off functionality

  Scenario Outline: Change phone status
    Given phone is <state>
    When user turns <newstate> phone
    Then user receive a <message>

    Examples: 
      | state | newstate | message        |
      | on    | off      | successmessage |
      | off   | off      | errormessage   |
      | off   | on       | successmessage |
      | on    | on       | errormessage   |
