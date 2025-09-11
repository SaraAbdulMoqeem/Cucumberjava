#This feature defines add items to cart and proceed to checkout


Feature: Add multiple items to cart and validate totals

  Scenario Outline: Add multiple products and verify cart
    Given user logs in with "<email>" and "<password>"
    When user adds the following products to the cart:
      | product     | quantity |
      | Blue Top    | 2        |
      | Men Tshirt  | 1        |
    Then each item should have correct quantity and price
    And total amount should be calculated correctly
    Then  user logs out after checkout

  Examples:
    | email                  | password   |
    | sarah.moqeem@gmail.com | Abdullah1! |