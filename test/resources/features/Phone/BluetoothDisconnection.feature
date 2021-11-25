#Author: @raphabiz
@US008
Feature: Disconnect wireless headphone

  Scenario: Disconnect wireless headphone to a phone
    Given wireless headphone is connected
    When user disconnect wireless headphone
    Then user : success message
