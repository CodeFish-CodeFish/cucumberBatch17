Feature: Testing the Google Search Functionality
  #General description
  Scenario: Happy Path(Positive) testing for Link Research
    #test case
    Given User navigates to the Google
    #precondition
    When User searches for CodeFish
    #actions
    Then User validates first page returns more than five links
    #results of action

  Scenario:Happy Path(positive) Testing for Results Search
    Given User navigates to the Google
    When User searches for Kyrgyz Food in USA
    Then User validates the result is less than thirty millions

  Scenario:Happy Path(Positive) Testing for Search Timing
    Given User navigates to the Google
    When User searches for Turkish Baklava
    Then User validates the search time is less than one sec









