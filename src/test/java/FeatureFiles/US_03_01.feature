Feature: Cart Edit, Update and Remove
  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

    Scenario: User should be able to click on the cart module
      And User should be able to remove Item from the cart
      Then User should see Item has been removed


