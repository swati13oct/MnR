@PlanRecommandonationEngineMobile @PRERegressionRankingMobile @PRERegressionMobile
Feature: Plan Recommendation Engine Ranking - Verify PRE Edit Response functionalities using mobile

  @PRE @planrecommendationMobile @EditResponsePageMobile @MobileVerifyEdit
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate responses in edit preference page in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate saved values in edit response page mobile
      | Zip Code            | <Zipcode>                                                              |
      | CountyDropDown      | <County>                                                               |
      | Plan Type           | <isCoverageOpt>                                                        |
      | SNP Options         | <SpecialNeeds>                                                         |
      | Travel Options      | <TravelOption>                                                         |
      | Doctors             | <DoctorsSelection>                                                     |
      | Doctors Search Text | <DoctorsName>                                                          |
      | Drug Selection      | <DrugSelection>                                                        |
      | Drug Details        | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
      | Additional Option   | <Dental-Hearing-Vision-Fitness>                                        |
      | Preference Option   | <costPreferenceOption>                                                 |
      | Priorities          | <priorities>                                                           |
    Then user return to vpp page using "return" from edit response page mobile
    Then user validate UI and API recommendation rankings in results page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         |
      |   10001 | NO            | New York | None          | Medicaid     | regular      | Lookup           | sue         | NO            | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Doctors |

  @PRE @planrecommendationMobile @EditResponsePageMobile @MobileEditvalueMAPD
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Edit preference functions for MAPD in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page mobile
    Then user edits values in edit response page mobile
      | Plan Type           | <isCoverageOpt>                                                          |
      | Zip Code            | <E_Zipcode>                                                              |
      | Is Multi County     | <E_isMultiCounty>                                                        |
      | CountyDropDown      | <E_county>                                                               |
      | SNP Options         | <E_specialNeeds>                                                         |
      | Travel Options      | <E_travel>                                                               |
      | Doctors             | <E_doctors>                                                              |
      | Doctors Search Text | <E_DoctorsName>                                                          |
      | Multi Doctor        | <E_isMultiDoctor>                                                        |
      | Drug Selection      | <E_Drug Selection>                                                       |
      | Drug Details        | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
      | Additional Option   | <E_Dental-Hearing-Vision-Fitness>                                        |
      | Preference Option   | <E_costPreferenceOption>                                                 |
      | Priority Option     | <E_priorityOption>                                                       |
      | Priorities          | <E_priorities>                                                           |
    Then user return to vpp page using "update" from edit response page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_Zipcode | E_isMultiCounty | E_county    | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      |   10001 | NO            | New York | MAPD          | Medicaid     | regular      | Lookup           | sue         | NO            | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                |     35034 | YES             | Bibb County | MAPD            | nursing        | withinUS | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                                | No,No,No,No                     | Higher                 |

  @PRE @planrecommendationMobile @EditResponsePageMobile @MobileMAPDtoMA
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate Edit preference functions for MAPD to MA in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user navigates to edit response page mobile
      | Plan Type   | <isCoverageOpt> |
      | SNP Options | <SpecialNeeds>  |
    Then user edits coverage value in edit response page mobile
      | Plan Type | <E_isCoverageOpt> |
    Then user validates coverage value in edit response page mobile
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     | E_isCoverageOpt |
      |   10001 | NO            | New York | MAPD          | Medicaid     | regular      | Lookup           | sue         | NO            | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                | both           | Travel,Doctors | MA              |

  @PRE @planrecommendationMobile @EditResponsePageMobile @MobileIDKtoPDP
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption>  - To validate Edit preference functions for IDK to PDP in PRE Mobile
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
    And user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    And user selects cost preferences option in cost preferences page mobile
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page mobile
    Then user navigates to edit response page mobile
      | Plan Type   | <isCoverageOpt> |
      | SNP Options | <SpecialNeeds>  |
    Then user edits coverage value in edit response page mobile
      | Plan Type | <E_isCoverageOpt> |
    Then user validates coverage value in edit response page mobile
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_isCoverageOpt |
      |   10001 | NO            | New York | None          | Medicaid     | regular      | Lookup           | sue         | NO            | Yes           | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                | PDP             |

  @PRE @planrecommendationMobile @EditResponsePageMobile @MobilePDPtoMAPD
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Edit preference functions for PDP to MAPD in PRE Mobile
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
    Then user navigates to edit response page mobile
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page mobile
      | Plan Type | <E_isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <E_specialNeeds> |
    And user selects Travel options in Travel Page mobile
      | Travel Options | <E_travel> |
    And user selects Doctors in Doctors page and validate next page name mobile
      | Doctors Selection   | <E_doctors>       |
      | Doctors Search Text | <E_DoctorsName>   |
      | Multi Doctor        | <E_isMultiDoctor> |
    Then user selects add drug option in Drug page mobile
      | Drug Selection | <E_Drug Selection>                                                       |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page mobile
      | Additional Option | <E_Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page mobile
      | Preference Option | <E_costPreferenceOption> |
    Then user validate recommendations in results page mobile
      | Zip Code           | <Zipcode>           |
      | County Name        | <County>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | No            | MAPD            | nursing        | withinUS | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                                | No,No,No,No                     | Higher                 | SNP               | MS                |
