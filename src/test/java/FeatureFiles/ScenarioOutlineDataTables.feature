Feature: Employee Functionality (Data Table-Scenario)

  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Employee Functionality
    And Click on the card module in US_03_01
      | Cart   |
      | deleteButton |
      | okButton   |
      | Cart |

    Then Success message should be displayed

    And Click on the card module in US_03_01
      | Cart   |

    And Click on the element in the  US_03_01
      | cartModuleQuantity       | <quantity>|


    And Click on the card module in US_03_01
      | update   |

    Then Success message should be displayed


    Examples:

      |quantity         |
      |12               |
