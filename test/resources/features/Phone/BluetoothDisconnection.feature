#Author: @raphabiz
@US008
Feature: Disconnect wireless headphone

  As an user
  I want to disconnect wireless headphone to my phone
  In order to stop using it

  Scenario: Disconnect wireless headphone to a phone
    Given wireless headphone is connected
    When user disconnect wireless headphone
    Then user : success message
