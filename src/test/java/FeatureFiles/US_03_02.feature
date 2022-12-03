Feature: Cart Edit, Update and Remove
  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: User should be able to view and edit cart
    And User should be able to change quantity
    And User should be able to update shopping cart button
    Then User should be able to check subtotal value bigger than old value