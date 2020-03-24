@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engine flow - Verify Additional Services page functionalities in PRE using mobile

  @PRE @planrecommandonationmobile @additionalservicespagemobile @additionalserviceselementsmobile @F374227
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Additional Services page elements in PRE Mobile
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
    Then user validate elements in additional services page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection |
      |   10001 | NO            | New York | NA            | None         | Travel       | want to use      |             |               | skip          |

  @PRE @planrecommandonationmobile @additionalservicespagemobile @additionalservicespageselectionmobile @F374227
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Additional Services page functions in PRE Mobile
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
    And user selects Pharmacy in Pharmacy page mobile
      | Pharmacy Selection | <PharmacySelection> |
    Then user selects additional services option in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | Dental-Hearing-Vision-Fitness |
      |   10003 | NO            | New York | NA            | None         | Travel       | want to use      |             |               | skip          | Yes,No,No,Yes                 |

  @PRE @planrecommandonationmobile @additionalservicespagemobile @additionalserviceserrormobile @F374227
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DrugOption: <DrugSelection> -PharmacySelection: <PharmacySelection> - To validate Additional Services error page functions in PRE Mobile
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
    Then user validates additional services error function in additional services page mobile
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor | DrugSelection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | PharmacySelection | Dental-Hearing-Vision-Fitness |
      |   10001 | NO            | New York | MAPD          | None         | Travel       | want to use      |             |               | add           | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO                               | Retail            | Yes,No,No,Yes                 |
