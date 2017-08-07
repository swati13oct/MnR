@contactUsTestredesign
Feature: To test EmailUs Widget and Click to call functionality in contact us redesign pages in AARP site

  Scenario Outline: Verify secureEmail Widget page section in contact us redesign page for not opted in aarp member of  AARP site covers scenario 1,2,5,6,7
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail Widget page in contact us redesign page of  AARP site covers scenario 4
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget functionality in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail Widget page in contact us redesign page of  AARP site covers scenario 3
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget functionality using Email Address on File radio button

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US632918 secureMessaging Model
  Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure Messaging Model

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure Messaging Model Cancel link

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
    #Given registered UMS member with following attributes
      #| UserName    | <userName>   |
      #| Password    | <password>   |
      #| Member Type | <memberType> |
    #When the user validates the contact us redesign  page in AARP site
    #Then user validates secure Messaging Model Prescription link click on SecureEmail Model
#
    #Examples: 
      #| userName         |  | password   | memberType |
      #| q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US634971
  #contactUsTestredesign
  Scenario Outline: Verify go To Inbox button on contactUS redesign page for opted in member
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates go To Inbox button  in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail widget on contactUS redesign page for not opted in member
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #Scenario Outline: Verify secureEmail widget non display on contactUS redesign page for non eligible member
    #Given registered UMS member with following attributes
      #| UserName    | <userName>   |
      #| Password    | <password>   |
      #| Member Type | <memberType> |
    #When the user validates the contact us redesign  page in AARP site
    #Then user validates non display secure email widget UI in redesign contact us page
#
    #Examples: 
      #| userName         |  | password   | memberType |
      #| q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US633085
  Scenario Outline: Verify clickToCallButton Widget and Button display on contactUS redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates clickToCallButton display on contactUS redesign page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US634553,US634832
  Scenario Outline: Verify clickToCall Widget Expansion (Drop-Down, Text Box and Button UI)  on contactUS redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on send a Request button on Click to call widget

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US634778,US634969
  Scenario Outline: Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  #US630418
  Scenario Outline: Verify sendUs A Question Widget page section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates sendUS A question Widget in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer005 |  | Password@1 | Federal    |

  Scenario Outline: Verify sendUs A Question Widget page section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates PDP page display in redesign contact us page

    Examples: 
      | userName         |  | password   | memberType |
      | q3_sep_ulayer460 |  | Password@1 | Federal    |
