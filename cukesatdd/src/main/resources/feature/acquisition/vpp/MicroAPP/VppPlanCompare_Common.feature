@vppPlanCompareAARPNew @vpp @planCompare
Feature: 1.01.3-Vpp to plan Compare Scenarios

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify the checkbox for add to compare link is not visible for single plan on <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then verify plan compare checkbox is not visible on plan summary

    @vppPlanCompareCommon_AARP01 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | future   |
      | 00002 | AARP |   10001 | NO            | New York         | SNP      | future   |
      | 00003 | AARP |   48101 | NO            | Wayne County     | MAPD     | future   |
      | 00004 | AARP |   70072 | NO            | Jefferson Parish | MAPD     | future   |

		@sanity @vbfGate
		Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | AARP |   96799 | NO            | Western District | PDP      | future   |
      
    @vppPlanCompareCommon_UHC01 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00001 | UHC  |   96799 | NO            | Western District | PDP      | future   |
      | 00002 | UHC  |   10001 | NO            | New York  County | SNP      | future   |
      | 00003 | UHC  |   48101 | NO            | Wayne County     | MAPD     | future   |
      | 00004 | UHC  |   70072 | NO            | Jefferson Parish | MAPD     | future   |
      
    @sanity
		Examples: 
      | TID   | site | zipcode | isMultiCounty | county           | plantype | planyear |
      | 00002 | UHC  |   10001 | NO            | New York  County | SNP      | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Call sticky action menu on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    When verify Call SAM icon is visible or not on Plan Comapare Page
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare Page
    Then user verify the popup and content on Plan Comapare Page

    @vppPlanCompareCommon_AARP01 @VBFTEAMC @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | AARP |   90210 | NO            | Los Angeles County | MAPD     | future   |

    @vppPlanCompareCommon_UHC01 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00005 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | future   |

  Scenario Outline: TID: <TCID> - Plan Type: <plantype> - To verify links displayed in the global footer of <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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
    #And user verifies home link of agents & brokers page

    @vppPlanCompareCommon_AARP01 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | AARP |   90210 | No            | Los Angeles County | MAPD     | future   |

    @vppPlanCompareCommon_UHC01 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00007 | UHC  |   90210 | No            | Los Angeles County | MAPD     | future   |
	#1a
  Scenario Outline: TID: <TCID> - Plan Type: <plantype> -Navigation for plan comapre to Back to summary page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then the user clicks on back on all plan link in Plan Compare page

    @vppPlanCompareCommon_AARP01 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | AARP |   90210 | No            | Los Angeles County | MAPD     | future   |

    @vppPlanCompareCommon_UHC01 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00008 | UHC  |   90210 | No            | Los Angeles County | MAPD     | future   |
	#1b
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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

    @vppPlanCompareCommon_AARP01 @regressionAARP @sanity
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | AARP |   90210 | NO            | Los Angeles County | MAPD     | future   |

    @vppPlanCompareCommon_UHC01 @regressionUHC @prodRegression @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planyear |
      | 00009 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | future   |
	#1c
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget on <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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

    @vppPlanCompareCommon_AARP01 @regressionAARP @prodRegression @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | AARP |   90210 | NO            | Los Angeles County | MAPD     |     2 | future   |

    @vppPlanCompareCommon_UHC01 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     2 | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and Edit provider from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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
    Then verify Your doctors is loaded with all added doctor summary on Plan Compare page

    @vppPlanCompareCommon_AARP02 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

    @vppPlanCompareCommon_UHC02 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00011 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from plan compare and Edit provider from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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
    Then verify Your doctors is loaded with all added doctor summary on Plan Compare page

    @vppPlanCompareCommon_AARP02 @regressionAARP 
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

    @vppPlanCompareCommon_UHC02 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00012 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hospital from VPP and Edit hospital from plan compare page for <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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

    @vppPlanCompareCommon_AARP02 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | future   |

    @vppPlanCompareCommon_UHC02 @regressionUHC @prodRegression
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00013 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hosptial from plan compare and Edit Hosptial from plan compare page for <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
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

    @vppPlanCompareCommon_AARP02 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | AARP |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | future   |

    @vppPlanCompareCommon_UHC02 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | planname                             | planyear |
      | 00014 | UHC  |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify if optional service section is hidden when a plan with only one optional service benefit on compare page on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove "<removePlanIndices>" plan from new plan compare page
    Then validate optional service riders section on compare page is not shown

    @vppPlanCompareCommon_AARP02 @vppPlanCompareAARP12 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | AARP |   55343 | NO            | Hennepin County | MAPD     |                 1 | future   |           5 |

    @vppPlanCompareCommon_UHC02 @vppPlanCompareUHC12 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          | plantype | removePlanIndices | planyear | planIndices |
      | 00015 | UHC  |   55343 | NO            | Hennepin County | MAPD     |                 1 | future   |           5 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - validation of plan compare on click of view all plans on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove "<removePlanIndices>" plan from new plan compare page
    #Then validate all available plans are shown on click of view all plans

    @vppPlanCompareCommon_AARP02 @vppPlanCompareAARP13 @regressionAARP @prodRegression @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          		| plantype | removePlanIndices | planyear | planIndices |
      | 00016 | AARP |   55343 | NO            | Hennepin County 		| MAPD     |             3,1,2 | future   |           5 |
      | 00016 | AARP |   33111 | NO            | Miami-Dade County 	| SNP    	 |             2,1   | future   |           4 |

    @vppPlanCompareCommon_UHC02 @vppPlanCompareUHC13 @regressionUHC @sanity
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county          		| plantype | removePlanIndices | planyear | planIndices |
      | 00016 | UHC  |   55343 | NO            | Hennepin County 		| MAPD     |               2,1 | future   |           5 |
      | 00016 | UHC  |   55343 | NO            | Hennepin County 		| PDP      |               2,1 | future   |           3 |
      | 00016 | UHC  |   33111 | NO            | Miami-Dade County 	| SNP	     |             	 2,1 | future   |           4 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - validation of plan compare on OON Toggle for Medical Benefits and Additional Benefits on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then validate OON Toggle is displayed on medical and additional benefits
    When remove "<removePlanIndices>" plan from new plan compare page
    Then Validate OON Toggle is not displayed when there are no OON Plans Available

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | AARP |   78006 | YES           | Bexar County | MAPD     | future   |           4 |               3,1 |

    @vppPlanCompareCommon_UHC03 @regressionUHC @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county       | plantype | planyear | planIndices | removePlanIndices |
      | 00017 | UHC  |   78006 | YES           | Bexar County | MAPD     | future   |           4 |               1,3 |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to OLE on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | AARP |   90210 | No            | Los Angeles County | MAPD     | future   |           5 |

    @vppPlanCompareCommon_UHC03 @regressionUHC @prodRegression
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planyear | planIndices |
      | 00018 | UHC  |   90210 | No            | Los Angeles County | MAPD     | future   |           5 |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to Plan Detail on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then the user clicks on Plan details link in new Plan Compare page

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | AARP |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | future   |

    @vppPlanCompareCommon_UHC03 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                                       | planIndices | planyear |
      | 00019 | UHC  |   90210 | No            | Los Angeles County | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |           4 | future   |

  Scenario Outline: <TCID> - Plan Type: <plantype> - Validation for Selecting more than 4 plans for plan comapre from VPP on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on view more plans for right navigaton
    Then Click on view less plans for left navigaton

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | AARP |   10010 | No            | New York County | MAPD     |           9 | future   |

    @vppPlanCompareCommon_UHC03 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | planIndices | planyear |
      | 00020 | UHC  |   10010 | No            | New York County | MAPD     |           9 | future   |

  @vppPlanCompareAARP16 @vppPlanCompareAARPRun02 @vppPlanCompareAARPRegression
  Scenario Outline: <TCID> - Plan Type: <plantype> - Validation for remove icon should be disabled when only one plan on plan compare on <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I select "<plantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove one plan from "<count>" new plan compare and verify remove icon is disabled page

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | AARP |   10010 | No            | New York County | MAPD     |     1 |           2 | future   |

    @vppPlanCompareCommon_UHC03 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county          | plantype | count | planIndices | planyear |
      | 00021 | UHC  |   10010 | No            | New York County | MAPD     |     1 |           2 | future   |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Dental Flyer PDF are loading on plan compare page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Dental Flyer Link
      | PDF LINK     | <pdfLink> |
      | DocumentCode | <docCode> |

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0022 | AARP |   78006 | YES           | Bexar County | MAPD     | future   |    1023 | 4866893 |
      | 0023 | AARP |   78006 | YES           | Bexar County | MAPD     | future   |    1025 | 4805658 |

    @vppPlanCompareCommon_UHC03 @regressionUHC
    Examples: 
      | TID  | site | zipcode | isMultiCounty | county       | plantype | planyear | pdfLink | docCode |
      | 0024 | UHC  |   78006 | YES           | Bexar County | MAPD     | future   |    1023 | 4866893 |
      | 0025 | UHC  |   78006 | YES           | Bexar County | MAPD     | future   |    1025 | 4805658 |

  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and view locations on plan compare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
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

    @vppPlanCompareCommon_AARP03 @regressionAARP
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | AARP |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

    @vppPlanCompareCommon_UHC03 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | planname                                            | planyear |
      | 00026 | UHC  |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |
   
