Feature: Item Box Functionality

  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: US_04_01 Add to Wish List on Item Box
    And User sending the keys in US_04_Dialog
      | searchBox | <productName> |

    And Click on the element in US_04_Dialog
      | searchButton |

    And User should click add to wish list on item box in US_04_Dialog
      | <productName> |

    Then User should see the this message in US_04_Dialog
      | <message> |

    Examples:
      | productName       | message |
      | Breathe-Easy Tank | added   |

  Scenario Outline: US_04_02 Add To Cart From Wishlist
    And User sending the keys in US_04_Dialog
      | searchBox | <productName> |

    And Click on the element in US_04_Dialog
      | searchButton |

    And User should click add to wish list on item box in US_04_Dialog
      | <productName> |

    Then User should see the this message in US_04_Dialog
      | <addedMessage> |

    And User should click add to cart on item box at Wishlist in US_04_Dialog
      | <productName> |

    Then User should see the this message in US_04_Dialog
      | <needMessage> |

    Examples:
      | productName       | addedMessage | needMessage |
      | Breathe-Easy Tank | added        | need        |

  Scenario Outline: US_04_03 Add All To Cart From Wishlist
    And User sending the keys in US_04_Dialog
      | searchBox | <productName1> |

    And Click on the element in US_04_Dialog
      | searchButton |

    And User should click add to wish list on item box in US_04_Dialog
      | <productName1> |

    Then User should see the this message in US_04_Dialog
      | <addedMessage> |

    And User sending the keys in US_04_Dialog
      | searchBox | <productName2> |

    And Click on the element in US_04_Dialog
      | searchButton |

    And User should click add to wish list on item box in US_04_Dialog
      | <productName2> |

    Then User should see the this message in US_04_Dialog
      | <addedMessage> |

    When Click on the element in US_04_Dialog
      | addAllToCart |

    Then User should see the this message in US_04_Dialog
      | <needMessage> |

    Examples:
      | productName1      | productName2 | addedMessage | needMessage |
      | Breathe-Easy Tank | Zoe Tank     | added        | need        |