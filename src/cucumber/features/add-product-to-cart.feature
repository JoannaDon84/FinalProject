#
#Zadanie warsztatowe 2 (dowolny sposób)
#Napisz skrypt, który:
#
#zaloguje się na tego samego użytkownika z zadania 1,
#wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
#wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
#wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
#dodaj produkt do koszyka,
#przejdzie do opcji - checkout,
#potwierdzi address (możesz go dodać wcześniej ręcznie),
#wybierze metodę odbioru - PrestaShop "pick up in store",
#wybierze opcję płatności - Pay by Check,
#kliknie na "order with an obligation to pay",
#zrobi screenshot z potwierdzeniem zamówienia i kwotą.
#Dodatkowe kroki dla chętnych:
#
#Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
#sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

@cart
Feature: User can buy a product

  Scenario Outline:
    Given I am on a main page
    When I login to account created in First Task
    And I choose a product
    Then I choose "<size>"
    And I choose "<number>" of product
    And I add this products to a cart
    And I proceed to checkout
    Then I confirm an address
    And I choose delivery method
    And I confirm delivery
    And I choose the payment method
    And I take a screenshot of confirmation
    And I quit the page
    Examples:
      | size | number |
#      | M    | 5      |
      | S    | 3      |
#      | L    | 2      |
