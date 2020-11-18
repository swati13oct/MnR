@vppPlanCompareAARPNew
Feature: 1.01.3-Vpp to plan Compare AARP Scenarios

  #@vppPlanCompareAARP01 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify the checkbox for add to compare link is not visible for single plan on <site> site.
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
    Then verify plan compare checkbox is not visible on plan summary

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | current  |
      | 00002 | AARP |   78006 | YES           | Bexar County     | SNP      | current  |
      | 00003 | AARP |   90265 | YES           | Ventura County   | MAPD     | current  |
      | 00004 | AARP |   70072 | NO            | Jefferson Parish | MAPD     | current  |

    @VppPlanCompareCommon_UHC01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | UHC  |   96799 | NO            | Western District | PDP      | current  |
      | 00002 | UHC  |   78006 | YES           | Bexar County     | SNP      | current  |
      | 00003 | UHC  |   90265 | YES           | Ventura County   | MAPD     | current  |
      | 00004 | UHC  |   70072 | NO            | Jefferson Parish | MAPD     | current  |

  #@vppPlanCompareAARP02 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Call sticky action menu on <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    When verify Call SAM icon is visible or not on Plan Comapare Page
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare Page
    Then user verify the popup and content on Plan Comapare Page

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | AARP |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @VppPlanCompareCommon_UHC01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | current  |

  @vppPlanCompareAARP04 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TCID> - Plan Type: <plantype> - To verify links displayed in the global footer of <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    #When user accesses global footer of the AARP Medicare Plans home page
    And user clicks on About us link from footer of the Medicare Plans home page
    And user clicks on contact us link of aboutus page
    And user clicks on sitemap link of contact us page
    And user clicks on privacy policy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms & conditions page
    And user clicks on agents & brokers link of disclaimers page
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents & brokers page

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | AARP |   90210 | No            | Los Angeles County | MAPD     | current  |

    @VppPlanCompareCommon_UHC01
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | UHC  |   90210 | No            | Los Angeles County | MAPD     | current  |

  #    @vppPlanCompareAARP05 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TCID> - Plan Type: <plantype> -Navigation for plan comapre to Back to summary page on <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    Then the user clicks on back on all plan link in Plan Compare page

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | AARP |   90210 | No            | Los Angeles County | MAPD     | current  |

    @VppPlanCompareCommon_UHC01
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | UHC  |   90210 | No            | Los Angeles County | MAPD     | current  |

  #      @vppPlanCompareAARP06 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page on <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove one plan from new plan compare page
    And click on back to plans on plan compare page
    Then Verify the Plan compare checkbox should be unchecked for the removed plan

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | AARP |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @VppPlanCompareCommon_UHC01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | current  |

  # @vppPlanCompareAARP07 @vppPlanCompareAARPRun01New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget on <site> site.
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
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And check one plan and add it to plancompare
    Then Verify newly added plan displayed on new plan compare page

    @VppPlanCompareCommon_AARP01
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | AARP |   90210 | NO            | Los Angeles County | MAPD     |     1 | current  |

    @VppPlanCompareCommon_UHC011
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     1 | current  |

  # @vppPlanCompareAARP08 @vppPlanCompareAARPRun02New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and Edit provider from plan compare page for <site> site
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
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    And click on Edit your doctors link and Navigate to Rally page
    When user selects a provider from medical group and retuns to plan compare page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page

    @VppPlanCompareCommon_AARP02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @VppPlanCompareCommon_UHC02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

  #@vppPlanCompareAARP09 @vppPlanCompareAARPRun02New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from plan compare and Edit provider from plan compare page for <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify Add doctors is loaded with doctor summary on Plan Compare page
    And click on Add your doctors link and Navigate to Rally page
    And I click on Get Started on and Add PrimaryCare PCP from find care page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    And click on Edit your doctors link and Navigate to Rally page
    When user selects a provider from medical group and retuns to plan compare page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page

    @VppPlanCompareCommon_AARP02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @VppPlanCompareCommon_UHC02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

  # @vppPlanCompareAARP10 @vppPlanCompareAARPRun02New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hospital from VPP and Edit hospital from plan compare page for <site> site.
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
    When user selects a Hospitals and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    And click on Edit your Hospitals link and Navigate to Rally page
    When user selects a Hospitals from Clinical and retuns to plan compare page
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page

    @VppPlanCompareCommon_AARP02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

    @VppPlanCompareCommon_UHC02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

  #    @vppPlanCompareAARP11 @vppPlanCompareAARPRun02New @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hosptial from plan compare and Edit Hosptial from plan compare page for <site> site
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
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify Add Hospitals is loaded without summary on Plan Compare page
    And click on Add your Hospitals link and Navigate to Rally page
    And I click on Get Started on and Add Places from Hospitals find care page
    Then verify plan compare page is loaded
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    And click on Edit your Hospitals link and Navigate to Rally page
    When user selects a Hospitals from Clinical and retuns to plan compare page
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page

    @VppPlanCompareCommon_AARP02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

    @VppPlanCompareCommon_UHC02
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |