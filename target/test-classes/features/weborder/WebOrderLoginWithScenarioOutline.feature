@smoke @regression
Feature: Testing the Login Functionality of WebOrder Page Scenario Outline

  Scenario Outline: User provides correct username and wrong password
    When User provides '<username>' and '<password>' and click login button
    Then User validates the '<errorMessage>' and '<textBackGroundColor>' from Login Page
    Examples:
      | username              | password | errorMessage   | textBackGroundColor    |
      | guest1@microworks.com | dsfgfdg  | Sign in Failed | rgba(248, 215, 218, 1) |
      | fsdfsdg@gmail.com     | Guest1!  | Sign in Failed | rgba(248, 215, 218, 1) |
      |                       |          | Sign in Failed | rgba(248, 215, 218, 1) |
      | guest1@microworks.com | guest1!  | Sign in Failed | rgba(248, 215, 218, 1) |
      | guest1@microworks.com | GUEST1!  | Sign in Failed | rgba(248, 215, 218, 1) |