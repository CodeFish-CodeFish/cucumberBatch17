@smoke @regression
Feature: Testing the Login Functionality of WebOrder Page

  Scenario: User provides correct username and wrong password
    When User provides 'guest1@microworks.com' and 'asdfgdfg' and click login button
    Then User validates the 'Sign in Failed' and 'rgba(248, 215, 218, 1)' from Login Page

  Scenario: User provides wrong username and correct password
    When User provides 'sgdfg@gmail.com' and 'Guest1!' and click login button
    Then User validates the 'Sign in Failed' and 'rgba(248, 215, 218, 1)' from Login Page

  Scenario: User provides empty username and empty password
    When User provides '' and '' and click login button
    Then User validates the 'Sign in Failed' and 'rgba(248, 215, 218, 1)' from Login Page

  Scenario: User provides correct username and correct password'
    When User provides 'guest1@microworks.com' and 'Guest1!' and click login button
    Then User validates the 'ORDER DETAILS - Weborder' from the WebOrderMain Page

  Scenario: User provides correct username and correct password' from ConfigReader
    When User provides username and password and click login button
    Then User validates the 'ORDER DETAILS - Weborder' from the WebOrderMain Page
