@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with session cookies

  @PRE @DrugPREtoVPPtoDCE @F375045 @F583139
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs details from PRE to VPP Page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo> |
    Then user validate drugs details from VPP to DCE page
      | Drugs Name | <DrugsName> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | DrugInfo                                                                                                                                              | DrugsName                         |
      | AARP |   94203 | NO            | Sacramento | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:Actiq,NO,,,,Week,1,YES,NO         | Yes,No,No,Yes                 | Lower                | Assure (HMO),Actiq LOZ 200MCG,False:Assure (HMO),Lipitor TAB 20MG,False:Walgreens (PDP),Actiq LOZ 200MCG,False:Walgreens (PDP),Lipitor TAB 20MG,False | Lipitor TAB 20MG:Actiq LOZ 200MCG |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | DrugInfo                                                                                                                                              | DrugsName                         |
      | UHC  |   94203 | NO            | Sacramento | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:Actiq,NO,,,,Week,1,YES,NO         | Yes,No,No,Yes                 | Lower                | Assure (HMO),Actiq LOZ 200MCG,False:Assure (HMO),Lipitor TAB 20MG,False:Walgreens (PDP),Actiq LOZ 200MCG,False:Walgreens (PDP),Lipitor TAB 20MG,False | Lipitor TAB 20MG:Actiq LOZ 200MCG |

  @PRE @DrugDCEtoPRE @F358830 @DruglistSessionStorageDCEtoPRE
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate Drugs details are reflecting from VPP to DCE and PRE Page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    And user navigates to vpp summary page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to PRE page
    Then user clicks on GetStarted button in PRE page
    And verify continue function on "Location" page
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option and comparing DCE and Drug page
      | Drug Selection | <Drug Selection> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   10001 | NO            | Sacramento | PDP           | Yes            | Lipitor,YES,Lipitor TAB 10MG,,,Week,1,YES,NO                                 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   10001 | NO            | Sacramento | PDP           | Yes            | Lipitor,YES,Lipitor TAB 10MG,,,Week,1,YES,NO                                 |

  @PRE @providersessionVPPtoPRE @F358845 @F427538 @F458224
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - - To validate Providers session from VPP to PRE for MA plans
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    And user navigates to vpp summary page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user verifies "VPP" page
    Then user adds Doctors in vpp summary page
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user navigate to PRE from vpp page
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user navigate Doctors lookup session in Doctors page
    And user verifies doctors session in Doctors page
      | Multi Doctor | <isMultiDoctor> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | DoctorsName | isMultiDoctor |
      | AARP |   10003 | NO            | New York | MAPD          | None         | sue         | NO            |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | DoctorsName | isMultiDoctor |
      | UHC  |   10003 | NO            | New York | MAPD          | None         | sue         | NO            |

  @PRE @DruglistSessionStoragePREtoDCE @F537262
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> - To validate Drug list are same PRE vs DCE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    When user navigate to Drug Cost Estimator page
    Then user validate drugs details from VPP to DCE page
      | Drugs Name | <DrugsName> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | DrugsName                                     |
      | AARP |   35034 | Yes           | Bibb County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Lipitor TAB 20MG:morphine sulfate CAP 10MG ER |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | DrugsName                                     |
      | UHC  |   35034 | Yes           | Bibb County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Lipitor TAB 20MG:morphine sulfate CAP 10MG ER |

  @PRE @DruglistSessionStoragePREtoDCEWithoutContinue @F558359
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> - To validate Drug list are same PRE vs DCE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page without continue next page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    When user navigate to Drug Cost Estimator page
    And user validate druglist in Drug Cost Estimator page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                |
      | AARP |   35034 | Yes           | Bibb County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                |
      | UHC  |   35034 | Yes           | Bibb County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO |
