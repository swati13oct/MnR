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

    @visitorProfile_AARP @regressionAARP @VP_ProdRegression_AARP @prodRegression @sanity @vbfGate
    Examples:
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor | 90210   | AARP |

    @visitorProfile_UHC @regressionUHC @VP_ProdRegression_UHC @featureGate
    Examples:
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor | 90210   | UHC  |

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

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @prodRegression @regressionAARP @featureGate @vbfGate
    Examples:
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor | 90210   | AARP |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @regressionUHC @sanity
    Examples:
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor | 90210   | UHC  |

  #commenting this out as it is already there in the UAT feature file for VP
  #@addPlans @addPlansULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile in <site> site- zip -<zipcode>
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
    @vbfGate
    Examples:
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | AARP | Alabama | US1770330 | future   | 90210   | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    #@visitorProfile_UHC @regressionUHC  @VP_ProdRegression_UHC @prodRegression
    Examples:
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | UHC  | Alabama | US1770330 | future   | 90210   | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @addPlansPlanDetail @visitorProfileRegressionAARP
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile in <site> site - zipcode - <zipcode>
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

    @visitorProfile_AARP @regressionAARP @VP_ProdRegression_AARP @prodRegression @VP_ProdRegression_AARP @prodRegression_AARP_02 @prodRegression @regressionAARP @featureGate
    Examples:
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                      | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | AARP | Alabama | US1770330 | 53503   | NO            | MAPD     | current  | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full.\n\nHome delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only). | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

#    @nextYear @regressionAARP
#    Examples:
#      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                  | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
#     | AARP | Alabama | US1770330 | 53503   | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. Home delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only) | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

    @visitorProfile_UHC @regressionUHC @VP_ProdRegression_UHC
    Examples:
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                      | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Alabama | US1770330 | 53503   | NO            | MAPD     | current  | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full.\n\nHome delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only). | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

#    @nextYear @regressionAARP
#    Examples:
#      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                                                                                                                                  | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
#      | UHC  | Alabama | US1770330 | 53503   | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay; up to $200 every year for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. Home delivered eyewear available nationwide only through UnitedHealthcare Vision (select products only) | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

  @vpOLE
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile and complete OLE in <site> site - zip -<zipcode>
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

    @visitorProfile_AARP @VP_ProdRegression_AARP @regressionAARP @featureGate
    Examples:
      | UID                                   | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
      | Visitor Profile - E2E Scenario 1 _AMP | AARP | Florida | 33143   | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | current  | 33143   | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   | 01012010  | 01012010  | 0123456789     | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           | 33143      | test@test.com | moved outside of the service area | 01012018   | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      | 655                | MINNEAPOLIS   | 55455        | 1235678901           | FRIEND                | MN             | Agree              | 566       | 677          | true     | K          |

  #  @nextYear @regressionAARP
  #  Examples:
  #    | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
  #    | AARP | Florida | 33143   | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | future   | 33143   | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   | 01012010  | 01012010  | 0123456789     | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           | 33143      | test@test.com | moved outside of the service area | 01012018   | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      | 655                | MINNEAPOLIS   | 55455        | 1235678901           | FRIEND                | MN             | Agree              | 566       | 677          | true     | K          |

    @visitorProfile_UHC @VP_ProdRegression_UHC @regressionUHC
    Examples:
      | UID                                   | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
      | Visitor Profile - E2E Scenario 1 _UHC | UHC  | Florida | 33143   | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | current  | 33143   | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   | 01012010  | 01012010  | 0123456789     | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           | 33143      | test@test.com | moved outside of the service area | 01012018   | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      | 655                | MINNEAPOLIS   | 55455        | 1235678901           | FRIEND                | MN             | Agree              | 566       | 677          | true     | K          |

#    @nextYear @regressionAARP
#    Examples:
#      | site | state   | zipcode | isMultiCounty | testPlans                                              | plantype | planName          | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | middlename |
#      | UHC  | Florida | 33143   | Yes           | AARP Medicare Advantage Choice (PPO),MedicareMax (HMO) | MAPD     | MedicareMax (HMO) | future   | 33143   | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   | 01012010  | 01012010  | 0123456789     | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           | 33143      | test@test.com | moved outside of the service area | 01012018   | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      | 655                | MINNEAPOLIS   | 55455        | 1235678901           | FRIEND                | MN             | Agree              | 566       | 677          | true     | K          |

  @vpMSSavePlan
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile in <site> site - zip -<zipcode>
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
    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @featureGate
    Examples:
      | site | state    | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  |
