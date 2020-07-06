@vppPlanCompareUHC
Feature: 2.01.3-Vpp to plan Compare UHC Scenarios

  @vppPlanCompareUHC01 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> -  Verify the checkbox for add to compare link is not visible for single plan.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then verify plan compare checkbox is not visible on plan summary on UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county           | plantype |
      | 00001 |   96799 | NO            | Western District | PDP      |
      | 00002 |   78006 | YES           | Bexar County     | SNP      |
      | 00003 |   90265 | YES           | Ventura County   | MAPD     |
      | 00004 |   70072 | NO            | Jefferson Parish | MAPD     |

  @vppPlanCompareUHC02 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Verify Call sticky action menu on AARP site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    When verify Call SAM icon is visible or not on Plan Comapare on UHC site
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site
    Then user verify the popup and content on Plan Comapare on UHC site

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00005 |   90210 | No            | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC03 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare

    Examples: 
      | TID   | zipcode | isMultiCounty | county         | plantype |
      | 00006 |   35616 | NO            | Colbert County | MAPD     |

  @vppPlanCompareUHC04 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - To verify links displayed in the global footer of UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
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
      | TID   | zipcode | isMultiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00007 |   90210 | No            | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC05 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Navigation for plan comapre to Back to summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    And click on back to plans on plan compare page for UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00008 |   90210 | No            | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC06 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be removed using Remove link from the widget on the top of page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then remove one plan from new plan compare page for UHC
    And click on back to plans on plan compare page for UHC
    Then Verify the Plan compare checkbox should be unchecked for the removed plan for UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype |
      | 00009 |   90210 | NO            | Los Angeles County | MAPD     |

  @vppPlanCompareUHC07 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page for UHC
    And check one plan and add it to plancompare for UHC
    Then Verify newly added plan displayed on new plan compare page for UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | count |
      | 00010 |   90210 | NO            | Los Angeles County | MAPD     |     1 |

  @vppPlanCompareUHC08 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from VPP and Edit provider from plan compare page for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Your doctors is loaded with doctor summary on Plan Compare page UHC
    And click on Edit your doctors link and Navigate to Rally page for UHC
    When user selects a provider from medical group and retuns to plan compare page in UHC
    Then verify Your doctors is loaded with doctor summary on Plan Compare page UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | planName                                            |
      | 00011 |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanCompareUHC09 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add provider from plan compare and Edit provider from plan compare page for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Add doctors is loaded with doctor summary on Plan Compare page UHC
    And click on Add your doctors link and Navigate to Rally page for UHC
    And I click on Get Started on and Add PrimaryCare PCP from find care page in UHC
    Then verify Your doctors is loaded with doctor summary on Plan Compare page UHC
    And click on Edit your doctors link and Navigate to Rally page for UHC
    When user selects a provider from medical group and retuns to plan compare page in UHC
    Then verify Your doctors is loaded with doctor summary on Plan Compare page UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | planName                                            |
      | 00012 |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanCompareUHC10 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hospital from VPP and Edit hospital from plan compare page for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page UHC
    And click on Edit your Hospitals link and Navigate to Rally page for UHC
    When user selects a Hospitals from Clinical and retuns to plan compare page in UHC
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county          | plantype | planName                             |
      | 00013 |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |

  @vppPlanCompareUHC11 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add Hosptial from plan compare and Edit Hosptial from plan compare page for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Add Hospitals is loaded without summary on Plan Compare page UHC
    And click on Add your Hospitals link and Navigate to Rally page for UHC
    And I click on Get Started on and Add Places from Hospitals find care page in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page UHC
    And click on Edit your Hospitals link and Navigate to Rally page for UHC
    When user selects a Hospitals from Clinical and retuns to plan compare page in UHC
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county          | plantype | planName                             |
      | 00014 |   10010 | NO            | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |

  @vppPlanCompareUHC12 @vppPlanCompareUHCRun01New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add drug from plan compare and Edit drug from plan compare page for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And user access DCE tool on UMS site
      | Plan Type | <plantype> |
      | PlanName  | <planName> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded>   |
      | Drug            | <drugName1> |
    And I navigate to step2 page
    When the user selects the pharmacy type and distance in UMS site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in UMS site
      | Pharmacy Name | <pharmacyName> |
    And I navigate to step3 page and validate the drug info
      | Drug | <drugName1> |
    And the user clicks on return link to navigate to plan summary in UHC
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then verify Edit your Drugs is loaded with Drugs summary on Plan Compare page UHC
    And click on Edit Drug link on plan compare for UHC site
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name2 | <drugName2> |
    And selects drug details for other drugs in ums site
      | Drug Name2 | <drugName2> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name3 | <drugName3> |
    And selects drug details in ums site
      | Drug Name3 | <drugName3> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the ums site
      | Drug Name3 | <drugName3> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    When the user selects the pharmacy type and distance in UMS site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in UMS site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    And the user clicks on Back to Plans button in UHC site and Navigates to new Plan Compare
    Then verify plan compare page is loaded on UHC
    Then verify Edit your Drugs is loaded with Drugs summary on Plan Compare page UHC

    Examples: 
      | TID   | zipcode | drugName1 | dosage   | plantype | county             | isMultiCounty | quantity | frequency     | branded | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName   | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear | genericName1 |
      | 00015 |   90002 | Lipitor   | TAB 10MG | MAPD     | Los Angeles County | no            |       30 | Every 1 month | yes     | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | BRAVO PHARMACY | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          | atorvastatin |

  @vppPlanCompareUHC13 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> - Navigation for plan comapre to OLE
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then the user clicks on Enroll in plan for UHC site and validates the Welcome to OLE Page on new Plan Compare

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | MultiCOuntyzipcode | plantype | count |
      | 00016 |   90210 | No            | Los Angeles County |              80002 | MAPD     |     2 |

  @vppPlanCompareUHC14 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> -  Navigation for plan comapre to Plan Detail
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then the user clicks on Plan details link in new Plan Compare page on UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | MultiCOuntyzipcode | plantype | count | pdfType               | docCode                 |
      | 00017 |   90210 | No            | Los Angeles County |              80002 | MAPD     |     2 | Step Therapy Criteria | Step_Therapy_MCORE_2020 |

  @vppPlanCompareUHC15 @vppPlanCompareUHCRun02New @vppPlanCompareUHCRegression
  Scenario Outline: TID: <TID> -  Validation for Selecting more than 4 plans for plan comapre from VPP
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then Click on view more plans for right navigaton on UHC
    Then Click on view less plans for left navigaton on UHC

    Examples: 
      | TID   | zipcode | isMultiCounty | county          | plantype | count |
      | 00018 |   10010 | No            | New York County | MAPD     |     9 |
