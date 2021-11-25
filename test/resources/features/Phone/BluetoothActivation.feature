#Author: @raphabiz
@US006
Feature: Activate/Desactivate bluetooth functionality

  Scenario Outline: Change bluetooth status
    Given bluetooth is <state>
    When user turns <newstate> bluetooth
    Then user receive <message>

    Examples: 
      | state | newstate | message        |
      | off   | on       | successmessage |
      | on    | on       | errormessage   |
      | on    | off      | successmessage |
      | off   | off      | errormessage   |
