@shop
Feature: Add new address

  @buysweater
  Scenario Outline: Add new address after log in and check data

    Given user is logged in to My Store

    And user finds <item>

    And user clicks on <item>

    And user chooses M size

    And user sets 5 pcs to buy

    And user adds item to cart

    And user proceeds to checkout

    And user confirms address

    And user chooses PrestaShop pick up in store

    And user chooses payment and confirms

    Then user takes screenshot with order confirmation

#    Then closes browser

    Examples:
      | item                        |
      | Hummingbird printed sweater |
