Feature: Compare Functionality

  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: US_05_01 - Add to Compare Functionality
    And User sending the keys in US_05_Dialog
      | searchBox | <productName> |

    And Click on the element in US_05_Dialog
      | searchButton |
      | productItem  |
      | addToCompare |

    Then User should see the this message in US_05_Dialog
      | <message> |

    Examples:
      | productName | message |
      | Radiant Tee | added   |

  Scenario Outline: US_05_02 - Remove Product From Compare Page Functionality
    And User sending the keys in US_05_Dialog
      | searchBox | <productName> |

    And Click on the element in US_05_Dialog
      | searchButton |
      | productItem  |
      | addToCompare |
    Then User should see the this message in US_05_Dialog
      | <addedMessage> |

    And Click on the element in US_05_Dialog
      | comparePage |

    And Click remove that item at Compare Page in US_05_Dialog
      | <productName> |

    And Click on the element in US_05_Dialog
      | okButton |

    Then User should see the this message in US_05_Dialog
      | <removedMessage> |

    Examples:
      | productName | addedMessage | removedMessage |
      | Radiant Tee | added        | removed        |

  Scenario Outline: US_05_03 - Add to Cart Item From Compare Page Functionality
    And User sending the keys in US_05_Dialog
      | searchBox | <productName> |

    And Click on the element in US_05_Dialog
      | searchButton |
      | productItem  |
      | addToCompare |

    Then User should see the this message in US_05_Dialog
      | <message> |

    And Click on the element in US_05_Dialog
      | comparePage |

    And Click on this product in US_05_Dialog
      | <productName> |

    And Choose option in product in US_05_Dialog
      | <size>  |
      | <color> |

    And Click on the element in US_05_Dialog
      | addToCart |

    Then User should see the this message in US_05_Dialog
      | <message> |

    Examples:
      | productName       | message | size | color  |
      | Breathe-Easy Tank | added   | XS   | Purple |

