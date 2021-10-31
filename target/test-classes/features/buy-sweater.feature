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

    Examples:
      | item                        |
      | Hummingbird printed sweater |

#  zaloguje się na tego samego użytkownika z zadania 1,
#  wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
#  wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
#  wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
#  dodaj produkt do koszyka,
#  przejdzie do opcji - checkout,
#  potwierdzi address (możesz go dodać wcześniej ręcznie),
#  wybierze metodę odbioru - PrestaShop "pick up in store",
#  wybierze opcję płatności - Pay by Check,
#  kliknie na "order with an obligation to pay",
#  zrobi screenshot z potwierdzeniem zamówienia i kwotą.
