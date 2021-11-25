#Author: @raphabiz
@US010
Feature: Message functionnality

  As an user
  I want to send a message
  In order to chat with

  Scenario: User send a message
    Given user wants to send message to an other phone
    When user sends it
    Then message is sent
    And second phone has received message
