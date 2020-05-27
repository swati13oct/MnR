@PlanRecommandonationEngineMobile @PRERegressionSessionCookiesMobile @PRERegressionMobile
Feature: Plan Recommendation Engine - Verify PRE Session Cookies functionalities using mobile

  @PRE @planrecommandonationmobile @providersessionVPPtoPRE @F358845 @F427538
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> - To validate Providers session from VPP to PRE for MA plans in Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to vpp summary page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    When user adds Doctors in vpp summary page mobile
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user navigates to Zip Code page from vpp mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user navigate Doctors lookup session in Doctors page mobile
    And user verifies doctors session in Doctors page mobile
      | Multi Doctor | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsName | isMultiDoctor |
      |   10003 | NO            | New York | MAPD          | None         | WithinUS     | sue         | NO            |

  @PRE @planrecommandonationmobile @providersessionPREtoVPP @F358845
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate providers session from PRE to VPP in MAPD flow with drug functions for MA plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    When user adds Providers in Doctors page mobile
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user verifies doctors session in VPP page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York | MAPD          | None         | WithinUS     | lookup           | sue         | NO            | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonationmobile @drugsessionPREtoVPP @F375045
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate drug session from PRE to VPP in MAPD flow with drug functions for MA plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    When user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |
    And user adds drugs in Drug page mobile
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user verifies drugs session in VPP page mobile

    Examples: 
      | Zipcode | isMultiCounty | County     | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   94203 | NO            | Sacramento | MAPD          | None         | WithinUS     | lookup           | robert      | NO            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonationmobile @zipsessionVPPtoPRE @F428517
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty>  - To validate zip code session from VPP to PRE in Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to vpp summary page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user navigates to Zip Code page from vpp plans mobile
    Then user validte zip info in location page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode1>       |
      | Is Multi County | <isMultiCounty1> |
      | County Name     | <County1>        |

    Examples: 
      | Zipcode | isMultiCounty | County       | Zipcode1 | isMultiCounty1 | County1     |
      |   10003 | NO            | New York     |    94203 | NO             | Sacramento  |
      |   84315 | YES           | Davis County |    35034 | YES            | Bibb County |

  @PRE @planrecommandonationmobile @startovermobile @F427582
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate start over function with MAPD flow in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    And user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    When user navigates to Zip Code page from vpp plans using startover mobile
    And user validte zip info in location page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    Then user selects plan type in coverage options page mobile
      | Plan Type |  |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page and validate errors mobile
      | SNP Options |  |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page and validate errors mobile
      | Travel Options |  |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    And user selects Doctors in Doctors page and validate errors mobile
      | Doctors Selection   |  |
      | Doctors Search Text |  |
      | Multi Doctor        |  |
    And user navigate Doctors lookup session in Doctors page mobile
    Then user verifies existing PRE provider session using startover mobile
      | Multi Doctor | <isMultiDoctor> |
    And user validte error function in drug option selection page mobile
      | Drug Selection |  |
    And user verifies exisitng PRE drug session using startover mobile
    And user selects Pharmacy in Pharmacy page and validate errors mobile
      | Pharmacy Selection |  |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user validates additional services error function in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user validates cost preferences error function in cost preferences page mobile
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    And user navigates to Zip Code page from vpp plans using startover mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York | MAPD          | None         | Regular      | lookup           | sue         | YES           | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonationmobile @startnowmobile @F427582
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate start now function in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    And user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    When user navigates to Zip Code page from vpp plans mobile
    And user validte zip info in location page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And verify continue function on "Location" page mobile
    And verify continue function on "Coverage" page mobile
    And verify continue function on "Special" page mobile
    And verify continue function on "Travel" page mobile
    And user navigate Doctors lookup session in Doctors page mobile
    Then user verifies existing PRE provider session using startnow mobile
      | Multi Doctor | <isMultiDoctor> |
    And user verifies exisitng PRE drug session using startnow mobile
    And verify continue function on "Pharmacy" page mobile
    And verify continue function on "Additional Services" page mobile
    And verify continue function on "Cost Preferences" page mobile
    And user validate elements in loading page mobile
    And user navigates to Zip Code page from vpp plans mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York | MAPD          | None         | Regular      | lookup           | sue         | YES           | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonationmobile @deleteDocZipChange @F428517
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate provider removal on zip change in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    And user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    When user navigates to Zip Code page from vpp plans mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode1>       |
      | Is Multi County | <isMultiCounty1> |
      | County Name     | <County1>        |
    And verify continue function on "Coverage" page mobile
    And verify continue function on "Special" page mobile
    And verify continue function on "Travel" page mobile
    And user selects Doctors in Doctors page and validate next page name mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName1>     |
      | Multi Doctor        | <isMultiDoctor1>   |
    And user verifies exisitng PRE drug session using startnow mobile
    And verify continue function on "Pharmacy" page mobile
    And verify continue function on "Additional Services" page mobile
    And verify continue function on "Cost Preferences" page mobile
    And user validate elements in loading page mobile
    And user navigates to Zip Code page from vpp plans mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | Zipcode1 | isMultiCounty1 | County1  | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DoctorsName1 | isMultiDoctor1 | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York |    10001 | NO             | New York | MAPD          | None         | Regular      | lookup           | sue         | Yes           | robert       | No             | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonationmobile @EmailListmobile @PDPEmailPlans @F452764
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> - To validate Email Plan List PDP plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    When user selects skip option in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user validate elements in loading page mobile
    Then user validate email plan list from vpp mobile
      | Recommendation | <primaryRecommendation> |
      | EmailID        | <Email>                 |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | primaryRecommendation | Email                  |
      |   10003 | NO            | New York | PDP           | No            | PDP                   | julia_dowden@optum.com |

  @PRE @planrecommandonationmobile @EmailListmobile @F452764
  Scenario Outline: Zipcode: <Zipcode> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> -Email Plan <primaryRecommendation> - To validate Email plan list in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    When user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |
    And user selects skip option in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate email plan list from vpp mobile
      | Recommendation | <primaryRecommendation> |
      | EmailID        | <Email>                 |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | Email                  |
      |   32111 | No            | Marion   | MAPD          | Medicaid     | OutsideUS    | AcceptsMedicare  |             |               | No            | No,No,No,Yes                  | Higher               | SNP                   | julia_dowden@optum.com |
      |   10001 | No            | New York | MAPD          | None         | None         | UHCNetwork       |             |               | No            | No,No,No,Yes                  | Lower                | MA                    | julia_dowden@optum.com |
