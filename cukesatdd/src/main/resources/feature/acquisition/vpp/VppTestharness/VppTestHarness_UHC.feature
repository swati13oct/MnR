@vppMicroAppUHC
Feature: VPP Testharness for UHC Site

   @vppTestharnessUHC01 
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
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
      | Monthly Premium | <monthlyPremium> |
      | Primary Care Physician | <primaryCarePhysician> |
      | Specialist | <specialist> |
      | Referral Required | <referralRequired> |
      | Out Of Pocket Maximum | <outOfPocketMaximum> |
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
   |   TID  | THPage         | siteName |zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician  | specialist  | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
   |  15553 |  vppzipcode | Blayer   |90210  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
   |  15554 | vppzipcode | Blayer   | 28105  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)             | $0              | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                               
     