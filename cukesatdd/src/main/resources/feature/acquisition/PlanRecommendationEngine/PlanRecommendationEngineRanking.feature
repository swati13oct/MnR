@PlanRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking

  @PRE @Ranking @MAPlansRanking @F3588461
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
    Then user validate recommendation rankings in results page
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel    | doctors    | DoctorsName           | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder                                    |
      |   94203 | NO            | Sacramento | MAPD          | None         | withinUS  | UHGNetwork |                       |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Online         | No,No,No,No                   | Lower                | MA                    | Advantage Assure:SecureHorizons Focus:SecureHorizons |
      |   94203 | NO            | Sacramento | MAPD          | None         | outsideUS | Lookup     | Robert Deloy Jamieson | NO            | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,1,YES,NO                               | Retail         | Yes,Yes,Yes,Yes               | Higher               | MA                    | SecureHorizons:SecureHorizons Focus:Advantage Assure |

  @PRE @Ranking @MAPlansRanking @F3588461
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

  @PRE @Ranking @PDPPlansRanking @F3588461
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

  @PRE @Ranking @PDPPlansRanking @F3588461
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

  @PRE @planrecommandonation @SNPPlansRanking @F3588461
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption>, <primaryRecommendation> , <RankingplansOrder> - To validate SNP ranking plans in PRE
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
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel    | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder |
      |   32111 | No            | Marion | MAPD          | Medicaid,Chronic,Nursing | OutsideUS | AcceptsMedicare |             |               | No             | No,No,No,Yes                  | Higher               | SNP                   | D-SNP:C-SNP:I-SNP |
      |   32111 | No            | Marion | MAPD          | Chronic,Nursing          | OutsideUS | AcceptsMedicare |             |               | No             | No,No,No,Yes                  | Higher               | SNP                   | C-SNP:I-SNP:D-SNP |
      |   32111 | No            | Marion | MAPD          | Nursing                  | OutsideUS | AcceptsMedicare |             |               | No             | No,No,No,Yes                  | Higher               | SNP                   | I-SNP:D-SNP:C-SNP |
