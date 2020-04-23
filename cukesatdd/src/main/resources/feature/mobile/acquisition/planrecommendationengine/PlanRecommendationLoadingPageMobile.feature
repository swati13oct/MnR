@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engine flow - Verify Loading screen page functionalities in PRE using mobile

  @PRE @planrecommandonationmobile @loadingpagemobile @loadingpageelementsmobile @F384284
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Loading page functions in PRE Mobile
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
    Then user validate elements in loading page mobile

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10003 | NO            | New York    | MAPD          | None         | Travel       | want to use      |             |               | skip          | Yes,No,No,Yes                 | Higher               |
      |   35034 | YES           | Bibb County | NA            | None         | Travel       | want to use      |             |               | skip          | Yes,No,No,Yes                 | Higher               |
