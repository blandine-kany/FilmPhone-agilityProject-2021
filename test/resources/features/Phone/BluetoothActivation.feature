#Author: @raphabiz
@US006
Feature: Activate/Desactivate bluetooth functionality
  As an user
  I want to change my bluetooth state
  In order to manage my phone

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