#      | AARP | North Dakota | 58102   | NO            | MS       | future   | 11/11/1949 | Cass County | Plan G,Plan A |
      | AARP | Virginia | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | state    | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  |
#      | UHC  | North Dakota | 58102   | NO            | MS       | future   | 11/11/1949 | Cass County | Plan G,Plan A |
      | UHC  | Virginia | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A |

  @providerFlow
  Scenario Outline: Verify Provider Search functional flow for unauthenticated Visitor Profile page in <site> site - zip -<zipcode>
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
      | AARP | New York | 10001   | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

    @visitorProfile_UHC @VP_ProdRegression_UHC @regressionUHC @featureGate
    Examples:
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |
      | UHC  | New York | 10001   | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  @planCompareTest @planCompareULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline:<UID> : Verify user is able to Plan compare to the unauthenticated visitor profile in <site> site - zip -<zipcode> for <plantype> plantype
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

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_04 @prodRegression @regressionAARP @vbfGate
    Examples:
      | UID                                   | site | state   | UID       | zipcode | isMultiCounty | county             | plantype | planyear | testPlans                                                                                                                                                                                   |
      | Visitor Profile - E2E Scenario 3 _AMP | AARP | Alabama | US1770330 | 90210   | NO            | Jefferson County   | MAPD     | next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage Harmony (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | Visitor Profile - E2E Scenario 3 _AMP | AARP | Alabama | US1770330 | 90210   | NO            | Los Angeles County | PDP      | next     | AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP)                                                                                                                             |
      | Visitor Profile - E2E Scenario 3 _AMP | AARP | Florida | US1770330 | 33433   | NO            | Palm Beach County  | SNP      | next     | Preferred Medicare Assist Palm Beach (HMO D-SNP),UnitedHealthcare Dual Complete Choice (PPO D-SNP)                                                                                          |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_04 @regressionUHC @featureGate
    Examples:
      | UID                                   | site | state   | UID       | zipcode | isMultiCounty | county             | plantype | planyear | testPlans                                                                                                                                                                                   |
      | Visitor Profile - E2E Scenario 3 _UHC | UHC  | Alabama | US1770330 | 90210   | NO            | Jefferson County   | MAPD     | next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage Harmony (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | Visitor Profile - E2E Scenario 3 _UHC | UHC  | Alabama | US1770330 | 90210   | NO            | Los Angeles County | PDP      | next     | AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP)                                                                                                                             |
      | Visitor Profile - E2E Scenario 3 _UHC | UHC  | Florida | US1770330 | 33433   | NO            | Palm Beach County  | SNP      | next     | Preferred Medicare Assist Palm Beach (HMO D-SNP),UnitedHealthcare Dual Complete Choice (PPO D-SNP)                                                                                          |

  @importDrugsDocs @nonProd
  Scenario Outline: Verify user is able to import drugs and doctors for unauthenticated visitor profile in <site> site - member -<member>
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
    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_05 @regressionAARP @importDrugsFunctionality
    Examples:
      | site | member    | firstName | lastName | dob        | zipcode | mbi         | Drugs                                                                              | Providers |
      | AARP | UHC       | JONETTE   | ESCUTIA  | 03/27/1936 | 06902   | 3PW3A88CU71 | amlodipine besylate TAB 5MG;Lipitor TAB 20MG;lisinopril TAB 10MG;Levoxyl TAB 88MCG |           |
      | AARP | NonMember | DFONNMDF  | DFONNMDL | 06/30/1948 | 10010   |             | ciprofloxacin hcl TAB 500MG                                                        |           |
      | AARP | Aetna     |           |          |            |         |             |                                                                                    |           |
      | AARP | Humana    |           |          |            |         |             |                                                                                    |           |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_05 @regressionUHC @featureGate
    Examples:
      | site | member    | firstName | lastName | dob        | zipcode | mbi         | Drugs                                                                              | Providers |
      | UHC  | UHC       | JONETTE   | ESCUTIA  | 03/27/1936 | 06902   | 3PW3A88CU71 | amlodipine besylate TAB 5MG;Lipitor TAB 20MG;lisinopril TAB 10MG;Levoxyl TAB 88MCG |           |
      | UHC  | NonMember | DFONNMDF  | DFONNMDL | 06/30/1948 | 10010   |             | ciprofloxacin hcl TAB 500MG                                                        |           |
      | UHC  | Aetna     |           |          |            |         |             |                                                                                    |           |
      | UHC  | Humana    |           |          |            |         |             |                                                                                    |           |

  @vppMSSP4.0
  Scenario Outline: Verify user save Medsupp plans 4.0 with plan details,start application, learn more,add your information on unauthenticated visitor profile-Medsup4.0 in <site> site- zipcode - <zipcode>
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

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start  @featureGate
    Examples:
      | site | zipcode | isMultiCounty | plantype | county            | MS_testPlans                                      | MS_Plan                  | component_code |
      | AARP | 07303   | NO            | MS       | Hudson County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 20906   | NO            | MS       | Montgomery County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 30002   | NO            | MS       | DeKalb County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 66113   | NO            | MS       | Wyandotte County  | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | AARP | 06011   | NO            | MS       | Hartford County   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 63113   | NO            | MS       | St. Louis City    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 19706   | NO            | MS       | New Castle County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 39206   | NO            | MS       | Hinds County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 70726   | NO            | MS       | Livingston Parish | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 40475   | NO            | MS       | Madison County    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 73008   | NO            | MS       | Oklahoma County   | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | AARP | 77070   | NO            | MS       | Harris County     | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county            | MS_testPlans                                      | MS_Plan                  | component_code |
      | UHC  | 07303   | NO            | MS       | Hudson County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 20906   | NO            | MS       | Montgomery County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 30002   | NO            | MS       | DeKalb County     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 66113   | NO            | MS       | Wyandotte County  | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | UHC  | 06011   | NO            | MS       | Hartford County   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 63113   | NO            | MS       | St. Louis City    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 19706   | NO            | MS       | New Castle County | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 39206   | NO            | MS       | Hinds County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 70726   | NO            | MS       | Livingston Parish | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 40475   | NO            | MS       | Madison County    | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 73008   | NO            | MS       | Oklahoma County   | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | UHC  | 77070   | NO            | MS       | Harris County     | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |


    @vpMS4Start_Feb
    Examples:
      | site | zipcode | isMultiCounty | plantype | county          | MS_testPlans  | MS_Plan | component_code |
      | AARP | 10001   | NO            | MS       | New York County | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 10001   | NO            | MS       | New York County | Plan G,Plan A | Plan G  | WB27375ST      |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start @featureGate
    Examples:
      | site | zipcode | isMultiCounty | plantype | county                 | MS_testPlans  | MS_Plan | component_code |
      | AARP | 10001   | NO            | MS       | New York County        | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 05401   | NO            | MS       | Chittenden County      | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 71613   | NO            | MS       | Jefferson County       | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 96701   | NO            | MS       | Honolulu County        | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 02860   | NO            | MS       | Providence County      | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 99501   | NO            | MS       | Anchorage Municipality | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 57103   | NO            | MS       | Minnehaha County       | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 00982   | NO            | MS       | Carolina Municipio     | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 00840   | NO            | MS       | St. Croix Island       | Plan G,Plan A | Plan G  | WB27375ST      |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county                 | MS_testPlans  | MS_Plan | component_code |
      | UHC  | 10001   | NO            | MS       | New York County        | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 05401   | NO            | MS       | Chittenden County      | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 71613   | NO            | MS       | Jefferson County       | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 96701   | NO            | MS       | Honolulu County        | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 02860   | NO            | MS       | Providence County      | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 99501   | NO            | MS       | Anchorage Municipality | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 57103   | NO            | MS       | Minnehaha County       | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 00982   | NO            | MS       | Carolina Municipio     | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 00840   | NO            | MS       | St. Croix Island       | Plan G,Plan A | Plan G  | WB27375ST      |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start @featureGate
    Examples:
      | site | zipcode | isMultiCounty | plantype | county           | MS_testPlans                           | MS_Plan    | component_code |
      | AARP | 96910   | NO            | MS       | Guam             | Plan G,Plan A                          | Plan G     | WB27375ST      |
      | AARP | 55343   | NO            | MS       | Hennepin County  | Basic Plan,Extended Basic 2020 Plan    | Basic Plan | WB27375S1      |
      | AARP | 01003   | NO            | MS       | Hampshire County | Core Plan,Supplement 1A Plan           | Core Plan  | WB27375ST      |
      | AARP | 53006   | Yes           | MS       | Dodge County     | Basic Plan,Basic Plan with Co-Payments | Basic Plan | WB27375S1      |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county           | MS_testPlans                           | MS_Plan    | component_code |
      | UHC  | 96910   | NO            | MS       | Guam             | Plan G,Plan A                          | Plan G     | WB27375ST      |
      | UHC  | 55343   | NO            | MS       | Hennepin County  | Basic Plan,Extended Basic 2020 Plan    | Basic Plan | WB27375S1      |
      | UHC  | 01003   | NO            | MS       | Hampshire County | Core Plan,Supplement 1A Plan           | Core Plan  | WB27375ST      |
      | UHC  | 53006   | Yes           | MS       | Dodge County     | Basic Plan,Basic Plan with Co-Payments | Basic Plan | WB27375S1      |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start
    Examples:
      | site | zipcode | isMultiCounty | plantype | county      | MS_testPlans  | MS_Plan | component_code |
      | AARP | 58102   | NO            | MS       | Cass County | Plan G,Plan A | Plan G  | WB27375ST      |
    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county      | MS_testPlans  | MS_Plan | component_code |
      | UHC  | 58102   | NO            | MS       | Cass County | Plan G,Plan A | Plan G  | WB27375ST      |


  Scenario Outline: User verify LTC pharmacy scenario in <site> site- zipcode - <zipcode>
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
    Then user saves all plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    And user clicks on change pharmacy link from summary page
    Then the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page
      | PharmacyFilterText | <SelectPharmacy> |
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    Then the user should be able to see the changed pharmacy
      | pharmacyName | <SelectPharmacy> |
    Then the user validate the show drug coverage message on visitor profile
      | pharmacyName | <SelectPharmacy> |
    Then user validate no average cost is visible
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user click on Change Pharmacy link on Visitor Profile Page
    Then the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page
      | PharmacyFilterText | <SelectPharmacy1> |
    Then the user select pharmacy and return to visitor profile
      | SelectPharmacy | <SelectPharmacy1> |
    Then the user should be able to see the changed pharmacy
      | pharmacyName | <SelectPharmacy1> |

    @LTCPharmacyVPAARP
    Examples:
      | site | state | planyear | zipcode | isMultiCounty | county       | plantype | testPlans                            | drug1   | SelectPharmacy    | SelectPharmacy1 | tfnXpath                                      | tfnFlag |
      | AARP | Miama | future   | 45373   | NO            | Miami County | MAPD     | AARP Medicare Advantage Plan 6 (HMO) | Lipitor | REMEDI SENIORCARE | CVS PHARMACY    | (//a[contains(@class,'toll-free-number')])[1] | true    |

    @LTCPharmacyVPUHC
    Examples:
      | site | state | planyear | zipcode | isMultiCounty | county       | plantype | testPlans                            | drug1   | SelectPharmacy    | SelectPharmacy1 | tfnXpath                                      | tfnFlag |
      | UHC  | Miama | future   | 45373   | NO            | Miami County | MAPD     | AARP Medicare Advantage Plan 6 (HMO) | Lipitor | REMEDI SENIORCARE | CVS PHARMACY    | (//a[contains(@class,'toll-free-number')])[1] | true    |


  Scenario Outline: User verify LTC pharmacy scenario in <site> site for no drug coverage message- zipcode - <zipcode>
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
    Then user saves all plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    And user clicks on change pharmacy link from summary page
    Then the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page
      | PharmacyFilterText | <SelectPharmacy> |
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    Then the user should be able to see the changed pharmacy
      | pharmacyName | <SelectPharmacy> |
    Then the user validate the show no drug coverage message on visitor profile
      | pharmacyName | <SelectPharmacy> |
    Then user validate no average cost is visible
    Then user clicks on drug pricing link for the below plan
      | PlanName | <testPlans> |
    Then the user validate the show no drug coverage message on visitor profile drug pricing modal
      | pharmacyName | <SelectPharmacy> |
    Then the user click on Change Pharmacy link on Visitor Profile Page Drug Pricing Modal
    Then the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page
      | PharmacyFilterText | <SelectPharmacy1> |
    Then the user select pharmacy and return to visitor profile
      | SelectPharmacy | <SelectPharmacy1> |
    Then the user should be able to see the changed pharmacy
      | pharmacyName | <SelectPharmacy1> |

    @LTCPharmacyVPAARP
    Examples:
      | site | state | planyear | zipcode | isMultiCounty | county       | plantype | testPlans                       | drug1   | SelectPharmacy   | SelectPharmacy1 | tfnXpath                                      | tfnFlag |
      | AARP | Miama | future   | 45373   | NO            | Miami County | PDP      | AARP MedicareRx Walgreens (PDP) | Lipitor | WALMART PHARMACY | CVS PHARMACY    | (//a[contains(@class,'toll-free-number')])[1] | true    |
    @LTCPharmacyVPUHC
    Examples:
      | site | state | planyear | zipcode | isMultiCounty | county       | plantype | testPlans                       | drug1   | SelectPharmacy   | SelectPharmacy1 | tfnXpath                                      | tfnFlag |
      | UHC  | Miama | future   | 45373   | NO            | Miami County | PDP      | AARP MedicareRx Walgreens (PDP) | Lipitor | WALMART PHARMACY | CVS PHARMACY    | (//a[contains(@class,'toll-free-number')])[1] | true    |


  Scenario Outline: User validate PRE flow from Visitor Profile on <site> site for zipcode -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user click on Get Started to land on Plan Recommendation Page
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user save plan on PRE and then go to profile page
      | PlanName | <testPlans> |
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |

    @SavePlanPRE_AARP
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans                                                                       |
      | AARP | 10001   | NO            | New York | None          | Medicaid     | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,Yes                 | Lower                | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Mosaic Choice (PPO) |

    @SavePlanPRE_UHC
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans                                                                       |
      | UHC  | 10001   | NO            | New York | None          | Medicaid     | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,Yes                 | Lower                | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Mosaic Choice (PPO) |


  Scenario Outline: User validate PRE flow for MS from Visitor Profile on <site> site for zipcode -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user click on Get Started to land on Plan Recommendation Page
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user save plan on PRE and then go to profile page
      | PlanName | <testPlans> |
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <testPlans> |

    @SavePlanPRE_AARP
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans     | 1stRecommendation | 2ndRecommendation | UserType      | userName  | password    |
      | AARP | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Plan F,Plan G | SNP               | MA                | Authenticated | DDProfile | Test@123456 |

    @SavePlanPRE_UHC
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans     | 1stRecommendation | 2ndRecommendation | UserType      | userName  | password    |
      | UHC  | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Plan F,Plan G | SNP               | MA                | Authenticated | DDProfile | Test@123456 |


  Scenario Outline: User validate PRE flow for and validate create Account link from Visitor Profile on <site> site for zipcode -<zipcode> for plan <testPlan>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user click on Get Started to land on Plan Recommendation Page
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    #And verify continue function on "Priorities" page
    #Then user validate elements in loading results page
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user click on save results option and click on create account link and validate the correct login page

    @SavePlanPRE_AARP
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities | testPlan                             | userName              | password     | Premium |
      | AARP | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Lower                | [blank]        | [blank]    | AARP Medicare Advantage Choice (PPO) | vdatdd_18@getnada.com | Password@123 | $0      |

    @SavePlanPRE_UHC
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities | testPlan                             | userName              | password     | Premium |
      | UHC  | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Lower                | [blank]        | [blank]    | AARP Medicare Advantage Choice (PPO) | vdatdd_18@getnada.com | Password@123 | $0      |
