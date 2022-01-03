#Author: Naveen BK
#created Date:2/12/2019
@visitorProfileUnAuthenticated @visitorProfile
Feature: 1.09. UAT - Visitor profile Un-Authenticated

  @addDrugs @addDrugsULayerSmoke @visitorProfileRegressionAARP @dce_Regression_Ulayer_VisitorProfile
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile in <site> site - zip -<zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    @visitorProfile_AARP @regressionAARP @VP_ProdRegression_AARP @prodRegression @sanity
    Examples: 
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor |   90210 | AARP |

    @visitorProfile_UHC @regressionUHC @VP_ProdRegression_UHC @vbfGate
    Examples: 
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor |   90210 | UHC  |

  @addDrugsDCE1
  Scenario Outline: Verify user is able to add drug from DCE to the unauthenticated visitor profile in <site> site - zip -<zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    When user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @prodRegression @regressionAARP
    Examples: 
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor |   90210 | AARP |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @regressionUHC @vbfGate @sanity
    Examples: 
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor |   90210 | UHC  |

  #commenting this out as it is already there in the UAT feature file for VP
  #@addPlans @addPlansULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile - zip -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add plans button in the profile
    When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    #@visitorProfile_AARP @regressionAARP @VP_ProdRegression_AARP
    Examples: 
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | AARP | Alabama | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    #@visitorProfile_UHC @regressionUHC  @VP_ProdRegression_UHC @prodRegression
    Examples: 
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | UHC  | Alabama | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @addPlansPlanDetail @visitorProfileRegressionAARP
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user clicks on plan name
      | Test Plans | <testPlans> |
    Then the user validates the following Additional Benefits of Plan for the plan
      | Eye Wear Benefit Type           | <eyeWearBenefitType>          |
      | Eye Wear Expected Text          | <eyeWearExpectedText>         |
      | Eye Exam Benefit Type           | <eyeExamBenefitType>          |
      | Eye Exam Expected Text          | <eyeExamExpectedText>         |
      | Foot Care Routine Benefit Type  | <footCareRoutineBenefitType>  |
      | Foot Care Routine Expected Text | <footCareRoutineExpectedText> |
      | Hearing Exam Benefit Type       | <hearingExamBenefitType>      |
      | Hearing Exam Expected Text      | <hearingExamExpectedText>     |

    @visitorProfile_AARP @regressionAARP @VP_ProdRegression_AARP @prodRegression @vbfGate @VP_ProdRegression_AARP @prodRegression_AARP_02 @prodRegression @regressionAARP
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | AARP | Alabama | US1770330 |   53503 | NO            | MAPD     | current  | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

    @nextYear @regressionAARP
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                  | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | AARP | Alabama | US1770330 |   53503 | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. Home delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only) | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

    @visitorProfile_UHC @regressionUHC @VP_ProdRegression_UHC
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Alabama | US1770330 |   53503 | NO            | MAPD     | current  | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

    @nextYear @regressionAARP
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                  | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Alabama | US1770330 |   53503 | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. Home delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only) | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

  @vpOLE
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile and complete OLE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planYear> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user navigates to clicks on Enroll Now from visitor profile to start OLE flow
      | Plan Name       | <planName>       |
      | Plan Type       | <plantype>       |
      | Zip Code        | <zipcode>        |
      | County Name     | <county>         |
      | Monthly Premium | <monthlyPremium> |
    Then the user validates the Plan details on OLE
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
      | Rider Flag | <riderflag> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Middle Name              | <middlename>             |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Perm_AptNo               | <permaptno>              |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_AptNo            | <mailingaptno>           |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | Email Confirmation       | <emailConfirmation>      |
      | Go Green                 | <goGreen>                |
      | Home Number              | <phoneno>                |
      | Mobile Number            | <mobileno>               |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | Card Type       | <cardtype>       |
    Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    Then the user navigates to Confirm your Eligibility Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the long term questions in Medicare Information Page
      | LongTerm Question     | <longTermFlag>        |
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | PDP Question      | <pdpFlag>                  |
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
      | RX BIN Number     | <rxBinnumber>              |
    Then the user navigates to SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Authorization Page
    Then the user validates required fields for Authorization Page Representative
      | authorizationFirstname      | <authorizefirstN>       |
      | authorizationLastname       | <authorizelastN>        |
      | authorizationAddress        | <authorizeaddress>      |
      | authorizationApartmentSuite | <authorizeapartment>    |
      | authorizationCity           | <authorizecity>         |
      | authorizationZip            | <authorizezip>          |
      | authorizationPhoneNo        | <authorizephonenumber>  |
      | authorizationRelationship   | <authorizeRelationship> |
      | authorizationStateDisplay   | <authorizestate>        |
    Then the user validates Statement of Understanding Page
      | soAAgree | <authorizationagree> |
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    @visitorProfile_AARP @VP_ProdRegression_AARP @regressionAARP
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                                                      | plantype | planName                                  | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
      | AARP | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),Medica HealthCare Plans MedicareMax (HMO) | MAPD     | Medica HealthCare Plans MedicareMax (HMO) | current  |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | K          |

    @nextYear @regressionAARP
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
      | AARP | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | future   |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | K          |

    @visitorProfile_UHC @VP_ProdRegression_UHC @regressionUHC
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                                                      | plantype | planName                                  | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag |  |
      | UHC  | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),Medica HealthCare Plans MedicareMax (HMO) | MAPD     | Medica HealthCare Plans MedicareMax (HMO) | current  |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |  |

    @nextYear @regressionAARP
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
      | UHC  | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | future   |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | K          |

  @vpMSSavePlan
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user fills out medsup form and proceeds to next pages
      | Zip Code | <zipcode> |
      | DOB      | <DOB>     |
    Then user saves two ms plans as favorite
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |

    #No pdf link is avialable now
    #And user validate pdf link
    #| MS Test Plans | <MS_testPlans> |
    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county          | MS_testPlans  |
      | AARP | Alabama |   10001 | NO            | MS       | future   | 11/11/1949 | New York County | Plan G,Plan A |
      | AARP | Virginia |  23666 | NO            | MS       | future   | 11/11/1949 | Hampton City | Plan G,Plan A |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county          | MS_testPlans  |
      | UHC  | Alabama |   10001 | NO            | MS       | future   | 11/11/1949 | New York County | Plan G,Plan A |
      | UHC  | Virginia|  23666  | NO            | MS       | future   | 11/11/1949 | Hampton City    | Plan G,Plan A |

  @providerFlow
  Scenario Outline: Verify Provider Search functional flow for unauthenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |

    @visitorProfile_AARP @VP_ProdRegression_AARP @regressionAARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |
      | AARP | New York |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

    @visitorProfile_UHC @VP_ProdRegression_UHC @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |
      | UHC  | New York |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  @planCompareTest @planCompareULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to Plan compare to the unauthenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves all plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user selects four plans to compare from visitor Profile
      | Test Plans | <testPlans> |
    Then verify the plans on plan compare page
      | Test Plans | <testPlans> |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_04 @prodRegression @regressionAARP
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | county           | plantype | planyear | testPlans                                                                                                                                                                                   |
      | AARP | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage Harmony (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_04 @regressionUHC @vbfGate
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | county           | plantype | planyear | testPlans                                                                                                                                                                                   |
      | UHC  | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage Harmony (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @importDrugsDocs @nonProd
  Scenario Outline: Verify user is able to import drugs and doctors for unauthenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    When the user Import Drugs and Doctors
      | FirstName | <firstName> |
      | LastName  | <lastName>  |
      | DOB       | <dob>       |
      | ZipCode   | <zipcode>   |
      | MBI       | <mbi>       |
      | Member    | <member>    |

    #Then the user validates the Drugs and Doctors
    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_05 @regressionAARP
    Examples: 
      | site | member    | firstName | lastName | dob        | zipcode | mbi         | Drugs                                                                              | Providers |
      | AARP | UHC       | JONETTE   | ESCUTIA  | 03/27/1936 |   06902 | 3PW3A88CU71 | amlodipine besylate TAB 5MG;Lipitor TAB 20MG;lisinopril TAB 10MG;Levoxyl TAB 88MCG |           |
      | AARP | NonMember | DFONNMDF  | DFONNMDL | 06/30/1948 |   10010 |             | ciprofloxacin hcl TAB 500MG                                                        |           |
      | AARP | Aetna     |           |          |            |         |             |                                                                                    |           |
      | AARP | Humana    |           |          |            |         |             |                                                                                    |           |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_05 @regressionUHC
    Examples: 
      | site | member    | firstName | lastName | dob        | zipcode | mbi         | Drugs                                                                              | Providers |
      | UHC  | UHC       | JONETTE   | ESCUTIA  | 03/27/1936 |   06902 | 3PW3A88CU71 | amlodipine besylate TAB 5MG;Lipitor TAB 20MG;lisinopril TAB 10MG;Levoxyl TAB 88MCG |           |
      | UHC  | NonMember | DFONNMDF  | DFONNMDL | 06/30/1948 |   10010 |             | ciprofloxacin hcl TAB 500MG                                                        |           |
      | UHC  | Aetna     |           |          |            |         |             |                                                                                    |           |
      | UHC  | Humana    |           |          |            |         |             |                                                                                    |           |

  @vppMSSP4.0
  Scenario Outline: Verify user save Medsupp plans 4.0 with plan details,start application, learn more,add your information on unauthenticated visitor profile-Medsup4.0 - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the med supp plans
      | Plan Type | <plantype> |
    Then user saves two msvpp4 plans as favorite
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |
    And user clicks on ms plan details button
      | MS Plan | <MS_Plan> |
    And user validates MS plan details
    And user clicks on Back to Profile link
    And user clicks on ms start application button
      | MS Plan | <MS_Plan> |
    And user validates MS Start application page
    And user close MS application page
    And user clicks on ms Learn More link
      | MS Plan | <MS_Plan> |
    And user validates MS Learn More page
    And user clicks on Back to Profile link
    And user clicks on MS Add your Information link
      | MS Plan | <MS_Plan> |
    And user validates MS Add your Information page
    And user close MS application page
    And user validates MS SP Profile page with Import, PRE and ComponentCode
      | Component Code | <component_code> |
    And user delets the added Ms plans on visitor profile page
      | MS_testPlans | <MS_testPlans> |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start
    Examples: 
      | site | zipcode | isMultiCounty | plantype | county            | MS_testPlans                                      | MS_Plan                  | component_code |
      | AARP |   07303 | NO            | MS       | Hudson County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   20906 | NO            | MS       | Montgomery County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   30002 | NO            | MS       | DeKalb County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   66113 | NO            | MS       | Wyandotte County  | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | AARP |   06011 | NO            | MS       | Hartford County   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   63113 | NO            | MS       | St. Louis City    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   19706 | NO            | MS       | New Castle County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   39206 | NO            | MS       | Hinds County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   70726 | NO            | MS       | Livingston Parish | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   40475 | NO            | MS       | Madison County    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP |   73008 | NO            | MS       | Oklahoma County   | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | AARP |   77070 | NO            | MS       | Harris County     | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples: 
      | site | zipcode | isMultiCounty | plantype | county            | MS_testPlans                                      | MS_Plan                  | component_code |
      | UHC  |   07303 | NO            | MS       | Hudson County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   20906 | NO            | MS       | Montgomery County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   30002 | NO            | MS       | DeKalb County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   66113 | NO            | MS       | Wyandotte County  | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | UHC  |   06011 | NO            | MS       | Hartford County   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   63113 | NO            | MS       | St. Louis City    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   19706 | NO            | MS       | New Castle County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   39206 | NO            | MS       | Hinds County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   70726 | NO            | MS       | Livingston Parish | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   40475 | NO            | MS       | Madison County    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  |   73008 | NO            | MS       | Oklahoma County   | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | UHC  |   77070 | NO            | MS       | Harris County     | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |
