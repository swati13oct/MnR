@campaignExternalLinks
Feature: 1.05.5. UAT Scripts Campaign External Links Scenario 5 related to morganstanley

  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in Learn About Medicare from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------Learn About Medicare from Morgan Stanley page------------------
    Then the user clicks on Learn About Medicare button on Morgan Stanley external link page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of page
      | TFN Xpath | <TFNxpath3> |
    And the user clicks on Medicare Education Supplement Insurance Plans Link
    And the user validates SAM icons on Medsupp page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of Medsupp page
      | TFN Xpath | <TFNxpath4> |

    #And the user closes the new browser tab
    @Scenario5_AARP @Scenario5_AARP_LearnAboutMedicare
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                 | TFNxpath3                              | TFNxpath4                             | pscCode | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | plantype | planName                                                         | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[@data-asset-name= 'TFN'])[1]/u[1] | (//div[@class= 'twineTfn'])[2]/div[2] | 8002977 |   65656 | YES           | Christian County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MA       | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] |

  #--------------------PRE from Morgan Stanley page---------------------------
  @campaignExternalLinks_PRE
  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in PRE from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then the user clicks on Learn About Medicare button on Morgan Stanley external link page
    And the user closes the new browser tab
    Then the user clicks on Get Help Finding a Plan button on Morgan Stanley external link page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate loading results page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user click on view plan in results page
    And User clicks on Back to Plans on detail page
    And the user views the plans for below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    #And the user views plan details of the above selected plan and validates
    And the user views plan details for selected plan and validates
      | Plan Name | <planName> |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    #Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user clicks on Enroll Now in Details Page to start the OLE flow on the site
    #Then The User validates the Plan details on OLE page
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |

    @Scenario5_AARP @Scenario5_AARP_PRE
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                 | TFNxpath3                              | TFNxpath4                             | pscCode | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | plantype | planName                             | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            | planyear |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[@data-asset-name= 'TFN'])[1]/u[1] | (//div[@class= 'twineTfn'])[2]/div[2] | 8002977 |   65656 | YES           | Christian County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MA       | AARP Medicare Advantage Choice (PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] | future   |

  #---------------------VPP from Morgan Stanley page-------------------
  @campaignExternalLinks_VPP_Summary
  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup VPP Plan Summary from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    When the user performs plan search using following information on Morgan Stanley external link page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans for below plan type
      | Plan Type | <plantypePDP> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
      | Plan Type | <plantypeSNP> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans for below plan type
      | Plan Type | <plantype> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
      | Plan Type | <plantypeMS> |
    And the user validates SAM icons on Medsupp page from External Link
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail for Medsupp External Link
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath5> |

    #And the user closes the new browser tab
    @Scenario5_AARP @Scenario5_AARP_VPP_Summary
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                 | TFNxpath3                           | TFNxpath4                             | pscCode | Zipcode | isMultiCounty | county       | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | plantype | planName                                                         | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //a[contains(@class,'invoca_swap')] | (//div[@class= 'twineTfn'])[2]/div[2] | 8002977 |   24010 | NO            | Roanoke City | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MA       | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] |

  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in Learn About Medicare from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------Learn About Medicare from Morgan Stanley page------------------
    Then the user clicks on Learn About Medicare button on external link page in lower env
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of page
      | TFN Xpath | <TFNxpath3> |
    And the user clicks on Medicare Education Supplement Insurance Plans Link
    And the user validates SAM icons on Medsupp page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of Medsupp page
      | TFN Xpath | <TFNxpath4> |

    @Scenario5_AARP_Stage @regressionAARP @campaignExternalStage @Scenario5_AARP_Stage_LearnAboutMeducare
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                            | TFNxpath3                              | TFNxpath4                                             | pscCode | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | plantype | planName                                                         | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            | planyear | TFNxpath6                           |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | (//a[@data-asset-name= 'TFN'])[1]/u[1] | (//div[contains(@class,'calluswidgets')]//p[2]//a)[2] | 8002977 |   65656 | YES           | Christian County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MA       | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] | current  | //a[contains(@class,'invoca_swap')] |

  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in MA, Medsupp page, PRE from External link: <externallink>
    #--------------------PRE from Morgan Stanley page---------------------------
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then the user clicks on Learn About Medicare button on external link page in lower env
    And the user closes the new browser tab
    Then the user clicks on Get Help Finding a Plan button on external link page in lower env
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    #And user clicks on get started to start questionnaire
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And user select plantype in the coverage options page
      | Plan Type | <isCoverageOpt> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user select add drug option in the Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    #Then user validate elements in loading results page
    # And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user click on view plan in results page
    And User clicks on Back to Plans on detail page
    And the user views the plans for below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views the plans for below plan type
      | Plan Type | <plantypePDP> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details for selected plan and validates
      | Plan Name | <PDPplanName> |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    #Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user clicks on Enroll Now in Details Page to start the OLE flow on the site
    #Then The User validates the Plan details on OLE page
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |

    @Scenario5_AARP_Stage @regressionAARP @campaignExternalStage @Scenario5_AARP_Stage_PRE
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                            | TFNxpath3                              | TFNxpath4                                             | pscCode | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | MAplantype | planName                             | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            | planyear | TFNxpath6                           | PDPplanName                     |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | (//a[@data-asset-name= 'TFN'])[1]/u[1] | (//div[contains(@class,'calluswidgets')]//p[2]//a)[2] | 8002977 |   65656 | YES           | Christian County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MAPD       | AARP Medicare Advantage Choice (PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] | future   | //a[contains(@class,'invoca_swap')] | AARP MedicareRx Walgreens (PDP) |

  #---------------------VPP from Morgan Stanley page-------------------
  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in MA, Medsupp page, VPP Summary from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    When the user performs plan search using following information on Morgan Stanley external link page in lower env
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans for below plan type
      | Plan Type | <plantypePDP> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
      | Plan Type | <plantypeSNP> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans for below plan type
      | Plan Type | <plantype> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail from external link
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
      | Plan Type | <plantypeMS> |
    And the user validates SAM icons on Medsupp page from External Link
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail for Medsupp External Link
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath5> |

    #And the user closes the new browser tab
    @Scenario5_AARP_Stage @regressionAARP @campaignExternalStage @Scenario5_AARP_Stage_VPP_Summary
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                            | TFNxpath3                           | TFNxpath4                                             | pscCode | Zipcode | isMultiCounty | county       | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | 1stRecommendation | 2ndRecommendation | plantype | planName                             | plantypePDP | plantypeSNP | plantypeMS | TFNxpath5                            | planyear | TFNxpath6                           |
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | //a[contains(@class,'invoca_swap')] | (//div[contains(@class,'calluswidgets')]//p[2]//a)[2] | 8002977 |   24010 | NO            | Roanoke City | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | PDP               | MA                | MA       | AARP Medicare Advantage Choice (PPO) | PDP         | SNP         | MS         | (//span[contains(@class, 'tel')])[1] | current  | //a[contains(@class,'invoca_swap')] |
