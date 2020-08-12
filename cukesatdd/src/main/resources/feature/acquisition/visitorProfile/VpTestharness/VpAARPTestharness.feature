@vpMicroAppAARP
Feature: VP Testharness flow Navigations for AARP Site

  @vpTestharnessAARP01 @vpTestharnessAARPRun01 @AddPlansForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Save Plans to Guest from VP Testharness page
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              |
      | 00001 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @vpTestharnessAARP02 @vpTestharnessAARPRun01 @DeletePlansForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Delete Plans to Guest from VP Testharness page
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user Enters Plan id and click on delete plan to Delete plan in Visitor Profile on AARP site
      | Plan ID | <planID> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <Deleteplancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <DeletePlans> |

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | planID      | DeletePlans                                        | Deleteplancount |
      | 00002 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000 | AARP Medicare Advantage SecureHorizons Focus (HMO) |               1 |

  @vpTestharnessAARP03 @vpTestharnessAARPRun01 @AddPlansForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Save Plans to Authenticated Profile from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              |
      | 00003 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @vpTestharnessAARP04 @vpTestharnessAARPRun01 @DeletePlansForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Save Plans to Authenticated Profile from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user Enters Plan id and click on delete plan to Delete plan in Visitor Profile on AARP site
      | Plan ID | <planID> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <Deleteplancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <DeletePlans> |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | planID      | DeletePlans                                        | Deleteplancount |
      | 00004 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000 | AARP Medicare Advantage SecureHorizons Focus (HMO) |               1 |

  @vpTestharnessAARP05 @vpTestharnessAARPRun01 @PlanCompareForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Plan Compare from Vistor from VP Testharness page for Guest
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects plan to compare from visitor Profile on AARP site
      | Plan compare | <planToCompare> |
      | Zip Code     | <zipcode>       |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | planToCompare           | zipcode |
      | 00005 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000,H0543168000 |   91020 |

  @vpTestharnessAARP06 @vpTestharnessAARPRun01 @PlanCompareForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Plan Compare from Vistor from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects plan to compare from visitor Profile on AARP site
      | Plan compare | <planToCompare> |
      | Zip Code     | <zipcode>       |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | planToCompare           | zipcode |
      | 00006 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000,H0543168000 |   91020 |

  @vpTestharnessAARP07 @vpTestharnessAARPRun01 @PlanDetailsForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Plan Details from Vistor from VP Testharness page for Guest
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user Enters plan info to land on plan details from visitor Profile on AARP site
      | Contract Number | <ContractNumber> |
      | PBP Number      | <PBPNumber>      |
      | Segment ID      | <SegmentID>      |
      | County code     | <countycode>     |
      | Product         | <product>        |
      | Plan Year       | <PlanYear>       |
      | Zip Code        | <zipcode>        |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | THPage         | siteName | ContractNumber | PBPNumber | SegmentID | countycode | product | PlanYear | plancount | testPlans                                                                                              | zipcode | monthlyPremium | yearlyPremium |
      | 00007 | visitorprofile | Ulayer   | H0543          |       001 |       000 |        037 | ma      |     2020 |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |   91020 | $0             | $0            |

  @vpTestharnessAARP08 @vpTestharnessAARPRun01 @PlanDetailsForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Plan Details from Vistor from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user Enters plan info to land on plan details from visitor Profile on AARP site
      | Contract Number | <ContractNumber> |
      | PBP Number      | <PBPNumber>      |
      | Segment ID      | <SegmentID>      |
      | County code     | <countycode>     |
      | Product         | <product>        |
      | Plan Year       | <PlanYear>       |
      | Zip Code        | <zipcode>        |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | ContractNumber | PBPNumber | SegmentID | countycode | product | PlanYear | plancount | testPlans                                                                                              | zipcode | monthlyPremium | yearlyPremium |
      | 00008 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   | H0543          |       001 |       000 |        037 | ma      |     2020 |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |   91020 | $0             | $0            |

  @vpTestharnessAARP09 @vpTestharnessAARPRun01 @AddDrugsAndPharamcyForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Drugs from VP Testharness page
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects helper mode for Launch Visitor Profile with Drugs in Visitor Profile on AARP site
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug> |

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | drug             |
      | 00009 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP |

  @vpTestharnessAARP10 @vpTestharnessAARPRun01 @AddDrugsAndPharamcyForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Drugs from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects helper mode for Launch Visitor Profile with Drugs in Visitor Profile on AARP site
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects Delete Drug and Pharamcy on the Authenticated profile on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | drug             |  |
      | 00010 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP |  |

  @vpTestharnessAARP11 @vpTestharnessAARPRun01 @AddProvidersForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Providers from VP Testharness page for Guest
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects helper mode for Launch Visitor Profile with Providers in Visitor Profile on AARP site
    Then Verify X out of Y provider covered information is displayed on visitor profile page of AARP site
      | PlanName | <planname> |

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | drug             | planname                                            |
      | 00011 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vpTestharnessAARP12 @vpTestharnessAARPRun01 @AddProvidersForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Providers from VP Testharness page for Authenticated
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP
      | UUID    | <uuid>    |
      | IsGuest | <isGuest> |
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects helper mode for Launch Visitor Profile with Providers in Visitor Profile on AARP site
    Then Verify X out of Y provider covered information is displayed on visitor profile page of AARP site
      | PlanName | <planname> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects Delete Provider on the Authenticated profile on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | drug             | planname                                            |
      | 00012 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vpTestharnessAARP13 @vpTestharnessAARPRun01 @OLEForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch OLE from Visitor Profile Guest from VP Testharness page
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Launch OLE for Guest profile on AARP
      | Plan Name    | <planName> |
      | Zip Code     | <zipcode>  |
      | County Name  | <county>   |
      | Plan Premium | <premium>  |
      | Plan Year    | <planYear> |
      | Plan Type    | <plantype> |
    Then the user validates the Plan details on OLE
    #Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    #Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
    Then the user validates the Plan details in SEP Page OLE Right Rail
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | isMultutiCounty | plantype | siteName | THPage         | siteId | pBPNumber | clientCode | segmentId | PlanTypeTH | TFN            | planName                                           | psc    | planYear | env     | zipcode | county             | FipsCode | StateCode | CMScode | HNumber | RiderFlag | PrefferedPlanId | PlanCode  | mapsPlanType | OLEisCNS | clientProdCode | lineOfBusiness | OLEisCSNP | fitness | vision | hearing | dental | salesagentid | premium | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 00013 | NO              | MAPD     | Ulayer   | visitorprofile | aarp   |       168 | AARP1      |       000 | MAPD       | 1-877-699-5710 | AARP Medicare Advantage SecureHorizons Focus (HMO) | 810027 |     2020 | nonProd |   91020 | Los Angeles County |      037 | CA        |     200 | H0543   | true      | H0543168000     | undefined | HMO          | false    | undefined      | undefined      | false     | true    | true   | true    | true   |              |    0.00 | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply    |            | yes     | no           | true      | NO                | NO      |
