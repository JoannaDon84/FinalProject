#Napisz skrypt, który:
#
#będzie logować się na tego stworzonego użytkownika,
#wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
#kliknie w + Create new address,
#wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone),
#sprawdzi czy dane w dodanym adresie są poprawne.
#Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber
#Dodatkowe kroki dla chętnych:
#
#usunie powyższy adres klikając w "delete",
#sprawdzi czy adres został usunięty.
@shop
Feature: User account edit

  Scenario Outline: User creates new address
    Given I am on a main page and I have an address in Addresses
    When I login to already created account
    And I go to the address page
    And I add new address
    And I enter new alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
    And I save the new address
    Then I verify created address alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
    And I remove the address
    And I can see the address was removed
    And I close the browser
    Examples:
      | alias | address     | city | state   | postal code | country        | phone     |
      | Zenio | Cucumber 28 | Ohio | Arizona | 23867       | United Kingdom | 234089654 |

#  @shop
#  Feature: User account edit
#
#  Scenario Outline: User creates new address
#    Given I am on a main page and I have an address in Addresses
#    When I login to already created account
#    And I go to the address page
#    And I add new address
#    And I enter new alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
#    And I save the new address
#    And I can see there is an address
#    And I add new address
#    And I enter new alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
#    And I save the new address
#    Then I verify created address alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
#    And I remove the address
#    And I can see the address was removed
#    And I close the browser
#    Examples:
#      | alias  | address | city     | state  | postal code | country       | phone     |
#      | Franio | Onion 8 | New Jork | Alaska | 22234       | United States | 123456789 |