@fixedTestCaseTest @vppBlayer
Feature: 1.09-VBF-Acq-To test plan summary in vpp flow UMS site

  @planDetailsUMS @vppBlayerSmoke
  Scenario Outline: Verify plan details in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
    Then User click on add to compare checkbox and click on view details link on UMS
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                          |
      |   80002 | YES             | Adams County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @defect1964
  Scenario Outline: To verify correct message shows on view details page after checking compare plans box
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I click on add to compare checkbox and click on view details link
    Then I uncheck and recheck the compare box and verify the message and link exists
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode |
      |   33012 |

  @defect1803
  Scenario Outline: To test checkbox is unchecked on vpp after unchecking it on view details page
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I click on add to compare checkbox and click on view details link
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode |
      |   33012 |

  @defect1970
  Scenario Outline: To test correct message is displayed for PDP plans after checking compare plans box
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I select pdp plans and go to view details page
    Then I check compare box and verify right info is shown

    Examples: 
      | zipcode |
      |   33012 |

  @defect1363
  Scenario Outline: To test two plans are added when clicked on compare plans on Plan details page
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user clicks on add to compare box and validates that info shows 2 plans added

    Examples: 
      | zipcode | planName                                           | plantype |
      |   33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD     |

  @theSpartans @aprilRelease2018 @vppbacktoallplans @US987469 @US987465
  Scenario Outline: TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection

    Examples: 
      | zipcode | planName                                           | plantype |
      |   33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD     |

  @emailandprintplancompareuhc @predatorsdecrelease2018
  Scenario Outline: Verify email plan compare plan details in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I select all 3 plans to compare in MA and click on compare plan link in UHS site
    When the user validate the print and email link option in plan compare in UHS site
    Then the user validating email and print option in plan compare in UHS site
	Then the user validate thank you message in plan compare in UHS site 
	Then the user clicks on back to all plans link and validates all three plans are selected
    
    Examples: 
      | zipcode |
      |   90210 |

  @emailAndPrintPlanDetailsuhc @predatorsdecrelease2018
  Scenario Outline: TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user validate the print and email links on the plan Details Page on uhc site
    Then the user validates the functionality of email and print buttons on the plan Details Page on uhc site

    Examples: 
      | zipcode | planName                                           | plantype |
      |   33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD     |

  @validateEyeWearCredit @fastandfurious @Feb_release_2019
  Scenario Outline: Verify specific Additional Benefits in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user validates the following Plan details for the plan in UMS
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | zipcode | isMultutiCounty | county              | plantype | planName                                                 | benefitType | expectedText                           |
      |   80002 | Yes             | Adams County        | MAPD       | AARP MedicareComplete SecureHorizons Plan 1 (HMO)        | Eyewear     | for frames or / for contacts per       |
      |   80002 | Yes             | Adams County        | SNP      | UnitedHealthcare Dual Complete (HMO SNP)                 | Eyewear     | for frames or / for contacts per       |
      |   78006 | Yes             | Kendall County      | MAPD       | AARP MedicareComplete SecureHorizons (HMO)               | Eyewear     | Eyewear has a plan benefit limit up to |
      |   65058 | Yes             | Miller County       | SNP      | UnitedHealthcare Dual Complete (HMO SNP)                 | Eyewear     | Eyewear has a plan benefit limit up to |
      |   78006 | Yes             | Kendall County      | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO SNP) | Eyewear     | No Coverage                            |
      |   03033 | NO              | Hillsborough County | MAPD       | UnitedHealthcare MedicareComplete Assure (PPO)           | Eyewear     | No Coverage                            |

  @F250062 @HomeMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Home Page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following MultiCounty Zip information in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @SubNavMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Sub-nav Plan Search
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following MultiCounty Zip in Header Sub Nav in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @VPPChangeLocationMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on VPP for Change Location
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultiCounty> |
    When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | zipcode | isMultiCounty | county             | MultiCOuntyzipcode |
      |   90210 | NO              | Los Angeles County |              80002 |
