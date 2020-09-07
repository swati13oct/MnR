@PlanRecommandonationEngineMobile @PRERegressionRankingMobile @PRERegressionMobile
Feature: Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking using mobile

  @PRE @Rankingmobile @MAPlansRankingmobile @F358846
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Ranking for MA plans in PRE Mobile
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
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    #And user selects Pharmacy in Pharmacy page mobile
    #  | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendation rankings in results page mobile
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | County     | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName           | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder                                    |
      |   94203 | NO            | Sacramento | MAPD          | None         | WithinUS     | UHCNetwork       |                       |               | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Online            | No,No,No,No                   | Lower                | MA                    | Advantage Assure:SecureHorizons Focus:SecureHorizons |
      |   94203 | NO            | Sacramento | MAPD          | None         | OutsideUS    | lookup           | Robert Deloy Jamieson | NO            | Yes           | Lipitor,NO,Lipitor TAB 10MG,,,1,YES,NO                               | Retail            | Yes,Yes,Yes,Yes               | Higher               | MA                    | SecureHorizons:SecureHorizons Focus:Advantage Assure |

  @PRE @Rankingmobile @MAPlansRankingmobile @F358846
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Ranking for MA plans in PRE Mobile
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
    Then user validate recommendation rankings in results page mobile
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | County     | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder                                    |
      |   94203 | NO            | Sacramento | MAPD          | None         | None         | AcceptsMedicare  |             |               | NO            | No,No,Yes,Yes                 | Lower                | MA                    | SecureHorizons Focus:Advantage Assure:SecureHorizons |

  @PRE @Rankingmobile @PDPPlansRankingmobile @F358846
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> -Rankings <RankingplansOrder>- To validate PDP ranking plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option without drugs in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user validate elements in loading page mobile
    Then user validate recommendation rankings in results page mobile
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | DrugSelection | primaryRecommendation | RankingplansOrder              |
      |   35034 | Yes           | Bibb County | PDP           | Yes           | PDP                   | Walgreens:Preferred:Saver Plus |

  @PRE @Rankingmobile @PDPPlansRankingmobile @F358846
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> -Rankings <RankingplansOrder>- To validate PDP ranking plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    #When user selects Pharmacy in Pharmacy page mobile
    #  | Pharmacy Selection | <PharmacySelection> |
    And user validate elements in loading page mobile
    Then user validate recommendation rankings in results page mobile
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                 | PharmacySelection | primaryRecommendation | RankingplansOrder              |
      |   35034 | Yes           | Bibb County | PDP           | Yes           | Lipitor,NO,Lipitor TAB 10MG,,,1,YES,NO                                                               | Retail            | PDP                   | Saver Plus:Walgreens:Preferred |
      |   35034 | Yes           | Bibb County | PDP           | Yes           | Atorvastatin calcium,NO,atorvastatin calcium TAB 10MG,,,1,NO,NO:Aptiom,NO,Aptiom TAB 200MG,,,1,NO,NO | Online            | PDP                   | Preferred:Walgreens:Saver Plus |

  @PRE @planrecommandonationmobile @SNPPlansRankingmobile @F358846
  Scenario Outline: Zipcode: <Zipcode> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> -Rankings <RankingplansOrder> - To validate SNP ranking plans in PRE Mobile
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
    Then user validate recommendation rankings in results page mobile
      | Recommendation      | <primaryRecommendation> |
      | Ranking plans Order | <RankingplansOrder>     |

    Examples: 
      | Zipcode | isMultiCounty | County | isCoverageOpt | SpecialNeeds             | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | primaryRecommendation | RankingplansOrder |
      |   32111 | No            | Marion | MAPD          | Medicaid,Chronic,Nursing | OutsideUS    | AcceptsMedicare  |             |               | No            | No,No,No,Yes                  | Higher               | SNP                   | D-SNP:C-SNP:I-SNP |
      |   32111 | No            | Marion | MAPD          | Chronic,Nursing          | OutsideUS    | AcceptsMedicare  |             |               | No            | No,No,No,Yes                  | Higher               | SNP                   | C-SNP:I-SNP:D-SNP |
      |   32111 | No            | Marion | MAPD          | Nursing                  | OutsideUS    | AcceptsMedicare  |             |               | No            | No,No,No,Yes                  | Higher               | SNP                   | I-SNP:D-SNP:C-SNP |
