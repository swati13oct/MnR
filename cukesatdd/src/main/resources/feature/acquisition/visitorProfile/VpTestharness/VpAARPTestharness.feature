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
      | 00001 | visitorprofile | Ulayer   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000 | AARP Medicare Advantage SecureHorizons Focus (HMO) |               1 |

  @vpTestharnessAARP03 @vpTestharnessAARPRun01 @AddPlansForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Save Plans to Authenticated Profile from VP Testharness page
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
      | 00001 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @vpTestharnessAARP04 @vpTestharnessAARPRun01 @DeletePlansForAuthenticated
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Save Plans to Authenticated Profile from VP Testharness page
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
      | 00001 | visitorprofile | Ulayer   | 200b4216-15a8-4b11-9879-30c13f270de6 | false   |         2 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543001000 | AARP Medicare Advantage SecureHorizons Focus (HMO) |               1 |
