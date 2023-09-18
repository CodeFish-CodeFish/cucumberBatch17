@regression
Feature:Testing the Search Functionality of the Etsy Website Scenario Outline

  Scenario Outline: Search Functionality Happy Path for Etsy Hat scenario Outline
    When User searches '<item>' for Etsy
    Then User validates the title '<title>' from Etsy
    Examples:
      | item | title      |
      | Hat  | Hat - Etsy |
      | Key  | Key - Etsy |
      | Pin  | Pin - Etsy |

