@PlanRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking with API results

  @PRE @Ranking @MAPlansAPIRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate API Ranking for MA plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds    | travel    | doctors | DoctorsName              | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                              | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      #      |   90210 | NO            | Los Angeles | MAPD          | Nursing         | withinUS  | Lookup  | George Mordechai Delshad | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Online         | Yes,Yes,Yes,Yes               | Lower                |
      |   32115 | NO            | Volusia  | MAPD          | Chronic,Nursing | withinUS  | Lookup  | David B. Auerbach        | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Online         | No,No,Yes,No                  | Lower                |
      #      |   15537 | NO            | Bedford     | MAPD          | None            | withinUS  | Lookup  | George Mordechai Delshad | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Retail         | Yes,Yes,Yes,Yes               | Lower                |
      |   10001 | NO            | New York | MAPD          | None            | OutsideUS | Lookup  | James D. Auran           | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Retail         | No,Yes,Yes,No                 | Lower                |
      |   10001 | NO            | New York | MAPD          | None            | OutsideUS | Lookup  | George Mordechai Delshad | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Retail         | No,Yes,Yes,No                 | Higher               |
      
      @PRE @planrecommandonation @SNPPlansAPIRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption> - To validate SNP API ranking plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName      | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup  | Armando J Blanco |               | No             | Yes,No,No,No                  | Higher               |


@PRE @planrecommendation @MAAPIRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MA flow functions for MA and MS plans in PRE
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county         | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York       | MA            | None         | withinUS | Lookup          | john        | YES           | Yes,No,No,Yes                 | Lower                |
      
      
  @PRE @Ranking @MAPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Ranking for MA plans in PRE
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
    Then user validate recommendation rankings in results page
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder                                    |
      |   94203 | NO            | Sacramento | MAPD          | None         | None   | AcceptsMedicare |             |               | NO             | No,No,Yes,Yes                 | Lower                | MA                    | SecureHorizons Focus:Advantage Assure:SecureHorizons |

  @PRE @Ranking @PDPPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user validate recommendation rankings in results page
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | primaryRecommendation | RankingplansOrder              |
      |   35034 | Yes           | Bibb County | PDP           | Yes            | PDP                   | Walgreens:Preferred:Saver Plus |

  @PRE @Ranking @PDPPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption>, <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    Then user validate elements in loading results page
    Then user validate recommendation rankings in results page
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                 | pharmacyoption | primaryRecommendation | RankingplansOrder              |
      |   35034 | Yes           | Bibb County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,1,YES,NO                                                               | Retail         | PDP                   | Saver Plus:Walgreens:Preferred |
      |   35034 | Yes           | Bibb County | PDP           | Yes            | Atorvastatin calcium,NO,atorvastatin calcium TAB 10MG,,,1,NO,NO:Aptiom,NO,Aptiom TAB 200MG,,,1,NO,NO | Online         | PDP                   | Preferred:Walgreens:Saver Plus |

  
