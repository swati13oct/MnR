@vppMicroAppAARP
Feature: VPP Testharness flow Navigations for AARP Site

  @vppTestharnessAARP01 @vppTestharnessAARPRun01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Enter Zipcode on testharness page and Verify Navigation to VPP page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters following information in the AARP Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan in AARP site
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user view plan details of the above selected plan in AARP site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Annual Deductible          | <annualDeductible>       |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site
    Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      | 00001 | vppzipcode | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 00002 | vppzipcode | Ulayer   |   28105 | YES           | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

  @vppTestharnessAARP02 @vppTestharnessAARPRun01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Lookup Zipcode on testharness page and Verify Navigation to VPP page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user clicks on Lookup zipcode and enters following information in the AARP Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Address         | <address>       |
      | City            | <city>          |
      | State           | <state>         |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan in AARP site
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user view plan details of the above selected plan in AARP site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Annual Deductible          | <annualDeductible>       |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site
    Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultiCounty | county           | plantype | planName                                                   | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | address                    | city      | state       |
      | 00003 | vppzipcode | Ulayer   |   06851 | NO            | Fairfield County | MAPD     | UnitedHealthcare Medicare Advantage Plan 3 (HMO)           | $0             | $15  copay           | $45  copay | No               | $6,700.00          | $3  copay              |                  | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT |
      | 00004 | vppzipcode | Ulayer   |   30606 | YES           | Clarke County    | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0                 | 25% of the cost        |                  | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     |

  @vppTestharnessAARP03 @vppTestharnessAARPRun01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Testharness without zipcode to VPP
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user click on Go botton without entering Zipcode and enters zipcode from shop for a plan on the AARP Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan in AARP site
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user view plan details of the above selected plan in AARP site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Annual Deductible          | <annualDeductible>       |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site
    Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page

    Examples: 
      | TID   | THPage     | siteName | zipcode | isMultiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      | 00005 | vppzipcode | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 00006 | vppzipcode | Ulayer   |   28105 | YES           | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

  @vppTestharnessAARP04 @vppTestharnessAARPRun01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Enter Zipcode on testharness page and Verify Navigation to VPP page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters zipcode on plan summary deep link and clik on deeplink navigates to VPP plan summary for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county             | plantype | planName                                            |
      | 00007 | vppdeeplink | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | 00008 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)          |
      | 00008 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     |

  @vppTestharnessAARP06 @vppTestharnessAARPRun01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Summary Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Deeplink        | <deeplink>      |
      | Plan Type       | <plantype>      |
      | Year            | <year>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county             | plantype | planName                                           | deeplink         | year |
      | 00012 | vppdeeplink | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | favPlansDeepLink | 2020 |
      #| 00013 | vppdeeplink | Ulayer   |   10001 | NO            | New York County    | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         | favPlansDeepLink | 2020 |

  @vppTestharnessAARP07 @vppTestharnessAARPRun02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Summary Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Deeplink        | <deeplink>      |
      | Plan Type       | <plantype>      |
      | Year            | <year>          |
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county       | plantype | planName                        | deeplink         | Year |
      | 00014 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP) | favPlansDeepLink | 2020 |

  @vppTestharnessAARP08 @vppTestharnessAARPRun02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Compare Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan compare deeplink and clik on deeplink navigates to VPP plan Compare for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Expiry Date     | <expDate>       |
      | ContractPBP     | <hnpbpb>        |
      | Plan Type       | <plantype>      |
      | Plan Year       | <year>          |
      | fisCountyCode   | <ficcode>       |
    Then verify plan compare page is loaded on AARP

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county             | plantype | planName                                           | expDate       | hnpbpb                              | year | ficcode |
      | 00015 | vppdeeplink | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | 1590058773320 | H0543168000,H0543001000             | 2020 |     037 |
      | 00016 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                    | 1590058773320 | S5921403000,S5820021000,S5921367000 | 2020 |     029 |

  @vppTestharnessAARP09 @vppTestharnessAARPRun02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Details Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan details deeplink and clik on deeplink navigates to VPP plan details for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Plan Type       | <plantype>      |
      | ContractPBP     | <hnpbpb>        |
      | Plan Year       | <year>          |
      | fisCountyCode   | <ficcode>       |
      | Deeplink        | <deeplink>      |
    Then the user view plan details of the above selected plan in AARP site and validates from Deeplink
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county             | plantype | planName                                           | hnpbpb      | year | ficcode | deeplink   |
      | 00017 | vppdeeplink | Ulayer   |   90210 | NO            | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | H0543168000 | 2020 |     037 | plandetail |
      | 00018 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                    | S5921403000 | 2020 |     029 | plandetail |
      | 00019 | vppdeeplink | Ulayer   |   10001 | NO            | New York County    | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         | H3387010000 | 2020 |     061 | plandetail |

  @vppTestharnessAARP10 @vppTestharnessAARPRun02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Plan Selector Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on plan selector deeplink and clik on deeplink navigates to VPP plan details for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Plan Type       | <plantype>      |
      | ContractNum     | <contractNum>   |
      | Segment ID      | <segmentID>     |
      | PbpNumber       | <pbpNumber>     |
      | Plan Year       | <year>          |
      | CountyCode      | <Countyccode>   |
      | User Group      | <userGroup>     |
    Then the user view plan details of the above selected plan in AARP site and validates from Deeplink
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county       | plantype | planName                                     | contractNum | pbpNumber | segmentID | year | Countyccode | userGroup |
      | 00020 | vppdeeplink | Ulayer   |   78006 | YES           | Bexar County | MAPD     | AARP Medicare Advantage SecureHorizons (HMO) | H4590       |       010 |       000 | 2020 |       48029 | DST       |

  @vppTestharnessAARP11 @vppTestharnessAARPRun02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Navigation from Med Sup Deeplink with below parameters to plan summary page
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters Mandatory fields on MedSup deeplink and clik on deeplink navigates to VPP plan details for AARP
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | Plan Type       | <plantype>      |
      | URI             | <uri>           |
      | MPBED           | <mpbed>         |
      | EBRC            | <ebrc>          |
      | DPSD            | <dpsd>          |
      | Intref          | <intref>        |
      | MPAED           | <mpaed>         |
      | GenderCode      | <genderCode>    |
      | TobaccoUser     | <tobaccoUser>   |
      | DOB             | <dob>           |
    And the user validates plan summary for the below plan in AARP site for Medsup Deeplink
      | Plan Name | <planName> |

    Examples: 
      | TID   | THPage      | siteName | zipcode | isMultiCounty | county       | plantype | planName | uri                                         | mpbed      | ebrc                                                                       | dpsd       | intref                     | mpaed      | genderCode | tobaccoUser | dob        |
      | 00021 | vppdeeplink | Blayer   |   10001 | No            | Bexar County | MAPD     | Plan F   | health-plans/medicare-supplement-plans.html | 2018-01-01 | https://www.aarpmedicaresupplement.uhc.com/medicare-information-guide.html | 2020-04-01 | AARPMedicareSupplement.com | 2018-01-01 | Male       | Yes         | 1950-03-25 |
      | 00022 | vppdeeplink | Blayer   |   10001 | No            | Bexar County | MAPD     | Plan F   | health-plans.html                           | 2018-01-01 |                                                                            | 2020-04-01 |                            | 2018-01-01 | Male       | Yes         | 1950-03-25 |
