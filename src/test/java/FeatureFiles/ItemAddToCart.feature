Feature: Item Box Functionality
  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Add to Cart on Item Box
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |

    And User should choose "<size>" on item box
      | <productName> |

    And User should choose "<color>" on item box
      | <productName> |

    And User should click add to cart on item box
      | <productName> |

    Then User should see the this message
      | <message> |

    Examples:
      | productName       | message | color  | size |
      | Breathe-Easy Tank | added   | Purple | XS   |