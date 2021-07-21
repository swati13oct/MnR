@globalComponent @samIcons
Feature: ACQ M&R- To test SAM Icons

  Scenario Outline: To test the SAM icons on Acq site on <site> <pagename>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user opens the page to validate M&R Sites
      | pagename | <pagename> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon

    @samChatAARP @regressionAARP
    Examples: 
      | pagename | site |
      | /        | AARP |

  Scenario Outline: To test the SAM icons on Acq site on VPP, Detail, DCE, Compare, OLE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user validates Get Started Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user click on return to plan summary from Get Started Page to return to VPP Plan Summary
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    And I select "<plantype>" plans to compare and click on compare plan link
    Then the user clicks on back on all plan link in Plan Compare page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user clicks on Enroll Now and validates the Welcome to OLE Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon

    @samChatAARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planName                                            |
      | AARP |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @samChatAARP @regressionUHC
    Examples: 
      | site | zipcode | plantype | planName                                            |
      | UHC  |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @samChatAARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planName                        |
      | AARP |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) |

    @samChatAARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planName                        |
      | UHC  |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) |
