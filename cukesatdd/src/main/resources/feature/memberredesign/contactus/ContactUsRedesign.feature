@velocityDashers
Feature: To test Send us a question Widget and Click to call functionality in contact us redesign pages in UHCM site

  @secureEmailWidget
  Scenario Outline: Verify Send us a question Widget section in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page

    Examples: 
      | plantype | memberType   |
      | MAPD     | COSMOSCLAIMS |

  #@secureEmailWidgetGroup
  #Scenario Outline: Verify Send us a question Widget section in contact us redesign page which covers 1,3,4
  #Given registered UMS member with following attributes
  #| Plan Type   | <plantype>   |
  #| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user validates Group secure email widget  in redesign contact us page
  #
  #Examples:
  #| plantype | memberType 			|
  #| MAPD     | SDCERAGroup      |
  @secureEmailWidgetCancelForGroup
  Scenario Outline: Verify cancel click on Group secure email widget  in redesign contact us page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates cancel click on Group secure email widget  in redesign contact us page

    Examples: 
      | plantype | memberType  |
      | MAPD     | SDCERAGroup |

  @invalidEmail
  Scenario Outline: Validate  invalid aletrnative emailIds in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate alternative email ID in sendUS A question widget

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @invalidConfirmEmail
  Scenario Outline: Validate  invalid confirm aletrnative emailIds in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters invalidate Confirm email ID in sendUS A question widget

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @blankSendUsQuestion
  Scenario Outline: validate user enters blank text  in sendUS A question  message widget in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters blank text  in sendUS A question  message widget

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @invalidPhone
  Scenario Outline: validate user enters invalid phone number  in sendUS A question widget in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user enters invalid phone number  in sendUS A question widget

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @GroupEmailConfirmMessage
  Scenario Outline: Verify Group Email Widget Confirm Request in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page
    And UI should be replaced by a confirmation display

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  #@secureEmailForCombo
  #Scenario Outline: Verify secureEmail Widget using using Email Address on File radio button in contact us redesign page of  AARP site
  #Given registered UMS member with following attributes
  #| Plan Type   | <plantype>   |
  #| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user validates secure email widget functionality using Email Address on File radio button
  #
  #Examples:
  #| plantype | memberType  |
  #| MAPD     | MAPDwithMedSupp |
  #@secureMessagingModel
  #Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
  #Given registered UMS member with following attributes
  #| Plan Type   | <plantype>   |
  #| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user validates secure Messaging Model
  #
  #Examples:
  #| plantype | memberType  |
  #| MAPD     | MAPDwithMedSupp |
  @secureMessagingModelCancel
  Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button and cancel link
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure Messaging Model Cancel link

    Examples: 
      | plantype | memberType |
      | PDP      | HIP        |

  #@secureMessagingModelPrescriptionLink
  #Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
  #Given registered UMS member with following attributes
  #| Plan Type   | <plantype>   |
  #| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user validates secure Messaging Model Prescription link click on SecureEmail Model
  #
  #Examples:
  #| plantype | memberType  |
  #| MAPD     | MAPDwithMedSupp |
  @goToInbox
  Scenario Outline: Verify go To Inbox button on contactUS redesign page for opted in member
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates go To Inbox button  in redesign contact us page

    Examples: 
      | plantype | memberType      |
      | MAPD     | MAPDwithMedSupp |

  #	@NoSecureEmailForNonEligibleMember
  #Scenario Outline: Verify secureEmail widget non display on contactUS redesign page for non eligible member
  #Given registered UMS member with following attributes
  #| Plan Type   | <plantype>   |
  #		| Member Type | <memberType> |
  #When the user navigates to contact us page in UHC site
  #Then user validates non display secure email widget UI in redesign contact us page
  #
  #Examples:
  #| plantype | memberType |
  #| MAPD     | MAPDwithMedSupp|
  @clickToCallCancel
  Scenario Outline: Verify clickToCall Widget Expansion (Drop-Down, Text Box and Button UI) and click on cancel on contactUS redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on send a Request button on Click to call widget

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @clickToCall
  Scenario Outline: Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click

    Examples: 
      | plantype | memberType |
      | MAPD     | Group      |

  @sendUsQuestionPDP
  Scenario Outline: Verify sendUs A Question Widget page for PDP display section in contact us redesign page
    Given registered UMS member with following attributes
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates PDP page display in redesign contact us page

    Examples: 
      | plantype | memberType |
      | MAPD     | PDP        |
