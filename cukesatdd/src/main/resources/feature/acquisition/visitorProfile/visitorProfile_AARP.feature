#Author: Danthoori shiva
#created Date:2/12/2019
@Test @VisitorProfile
Feature: 1.08. ACQ- Visitor profile

  @addDrugs @addDrugsULayerSmoke @visitorProfileRegressionAARP @DCE_Regression_Ulayer_VisitorProfile
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile - zip - <zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    @VisitorProfile_AARP @regressionAARP @prodRegression_AARP_03  @prod_regression
    Examples: 
      | state        | drug1   | zipCode | site |
      | Alabama      | Lipitor |   90210 | AARP |
      

     @VisitorProfile_AARP @regressionAARP
    Examples: 
      | state   | drug1   | zipCode | site |
      | Pennsylvania | Lipitor |   15001 | AARP |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | state        | drug1   | zipCode | site |
      | Alabama      | Lipitor |   90210 | UHC  |
      | Pennsylvania | Lipitor |   15001 | UHC  |

  @addDrugsDCE1
  Scenario Outline: Verify user is able to add drug from DCE to the unauthenticated visitor profile - zip -<zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | state    | drug1   | zipCode | site |
      | Alabama  | Lipitor |   90210 | AARP |
      | Virginia | Lipitor |   22320 | AARP |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | state    | drug1   | zipCode | site |
      | Alabama  | Lipitor |   90210 | UHC  |
      | Virginia | Lipitor |   22320 | UHC  |

  @addPlans @addPlansULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile - zip -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

     @VisitorProfile_AARP @regressionAARP
    Examples: 
      | site | state    | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | AARP | Alabama  | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @VisitorProfile_AARP @regressionAARP @prod_regression
    Examples: 
      | site | state    | UID       | planyear | zipcode | isMultiCounty | county          | plantype | testPlans                                                                 |
      | AARP | Virginia | US1770330 | future   |   22320 | NO            | Alexandria city | MAPD     | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS) |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state    | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | UHC  | Alabama  | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | UHC  | Virginia | US1770330 | future   |   22320 | NO            | Alexandria city  | MAPD     | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS)                              |


  @addPlansVPP
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    Then user saves two plans as favorite on AARP site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    # The steps for this scenario are being covered by the next sceanrio, hence, commenting this one out
    Examples: 
      | state | UID | zipcode | isMultiCounty | county | plantype | testPlans |

  #      | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
  @addPlansPlanDetail @visitorProfileRegressionAARP
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state    | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | AARP | Alabama  | US1770330 |   53503 | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |
      | AARP | Virginia | US1770330 |   22320 | NO            | MAPD     | future   | Alexandria city  | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS)           | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $35 copay                   | Hearing Exam           | $0 copay                |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state    | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Alabama  | US1770330 |   53503 | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |
      | UHC  | Virginia | US1770330 |   22320 | NO            | MAPD     | future   | Alexandria city  | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS)           | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $35 copay                   | Hearing Exam           | $0 copay                |

    @prod_regression
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | plantype | planyear | county           | testPlans                                                                           | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Alabama | US1770330 |   53503 | NO            | MAPD     | future   | Jefferson County | AARP Medicare Advantage Open Plan 2 (PPO),AARP Medicare Advantage Open Plan 1 (PPO) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

  @vpOLE
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile and complete OLE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    When the user performs plan search using following information
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
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #Then the user validates requierd ESRD on Medicare Info Page
    #  | MedicaidNumber | <medicaidnumber> |
    # | Plan Year      | <planyear>       |
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
    Then the user navigates to SEP Page
      | Input Data | <inputdataType> |
      | PartA Date | <partadate>     |
      | PartB Date | <partbdate>     |
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | UID       | site | state    | zipcode | isMultiCounty | county       | planyear | testPlans                                                                                | plantype | planName                                  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType |
      | US1770330 | AARP | New York |   66843 | Yes           | Chase County | future   | UnitedHealthcare MedicareDirect Rx (PFFS),UnitedHealthcare MedicareDirect Patriot (PFFS) | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  09011997 |  11012002 | 3A33C22YK22    | true     | 01011941 | Female | 003 Morris Rd | Los Angeles | Yes                    | [blank]       | [blank]     | KS           |      66843 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | UID       | site | state    | zipcode | isMultiCounty | county          | planyear | testPlans                                                                                | plantype | planName                            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType |
      | US1770330 | UHC  | New York |   10001 | NO            | New York County | Next     | UnitedHealthcare MedicareDirect Rx (PFFS),UnitedHealthcare MedicareDirect Patriot (PFFS) | MAPD     | AARP Medicare Advantage Prime (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  09011997 |  11012002 | 3A33C22YK22    | true     | 01011941 | Female | 003 Morris Rd | Los Angeles | Yes                    | [blank]       | [blank]     | KS           |      66843 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         |

  @vpMSSavePlan
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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
    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state       | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  |
      | AARP | Alabama     |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A |
      | AARP | Puerto Rico |   00641 | NO            | MS       | future   | 11/11/1949 | Utuado Municipio | Plan G,Plan A |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state       | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  |
      | UHC  | Alabama     |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A |
      | UHC  | Puerto Rico |   00641 | NO            | MS       | future   | 11/11/1949 | Utuado Municipio | Plan G,Plan A |

  @vpMSSavePlanAuthenticated
  Scenario Outline: Verify user saves Medsupp plans from VPP to the authenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |
    And user delets the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |

    #No pdf link is avialable now
    #And user validate pdf link
    #| MS Test Plans | <MS_testPlans> |
    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  | userName   | password   |
      | AARP | Alabama |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A | mnrmedsupp | Password@1 |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  | userName   | password   |
      | UHC  | Alabama |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A | mnrmedsupp | Password@1 |

  @providerFlow
  Scenario Outline: Verify Provider Search functional flow for unauthenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP @prodRegression_AARP_03 @prod_regression @regressionAARP 
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |
      | AARP | New York |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

    @VisitorProfile_UHC @prodRegression_UHC_03  @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |
      | UHC  | New York |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  @addDrugAuthenticated
  Scenario Outline: Verify user is able to add drug information to the authenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user clicks on the add drugs button in the profile
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    And user clicks on Edit Drug and Pharmacy on visitor profile page
    Then the user clicks on Remove button on Drug List page on DCE to delete drug
      | DrugName | <drug1> |

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state   | userName | password   | drug1   | zipCode |
      | AARP | Alabama | mnrqavd4 | Password@2 | Lipitor |   90210 |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state   | userName | password   | drug1   | zipCode |
      | UHC  | Alabama | mnrqavd4 | Password@2 | Lipitor |   90210 |

  @providerFlowAuthenticated
  Scenario Outline: Verify Provider Search functional flow for authenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
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
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             |
      | AARP | New York |   10001 | NO              | New York County | mnrqavd4 | Password@2 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             |
      | UHC  | New York |   10001 | NO              | New York County | mnrqavd4 | Password@2 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

  @planCompare @planCompareULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to Plan compare to the unauthenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | county           | plantype | planyear | testPlans                                                                                                                                                                                                 |
      | AARP | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | Next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state   | UID       | zipcode | isMultiCounty | county           | plantype | planyear | testPlans                                                                                                                                                                                                 |
      | UHC  | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | Next     | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @oleAuthenticatedValidations
  Scenario Outline: Verify OLE validations for authenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then validate OLE details
      | Plan Name       | <planname>       |
      | Zip Code        | <zipcode>        |
      | Status          | <status>         |
      | Monthly Premium | <monthlyPremium> |

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             | status      | monthlyPremium |
      | AARP | New York |   10001 | NO              | New York County | mnrqavd4 | Password@2 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34.00         |

    @VisitorProfile_UHC  @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             | status      | monthlyPremium |
      | UHC  | New York |   10001 | NO              | New York County | mnrqavd4 | Password@2 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34.00         |

  @vpPartialOLEAndRemove
  Scenario Outline: <UID> - Verify Partial enrollment and cancel or remove the enrollment from profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user cancel the enrollment
      | Plan Name | <planName> |
    And the user navigates to clicks on Enroll Now from visitor profile to start OLE flow
      | Plan Name       | <planName>       |
      | Plan Type       | <plantype>       |
      | Zip Code        | <zipcode>        |
      | County Name     | <county>         |
      | Monthly Premium | <monthlyPremium> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    Then the user clicks on save and return later to profile page
    And validate OLE details
      | Plan Name       | <planName>       |
      | Zip Code        | <zipcode>        |
      | Status          | <status>         |
      | Monthly Premium | <monthlyPremium> |
    And the user cancel the enrollment
      | Plan Name | <planName> |

    @VisitorProfile_AARP @regressionAARP 
    Examples: 
      | UID       | site | state    | userName | password   | zipcode | isMultiCounty | county          | planyear | PlanType | plantype | planName                              | cardtype | firstname | lastname | dob      | gender | permstreet    | permcity | mailingstate | mailingzip | email         | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | status      | monthlyPremium |
      | US1770330 | AARP | New York | mnrvd5   | Password@1 |   10001 | NO            | New York County | Next     | MA-MBI   | MA       | AARP Medicare Advantage Patriot (HMO) | MBI      | John      | Doe      | 01011903 | Male   | 003 Morris Rd | NY       | NY           |      10001 | test@test.com | 2n22C33YK33    | false   |  09011997 |  11012002 |      431665465 | In Progress | $0             |
