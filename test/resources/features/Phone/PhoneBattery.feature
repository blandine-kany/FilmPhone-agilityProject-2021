#Author: @raphabiz
@US003
Feature: Battery evolution functionality

  As an user
  I want to check my battery level
  In order to plug a charger or not

  Scenario: Phone loose battery
    Given phone has battery power
    When phone is used
    Then phone loose battery

  Scenario: Phone gains battery
    Given user wants to charge a phone
    When user plug a charger
    Then phone gains battery
