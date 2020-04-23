@PlanRecommandonationEngineMobile @PRERegressionSessionCookiesMobile
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with recommendation using mobile

 
  @PRE @planrecommandonationmobile @providersessionVPPtoPRE @F358845
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MAPD flow with drug functions for MA plans in PRE Mobile
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
