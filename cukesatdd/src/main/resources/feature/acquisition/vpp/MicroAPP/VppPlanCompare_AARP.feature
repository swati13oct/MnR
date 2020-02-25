@vppPlanCompareAARP @vppPlanCompareAARPRegression
Feature: Vpp to plan Compare AARP Scenarios

  @vppPlanCompareAARP01 @vppPlanCompareAARPRun01
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify Rally Tool from Plan Compare Page for AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    And I Click on Look up your doctor link on Plan compare in AARP
    And I click on Get Started on and Add Provider from find care page in AARP
    Then Verify provider is count is updated on plan compare page in AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 00001 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareAARP02 @vppPlanCompareAARPRun01
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then remove one plan from plan compare page for AARP
    And click on back to plans on plan compare page for AARP
    Then Verify the Plan compare checkbox should be unchecked for the removed plan for AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 00002 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareAARP03 @vppPlanCompareAARPRun01
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget.
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then Click on Add Icon and verify it navigates to plan summary page for AARP
    And check one plan and add it to plancompare for AARP
    Then Verify newly added plan displayed on plan compare page for AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | count |
      | 00003 |   90210 | NO              | Los Angeles County | MAPD     |     1 |

  @vppPlanCompareAARP04 @vppPlanCompareAARPRun01
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify the checkbox for add to compare link is not visible for single plan.
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then verify plan compare checkbox is not visible on plan summary on AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county           | plantype |
      | 00004 |   96799 | NO              | Western District | PDP      |
      | 00005 |   78006 | YES             | Bexar County     | SNP      |
      | 00006 |   90265 | YES             | Ventura County   | MAPD     |
      | 00007 |   70072 | NO              | Jefferson Parish | MAPD     |

  @vppPlanCompareAARP05 @vppPlanCompareAARPRun01
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare for AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype |
      | 00008 |   35616 | NO              | Colbert County | MAPD     |

  @vppPlanCompareAARP06 @vppPlanCompareAARPRun02
  Scenario Outline: UID: <UID> - Plan Type: <plantype> - Verify Call sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    When verify Call SAM icon is visible or not on Plan Comapare
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare
    Then user verify the popup and content on Plan Comapare

    Examples: 
      | UID     | zipcode | isMultutiCounty | county             | plantype |
      | F322478 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareAARP07 @vppPlanCompareAARPRun02
  Scenario Outline: UID: <UID> - Plan Type: <plantype> - Verify Chat sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    When verify Chat SAM icon is visible or not on Plan Comapare
    And verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare
    Then user verify the Chat original state on Plan Comapare

    Examples: 
      | UID     | zipcode | isMultutiCounty | county             | plantype |
      | F322478 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareAARP08 @vppPlanCompareAARPRun02
  Scenario Outline: <TCID> - Plan Type: <plantype> - To verify links displayed in the global footer of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
      | TCID  | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype |
      | 00009 |   90210 | No              | Los Angeles County |              80002 | MAPD     |

  @vppPlanCompareAARP09 @vppPlanCompareAARPRun02
  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to OLE
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then the user clicks on Enroll in plan for AARP site and validates the Welcome to OLE Page on Plan Compare

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype |
      | 00010 |   90210 | No              | Los Angeles County |              80002 | MAPD     |

  @vppPlanCompareAARP10 @vppPlanCompareAARPRun02
  Scenario Outline: <TCID> - Plan Type: <plantype> - Navigation for plan comapre to Plan Detail
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then the user clicks on Plan details linnk in Plan Compare page
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in URL
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | planName                                       | pdfType               | docCode                 |
      | 00011 |   90210 | No              | Los Angeles County |              80002 | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2020 |

  @vppPlanCompareAARP11 @vppPlanCompareAARPRun02
  Scenario Outline: <TCID> - Plan Type: <plantype> -Navigation for plan comapre to Back to summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then the user clicks on back on all plan linnk in Plan Compare page

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype |
      | 00012 |   90210 | No              | Los Angeles County |              80002 | MAPD     |

  