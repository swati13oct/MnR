@vppPlanCompareAARPNew @vpp @planCompare
Feature: 1.01.3-Vpp to plan Compare Scenarios

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify the checkbox for add to compare link is not visible for single plan on <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then verify plan compare checkbox is not visible on plan summary

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | current  |
      | 00002 | AARP |   10001 | NO            | New York         | SNP      | current  |
      | 00003 | AARP |   48101 | NO            | Wayne County     | MAPD     | current  |
      | 00004 | AARP |   70072 | NO            | Jefferson Parish | MAPD     | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | next     |
      | 00002 | AARP |   10001 | NO            | New York         | SNP      | next     |
      | 00003 | AARP |   48101 | NO            | Wayne County     | MAPD     | next     |
      | 00004 | AARP |   70072 | NO            | Jefferson Parish | MAPD     | next     |

    @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | current  |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | UHC  |   96799 | NO            | Western District | PDP      | current  |
      | 00002 | UHC  |   10001 | NO            | New York  County | SNP      | current  |
      | 00003 | UHC  |   48101 | NO            | Wayne County     | MAPD     | current  |
      | 00004 | UHC  |   70072 | NO            | Jefferson Parish | MAPD     | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | UHC  |   96799 | NO            | Western District | PDP      | next     |
      | 00002 | UHC  |   10001 | NO            | New York  County | SNP      | next     |
      | 00003 | UHC  |   48101 | NO            | Wayne County     | MAPD     | next     |
      | 00004 | UHC  |   70072 | NO            | Jefferson Parish | MAPD     | next     |

    @sanity
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00002 | UHC  |   10001 | NO            | New York  County | SNP      | current  |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Call sticky action menu on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    When verify Call SAM icon is visible or not on Plan Comapare Page
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare Page
    Then user verify the popup and content on Plan Comapare Page

    @VBFTEAMC @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | AARP |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @VBFTEAMC @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | AARP |   90210 | NO            | Los Angeles County | MAPD     | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | next     |

  Scenario Outline: TID: <TCID> - Plan Type: <plantype> - To verify links displayed in the global footer of <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    #When user accesses global footer of the AARP Medicare Plans home page
    And user clicks on About us link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contact us link of aboutus page
    And user clicks on sitemap link of contact us page
    And user clicks on privacy policy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms & conditions page
    And user clicks on agents & brokers link of disclaimers page

    #And user clicks on Request Assistance and validates modal window ulayer
    #And user verifies home link of agents & brokers page
    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | AARP |   90210 | No            | Los Angeles County | MAPD     | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | AARP |   90210 | No            | Los Angeles County | MAPD     | next     |

    @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | UHC  |   90210 | No            | Los Angeles County | MAPD     | current  |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | UHC  |   90210 | No            | Los Angeles County | MAPD     | next     |

  #1a
  Scenario Outline: TID: <TCID> - Plan Type: <plantype> -Navigation for plan comapre to Back to summary page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then the user clicks on back on all plan link in Plan Compare page

    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | AARP |   90210 | No            | Los Angeles County | MAPD     | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | AARP |   90210 | No            | Los Angeles County | MAPD     | next     |

    @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | UHC  |   90210 | No            | Los Angeles County | MAPD     | current  |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | UHC  |   90210 | No            | Los Angeles County | MAPD     | next     |

  #1b
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove one plan from new plan compare page
    And click on back to plans on plan compare page
    Then Verify the Plan compare checkbox should be unchecked for the removed plan

    @regressionAARP @sanity
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | AARP |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | AARP |   90210 | NO            | Los Angeles County | MAPD     | next     |

    @regressionUHC @prodRegression @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | current  |

    @regressionUHC @prodRegression @sanity @vbfGate @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | next     |

  #1c
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget on <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And check one plan and add it to plancompare
    Then Verify newly added plan displayed on new plan compare page

    @regressionAARP @prodRegression @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | AARP |   90210 | NO            | Los Angeles County | MAPD     |     2 | current  |

    @regressionAARP @prodRegression @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | AARP |   90210 | NO            | Los Angeles County | MAPD     |     2 | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     2 | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     2 | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and Edit provider from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
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
    Then verify Your doctors is loaded with all added doctor summary on Plan Compare page

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from plan compare and Edit provider from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
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
    Then verify Your doctors is loaded with all added doctor summary on Plan Compare page

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hospital from VPP and Edit hospital from plan compare page for <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
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

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

    @regressionUHC @prodRegression
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hosptial from plan compare and Edit Hosptial from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
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

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify if optional service section is hidden when a plan with only one optional service benefit on compare page on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove "<removePlanIndices>" plan from new plan compare page
    Then validate optional service riders section on compare page is not shown

    @vppPlanCompareAARP12 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | AARP |   55343 | NO            | Hennepin County | MAPD     |                 1 | current  |           5 |

    @vppPlanCompareAARP12 @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | AARP |   55343 | NO            | Hennepin County | MAPD     |                 1 | next     |           5 |

    @vppPlanCompareUHC12 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | UHC  |   55343 | NO            | Hennepin County | MAPD     |                 1 | current  |           5 |

    @vppPlanCompareUHC12 @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | UHC  |   55343 | NO            | Hennepin County | MAPD     |                 1 | next     |           5 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - validation of plan compare on click of view all plans on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove "<removePlanIndices>" plan from new plan compare page

    #Then validate all available plans are shown on click of view all plans
    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county            | plantype | removePlanIndices | planyear | planIndices |
      | 00016 | AARP |   55343 | NO            | Hennepin County   | MAPD     |             3,1,2 | current  |           5 |
      | 00016 | AARP |   33111 | NO            | Miami-Dade County | SNP      |               2,1 | current  |           4 |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county            | plantype | removePlanIndices | planyear | planIndices |
      | 00016 | AARP |   55343 | NO            | Hennepin County   | MAPD     |             3,1,2 | next     |           5 |
      | 00016 | AARP |   33111 | NO            | Miami-Dade County | SNP      |               2,1 | next     |           4 |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county            | plantype | removePlanIndices | planyear | planIndices |
      | 00016 | UHC  |   55343 | NO            | Hennepin County   | MAPD     |               2,1 | current  |           5 |
      | 00016 | UHC  |   55343 | NO            | Hennepin County   | PDP      |               2,1 | current  |           3 |
      | 00016 | UHC  |   33111 | NO            | Miami-Dade County | SNP      |               2,1 | current  |           4 |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county            | plantype | removePlanIndices | planyear | planIndices |
      | 00016 | UHC  |   55343 | NO            | Hennepin County   | MAPD     |               2,1 | next     |           5 |
      | 00016 | UHC  |   55343 | NO            | Hennepin County   | PDP      |               2,1 | next     |           3 |
      | 00016 | UHC  |   33111 | NO            | Miami-Dade County | SNP      |               2,1 | next     |           4 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - validation of plan compare on OON Toggle for Medical Benefits and Additional Benefits on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then validate OON Toggle is displayed on medical and additional benefits
    Then click on OON Toggle for additional benefits
    Then validate text under additional benefits
    When remove "<removePlanIndices>" plan from new plan compare page
    Then Validate OON Toggle is not displayed when there are no OON Plans Available

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | AARP |   78006 | YES           | Bexar County | MAPD     | current  |           4 |               4,3 |

    @regressionAARP @nextYear @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | AARP |   78006 | YES           | Bexar County | MAPD     | next     |           4 |               4,3 |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | UHC  |   78006 | YES           | Bexar County | MAPD     | current  |           4 |               4,3 |

    @regressionUHC @nextYear @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | UHC  |   78006 | YES           | Bexar County | MAPD     | next     |           4 |               4,3 |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to OLE on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare

    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | AARP |   90210 | No            | Los Angeles County | MAPD     | current  |           5 |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | AARP |   90210 | No            | Los Angeles County | MAPD     | next     |           5 |

    @regressionUHC @prodRegression
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | UHC  |   90210 | No            | Los Angeles County | MAPD     | current  |           5 |

    @regressionUHC @prodRegression @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | UHC  |   90210 | No            | Los Angeles County | MAPD     | next     |           5 |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to Plan Detail on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then the user clicks on Plan details link in new Plan Compare page

    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | AARP |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | AARP |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | next     |

    @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | UHC  |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | current  |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | UHC  |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | next     |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Validation for Selecting more than 4 plans for plan comapre from VPP on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on view more plans for right navigaton
    Then Click on view less plans for left navigaton

    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | AARP |   10010 | No            | New York County | MAPD     |           9 | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | AARP |   10010 | No            | New York County | MAPD     |           9 | next     |

    @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | UHC  |   10010 | No            | New York County | MAPD     |           9 | current  |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | UHC  |   10010 | No            | New York County | MAPD     |           9 | next     |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Validation for remove icon should be disabled when only one plan on plan compare on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove one plan from "<count>" new plan compare and verify remove icon is disabled page

    @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | AARP |   10010 | No            | New York County | MAPD     |     1 |           2 | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | AARP |   10010 | No            | New York County | MAPD     |     1 |           2 | next     |

    @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | UHC  |   10010 | No            | New York County | MAPD     |     1 |           2 | current  |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | UHC  |   10010 | No            | New York County | MAPD     |     1 |           2 | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Dental Flyer PDF are loading on plan compare page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Dental Flyer Link
      | PDF LINK     | <pdfLink> |
      | DocumentCode | <docCode> |

    @regressionAARP
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0022 | AARP |   78006 | YES           | Bexar County | MAPD     | current  |    1023 | 4805658 |

    @regressionAARP @nextYear
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0022 | AARP |   78006 | YES           | Bexar County | MAPD     | next     |    1023 | 4805658 |
      | 0023 | AARP |   78006 | YES           | Bexar County | MAPD     | next     |    1025 | 4875364 |

    @regressionUHC
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0024 | UHC  |   78006 | YES           | Bexar County | MAPD     | current  |    1023 | 4805658 |
      | 0025 | UHC  |   78006 | YES           | Bexar County | MAPD     | current  |    1025 | 4875364 |

    @regressionUHC @nextYear
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0024 | UHC  |   78006 | YES           | Bexar County | MAPD     | next     |    1023 | 4805658 |
      | 0025 | UHC  |   78006 | YES           | Bexar County | MAPD     | next     |    1025 | 4875364 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and view locations on plan compare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    Then validate view locations popup on compare page

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Change Zip Code on Plan Compare Screen using <Click on Enter> on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Verify Change Zip Code Link is displayed on compare Page
    When the user performs zip search using following information on Plan Compare Page
      | Zip Code        | <Changezipcode>       |
      | Is Multi County | <ChangeisMultiCounty> |
      | County Name     | <Changecounty>        |
      | Click on Enter  | <ClickEnter>          |

    @regressionUHC @test1
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode | ChangeisMultiCounty | Changecounty       | ClickEnter                |
      | 00027 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         78006 | YES                 | Bexar County       | Click on Find Plan button |
      | 00028 | UHC  |   78006 | Yes           | Bexar County       | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         90210 | NO                  | Los Angeles County | Click Enter               |

    @regressionUHC @test1 @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode | ChangeisMultiCounty | Changecounty       | ClickEnter                |
      | 00027 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         78006 | YES                 | Bexar County       | Click on Find Plan button |
      | 00028 | UHC  |   78006 | Yes           | Bexar County       | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         90210 | NO                  | Los Angeles County | Click Enter               |

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode | ChangeisMultiCounty | Changecounty       | ClickEnter                |
      | 00029 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         78006 | YES                 | Bexar County       | Click on Find Plan button |
      | 00030 | AARP |   78006 | Yes           | Bexar County       | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         90210 | NO                  | Los Angeles County | Click Enter               |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode | ChangeisMultiCounty | Changecounty       | ClickEnter                |
      | 00029 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         78006 | YES                 | Bexar County       | Click on Find Plan button |
      | 00030 | AARP |   78006 | Yes           | Bexar County       | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         90210 | NO                  | Los Angeles County | Click Enter               |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Invalid Zip Code on Plan Compare Screen on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Verify Change Zip Code Link is displayed on compare Page
    When the user searches for zip code using following information on Plan Compare Page
      | Zip Code | <Changezipcode> |
    Then Verify Invalid Zip Code Error message is displayed

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00031 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         00000 |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00031 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         00000 |

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00032 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         00000 |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00032 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         00000 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify  Searching plans with Zip Code containing zero plans on Plan Compare Screen on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Verify Change Zip Code Link is displayed on compare Page
    When the user searches for zip code using following information on Plan Compare Page
      | Zip Code | <Changezipcode> |
    Then Verify Zip Code with zero plans Error message is displayed

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00033 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         96799 |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00033 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         96799 |

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00034 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |         96799 |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear | Changezipcode |
      | 00034 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |         96799 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Dental behaviour Medical provider from VPP and view locations on plan compare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    When the user Click on Provider covered link
      | PlanName | <planname> |
    When user selects a Behaviour and returns to VPP page
    When the user Click on Provider covered link
      | PlanName | <planname> |
    When user selects a Dental and retuns to VPP page
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then verify icons loaded with doctor summary on Plan Compare page
    Then validate all providers are covered

    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00035 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |

    @regressionAARP @nextYear  @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00035 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00035 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |

    @regressionUHC @nextYear  @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00035 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | next     |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - validation of routine dental benefit link on plan compare on click of view all plans on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then click on Show All button on plan compare page
    Then Verify Dental Link text for third plan on plan Compare page

    #Then validate all available plans are shown on click of view all plans
    @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county         | plantype | planyear | planIndices |
      | 00036 | AARP |   78006 | Yes            | Bexar County   | MAPD     | current  |           2 |

    @regressionAARP @nextYear @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county         | plantype | planyear | planIndices |
      | 00036 | AARP |   78006 | Yes            | Bexar County   | MAPD     | next     |           2 |

    @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county         | plantype | planyear | planIndices |
      | 00037 | UHC  |   78006 | Yes            | Kendall County | MAPD     | current  |           2 |

    @regressionUHC @nextYear @UATSpartans
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county         | plantype | planyear | planIndices |
      | 00037 | UHC  |   78006 | Yes            | Kendall County | MAPD     | next     |           2 |
