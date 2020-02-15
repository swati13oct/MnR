@vppPlanCompareUHC
Feature: Vpp to plan Compare UHC Scenarios

  @vppPlanCompareUHC01
  Scenario Outline: TID: <TID> Plan Type: <plantype> - Verify Rally Tool from plan compare for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    And I Click on Look up your doctor link on Plan compare
    And I click on Get Started on and Add Provider from find care page
    Then Verify provider is count is updated on plan compare page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 00001 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareUHC02
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then remove one plan from plan compare page for UHC
    And click on back to plans on plan compare page for UHC
    Then Verify the Plan compare checkbox should be unchecked for the removed plan for UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 00002 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareUHC03
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then Click on Add Icon and verify it navigates to plan summary page for UHC
    And check one plan and add it to plancompare for UHC
    Then Verify newly added plan displayed on plan compare page for UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | count |
      | 00003 |   90210 | NO              | Los Angeles County | MAPD     |     1 |

  @vppPlanCompareUHC04
  Scenario Outline: TID: <TID> - Plan Type: <plantype> -  Verify the checkbox for add to compare link is not visible for single plan.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then verify plan compare checkbox is not visible on plan summary on UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county           | plantype |
      | 00004 |   96799 | NO              | Western District | PDP      |
      | 00005 |   78006 | YES             | Bexar County     | SNP      |
      | 00006 |   90265 | YES             | Ventura County   | MAPD     |
      | 00007 |   70072 | NO              | Jefferson Parish | MAPD     |

  @vppPlanCompareUHC05
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype |
      | 00008 |   35616 | NO              | Colbert County | MAPD     |

  @vppPlanCompareUHC06
  Scenario Outline: TID: <TID> - Verify Call sticky action menu on AARP site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    When verify Call SAM icon is visible or not on Plan Comapare on UHC site
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site
    Then user verify the popup and content on Plan Comapare on UHC site

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00009 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC07
  Scenario Outline: TID: <TID> - Verify Chat sticky action menu on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    When verify Chat SAM icon is visible or not on Plan Comapare on UHC site
    And verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site
    Then user verify the Chat original state on UHC site

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00010 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC08
  Scenario Outline: TID: <TID> - To verify links displayed in the global footer of UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    And the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site
    And the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site
    And the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
    And the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site
    #And the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site
    And the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site
    And the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents&brokers page bluelayer

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00011 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC09
  Scenario Outline: TID: <TID> - Navigation for plan comapre to OLE
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then the user clicks on Enroll in plan for UHC site and validates the Welcome to OLE Page on Plan Compare

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00012 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC10
  Scenario Outline: TID: <TID> -  Navigation for plan comapre to Plan Detail
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then the user clicks on Plan details link in Plan Compare page on UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count | pdfType               | docCode                 |
      | 00013 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 | Step Therapy Criteria | Step_Therapy_MCORE_2020 |

  @vppPlanCompareUHC11
  Scenario Outline: TID: <TID> - Navigation for plan comapre to Back to summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    And click on back to plans on plan compare page for UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00014 |   90210 | No              | Los Angeles County |              80002 | MAPD     |     2 |
