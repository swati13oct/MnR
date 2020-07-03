@vppPlanCompareAARPNew
Feature: 2.01.3-Vpp to plan Compare AARP Scenarios

  @vppPlanCompareAARP01 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify the checkbox for add to compare link is not visible for single plan.
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then verify plan compare checkbox is not visible on plan summary on AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county           | plantype |
      | 00001 |   96799 | NO            | Western District | PDP      |
      | 00002 |   78006 | YES           | Bexar County     | SNP      |
      | 00003 |   90265 | YES           | Ventura County   | MAPD     |
      | 00004 |   70072 | NO            | Jefferson Parish | MAPD     |

  @vppPlanCompareAARP02 @vppPlanCompareAARPRun02 @vppPlanCompareAARPRegression
  Scenario Outline: UID: <UID> - Plan Type: <plantype> - Verify Call sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    When verify Call SAM icon is visible or not on Plan Comapare
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare
    Then user verify the popup and content on Plan Comapare

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype |
      | 00005 |   90210 | NO            | Los Angeles County | MAPD     |

  @vppPlanCompareAARP03 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare for AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county         | plantype |
      | 00006 |   35616 | NO            | Colbert County | MAPD     |

  @vppPlanCompareAARP04 @vppPlanCompareAARPRun02 @vppPlanCompareAARPRegression
  Scenario Outline: <TCID> - Plan Type: <plantype> - To verify links displayed in the global footer of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    #When user accesses global footer of the AARP Medicare Plans home page
    And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
    And user clicks on contactus link of aboutus page
    And user clicks on sitemap link of contactus page
    And user clicks on privacypolicy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms&conditions page
    And user clicks on agents&brokers link of disclaimers page
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents&brokers page ulayer

    Examples: 
      | TCID  | zipcode | isMultiCounty | county             | plantype |
      | 00007 |   90210 | No            | Los Angeles County | MAPD     |

  @vppPlanCompareAARP05 @vppPlanCompareAARPRun02 @vppPlanCompareAARPRegression
  Scenario Outline: <TCID> - Plan Type: <plantype> -Navigation for plan comapre to Back to summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then the user clicks on back on all plan linnk in Plan Compare page

    Examples: 
      | TCID  | zipcode | isMultiCounty | county             | plantype |
      | 00008 |   90210 | No            | Los Angeles County | MAPD     |

  @vppPlanCompareAARP06 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then remove one plan from new plan compare page for AARP
    And click on back to plans on plan compare page for AARP
    Then Verify the Plan compare checkbox should be unchecked for the removed plan for AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype |
      | 00009 |   90210 | NO            | Los Angeles County | MAPD     |

  @vppPlanCompareAARP07 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget.
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page for AARP
    And check one plan and add it to plancompare for AARP
    Then Verify newly added plan displayed on new plan compare page for AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | count |
      | 00010 |   90210 | NO            | Los Angeles County | MAPD     |     1 |

  @vppPlanCompareAARP08 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and Edit provider from plan compare page for AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Your doctors is loaded with doctor summary on Plan Compare page AARP
    And click on Edit your doctors link and Navigate to Rally page for AARP
    When user selects a provider from medical group and retuns to plan compare page in AARP
    Then verify Your doctors is loaded with doctor summary on Plan Compare page AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | planname                                            |
      | 00011 |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanCompareAARP09 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from plan compare and Edit provider from plan compare page for AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Add doctors is loaded with doctor summary on Plan Compare page AARP
    And click on Add your doctors link and Navigate to Rally page for AARP
    And I click on Get Started on and Add PrimaryCare PCP from find care page in AARP
    Then verify Your doctors is loaded with doctor summary on Plan Compare page AARP
    And click on Edit your doctors link and Navigate to Rally page for AARP
    When user selects a provider from medical group and retuns to plan compare page in AARP
    Then verify Your doctors is loaded with doctor summary on Plan Compare page AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | planname                                            |
      | 00012 |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanCompareAARP10 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hospital from VPP and Edit hospital from plan compare page for AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a Hospitals and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page AARP
    And click on Edit your Hospitals link and Navigate to Rally page for AARP
    When user selects a Hospitals from Clinical and retuns to plan compare page in AARP
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county          | plantype | planname                             |
      | 00013 |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |

  @vppPlanCompareAARP11 @vppPlanCompareAARPRun01 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hosptial from plan compare and Edit Hosptial from plan compare page for AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Add Hospitals is loaded without summary on Plan Compare page AARP
    And click on Add your Hospitals link and Navigate to Rally page for AARP
    And I click on Get Started on and Add Places from Hospitals find care page in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page AARP
    And click on Edit your Hospitals link and Navigate to Rally page for AARP
    When user selects a Hospitals from Clinical and retuns to plan compare page in AARP
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county          | plantype | planname                             |
      | 00014 |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |
