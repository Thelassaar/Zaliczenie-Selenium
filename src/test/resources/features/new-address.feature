@shop
Feature: Add new address

  @newaddress
  Scenario Outline: Add new address after log in and check data

    Given user is logged in to My Store

    And user goes to Account

    And adds new Address

    And user fills <alias>, <address>, <city>, <zip/postal code>, country and <phone> in form

    And user clicks Save button

    Then user checks <alias>, <address>, <city>, <zip/postal code> and <phone> in form

    Then closes browser

#    Then removes address
#
#    And checks if it is removed

    Examples:
      | alias  | address     | city       | zip/postal code | phone     |
      | Main   | Rybnicka 20 | Nottingham | 05020           | 789987722 |
#      | Second | Rybnicka 30 | Manchester | 78624           | 748554125 |

