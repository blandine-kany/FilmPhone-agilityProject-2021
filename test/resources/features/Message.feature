#Author: @raphabiz
@US010
Feature: Message functionnality

  Scenario: User send a message
    Given user wants to send message to an other phone
    When user sends it
    Then message is sent
    And second phone has received message
