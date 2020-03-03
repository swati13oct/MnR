@vppMicroAppUHC
Feature: VPP Testharness flow Navigations for UHC Site

  @vppTestharnessUHC01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Enter Zipcode on testharness page and Verify Navigation to VPP page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters following information in the UMS Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS
    Then the user validates marketing bullets of the plan in UMS Site
    Then the user view plan details of the above selected plan in UMS site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    #    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
    #      | Monthly Premium | <monthlyPremium> |
    #      | Annual Deductible | <annualDeductible> |
    #      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site
    #   Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
    #   Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      | 00001 | vppzipcode | Blayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 00002 | vppzipcode | Blayer   |   28105 | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

  @vppTestharnessUHC02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Lookup Zipcode on testharness page and Verify Navigation to VPP page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user clicks on Lookup zipcode and enters following information in the UHC Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Address         | <address>         |
      | City            | <city>            |
      | State           | <state>           |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS
    Then the user validates marketing bullets of the plan in UMS Site
    Then the user view plan details of the above selected plan in UMS site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    #    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
    #      | Monthly Premium | <monthlyPremium> |
    #      | Annual Deductible | <annualDeductible> |
    #      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site
    #   Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
    #   Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultutiCounty | county           | plantype | planName                                                   | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | address                    | city      | state       |
      | 00003 | vppzipcode | Blayer   |   06851 | NO              | Fairfield County | MAPD     | UnitedHealthcare Medicare Advantage Plan 3 (HMO)           | $0             | $15  copay           | $45  copay | No               | $6,700.00          | $3  copay              |                  | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT |
      | 00004 | vppzipcode | Blayer   |   30606 | YES             | Clarke County    | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0                 | 25% of the cost        |                  | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     |

  @vppTestharnessUHC03
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Testharness without zipcode to VPP
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user click on Go botton without entering Zipcode and enters zipcode from shop for a plan on the UHC Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS
    Then the user validates marketing bullets of the plan in UMS Site
    Then the user view plan details of the above selected plan in UMS site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    #    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
    #      | Monthly Premium | <monthlyPremium> |
    #      | Annual Deductible | <annualDeductible> |
    #      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site
    #   Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
    #   Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      | 00005 | vppzipcode | Blayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 00006 | vppzipcode | Blayer   |   28105 | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

  @vppTestharnessUHC04
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Summary Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters zipcode on plan summary deep link and clik on deeplink navigates to VPP plan summary for UHC
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                            |
      | 00007 | vppdeeplink | Blayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | 00008 | vppdeeplink | Blayer   |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)          |
      | 00009 | vppdeeplink | Blayer   |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     |

  @vppTestharnessUHC05
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Connector modal plans Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on Connector Model and clik on deeplink navigates to VPP plan summary for UHC
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | CountyCode      | <countyCode>      |
      | StateCode       | <stateCode>       |
      | WTMCID          | <wtmcid>          |
      | OrgSite         | <orgsite>         |
      | Subdomain       | <subdomain>       |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultutiCounty | county          | plantype | planName                                        | countyCode | stateCode | wtmcid  | orgsite                                     | subdomain |
      | 00010 | vppdeeplink | Blayer   |   10001 | NO              | New York County | MAPD     | UnitedHealthcare Group Medicare Advantage (PPO) |        420 |        36 |  897576 | https%253A%252F%252Fwww.myuhcplans.com%252F | eaton     |
      | 00011 | vppdeeplink | Blayer   |   78006 | YES             | Bexar County    | MAPD     | UnitedHealthcare Group Medicare Advantage (PPO) |        130 |        48 | 8003093 | https%253A%252F%252Fwww.myuhcplans.com%252F | kohler    |

  @vppTestharnessUHC06
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Summary Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for UHC
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Deeplink        | <deeplink>        |
      | Plan Type       | <plantype>        |
      | Year            | <year>            |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                           | deeplink         | Year |
      | 00012 | vppdeeplink | Blayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | favPlansDeepLink | 2020 |
      | 00013 | vppdeeplink | Blayer   |   10001 | NO              | New York County    | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         | favPlansDeepLink | 2020 |

  @vppTestharnessUHC07
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Summary Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for UHC
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Deeplink        | <deeplink>        |
      | Plan Type       | <plantype>        |
      | Year            | <year>            |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultutiCounty | county       | plantype | planName                        | deeplink         | Year |
      | 00014 | vppdeeplink | Blayer   |   78006 | YES             | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP) | favPlansDeepLink | 2020 |

  @vppTestharnessUHC08
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Compare Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan compare deeplink and clik on deeplink navigates to VPP plan Compare for UHC
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Expiry Date     | <expDate>         |
      | ContractPBP     | <hnpbpb>          |
      | Plan Type       | <plantype>        |
      | Plan Year       | <year>            |
      | fisCountyCode   | <ficcode>         |
    Then verify plan compare page is loaded on UHC

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                           | expDate       | hnpbpb                              | year | ficcode |
      | 00015 | vppdeeplink | Blayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | 1590058773320 | H0543168000,H0543001000             | 2020 |     037 |
      | 00016 | vppdeeplink | Blayer   |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                    | 1590058773320 | S5921403000,S5820021000,S5921367000 | 2020 |     029 |
