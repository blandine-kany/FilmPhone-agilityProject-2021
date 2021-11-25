#Author: @raphabiz
@US002
Feature: On/off functionality

  As an user
  I want to turn on/off my phone
  In order to use it or not

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
