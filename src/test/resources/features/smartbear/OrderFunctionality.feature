@regression
Feature: Testing the order creation functionality of SmartBear Website

  Scenario: Creating the WebOrder from SmartBear (Happy Path)

    Given User provides username and password for SmartBear LoginPage
    When User clicks OrderButton and provides the 'MyMoney' and '4' for product information
    And User provides 'Ahmet','123 Main Street','Chicago','IL','60123' for address information
    And User provides 'Visa','123234234','06/25' for payment information
    Then User clicks process button and validate 'New order has been successfully added.'
    And User clicks View Order button
    And User validates all information 'Ahmet','MyMoney','4','123 Main Street','Chicago','IL','60123','Visa','123234234','06/25' from table

  Scenario Outline: Creating the WebOrder from SmartBear (Happy Path) with Scenario Outline

    Given User provides username and password for SmartBear LoginPage
    When User clicks OrderButton and provides the '<product>' and '<quantity>' for product information
    And User provides '<customerName>','<street>','<city>','<state>','<zip>' for address information
    And User provides '<cardType>','<cardNumber>','<expiredate>' for payment information
    Then User clicks process button and validate 'New order has been successfully added.'
    And User clicks View Order button
    And User validates all information '<customerName>','<product>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>','<cardNumber>','<expiredate>' from table
    Examples:
      | product     | quantity | customerName | street           | city    | state | zip   | cardType         | cardNumber | expiredate |
      | MyMoney     | 4        | Ahmet        | 123 Main Street  | Chicago | IL    | 60123 | Visa             | 123234234  | 06/25      |
      | FamilyAlbum | 4        | Mehmet       | 12 Main Street   | Chicago | IL    | 60123 | MasterCard       | 123234234  | 06/25      |
      | ScreenSaver | 4        | Mahmut       | 1236 Main Street | Chicago | IL    | 60123 | American Express | 123234234  | 06/25      |

  Scenario: Creating the WebOrder from SmartBear (Happy Path) with Data Table

    Given User provides username and password for SmartBear LoginPage
    When User clicks OrderButton and provides the product and quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides data for address information
      | customerName | Ahmet           |
      | street       | 123 Main Street |
      | city         | Chicago         |
      | state        | IL              |
      | zipCode      | 60123           |
    And User provides data for payment information
      | cardType   | Visa    |
      | cardNumber | 1232354 |
      | expireDate | 06/25   |
    Then User clicks process button and validate the message
      | New order has been successfully added. |
    And User clicks View Order button


















