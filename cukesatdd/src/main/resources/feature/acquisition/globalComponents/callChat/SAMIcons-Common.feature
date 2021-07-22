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
      
    @samChatUHC @regressionUHC
    Examples: 
      | pagename | site |
      | /        | UHC |

  Scenario Outline: To test the SAM icons on Acq site on VPP, Detail, Compare, OLE
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
      
    Scenario Outline: To test the SAM icons on DCE pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user validates all added drugs in DrugList
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon

    @samChatAARP @regressionAARP
    Examples: 
      | site | zipCode | planType | planName                                            |drug1|
      | AARP |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |Orkambi|

    @samChatUHC @regressionUHC
    Examples: 
      | site | zipCode | planType | planName                                            |drug1|
      | UHC  |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |Orkambi|
      
      Scenario Outline: To test the SAM icons on PRE pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user opens the page to validate M&R Sites
      | pagename | <pagename> |
    And user clicks on get started to start questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
      And user select plantype in the coverage options page
      | Plan Type | <isCoverageOpt> |
      Then user select add drug option in the Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
      Then user validate elements in loading results page
      And the user click on view plan in results page
      And User clicks on Back to Plans on detail page
      And the user clicks the plans of the below plan type
      | Plan Type | <planType> |
      
      @samChatAARP123 @regressionAARP
    Examples: 
      | site | zipcode | planType | planName                                            |drug1|pagename|isMultiCounty | county            |isCoverageOpt|Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch|
      | AARP |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |Orkambi|plan-recommendation-engine.html#/get-started|No            | Miami-Dade County |PDP           |Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO |

    @samChatUHC @regressionUHC
    Examples: 
      | site | zipcode | planType | planName                                            |drug1|pagename|isMultiCounty | county            |isCoverageOpt|Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch|
      | UHC |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |Orkambi|plan-recommendation-engine.html#/get-started|No            | Miami-Dade County |PDP           |Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO |
