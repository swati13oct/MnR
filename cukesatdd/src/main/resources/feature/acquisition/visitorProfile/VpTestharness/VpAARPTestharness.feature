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

  @vpTestharnessAARP05 @vpTestharnessAARPRun01 @AddDrugsAndPharamcyForGuest
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Drugs and Pharmacy from VP Testharness page
    Given the user is on VistorProfile TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    And user selects helper mode for Save plans in Guest profile to VP with plans data on AARP
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    Then user switch back to Vp Testharness Page on AARP site
    And user selects helper mode for Launch Visitor Profile with Drugs and Pharmacy in Visitor Profile on AARP site
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <drug> |

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | drug             |
      | 00005 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP |

  @vpTestharnessAARP06 @vpTestharnessAARPRun01 @AddDrugsAndPharamcyForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Launch Visitor Profile with Drugs and Pharmacy from VP Testharness page for Authenticated
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
    And user selects helper mode for Launch Visitor Profile with Drugs and Pharmacy in Visitor Profile on AARP site
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <drug> |

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | drug             |  |
      | 00006 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP |  |

  @vpTestharnessAARP07 @vpTestharnessAARPRun01 @AddProvidersForGuest
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
      | 00007 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vpTestharnessAARP08 @vpTestharnessAARPRun01 @AddProvidersForAuthenticated
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

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | drug             | planname                                            |
      | 00008 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | Lipichol 540 CAP | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vpTestharnessAARP09 @vpTestharnessAARPRun01 @PlanCompareForGuest
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
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | plancount | testPlans                                                                                              | planToCompare           |
      | 00009 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000,H0543168000 |

  @vpTestharnessAARP10 @vpTestharnessAARPRun01 @PlanCompareForAuthenticated
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
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | plancount | testPlans                                                                                              | planToCompare           |
      | 00010 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000,H0543168000 |

  @vpTestharnessAARP11 @vpTestharnessAARPRun01 @PlanDetailsForGuest
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
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | ContractNumber | PBPNumber | SegmentID | countycode | product | PlanYear | plancount | testPlans                                                                                              |
      | 00011 | visitorprofile | Ulayer   | H0543          |       001 |       000 |        037 | ma      |     2020 |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @vpTestharnessAARP12 @vpTestharnessAARPRun01 @PlanDetailsForGuest
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
    Then user verifies plan count on shopping cart Icon on AARP site
      | Plans Count | <plancount> |
    Then verify plans added in plan compare on visitor Profile for AARP

    Examples: 
      | TID   | THPage         | siteName | uuid                                 | isGuest | ContractNumber | PBPNumber | SegmentID | countycode | product | PlanYear | plancount | testPlans                                                                                              |
      | 00012 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   | H0543          |       001 |       000 |        037 | ma      |     2020 |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |
