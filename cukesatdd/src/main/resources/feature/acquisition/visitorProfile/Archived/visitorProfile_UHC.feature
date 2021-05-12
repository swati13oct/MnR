#Author: Naveen BK
#created Date:07/10/2019
#@Test @UHCvisitorprofile
Feature: 2.08. ACQ-Visitor profile - UMS

  #@UHCvisitorprofile @addDrugs @addDrugsBLayerSmoke @visitorProfileRegressionUHC @prodRegression @dce_Regression_Blayer_VisitorProfile
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile
    Given user is on blue layer landing page
    And the user clicks on the shopping cart icon in UHC site
    And the user clicks on the add drugs button in the guest profile in UHC site
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
      | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user verify the drug summary page on UHC
    And the user clicks on the shopping cart icon on DCE page on uhc
    Then the user should be able to see the Drug information in the profile page on UHC
      | Drugname | <drugName> |

    Examples: 
      | state   | drugName | zipCode |
      | Alabama | Lipitor  |   90210 |

  #@addDrugsDCE
  Scenario Outline: Verify user is able to add drug information from DCE to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the acquisition DCE tool from home page on ums site
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
      | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user verify the drug summary page on UHC
    And the user clicks on the shopping cart icon on DCE page on uhc
    Then the user should be able to see the Drug information in the profile page on UHC
      | Drugname | <drugName> |

    Examples: 
      | state   | drugName | zipCode |
      | Alabama | Lipitor  |   90210 |

  #@addPlans @addPlansBLayerSmoke @visitorProfileRegressionUHC @prodRegression
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    And the user selects the state drop down value in UHC home page
      | State | <state> |
    And the user clicks on the shopping cart icon in UHC site
    And the user validates the plan year buttons are present or not and chooses the plan year in UHC
      | Plan Year | <planYear> |
    And the user clicks on the add plans button in the guest profile in UHC site
    When the user enters zipcode on health plans page in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user saves two plans as favorite on UHC site
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              | plantype | planYear |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |     2020 |

  #@addPlansVPP
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user saves two plans as favorite on UHC site
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |

    # The steps for this scenario are being covered by the next sceanrio, hence, commenting this one out
    Examples: 
      | state | UID | zipcode | isMultiCounty | county | plantype | testPlans |

  #      | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
  #@addPlansPlanDetail @visitorProfileRegressionUHC @prodRegression
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user saves two plans as favorite on UHC site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |
    And user clicks on plan name of UHC site
      | Test Plans | <testPlans> |
    Then the user validates the following Additional Benefits of Plan for the plan in UMS
      | Eye Wear Benefit Type                                     | <eyeWearBenefitType>                              |
      | Eye Wear Expected Text                                    | <eyeWearExpectedText>                             |
      | Eye Exam Benefit Type                                     | <eyeExamBenefitType>                              |
      | Eye Exam Expected Text                                    | <eyeExamExpectedText>                             |
      | Foot Care Routine Benefit Type                            | <footCareRoutineBenefitType>                      |
      | Foot Care Routine Expected Text                           | <footCareRoutineExpectedText>                     |
      | Hearing Exam Benefit Type                                 | <hearingExamBenefitType>                          |
      | Hearing Exam Expected Text                                | <hearingExamExpectedText>                         |
      | Membership in Health Club / Fitness Classes Benefit Type  | <membershipinHealthClubFitnessClassesBenefitType> |
      | Membership in Health Club / Fitness Classes Expected Text | <membershipinHealthClubFitnessExpectedText>       |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | plantype | county           | testPlans                                                                                               | eyeWearBenefitType | eyeWearExpectedText                                           | eyeExamBenefitType | eyeExamExpectedText | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText | membershipinHealthClubFitnessClassesBenefitType | membershipinHealthClubFitnessExpectedText                                                                  |
      | Alabama | US1770330 |   53503 | NO            | MAPD     | Jefferson County | UnitedHealthcare Medicare Advantage Open (PPO),UnitedHealthcare Medicare Advantage Open Essential (PPO) | Eyewear            | Eyewear has a plan benefit limit up to $100 per every 2 years | Eye Exam           | $0 copay            | Foot Care - Routine        | $50 copay                   | Hearing Exam           | $0 copay                | Fitness Program through Renew Active            | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost |

  #@vppMSSavedPlan
  Scenario Outline: Verify user is save medsupp plans from VPP to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user will proceed to next pages
      | Zip Code | <zipcode> |
      | DOB      | <DOB>     |
    Then user saves two MS plans as favorite on UHC site
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added MS plans on visitor profile page of UHC site
      | MS Test Plans | <MS_testPlans> |
    And user validate pdf link on UHC Site
      | MS Test Plans | <MS_testPlans> |

    Examples: 
      | zipcode | isMultiCounty | plantype | DOB        | county           | MS_testPlans  |
      |   90210 | NO            | MS       | 11/11/1949 | Jefferson County | Plan G,Plan A |

  #@vpOLEUHC
  #Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile and complete OLE
  #Given the user is on the uhcmedicaresolutions site landing page
  #And the user clicks on the shopping cart icon in UHC site
  #And the user validates the plan year buttons are present or not and chooses the plan year in UHC
  #| Plan Year | <planYear> |
  #And the user clicks on the add plans button in the guest profile in UHC site
  #When the user enters zipcode on health plans page in UMS site
  #| Zip Code        | <zipcode>       |
  #| County Name     | <county>        |
  #| Is Multi County | <isMultiCounty> |
  #Then user validates plan count for all plan types on plan summary page in the UMS site
  #Then user saves two plans as favorite on UHC site
  #| Test Plans | <testPlans> |
  #| Plan Type  | <plantype>  |
  #Then user gets a create profile prompt on UHC site
  #Then user click on continue as guest button on UHC site
  #And user validates the added plans on visitor profile page of UHC site
  #| Test Plans | <testPlans> |
  #And the user navigates to clicks on Enroll Now from visitor profile to start the OLE flow
  #| Plan Name | <planName> |
  #| Plan Type | <plantype> |
  #    Then the user validates TFN in Welcome OLE Right Rail
  #Then the user validates Learn more modal for Welcome OLE
  #Then the user validates Leave OLE modal for Welcome OLE
  #Then the user validates cancellation modal for Welcome OLE
  #Then the user navigates to Personal Information Page
  #Then the user enters following required information in Personal Information Page
  #| First Name         | <firstname>         |
  #| Last Name          | <lastname>          |
  #| DOB                      | <dob>                    |
  #| Gender                   | <gender>                 |
  #| Perm_Street              | <permstreet>             |
  #| Perm_city                | <permcity>               |
  #| Mailing Address Question | <mailingaddressquestion> |
  #| Mailing_Street           | <mailingstreet>          |
  #| Mailing_City             | <mailingcity>            |
  #| Mailing_State            | <mailingstate>           |
  #| Mailing_Zip              | <mailingzip>             |
  #| Email                    | <email>                  |
  #| MedicaidNumber           | <medicaidnumber>         |
  #Then the user validates the Plan details in Personal Information Page OLE Right Rail
  #Then the user validates the Member details dynamic display in Personal Information Page
  #Then the user navigates to Medicare Information Page
  #Then the user validates Medicare Information Page required fields
  #Then the user enters following required Medicare Information
  #| Medicare Number    | <medicarenumber>    |
  #| SSN Flag           | <ssnflag>           |
  #| PartA Date         | <partadate>         |
  #| PartB Date         | <partbdate>         |
  #| Card Type          | <cardtype>          |
  #| Email Confirmation | <emailConfirmation> |
  #| Go Green           | <goGreen>           |
  #| Email              | <email>             |
  #    Then the user validates TFN in Medicare Info OLE Right Rail
  #Then the user validates the Plan details in Medicare Info OLE Right Rail
  #    Then the user navigates to Preliminary Questions Page
  #Then the user validates requierd ESRD on Medicare Info Page
  #| MedicaidNumber | <medicaidnumber> |
  #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
  #		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
  #Then the user answers following questions in Medicare Information Page
  #| PDP Question      | <pdpFlag>      |
  #| LongTerm Question | <longTermFlag> |
  #Then the user navigates to SEP Page
  #Then the user validates the Plan details in SEP Page OLE Right Rail
  #Then the user validates SEP options and Required Fields for PlanType in SEP Page
  #Then the user validates SEP options and Required Fields for PlanType in SEP Page
  #Then the user selects the following options for SEP Page
  #| Select Options | <selectoptions> |
  #| Option Data    | <optiondata>    |
  #    Then the user navigates to Coverage and Health Information Page
  #Then the user navigates to Proposed Effective Date Page
  #Then the user validates Proposed Effective Date is Displayed
  #Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
  #Then the user validates PCP page for MA and MAPD PFFS plans
  #Then the user validates Look up Provider for MA MAPD and DSNP plans.
  #Then the user navigates to Monthly Plan Premium Page
  #Then the user navigates to Optional Benefits Page for following plans with available Riders
  #| Rider Flag | <riderflag> |
  #Then the user navigates to Authorization Page for plan as per following rider options
  #| Rider Flag | <riderflag> |
  #Then the user validates required fields for Authorization Page
  #Then the user navigates to Review and Submit Page
  #Then the user validates the Plan and Member details on Review and Submit Page
  #Then the user clicks on Submit Enrollment to complete enrollment
  # Then the user validates Plan and Member Details on Confirmation Page
  #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
  #
  #Examples:
  #| UID       | zipcode | isMultiCounty | county          | testPlans                                                                                            | PlanType | plantype | planName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
  #| US1770330 |   10001 | NO            | New York County | AARP Medicare Advantage Essential (HMO),UnitedHealthcare Medicare Advantage Essential (Regional PPO) | MA-MBI   | MA       | AARP Medicare Advantage Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | NO                | NO      |
  #@providerFlowUHC @prodVP
  Scenario Outline: Verify Provider Search functional flow for unauthenticated Visitor Profile page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user saves two plans as favorite on UHC site
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |
    And the user back to VPP plan summary page in ums
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |
    Then Navigate to Visitor Profile page on UMS site
    Then Verify X out of Y provider covered information is displayed on visitor profile page of UHC site
      | PlanName | <planName> |
    And user delets the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |

    Examples: 
      | zipcode | isMultiCounty | county          | plantype | planName                             | testPlans                                                                 |
      |   10001 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  #@AddDrugsAuthenticated
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile
    Given user is on blue layer landing page
    And the user clicks on the shopping cart icon in UHC site
    Then the user signs in with optum Id credentials in UHC site
      | User Name | <userName> |
      | Password  | <password> |
    #And the user validates the plan year buttons are present or not and chooses the plan year in UHC
    #      | Plan Year | <planyear> |
    And the user clicks on the add drugs button in the guest profile in UHC site
    And the user clicks on the add drugs button in the guest profile in UHC site
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
      | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user verify the drug summary page on UHC
    And the user clicks on the shopping cart icon on DCE page on uhc
    Then the user should be able to see the Drug information in the profile page on UHC
      | Drugname | <drugName> |
    And user delets all the added drugs on visitor profile page of UHC site

    Examples: 
      | state   | userName | password   | drugName | zipCode |
      | Alabama | mnrqavd3 | Password@1 | Lipitor  |   90210 |

  #@providerFlowUHCAuthenticated
  Scenario Outline: Verify Provider Search functional flow for authenticated Visitor Profile page
    Given the user is on the uhcmedicaresolutions site landing page
    And the user clicks on the shopping cart icon in UHC site
    Then the user signs in with optum Id credentials in UHC site
      | User Name | <userName> |
      | Password  | <password> |
    And user delets all the added providers on visitor profile page of UHC site
    And the user back to VPP plan summary page in ums
    When the user Click on Show Plans link
      | PlanType | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |
    Then Navigate to Visitor Profile page on UMS site
    Then Verify X out of Y provider covered information is displayed on visitor profile page of UHC site
      | PlanName | <planName> |
    And user delets all the added providers on visitor profile page of UHC site

    Examples: 
      | zipcode | isMultutiCounty | county          | userName | password   | plantype | planName                             | testPlans                                                                 |
      |   10001 | NO              | New York County | mnrqavd3 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  #@planCompare @planCompareBLayerSmoke @visitorProfileRegressionUHC
  Scenario Outline: Verify user is able to Plan compare to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user saves all plans as favorite on UHC site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |
    And user selects four plans to compare from visitor Profile on UHC site
      | Test Plans | <testPlans> |
    Then verify the plans on plan compare page on UHC site
      | Test Plans | <testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                                                                                                                                                                                        |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Premier (HMO),UnitedHealthcare Medicare Advantage Assure (HMO) |