Feature: Cart Edit, Update and Remove
  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully
  Scenario: User should be able to update quantity
    And User should be able to change quantity on the cart module
    Then User should be able to check  Cart Icon's number