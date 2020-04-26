@PlanRecommandonationEngineMobile @PRERegressionSessionCookiesMobile
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with recommendation using mobile

  @PRE @planrecommandonationmobile @providersessionVPPtoPRE @F358845
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -AdditionalOption: <Dental-Hearing-Vision-Fitness> -CostPreferenceSelection: <costPreferenceOption> - To validate MAPD flow with drug functions for MA plans in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to vpp summary page mobile
      | Zip Code | <Zipcode> |
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
      |   10003 | NO            | New York | MAPD          | None         | Travel       | sue         | YES           |
