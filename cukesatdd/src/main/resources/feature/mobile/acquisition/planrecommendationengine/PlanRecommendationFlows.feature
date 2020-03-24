@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engine flow - Verify Loading screen page functionalities in PRE using mobile

 @PRE @planrecommandonationmobile @PDPmobile @PDPskipdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Loading page functions in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page mobile
      | Drug Selection | <DrugSelection> |
    Then user validate elements in loading page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | 
      |   10003 | NO            | New York | PDP           | skip          | 

  @PRE @planrecommandonationmobile @PDPmobile @PDPnodrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Loading page functions in PRE Mobile
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
    Then user validate elements in loading page mobile

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | DrugSelection |
      |   35034 | YES           | Bibb County | PDP           | add           |

  @PRE @planrecommandonationmobile @PDPmobile @PDPdrugmobile @F358830
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Loading page functions in PRE Mobile
    Given the user is on UHC medicare acquisition site mobile
    And user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page mobile
      | Drug Selection | <DrugSelection>                                                        |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    Then user validate elements in loading page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection |
      |   10003 | NO            | New York | PDP           | add           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            |
