@regression
Feature:Testing the Search Functionality of the Etsy Website

  Scenario: Search Functionality Happy Path for Etsy Hat
    When User searches 'Hat' for Etsy
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy Key
    When User searches 'Key' for Etsy
    Then User validates the title 'Key - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy Pin
    When User searches 'Pin' for Etsy
    Then User validates the title 'Pin - Etsy' from Etsy