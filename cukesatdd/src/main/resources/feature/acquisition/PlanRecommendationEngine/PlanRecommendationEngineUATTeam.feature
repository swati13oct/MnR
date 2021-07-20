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
    Then user Validate Drug and Provider details in Visitor profile page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | PlanYear |
      | AARP |   10001 | NO            | New York | None          | None         | None   | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                  | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Health Care Premium | current  |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | PlanYear |
      | UHC  |   10001 | NO            | New York | None          | None         | None   | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                  | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Health Care Premium | current  |

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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate SNP Plan in Enroll page
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to VPP and PRE page //deleted in PRE stepdefinition
    When user navigates to Zip Code page from vpp plans
    And verify continue function on "Location" page
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt1> |
    And user verifies exisitng PRE drug session using startnow

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities    | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 |
      | AARP |   15537 | NO            | Bedford | MA            | Medicaid     | withinUS | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 1st            | Doctors, None | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | PDP            |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities    | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | isCoverageOpt1 |
      | UHC  |   15537 | NO            | Bedford | MA            | Medicaid     | withinUS | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 1st            | Doctors, None | Lipitor,YES,Lipitor TAB 10MG,,,Month,1,YES,NO                                | PDP            |

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

    @uatE2EAARP @uatE2EUHC
    Examples: 
      | site                   | Zipcode | isMultiCounty | county       | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 |
      | Myuhcplans             |   10002 | NO            | New York     | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                                                   |
      | uhcandwellmedsa        |   10003 | NO            | New York     | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO                                              |
      | mauhcmedicaresolutions |   35035 | YES           | Bibb County  | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                                                 |
      | maaarpmedicareplans    |   35035 | YES           | Perry County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO |
      | uhcmedicaresolutions   |   10001 | NO            | New County   | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Week,1,YES,NO                                                                  |
      | aarpmedicareplans      |   10001 | NO            | New York     | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO                                               |

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

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | PlanYear |
      | AARP |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | current  |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | PlanYear |
      | UHC  |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | current  |

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
    Then user validate MA Plan Names in VPP Summary VS Details in results page
    Then user validate email plan list from vpp
      | Recommendation | <primaryRecommendation> |
      | EmailID        | <Email>                 |
    Then user adds SNP options and Location in edit response page
      | Plan Type       | <E_isCoverageOpt> |
      | Zip Code        | <E_Zipcode>       |
      | Is Multi County | <E_isMultiCounty> |
      | CountyDropDown  | <E_county>        |
      | SNP Options     | <E_specialNeeds>  |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel             | doctors | DoctorsName                                       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | PlanYear | primaryRecommendation | Email                  | E_Zipcode | E_isMultiCounty | E_county | E_isCoverageOpt | E_specialNeeds           |
      | AARP |   10001 | NO            | New York | MAPD          | None         | withinUS,outsideUS | Lookup  | Venegas-Pizarro, Marcelo F, MD:Agu, Chinedu L, PA | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | Yes,Yes,Yes,Yes               | Higher               | both           | Dental, Doctors | current  | MA                    | julia_dowden@optum.com |     10003 | NO              | New York | MAPD            | Medicaid,chronic,nursing |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel             | doctors | DoctorsName                                       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                 | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | PlanYear | primaryRecommendation | Email                  | E_Zipcode | E_isMultiCounty | E_county | E_isCoverageOpt | E_specialNeeds           |
      | UHC  |   10001 | NO            | New York | MAPD          | None         | withinUS,outsideUS | Lookup  | Venegas-Pizarro, Marcelo F, MD:Agu, Chinedu L, PA | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | Yes,Yes,Yes,Yes               | Higher               | both           | Dental, Doctors | current  | MA                    | julia_dowden@optum.com |     10003 | NO              | New York | MAPD            | Medicaid,chronic,nursing |

  @PRE @PRE_UAT_Provider_Drugs_StartNow_MAPD_PlanCompare_Scenario-5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Providers session from VPP to PRE for MA plans
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    And user navigates to vpp summary page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    Then user adds Doctors in vpp summary page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to VPP and PRE page //deleted in PRE stepdefinition
    When user navigates to Zip Code page from vpp plans
    And verify continue function on "Location" page
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
    Then user select plans in VPP Summary and navigate to Plan Compare page

    @uatE2EAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | travel | DoctorsName         | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | PlanYear |
      | AARP |   65656 | YES           | Christian | None          | None         | None   | Higgins, Mina K, NP | Multi         | Yes            | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO                              | Yes,Yes,Yes,Yes               | Higher               | both           | Drug Cost , Dental | current  |

    @uatE2EUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | travel | DoctorsName         | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | PlanYear |
      | UHC  |   65656 | YES           | Christian | None          | None         | None   | Higgins, Mina K, NP | Multi         | Yes            | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO                              | Yes,Yes,Yes,Yes               | Higher               | both           | Drug Cost , Dental | current  |
