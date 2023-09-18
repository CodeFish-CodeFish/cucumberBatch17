@regression
Feature: Testing Account Creation Functionality

  Scenario: Happy Path Account Creation
    When User clicks the Create New Account button
    And User provides 'Ahmet','Baldir','ahmet123@gmail.com' and 'ahmet5345' to the sign up form
    And User chooses the 'Jul','25' and '1991' for Birth Day
    And User chooses the 'Male' and click Sign Up button


