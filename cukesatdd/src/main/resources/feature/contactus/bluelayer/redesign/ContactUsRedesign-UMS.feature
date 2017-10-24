@contactUsTestredesignBlue
Feature: To test Send us a question Widget and Click to call functionality in contact us redesign pages in UHCM site

  #US634975
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  #US634972
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page which covers 1,3,4
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates Group secure email widget  in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: Verify cancel click on Group secure email widget  in redesign contact us page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates cancel click on Group secure email widget  in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: Verify user clicks on submit question by selecting Finding a Physician option in redesign contact us page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  #US634977
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: routing to appropriate department after clicking submit question button by  selecting Physician option  in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: routing to appropriate department after clicking submit question button by  selecting Billing Information option  in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Billing Information option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validating emailIds in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate alternative email ID in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validate user enters invalidate Confirm email ID in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate Confirm email ID in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validateuser enters invalidate alternative email ID in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate alternative email ID in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validate user enters invalidate Confirm email ID in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate Confirm email ID in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validate user enters blank text  in sendUS A question  message widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters blank text  in sendUS A question  message widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  Scenario Outline: validate user enters invalid phone number  in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters invalid phone number  in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |

  #US635973
  Scenario Outline: Verify Group Email Widget Confirm Request in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page
    And UI should be replaced by a confirmation display

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp001 |  | Password@1 | Group      |
