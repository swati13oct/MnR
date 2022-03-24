@globalComponent @samIcons
Feature: 1.15.1 ACQ M&R- To test SAM Icons and Proactive Chat
                                                                                                                                                                                                                                                                                   
  Scenario Outline: To test the SAM icons on Acq site on VPP, Detail, Compare, OLE <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user validates the proactive chat
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user validates the proactive chat
    Then the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user validates the proactive chat
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary
    #And I access the DCE Redesign from Plan Summary for mentioned plan
    # | Plan Type | <plantype> |
    # | Plan Name | <planName> |
    #Then the user validates Get Started Page
    #Then the user validates whether call icon is visible
    #And the user validates the chat icon
    #Then the user validates the proactive chat
    #Then the user click on return to plan summary from Get Started Page to return to VPP Plan Summary
    #Then the user validates whether call icon is visible
    #And the user validates the chat icon
    #Then the user validates the proactive chat
    And I select "<plantype>" plans to compare and click on compare plan link
    Then the user clicks on back on all plan link in Plan Compare page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user validates the proactive chat
    Then the user clicks on Enroll Now and validates the Welcome to OLE Page
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    Then the user validates the proactive chat

    @samIconsAARP @regressionAARP 
    Examples: 
      | site | zipcode | plantype | planName                                            |
      | AARP |   90210 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS)|

    @samIconsUHC @regressionUHC  @uhcmedicareSAMIcons
    Examples: 
      | site | zipcode | plantype | planName                                            |
      | UHC  |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @samIconsAARP @regressionAARP 
    Examples: 
      | site | zipcode | plantype | planName                        |
      | AARP |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) |

    @samIconsUHC @regressionUHC  @featureGate @uhcmedicareSAMIcons
    Examples: 
      | site | zipcode | plantype | planName                        |
      | UHC  |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) |

  Scenario Outline: To test the SAM icons on DCE pages <site>
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
    And the user validates the proactive chat

    @samIconsAARP @regressionAARP 
    Examples: 
      | site | zipCode | planType | planName                                            | drug1   |
      | AARP |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Orkambi |

    @samIconsUHC @regressionUHC  @featureGate @uhcmedicareSAMIcons
    Examples: 
      | site | zipCode | planType | planName                                            | drug1   |
      | UHC  |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Orkambi |

  Scenario Outline: To test the SAM icons on PRE pages <site>
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then the user validates whether call icon is visible
    And the user validates the chat icon
    And the user validates the proactive chat
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

    @samIconsAARP @regressionAARP 
    Examples: 
      | site | zipcode | planType | planName                                            | drug1   | pagename                                     | isMultiCounty | county            | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         |
      | AARP |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Orkambi | plan-recommendation-engine.html#/get-started | No            | Miami-Dade County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO |

    @samIconsUHC @regressionUHC @uhcmedicareSAMIcons 
    Examples: 
      | site | zipcode | planType | planName                                            | drug1   | pagename                                     | isMultiCounty | county            | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         |
      | UHC  |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Orkambi | plan-recommendation-engine.html#/get-started | No            | Miami-Dade County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO |
                                                                                                                                                                                                                                                                                  | UHC  |

  Scenario Outline: To test the SAM icons on Acq site from External Email Campaign <site> <pagename>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user opens the page to validate M&R Sites
      | pagename | <pagename> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon

    @samIconsAARP 
    Examples: 
      | pagename | site |
      | [blank]  | AARP |

    @samIconsAARP  @samIconsEmailExternal_01
    Examples: 
      | pagename                                                           | site |
      | ?WT.mc_id=8027650&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027650 | AARP |
      | ?WT.mc_id=8027651&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027651 | AARP |
      | ?WT.mc_id=8027652&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027652 | AARP |
      | ?WT.mc_id=8027677&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027677    | AARP |
      | ?WT.mc_id=8027678&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027678    | AARP |
      | ?WT.mc_id=8027679&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027679    | AARP |
      | ?WT.mc_id=8027682&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027682    | AARP |

    @samIconsAARP  @samIconsEmailExternal_02
    Examples: 
      | pagename                                                                                                                                           | site |
      | medicare-education/medicare-videos/medicare-prescription-drug-coverage-webinar.html?WT.mc_id=8015755&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8015755 | AARP |
      | medicare-education/medicare-videos/medicare-prescription-drug-coverage-webinar.html?WT.mc_id=8015756&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8015756 | AARP |
      | medicare-articles/aep-change-or-renew.html?WT.mc_id=8015751&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8015751                                          | AARP |
      | medicare-education/medicare-videos/medicare-prescription-drug-coverage-webinar.html?WT.mc_id=8015752&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8015752 | AARP |
      | medicare-education/medicare-videos/medicare-prescription-drug-coverage-webinar.html?WT.mc_id=8015753&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8015753 | AARP |
      | medicare-education/medicare-videos/medicare-prescription-drug-coverage-webinar.html?WT.mc_id=8017352&mrcid=em:Acq:MR%7CMMC%7CEGEM3561%7C::8017352 | AARP |
      | ?WT.mc_id=8027587&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027587                                                                                    | AARP |

    @samIconsAARP  @samIconsEmailExternal_03
    Examples: 
      | pagename                                                             | site |
      | ?WT.mc_id=8027588&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027588      | AARP |
      | ?WT.mc_id=8027590&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027590      | AARP |
      | ?WT.mc_id=8027591&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027591      | AARP |
      | ?WT.mc_id=8027592&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027592      | AARP |
      | ?WT.mc_id=8027589&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027589      | AARP |
      | ?WT.mc_id=8027593&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027593      | AARP |
      | ?WT.mc_id=8027581&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027581 | AARP |
      | ?WT.mc_id=8027582&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027582 | AARP |
      | ?WT.mc_id=8027583&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027583 | AARP |
      | ?WT.mc_id=8027586&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027586 | AARP |
      | ?WT.mc_id=8027492&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027492 | AARP |
      | ?WT.mc_id=8027494&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027494 | AARP |
      | ?WT.mc_id=8027495&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027495 | AARP |
      | ?WT.mc_id=8027496&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027496 | AARP |
      | ?WT.mc_id=8027571&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027571 | AARP |
      | ?WT.mc_id=8027572&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027572 | AARP |
      | ?WT.mc_id=8027573&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027573 | AARP |

    @samIconsUHC  @samIconsEmailExternal @uhcmedicareSAMIcons
    Examples: 
      | pagename                                                             | site |
      | ?WT.mc_id=8027650&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027650   | UHC  |
      | ?WT.mc_id=8027651&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027651   | UHC  |
      | ?WT.mc_id=8027652&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027652   | UHC  |
      | ?WT.mc_id=8027680&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027680     | UHC  |
      | ?WT.mc_id=8027681&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027681     | UHC  |
      | ?WT.mc_id=8027584&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027584 | UHC  |
      | ?WT.mc_id=8027585&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027585 | UHC  |
      | ?WT.mc_id=8027497&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027497 | UHC  |
      | ?WT.mc_id=8027499&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027499 | UHC  |
      | ?WT.mc_id=8027574&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027574 | UHC  |
      | ?WT.mc_id=8027575&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027575 | UHC  |
      | ?WT.mc_id=8027576&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027576 | UHC  |
