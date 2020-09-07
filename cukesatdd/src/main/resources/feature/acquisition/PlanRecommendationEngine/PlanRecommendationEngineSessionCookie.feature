@PlanRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with session cookies

  @PRE @planrecommendation @DrugPREtoVPP @F375045 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs details from PRE to VPP Page
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |
    Then user validate drugs details from PRE to VPP page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                 | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   94203 | NO            | Sacramento | MAPD          | None         | withinUS | AcceptsMedicare |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,1,YES,YES:Actiq,NO,,,,1,YES,NO | Retail         | Yes,No,No,Yes                 | Lower                | MA                | Assure      | MS                |

  @PRE @planrecommendation @DrugVPPtoPRE @F358830 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate removed Drugs details are reflecting from VPP to PRE Page
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |
    Then user validate removed drugs details updated from VPP to PRE page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                 | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   94203 | NO            | Sacramento | MAPD          | None         | withinUS | AcceptsMedicare |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,1,YES,YES:Actiq,NO,,,,1,YES,NO | Retail         | Yes,No,No,Yes                 | Lower                | MA                | Assure      | MS                |

  @PRE @planrecommendation @DrugVPPtoDCEandPRE @F358830 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate Drugs details are reflecting from VPP to DCE and PRE Page
    Given the user is on UHC medicare acquisition site landing page
    And user navigates to vpp summary page
      | Zip Code | <Zipcode> |
   When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to VPP and PRE page
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option and comparing DCE and Drug page
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   10001 | NO            | Sacramento | PDP           | Yes            | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO                              |

  @PRE @planrecommendation @providersessionVPPtoPRE @F358845 @F427538 @F458224 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Providers session from VPP to PRE for MA plans
    Given the user is on UHC medicare acquisition site landing page
    And user navigates to vpp summary page
      | Zip Code | <Zipcode> |
    And user verifies "VPP" page
    Then user adds Doctors in vpp summary page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user navigate Doctors lookup session in Doctors page
    And user verifies doctors session in Doctors page
      | Multi Doctor | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel   | DoctorsName | isMultiDoctor |
      |   10003 | NO            | New York | MAPD          | None         | withinUS | sue         | NO            |

  @PRE @planrecommendation @providersessionPREtoVPP @F358845 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate providers session from PRE to VPP in MAPD flow with drug functions for MA plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user adds Providers in Doctors page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    And user verifies doctors session in VPP page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel   | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York | MAPD          | None         | withinUS | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Retail         | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommendation @startNowZipcode @F428517 @PRERegression1
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Zipcode session from VPP to PRE Using StartNow
    Given the user is on UHC medicare acquisition site landing page
    Then user navigates to VPP Summary Page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    Then user validate zipcode and County in location page using StartNow
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |

    Examples: 
      | Zipcode | isMultiCounty | county           |
      |   10003 | NO            | New York         |
      |   77485 | YES           | Fort Bend County |

  @PRE @planrecommendation @startOverfunction @F427582 @PRERegression4
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Zipcode session from VPP to PRE Using StartNow
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user adds Providers in Doctors page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    Then user navigate to PRE and validate zipcode using Start Over
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user navigate Doctors lookup session in Doctors page
    And user verifies Start Over doctors session in Doctors page
      | Multi Doctor | <isMultiDoctor> |
    Then user selects add drug option and verifying the drugs in Drug page
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds | travel   | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York         | MAPD          | None         | withinUS | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Retail         | Yes,No,No,Yes                 | Lower                |
      |   77485 | YES           | Fort Bend County | MAPD          | None         | withinUS | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Retail         | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommendation @StartNowE2Eflow @F375045 @PRERegression4
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs details from PRE to VPP Page
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |
    Then user navigate to PRE using StartNow button and verify drugs details in PRE page
    Then user proceed page navigation till VPP page after Start Now button
      | Plan Type | <isCoverageOpt> |
    And verify continue function on "Pharmacy" page
    And verify continue function on "Additional Services" page
    And verify continue function on "Cost Preferences" page
    Then user validate elements in loading results page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   94203 | NO            | Sacramento | MAPD          | None         | withinUS | AcceptsMedicare |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Retail         | Yes,No,No,Yes                 | Lower                | MA                | Assure      | MS                |

  @PRE @planrecommendation @deleteDocZipChange @F428517 @PRERegression4
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate provider removal on zip change in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    When user navigates to Zip Code page from vpp plans
    And verify continue function on "Location" page
    And verify continue function on "Coverage" page
    And verify continue function on "Special" page
    And verify continue function on "Travel" page
    And user selects Doctors in Doctors page and validate next page name
    Then user verifies existing PRE provider session using startnow
      | Multi Doctor | <isMultiDoctor> |
    And user verifies exisitng PRE drug session using startnow
    And verify continue function on "Pharmacy" page
    And verify continue function on "Additional Services" page
    And verify continue function on "Cost Preferences" page
    And user validate elements in loading results page
    And user navigates to Zip Code page from vpp plans

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York | MAPD          | None         | regular | Lookup  | john        | YES           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Retail         | Yes,No,No,Yes                 | Lower                |

  @PRE @planrecommandonation @EmailList @PDPEmailPlans @F452764 @PRERegression4
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user validate email plan list from vpp
      | Recommendation | <primaryRecommendation> |
      | EmailID        | <Email>                 |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | primaryRecommendation | Email                  |
      |   10003 | NO            | New York | PDP           | No             | PDP                   | julia_dowden@optum.com |

  @PRE @planrecommandonation @EmailList @F452764 @PRERegression4
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption>, <primaryRecommendation> , <RankingplansOrder> - To validate Email plan list in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    Then user validate email plan list from vpp
      | Recommendation | <primaryRecommendation> |
      | EmailID        | <Email>                 |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel    | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | Email                  |
      |   32111 | No            | Marion   | MAPD          | Medicaid     | outsideUS | AcceptsMedicare |             |               | No             | No,No,No,Yes                  | Higher               | SNP                   | julia_dowden@optum.com |
      |   10001 | No            | New York | MAPD          | None         | None      | UHGNetwork      |             |               | No             | No,No,No,Yes                  | Lower                | MA                    | julia_dowden@optum.com |
