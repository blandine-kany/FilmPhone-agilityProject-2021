#Author: @raphabiz
@US001 
Feature: Login functionality
  Scenario Outline: Check login is succesful with password
    Given user is on <phone>
    When user enters <password> on phone
    Then user <isconnected>

    Examples: 
      | phone      | password     | isconnected |
      | muskphone1 | pass1       | false       |
      | muskphone1 | pass1dutout | true        |
