Feature: Item Box Functionality

  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: US_04_01 Add to Wish List on Item Box
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |

    And User should click add to wish list on item box
      | <productName> |

    Then User should see the this message
      | <message> |

    Examples:
      | productName       | message |
      | Breathe-Easy Tank | added   |

  Scenario Outline: US_04_02 Add To Cart From Wishlist
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |

    And User should click add to wish list on item box
      | <productName> |

    Then User should see the this message
      | <addedMessage> |

    And User should click add to cart on item box in Wishlist
      | <productName> |

    Then User should see the this message
      | <needMessage> |

    Examples:
      | productName       | addedMessage | needMessage |
      | Breathe-Easy Tank | added        | need        |

  Scenario Outline: US_04_03 Add All To Cart From Wishlist
    And User sending the keys in Dialog content
      | searchBox | <productName1> |

    And Click on the element in the Dialog
      | searchButton |

    And User should click add to wish list on item box
      | <productName1> |

    Then User should see the this message
      | <addedMessage> |

    And User sending the keys in Dialog content
      | searchBox | <productName2> |

    And Click on the element in the Dialog
      | searchButton |

    And User should click add to wish list on item box
      | <productName2> |

    Then User should see the this message
      | <addedMessage> |

    When Click on the element in the Dialog
      | addAllToCart |

    Then User should see the this message
      | <needMessage> |

    Examples:
      | productName1      | productName2 | addedMessage | needMessage |
      | Breathe-Easy Tank | Zoe Tank     | added        | need        |