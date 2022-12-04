Feature: Compare Functionality

  Background:
    Given Navigate to Luma website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: US_05_01 - Add to Compare Functionality
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |
      | productItem  |
      | addToCompare |

    Then User should see the this message
      | <message> |

    Examples:
      | productName | message |
      | Radiant Tee | added   |

  Scenario Outline: US_05_02 - Remove Product From Compare Page Functionality
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |
      | productItem  |
      | addToCompare |
    Then User should see the this message
      | <addedMessage> |

    And Click on the element in the Dialog
      | comparePage         |
      | removeProductButton |
      | okButton            |

    Then User should see the this message
      | <removedMessage> |

    Examples:
      | productName | addedMessage | removedMessage |
      | Radiant Tee | added        | removed        |

  Scenario Outline: US_05_03 - Add to Cart Item From Compare Page Functionality
    And User sending the keys in Dialog content
      | searchBox | <productName> |

    And Click on the element in the Dialog
      | searchButton |
      | productItem  |
      | addToCompare |

    Then User should see the this message
      | <message> |

    And Click on the element in the Dialog
      | comparePage |

    And Click on this product
      | <productName> |

    And Choose option in product
      | <size>  |
      | <color> |

    And Click on the element in the Dialog
      | addToCart |

    Then User should see the this message
      | <message> |

    Examples:
      | productName       | message | size | color  |
      | Breathe-Easy Tank | added   | XS   | Purple |

