#Author: @raphabiz
 @US004
Feature: Change password functionality
  Scenario: Change with success
    Given User wants to change his password
    When User enters pass1dutout and newpassword
    Then password is updated
  Scenario: Change with fail
    Given User wants to change his password
    When User enters pass1 and newpassword
    Then password isnt updated because isnt valid
