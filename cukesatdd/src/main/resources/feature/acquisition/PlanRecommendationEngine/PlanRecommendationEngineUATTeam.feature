@planRecommendationEngine
Feature: PRE_UAT - Verify UAT Scenarios in PRE

  @PRE @PRE_UAT_VP_DOC_DRUG_PlanName_Scenario-3 @F583139
  Scenario Outline: <Zipcode> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <PlanYear>  - To validate drug and doctors in Visitor profile
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user save 2 MA plans in vpp summary and Validate in Visitor profile page
      | Plan Year | <PlanYear> |
      | Plan Info | <PlanInfo> |
    Then user Validate Drug and Provider details in Visitor profile page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | PlanYear | PlanInfo                 |
      | AARP |   10001 | NO            | New York | None          | None         | None   | Lookup  | Ricky K. Hsu, MD         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                  | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Health Care Premium | current  | Prime (HMO):Choice (PPO) |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | PlanYear | PlanInfo                 |
      | UHC  |   10001 | NO            | New York | None          | None         | None   | Lookup  | Ricky K. Hsu, MD         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                  | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Health Care Premium | current  | Prime (HMO):Choice (PPO) |

  @PRE @PRE_UAT_DCE_VPP_Scenario-4 @F550383
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs in VPP page when MA flow complete in PRE and Add drugs in DCE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate SNP Plan in Enroll page
      | Plan Info | <PlanInfo> |
    Then user do browser back from current page
    When user navigate to Drug page to add drugs from PREResult page
    Then user selects add drug option in drug page from edit response page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user return to vpp page using "update" from edit response page
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo> |
    When user navigate to Drug page using edit drugs from PREResult page
    Then user selects add drug option in drug page from edit response page
      | Drug Selection | <Drug Selection>                                                                 |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user return to vpp page using "update" from edit response page
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo1> |
    Then user validate UI and API recommendation rankings in results page

    @uatE2EAARP12345
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities    | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 | PlanInfo            | Drug Selection | DrugInfo                               | DrugInfo1                              |
      | AARP |   53202 | NO            | Milwaukee | MAPD          | Medicaid     | withinUS | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 1st            | Doctors, None | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | Lipitor,YES,Lipitor TAB 40MG,,,Day,3,YES,NO                                    | PDP            | LP (HMO D-SNP),Link | Yes            | Preferred (PDP),Lipitor TAB 10MG,False | Preferred (PDP),Lipitor TAB 40MG,False |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities    | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 | PlanInfo            | Drug Selection | DrugInfo                               | DrugInfo1                              |
      | UHC  |   53202 | NO            | Milwaukee | MAPD          | Medicaid     | withinUS | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 1st            | Doctors, None | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | Lipitor,YES,Lipitor TAB 40MG,,,Day,3,YES,NO                                    | PDP            | LP (HMO D-SNP),Link | Yes            | Preferred (PDP),Lipitor TAB 10MG,False | Preferred (PDP),Lipitor TAB 40MG,False |

  @PRE @PRE_UAT_ExternalLink_PRE_Enroll_Scenario-2
  Scenario Outline: <site>  - To validate drug and doctors in Visitor profile
    Given the user is on external acquisition site landing page
      | Site Name | <site> |
    When user navigate to Plan Recommendation Engine Tool
      | Site Name       | <site>          |
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate PDP Plan Names in VPP Details and Click Enroll button in Plan Details page
      | Plan Info | <PlanInfo> |

    @uatE2EAARP @uatE2EUHC
    Examples: 
      | site                   | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | PlanInfo                    |
      | Myuhcplans             |   10002 | NO            | New York    | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                                                   | Walgreens (PDP),ViewButton  |
      #      | uhcandwellmedsa        |   10003 | NO            | New York     | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO                                              | Preferred (PDP),ViewButton  |
      | mauhcmedicaresolutions |   35035 | YES           | Bibb County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                                                 | Saver Plus (PDP),ViewButton |
      | maaarpmedicareplans    |   35035 | YES           | Bibb County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | Walgreens (PDP),ViewButton  |
      | uhcmedicaresolutions   |   10001 | NO            | New County  | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                                                  | Preferred (PDP),ViewButton  |
      | aarpmedicareplans      |   10001 | NO            | New York    | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO                                               | Saver Plus (PDP),ViewButton |

  @PRE @PRE_UAT_VP_PLANS_PDP_Defect1090
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <PlanYear> - To validate Plan Names VP VS VPP Details Page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user save plans in vpp summary and Validate in Visitor profile page
      | Plan Year | <PlanYear> |
      | Plan Info | <PlanInfo> |

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | PlanYear | PlanInfo                                                                      |
      | AARP |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | current  | Walgreens (PDP):Preferred (PDP):Prime (HMO):Plan 1 (HMO):Complete (HMO D-SNP) |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | PlanYear | PlanInfo                                                                      |
      | UHC  |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | current  | Walgreens (PDP):Preferred (PDP):Prime (HMO):Plan 1 (HMO):Complete (HMO D-SNP) |

  @PRE @PRE_UAT_PlanDetails_Email_EditMyResponses_Scenario-1
  Scenario Outline: <Zipcode> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <PlanYear>  - To validate drug and doctors in Visitor profile
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    And user views learn more from results page
      | Learn More | <learnMore> |
    Then user do browser back from current page
    And user views plan details from results page
      | Plan Info | <PlanInfo> |
    Then user do browser back from current page
    And user clicks on Medigap Plans Link in PRE Result page

    #Then user validate MA Plan Names in VPP Summary VS Details in results page
    #  | Plan Info | <PlanInfo> |
    #    Then user validate email plan list from vpp
    #      | Recommendation | <primaryRecommendation> |
    #      | EmailID        | <Email>                 |
    #Then user adds SNP options and Location in edit response page
    #  | Plan Type       | <E_isCoverageOpt> |
    #  | Zip Code        | <E_Zipcode>       |
    # | Is Multi County | <E_isMultiCounty> |
    #| CountyDropDown  | <E_county>        |
    #| SNP Options     | <E_specialNeeds>  |
    #Then user return to vpp page using "update" from edit response page
    #    Then user validate UI and API recommendation rankings in results page
    #Then user save recommendation results and validate in VP
    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel             | doctors | DoctorsName                                    | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | PlanYear | PlanInfo         | learnMore  |
      | AARP |   10001 | NO            | New York | MAPD          | None         | withinUS,outsideUS | Lookup  | Joseph, Jonathan Keith, MD:Fuhrer, Elliott, MD | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | Yes,Yes,Yes,Yes               | lower                | 1st            | Health Care Premium, Doctors | current  | Prime (HMO),Link | Supplement |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel             | doctors | DoctorsName                                    | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | PlanYear | PlanInfo         | learnMore  |
      | UHC  |   10001 | NO            | New York | MAPD          | None         | withinUS,outsideUS | Lookup  | Joseph, Jonathan Keith, MD:Fuhrer, Elliott, MD | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | Yes,Yes,Yes,Yes               | lower                | 1st            | Health Care Premium, Doctors | current  | Prime (HMO),Link | Supplement |

  @PRE @PRE_UAT_Provider_Drugs_StartNow_MAPD_PlanCompare_Scenario-5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Providers session from VPP to PRE for MA plans
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    And user navigates to vpp summary page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user verifies "VPP" page
    Then user adds Doctors in vpp summary page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to PRE page
    Then user clicks on GetStarted button in PRE page
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user navigate Doctors lookup session in Doctors page
    And user verifies doctors and continue to next page
      | Multi Doctor | <isMultiDoctor> |
    Then user selects add drug option and comparing DCE and Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate showmoreDoctor in PRE results page
      | DoctorsInfo | <doctorsInfo> |
    Then user validate drugCostModal in PRE results page
      | DrugInfo | <DrugInfo> |
    Then user validate showmoreDrug in PRE results page
      | DrugInfo | <DrugInfo1> |

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | DoctorsName          | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                            | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | PlanYear | DrugInfo                                         | DrugInfo1                                  | doctorsInfo                                    |
      | AARP |   65656 | YES           | Christian | None          | None         | Higgins, Mina K, FNP | Multi         | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:fentanyl citrate,NO,fentanyl citrate LOZ 200MCG,,,Week,1,NO,NO:Nutrilipid,NO,Nutrilipid EMU 20%,,,Week,1,NO,NO | Yes,Yes,Yes,Yes               | Higher               | both           | Drug Cost , Dental | current  | Plan 3 (Regional PPO),azathioprine TAB 50MG,True | Plan 1 (HMO-POS),azathioprine TAB 50MG,N/A | Plan 2 (Regional PPO),Higgins, Mina K, FNP,N/A |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | DoctorsName          | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                                                                   | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | PlanYear | DrugInfo                                         | DrugInfo1                                  | doctorsInfo                                    |
      | UHC  |   65656 | YES           | Christian | None          | None         | Higgins, Mina K, FNP | Multi         | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:fentanyl citrate/bupivacaine hydrochloride/sodium chloride,YES,fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,,,Month,1,NO,NO | Yes,Yes,Yes,Yes               | Higher               | both           | Drug Cost , Dental | current  | Plan 3 (Regional PPO),azathioprine TAB 50MG,True | Plan 1 (HMO-POS),azathioprine TAB 50MG,N/A | Plan 2 (Regional PPO),Higgins, Mina K, FNP,N/A |

  @PRE @PRE_UAT_DCE_VPP_Scenario-4_Updated @F550383
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs in VPP page when MA flow complete in PRE and Add drugs in DCE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan
    Then user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user adds SNP options and Location in edit response page
      | Plan Type       | <isCoverageOpt>  |
      | Zip Code        | <E_Zipcode>      |
      | Is Multi County | <isMultiCounty>  |
      | CountyDropDown  | <E_county>       |
      | SNP Options     | <E_specialNeeds> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds             | doctors | DoctorsName            | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities       | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 | PlanInfo            | E_specialNeeds | E_Zipcode | E_county |
      | AARP |   53202 | NO            | Milwaukee | MA            | Medicaid,chronic,nursing | Lookup  | Zimmer, Veronica L, NP | NO            | Yes,No,Yes,No                 | Lower                | both           | Dental , Doctors | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | PDP            | LP (HMO D-SNP),Link | chronic        |     10001 | New York |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds             | doctors | DoctorsName            | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities       | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 | PlanInfo            | E_specialNeeds | E_Zipcode | E_county |
      | UHC  |   53202 | NO            | Milwaukee | MA            | Medicaid,chronic,nursing | Lookup  | Zimmer, Veronica L, NP | NO            | Yes,No,Yes,No                 | Lower                | both           | Dental , Doctors | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | PDP            | LP (HMO D-SNP),Link | chronic        |     10001 | New York |

  @PRE @PRE_UAT_E2E_Scenario-6
  Scenario Outline: - To validate user MS 1st Recommendation and View Plan will take to MicroForm for Non Approved states
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to PRE using Homepage PRE widget
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    And user views plan details from results page
      | Plan Info | <planInfo> |

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                     | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                 | planInfo          |
      | AARP |   19901 | NO            | Kent County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,20,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 50MG ER,,20,Week,3,NO,NO | Yes,Yes,Yes,Yes               | Higher               | 1st            | Health Care Premium , None | Plan G,ViewButton |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                     | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                 | planInfo          |
      | UHC  |   19901 | NO            | Kent County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,20,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 50MG ER,,20,Week,3,NO,NO | Yes,Yes,Yes,Yes               | Higher               | 1st            | Health Care Premium , None | Plan G,ViewButton |

  @PRE @PRE_UAT_E2E_Scenario-7
  Scenario Outline: - To validate Edit preference functions for MA to PDP in PRE and Check Recommendations changes to MS to PDP
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user selects add drug option in drug page from edit response page
      | Drug Selection | <E_Drug Selection>                                                               |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validates coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @uatE2EAARP @null
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   32115 | NO            | Volusia | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Higher               | both           | Health Care Premium, Doctors | PDP             | Yes              | Lipitor,NO,Lipitor TAB 80MG,,,Week,1,YES,NO                                    |

    @uatE2EUHC
    Examples: 
      Examples:

      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   32115 | NO            | Volusia | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Higher               | both           | Health Care Premium, Doctors | PDP             | Yes              | Lipitor,NO,Lipitor TAB 80MG,,,Week,1,YES,NO                                    |

  @PRE @PRE_EditResponse_BrowserBack @F556308
  Scenario Outline:  - To validate PlanName and PlanType in Result page when user edit preference and do browser back to Result page without using Updated View planRecom Button
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user save recommendation PlanType and PlanName to validate Browser back Functionality in results page
    Then user adds SNP options in edit response page
      | Plan Type       | <isCoverageOpt>  |
      | SNP Options     | <E_specialNeeds> |
    Then user return to PRE-Result page using browser back in EditMyResponse page
    Then user validate edited recommendation PlanType and PlanName in results page
    Then user validate UI and API recommendation rankings in results page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities       | E_specialNeeds           |
      | AARP |   10001 | NO            | New York | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Lower                | both           | Dental , Doctors | Medicaid,chronic,nursing |
      
    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities       | E_specialNeeds           |
      | UHC  |   10001 | NO            | New York | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Lower                | both           | Dental , Doctors | Medicaid,chronic,nursing |
