Feature: Testing the Google Search Functionality with Parameters

  Background: Navigation to the website
    Given User navigates to the 'https://www.google.com/'

  Scenario: Happy Path(Positive) testing for Link Research
#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 5 links

  Scenario:Happy Path(positive) Testing for Results Search
#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 60000000.0

  Scenario:Happy Path(Positive) Testing for Search Timing
#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Turkish Baklava'
    Then User validates the search time is less than 1.0 second