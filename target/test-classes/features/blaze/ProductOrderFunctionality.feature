@regression
Feature: Testing Product Order Functionality

  Scenario Outline: Happy path Order Functionality
    Given User chooses the product option '<category>' from mainPage
    When User chooses the product type '<item>' from the list
    Then User validates '<header>','<price>' and '<description>' of them item
    And User clicks Add to cart button and validate 'Product added' from JS alert
    And User clicks global cart button and Place Order button
    And User provides '<name>','<country>','<city>','<creditCard>','<month>','<year>' to order Page
    And User clicks Purchase button and validates the 'Thank you for your purchase!'
    Examples:
      | category | item             | header           | price              | description     | name  | country | city   | creditCard | month | year |
      | Phones   | Nokia lumia 1520 | Nokia lumia 1520 | $820 *includes tax | The Nokia Lumia | Ahmet | Turkey  | Ankara | 1623423423 | 10    | 25   |
      | Phones   | Samsung galaxy s7 | Samsung galaxy s7 | $800 *includes tax  | The Samsung Galaxy | Mehmet | USA     | Chicago     | 1623423543 | 05    | 27   |
      | Laptops  | MacBook air       | MacBook air       | $700 *includes tax  | Intel Core i5      | Mahmut | Canada  | Toronto     | 1623428543 | 05    | 30   |
      | Laptops  | MacBook Pro       | MacBook Pro       | $1100 *includes tax | MacBook Pro line   | Leyla  | Mexico  | Mexico City | 1623423543 | 07    | 29   |

  Scenario: Happy Path Order Functionality with Data table

    Given User chooses the product option from mainPage
      | Phones |
    When User chooses the product type from the list
      | Nokia lumia 1520 |
    Then User validates data of the item
      | header      | Nokia lumia 1520   |
      | price       | $820 *includes tax |
      | description | The Nokia Lumia    |
    And User clicks Add to cart button and validates message from JS Alert
      | Product added |
    And User clicks global cart button and Place Order button
    And User provides data
      | name       | Ahmet    |
      | country    | Turkiye  |
      | city       | Ankara   |
      | creditCard | 13232343 |
      | month      | 11       |
      | year       | 1991     |
    And User clicks Purchase button and validates the message
      | Thank you for your purchase! |










