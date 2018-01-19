Feature: To test Send us a question Widget and Click to call functionality in contact us redesign pages in UHCM site

 @Sanity_contactusInd
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
 	And user clicks on Request Confirmation Click
    
     Examples: 
      | userName        |  | password   | memberType |
       | q1_feb_uhc002 |  | Password@1 | UHC      |
        | q1_aarp_feb015 |  | Password@1 | AARP      |
        
        
 @Sanity_contactusGrp
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates Group secure email widget  in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
 	And user clicks on Request Confirmation Click
    
     Examples: 
      | userName        |  | password   | memberType |
      | q1_grp_feb108 |  | Password@1 | Group      |


  #US634975
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Group      |

  #US634972
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page which covers 1,3,4
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates Group secure email widget  in redesign contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Group      |

  Scenario Outline: Verify cancel click on Group secure email widget  in redesign contact us page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates cancel click on Group secure email widget  in redesign contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Group      |

  Scenario Outline: Verify user clicks on submit question by selecting Finding a Physician option in redesign contact us page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Group      |

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
      | q4_dec_grp140 |  | Password@1 | Group      |

  Scenario Outline: routing to appropriate department after clicking submit question button by  selecting Physician option  in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Group      |

  Scenario Outline: routing to appropriate department after clicking submit question button by  selecting Billing Information option  in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Billing Information option in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Group      |

  #Scenario Outline: validating emailIds in contact us redesign page
  #Given registered UMS member with following attributes
  #| UserName    | <userName>   |  |
  #| Password    | <password>   |  |
  #| Member Type | <memberType> |  |
  #When the user navigates to contact us page in UHC site
  #Then user enters invalidate alternative email ID in sendUS A question widget
  #
  #Examples:
  #| userName      |  | password   | memberType |
  #| q4_dec_grp140 |  | Password@1 | Group      |
  #Scenario Outline: validate user enters invalidate Confirm email ID in sendUS A question widget in contact us redesign page
  #Given registered UMS member with following attributes
  #| UserName    | <userName>   |  |
  #| Password    | <password>   |  |
  #| Member Type | <memberType> |  |
  #When the user navigates to contact us page in UHC site
  #Then user enters invalidate Confirm email ID in sendUS A question widget
  #
  #Examples:
  #| userName      |  | password   | memberType |
  #| q4_dec_grp140 |  | Password@1 | Group      |
  #Scenario Outline: validateuser enters invalidate alternative email ID in sendUS A question widget in contact us redesign page
  #Given registered UMS member with following attributes
  #| UserName    | <userName>   |  |
  #| Password    | <password>   |  |
  #| Member Type | <memberType> |  |
  #When the user navigates to contact us page in UHC site
  #Then user enters invalidate alternative email ID in sendUS A question widget
  #
  #Examples:
  #| userName      |  | password   | memberType |
  #| q4_dec_grp140 |  | Password@1 | Group      |
  #
  #Scenario Outline: validate user enters invalidate Confirm email ID in sendUS A question widget in contact us redesign page
  #Given registered UMS member with following attributes
  #| UserName    | <userName>   |  |
  #| Password    | <password>   |  |
  #| Member Type | <memberType> |  |
  #When the user navigates to contact us page in UHC site
  #Then user enters invalidate Confirm email ID in sendUS A question widget
  #
  #Examples:
  #| userName      |  | password   | memberType |
  #| q4_dec_grp140 |  | Password@1 | Group      |
  Scenario Outline: validate user enters blank text  in sendUS A question  message widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |  |
      | Password    | <password>   |  |
      | Member Type | <memberType> |  |
    When the user navigates to contact us page in UHC site
    Then user enters blank text  in sendUS A question  message widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Group      |

  Scenario Outline: validate user enters invalid phone number  in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters invalid phone number  in sendUS A question widget

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Group      |

  #US635973
  #Scenario Outline: Verify Group Email Widget Confirm Request in contact us redesign page
  #Given registered UMS member with following attributes
  #| UserName    | <userName>   |
  #| Password    | <password>   |
  #| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page
  #And UI should be replaced by a confirmation display
  #
  #Examples:
  #| userName      |  | password   | memberType |
  #| q4_dec_grp140 |  | Password@1 | Group      |
  Scenario Outline: Verify secureEmail Widget page section in contact us redesign page for not opted in aarp member of  AARP site covers scenario 1,2,5,6,7
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail Widget page functionality in contact us redesign page of  AARP site covers scenario 4
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget in contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail Widget using using Email Address on File radio button in contact us redesign page of  AARP site
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget functionality using Email Address on File radio button

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

  #US632918 secureMessaging Model
  Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure Messaging Model

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button and cancel link
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure Messaging Model Cancel link

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

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
  #| q4_dec_combo024 |  | Password@1 | Federal    |
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
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

  Scenario Outline: Verify secureEmail widget on contactUS redesign page for not opted in member
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | userName        |  | password   | memberType |
      | q4_dec_combo024 |  | Password@1 | Federal    |

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
  #| q4_dec_combo024 |  | Password@1 | Federal    |
  #US633085
  Scenario Outline: Verify clickToCallButton Widget and Button display on contactUS redesign page
  Given registered UMS member with following attributes
  | UserName    | <userName>   |
  | Password    | <password>   |
  | Member Type | <memberType> |
  When the user validates the contact us redesign  page in AARP site
  Then user validates clickToCallButton display on contactUS redesign page
  
  Examples:
  | userName       |  | password   | memberType |
  | q4_dec_grp140  |  | Password@1 | Federal    |
  #
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
  | userName       |  | password   | memberType |
  | q4_dec_grp140 |  | Password@1 | Federal    |
  #
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
  | userName       |  | password   | memberType |
  | q4_dec_grp140 |  | Password@1 | Federal    |
  #US630418
  Scenario Outline: Verify sendUs A Question Widget page section in contact us redesign page
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user validates the contact us redesign  page in AARP site
    Then user validates sendUS A question Widget in redesign contact us page

    Examples: 
      | userName      |  | password   | memberType |
      | q4_dec_grp140 |  | Password@1 | Federal    |
  #Scenario Outline: Verify sendUs A Question Widget page for PDP display section in contact us redesign page
    #Given registered UMS member with following attributes
      #| UserName    | <userName>   |
      #| Password    | <password>   |
      #| Member Type | <memberType> |
    #When the user validates the contact us redesign  page in AARP site
    #Then user validates PDP page display in redesign contact us page
#
    #Examples: 
      #| userName       |  | password   | memberType |
      #| q4_dec_combo024 |  | Password@1 | Federal    |
      
 
        