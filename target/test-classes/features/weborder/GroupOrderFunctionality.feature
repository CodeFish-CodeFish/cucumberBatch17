@regression
Feature: Testing the Group Order Functionality of WebOrder

  Background: same steps
    Given User provides username and password and click login button
    When User clicks GroupOrder Button then Next Button
    And User provides note 'I love Selenium and Cucumber' to Invitees box
    And User provides gmail 'ahmet@gmail.com','mehmet@gmail.com' to Invite List

  Scenario: Happy Path Food Order for My House
    And User chooses the location 'My House' and validates '3137 Laguna Street'
    And User clicks Create Group Order button
    Then User validates the header 'View Group Order' and 'Your group order is now pending' from description

    @smoke
  Scenario: Happy Path Food Order for Office
    And User chooses the location 'Office' and validates '2012 EMPIRE BLVD'
    And User clicks Create Group Order button
    Then User validates the header 'View Group Order' and 'Your group order is now pending' from description
