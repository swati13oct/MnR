@PlanRecommandonationEngineMobile @PRERegressionFlowsMobile
Feature: Plan Recommendation Engine flow - Verify Loading screen page functionalities in PRE using mobile

  @PRE @planrecommandonationmobile @PDPmobile @PDPskipdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> - To validate PDP flow with drug skip functions in PRE Mobile
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
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | skip          | PDP               | Walgreens   | MS                |

  @PRE @planrecommandonationmobile @PDPmobile @PDPZerodrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> - To validate PDP flow with zero drug functions in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    When user selects add drug option without drugs in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | DrugSelection | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   35034 | YES           | Bibb County | PDP           | add           | PDP               | Walgreens   | MS                |

  @PRE @planrecommandonationmobile @PDPmobile @PDPdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate PDP flow with drug functions in PRE Mobile
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
    When user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | add           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | PDP               | Walgreens   | MA                |

  @PRE @planrecommandonationmobile @MAmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MA flow functions in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County         | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10003 | NO            | New York       | MA            | None         | Travel       | lookup           | sue         | YES           | Yes,No,No,Yes                 | Lower                | MA                | Plan 1      | MS                |
      |   25813 | NO            | Raleigh County | MA            | Medicaid     | Care Away    | want to use      |             |               | No,No,No,No                   | Higher               | MS                | Plan F      | PDP               |

  @PRE @planrecommandonationmobile @MAPDmobile @MAPDdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MAPD flow functions in PRE Mobile
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
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10003 | NO            | New York | MAPD          | None         | Travel       | lookup           | sue         | YES           | add           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                | MA                | Plan 1      | MS                |

  @PRE @planrecommandonationmobile @MAPDmobile @MAPDskipdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MAPD skip drug flow functions in PRE Mobile
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
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   35034 | YES           | Bibb County | MAPD          | None         | Another Part | lookup           | robert      | NO            | skip          | Yes,No,No,Yes                 | Higher               | MS                | Plan F      | MA                |

  @PRE @planrecommandonationmobile @MAPDmobile @MAPDzerodrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MAPD zero drug flow functions in PRE Mobile
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
    Then user selects add drug option without drugs in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County     | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   55001 | NO            | Washington | MAPD          | Facility     | Care Away    | want to use      |             |               | add           | Yes,No,No,Yes                 | Higher               | SNP               | I-SNP       | MS                |

  @PRE @planrecommandonationmobile @DKmobile @DKdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Dont Know flow functions in PRE Mobile
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
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10001 | NO            | New York | NA            | Medicaid     | Care Away    | lookup           | sue         | NO            | add           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 | Lower                | SNP               | D-SNP       | MA                |

  @PRE @planrecommandonationmobile @DKmobile @DKskipdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Dont know skip drug flow functions in PRE Mobile
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
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10001 | NO            | New York | NA            | None         | None         | lookup           | sue         | NO            | skip          | No,No,No,No                   | Lower                | MA                | Plan 1      | MS                |

  @PRE @planrecommandonationmobile @DKmobile @DKzerodrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Dont know zero drug flow functions in PRE Mobile
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
    Then user selects add drug option without drugs in Drug page mobile
      | Drug Selection | <DrugSelection> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County       | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   84315 | YES           | Davis County | NA            | Condition    | Care Away    | willing to use   |             |               | add           | Yes,Yes,Yes,Yes               | Lower                | SNP               | C-SNP       | MA                |

  @PRE @planrecommandonationmobile @MAflowTiemobile @F432670
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MA flow functions in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And user validate elements in loading page mobile
    Then user validate tie recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 1st Ranking plan   | <Rankingplan>       |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | Rankingplan | 2ndRecommendation |
      |   10003 | NO            | New York | MA            | None         | Travel       | want to use      |             |               | Yes,No,No,No                  | Lower                | MA                |             | MS                |
      |   10001 | NO            | New York | MA            | Medicaid     | Care Away    | want to use      |             |               | Yes,No,No,No                  | Lower                | SNP               |             |                   |
      |   10001 | NO            | New York | MA            | None         | None         | willing to use   |             |               | No,No,No,No                   | Lower                | MA                |             |                   |
