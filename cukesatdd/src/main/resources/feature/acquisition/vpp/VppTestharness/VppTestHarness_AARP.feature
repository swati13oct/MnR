@vppMicroAppAARP
Feature: VPP Testharness for AARP Site

  @vppTestharnessAARP01
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters following information in the AARP Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
      | TID   | THPage     | siteName | zipcode | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      | 00001 | vppzipcode | Ulayer   |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 00002 | vppzipcode | Ulayer   |   28105 | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

  @vppTestharnessAARP02
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on VPP TestHarness page for AARP
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user clicks on Lookup zipcode and enters following information in the AARP Acquisition Site VPPZipcode TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Address         | <address>         |
      | City            | <city>            |
      | State           | <state>           |
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
      | TID   | THPage     | siteName | zipcode | isMultutiCounty | county           | plantype | planName                                                   | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | address                    | city      | state       |
      | 00003 | vppzipcode | Ulayer   |   06851 | NO              | Fairfield County | MAPD     | UnitedHealthcare Medicare Advantage Plan 3 (HMO)           | $0             | $15  copay           | $45  copay | No               | $6,700.00          | $3  copay              |                  | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT |
      | 00004 | vppzipcode | Ulayer   |   30606 | YES             | Clarke County    | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0                 | 25% of the cost        |                  | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     |
