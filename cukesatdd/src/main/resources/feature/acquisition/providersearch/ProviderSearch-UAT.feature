@UATRegression @providerSearch
Feature: 1.07.2 UAT-Provider Search Flows

  @sanity
  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from Home Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user click on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider from home page and save it

    @ProviderSearchCommon_AARP @prodRegression @ProviderSearchFromHomePageUlayer @ProviderSearchFromHomePageNextYrUlayerSmoke
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year     |
      | Provider Search - E2E Scenario 1_AMP |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

    @ProviderSearchCommon_UHC @ProviderSearchFromHomePageBlayer @ProviderSearchFromHomePageNextYrBlayerSmoke
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year     |
      | Provider Search - E2E Scenario 1_UHC |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from Plan Details page for <plantype> plantype
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button on Plan Details Page
    When user selects a provider and retuns to VPP plan details page
    Then Verify X out of Y provider covered information is displayed on Plan Details page

    @ProviderSearchCommon_AARP @ProviderSearchFromVppPlanDetailsPageUlayer @regressionAARP 
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                                   | planyear |
      | Provider Search - E2E Scenario 2_AMP |   10001 | AARP | NO              | New York County | MA       | AARP Medicare Advantage Prime (HMO)        | current  |
      | Provider Search - E2E Scenario 2_AMP |   10001 | AARP | NO              | New York County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |

    @sanity @prodRegression
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                            | planyear |
      | Provider Search - E2E Scenario 2_AMP |   10001 | AARP | NO              | New York County | MA       | AARP Medicare Advantage Prime (HMO) | current  |

    @ProviderSearchCommon_UHC @ProviderSearchFromVppPlanDetailsPageBlayer @regressionUHC
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                                   | planyear |
      | Provider Search - E2E Scenario 2_UHC |   10001 | UHC  | NO              | New York County | MA       | AARP Medicare Advantage Prime (HMO)        | current  |
      | Provider Search - E2E Scenario 2_UHC |   10001 | UHC  | NO              | New York County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |

    @prodRegression @sanity
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                                   | planyear |
      | Provider Search - E2E Scenario 2_UHC |   10001 | UHC  | NO              | New York County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |

  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from Global Header
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user clicks on Provider Search on the global header for site
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider from home page and save it

    @ProviderSearchCommon_AARP @ProviderSearchFromGlobalHeaderUlayer @sanity
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year |
      | Provider Search - E2E Scenario 4_AMP |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | next |

    @ProviderSearchCommon_UHC @prodRegression @ProviderSearchFromGlobalHeaderBlayer @sanity
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year |
      | Provider Search - E2E Scenario 4_UHC |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | next |

  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from plan summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    #Then Verify X out of Y provider covered information is displayed on Plan Summary page
    #| PlanName | <planname> |
    #Then Verify provider name is displayed on Plan Summary page
    #| PlanName | <planname> |
    # Need to add steps for change zip code and same steps above
    Then user changes zipcode within VPP page
      | Zip Code        | <NewZipCode>      |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    #And the user views the plans of the below plan type
    #| Plan Type | <plantype> |
    #And the user selects plan year
    #| Plan Year | <planyear> |
    When user removes provider from plan card
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Verify provider name is displayed on Plan Summary page
      | PlanName | <planname> |

    @ProviderSearchCommon_AARP @prodRegression @ProviderSearchFromVppPlanSummaryPageUlayer @Dummy1 @regressionAARP
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear | NewZipCode |
      | Provider Search - E2E Scenario 5_AMP |   10001 | AARP | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |      10010 |

    @ProviderSearchCommon_UHC @ProviderSearchFromVppPlanSummaryPageBlayer @regressionUHC
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear | NewZipCode |
      | Provider Search - E2E Scenario 5_UHC |   10001 | UHC  | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |      10010 |

  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from AARP Acquisition site VPP Plan Summary
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #New Changes
    When the user Click on Is my Provider covered links
      | PlanName | <planName> |
    When user selects a multiple providers and retuns to VPP page
    Then User store the information provided from rally to vpp page
      | PlanName | <planName> |
    And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the User Validates Marketing Bullets for Welcome OLE
      | PlanName | <planName> |
    Then the user validates TFN in Welcome OLE Right Rail
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
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      # | PartA Date         | <partadate>         |
      # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #Then the user navigates to Preliminary Questions Page
    #Then the user validates Medicare Number and not required ESRD question on Medicare Info Page
    Then the user validates Medicaid Number in confirm Eligibility Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    #Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
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
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in SEP Page OLE Right Rail
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the User validates RadioButtons option in SEP Page
    #Then the user selects the following options for SEP Page
    # | Select Options | <selectoptions> |
    # | Option Data    | <optiondata>    |
    #Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    #Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user validates PCP page for MA and MAPD PFFS plans
    Then the User navigates to PCP Page and validates PCP Providers listed in the AARP VPP displayed
      | PlanName  | <planName> |
      | Plan Type | <plantype> |
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user select providers from the PCP page and continue to OLE Flow
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment

    #Then the user validates Plan and Member Details on Confirmation Page
    #   Then the user Validates Next Steps in Confirmation Page for the Plan Type.
    #Then the user validates the OLE Submission Details in GPS
    # | Plan Type | <plantype> |
    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | Scenario                                     | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate |
      | Provider Search - E2E Scenario 5_AMP_OLE_PCP | AARP | MA-MBI   | future   | future   |   10001 | NO              | New York County | MA       | future   | AARP Medicare Advantage Patriot (HMO) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET31    | false   |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | Scenario                                     | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType |
      | Provider Search - E2E Scenario 5_UHC_OLE_PCP | UHC  | MA-MBI   | future   | future   |   10001 | NO              | New York County | MA       | future   | AARP Medicare Advantage Patriot (HMO) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET31    | false   |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         |
