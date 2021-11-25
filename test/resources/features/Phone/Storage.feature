#Author: @raphabiz
@US005
Feature: Storage management functionality

  As an user
  I want to know my storage capacity
  In order to know if i can install an app or not

  Scenario: An app is added and phone storage is sufficient
    Given User wants to install starlink
    When User install starlink
    And phone storage is sufficient
    Then App is installed

  Scenario: An app is added and phone storage is not sufficient
    Given User wants to install bigapp
    When User install bigapp
    And phone storage is not sufficient
    Then App is not installed
