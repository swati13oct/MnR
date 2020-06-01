@acq_ChatWindow_AARP @F412628
Feature: 1.20 ACQ AARP- To test ChatWindow in AARP site

@ChatWindowUlayer
Scenario Outline: 1.20 To verify ChatWindow in all the pages of AARP site
Given the user is on AARP medicare acquisition site landing page
Then the user validates whether chat icon 

  @VppChatWindowUlayer123 @ChatWindowUlayer 
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in AARP site
    Given the user is on the AARP medicare acquisition site landing page
    Then the user validates chat Icon
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    # And the user views the plans of the below plan type in AARP site and select Next year
    #  | Plan Type | <plantype> |
      And the user views the plans of the below plan type in AARP site and validates Chat Icon
      | Plan Type | <plantype> |
    Then the user validates chat Icon
    And the user validates available plans for selected plan types in the AARP site 
     Then the user validates chat Icon
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
      Then the user validates chat Icon
    #Then the user validates marketing bullets of the plan in AARP site
    #Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
     Then the user view plan details of the above selected plan in AARP site and validates
     | Plan Name | <planName> |
    Then the user validates chat Icon
     # Then the user view plan details of the above selected plan in AARP site 
     # | Plan Name | <planName> |
     Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    #Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
       #| Monthly Premium | <monthlyPremium> |
       #| Primary Care Physician | <primaryCarePhysician> |
       #| Specialist | <specialist> |
       #| Referral Required | <referralRequired> |
       #| Out Of Pocket Maximum | <outOfPocketMaximum> |
       #| Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
       #|Plan Type | <plantype> |
    #Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      #| Monthly Premium | <monthlyPremium> |
     #| Annual Deductible | <annualDeductible> |
    # | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |  
    #Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site  
    #Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    #Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    #Then the user clicks on enter drug information link in the benefits table and validate the Chat Icon and DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
   # Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
   # Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
   #Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    #Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page
   Then the user validates chat Icon
      
	  
    Examples: 
       |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                         | annualDeductible                                       |
       | 15545  |  90210  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
       | 15546  |  28105  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)             | $0              | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                        |        
       
     @prodRegression
     Examples:
       |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                         | annualDeductible                                       |
      # | 15551  |  90210  | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0              | $5  copay             | $10  copay  | Yes              | $4,900.00          |  No drug coverage                            |                                                        | 
      # | 15552  |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $0              |                       |             |                  |                    | $0  copay                                    | $0 for Tier 1, Tier 2 $435 for Tier 3, Tier 4, Tier 5  | 
      
     @ComparePlansChatWindowUlayer123 @ChatWindowUlayer                                                                                                                                                                                                                                                                    
     Scenario Outline:TID: <TID> -plantype: <plantype> - Verify print and email for plan compare page in AARP site
    Given the user is on AARP medicare acquisition site landing page
     Then the user validates chat Icon
    When the user performs plan search using following information in the AARP site
    
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
      Then the user validates chat Icon
    And the user views the plans of the below plan type on test site
    
      | Plan Type       | <plantype> |
      | Site       | <site> |
      Then the user validates chat Icon
    Then user saves first plan on plan summary page on test site
    Then I select multiple plans to compare for selected plan and click on compare plan link in the test site
      | plan type       | <plantype> |
     Then the user validates chat Icon
 
    Examples: 
     | TID   | site   |zipcode | plantype          | isMultiCounty | 
     | 15523 | Ulayer |90210   | MA                | NO            | 

@DCEChatWindowUlayer123 @ChatWindowUlayer
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on the AARP medicare site landing page
    Then the user validates chat Icon
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    And the user clicks on the shopping cart icon in AARP site
    Then the user validates chat Icon
    And the user clicks on the add drugs button in the guest profile in AARP site
    Then the user validates chat Icon
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
      | Dosage    | <dosage>    |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    Then the user validates chat Icon
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
          | Drug | <drug> |
    Then the user validates chat Icon      
    And the user returns to the visitor profile page
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <drug> |
    Then the user validates chat Icon 
    Examples: 
      | state   | drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | Alabama | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |

  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary with chat icon validation
    Given the user is on AARP medicare acquisition site landing page
    Then the user validates chat Icon 
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
     Then the user validates chat Icon 
    #Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user validates chat Icon 
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates chat Icon 
    Then the user validates the Plan details on OLE
    Then the user validates chat Icon
  # Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates chat Icon 
   # Then the user validates Learn more modal for Welcome OLE
   # Then the user validates Leave OLE modal for Welcome OLE
   # Then the user validates cancellation modal for Welcome OLE
    #Then the user validates chat Icon 
    Then the user navigates to Medicare Information Page
    Then the user validates chat Icon 
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates chat Icon 
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates chat Icon 
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user validates chat Icon 
    Then the user navigates to Preliminary Questions Page
    Then the user validates chat Icon 
   #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
       Then the user validates chat Icon 
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
     Then the user validates chat Icon 
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    Then the user validates chat Icon 
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
     Then the user validates chat Icon 
    Then the user validates the Member details dynamic display in Personal Information Page
     Then the user validates chat Icon 
    Then the user navigates to SEP Page
     Then the user validates chat Icon 
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
      Then the user validates chat Icon
    Then the user navigates to Coverage and Health Information Page
     Then the user validates chat Icon 
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
      Then the user validates chat Icon
    Then the user navigates to Proposed Effective Date Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates chat Icon
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates chat Icon
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates chat Icon
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user validates chat Icon
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    #Then the user navigates to Optional Benefits Page for following plans with available Riders
     # | Rider Flag | <riderflag> |
     # Then the user validates chat Icon
   # Then the user navigates to Authorization Page for plan as per following rider options
    #  | Rider Flag | <riderflag> |
    # Then the user validates chat Icon
    # Then the user validates required fields for Authorization Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    #Then the user navigates to Review and Submit Page
    #Then the user validates chat Icon
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
   # Then the user validates the Plan and Member details on Review and Submit Page
    # Then the user validates chat Icon
   # Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | MA-HICN          |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Focus (HMO) | HICN     | John      | Doe      | 1EG4TE5MK75   | false   |  01012010 |  01012010 |      1EG4TE5MK75 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | false      | true       | true        | true        |	NO					| NO	  |
     # | 15559 | MA-RRID          |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | RRID     | John      | Doe      | AAA998877665   | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        |	NO					| NO	  |
     # | 15560 | MA-PFFS-MBI      |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)     | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        |	NO					| NO	  |
      #| 15555 | Medica-MAPD-HICN |   33143 | NO              | Miami-Dade County  | MAPD     | Medica HealthCare Plans MedicareMax (HMO)            | HICN     | John      | Doe      | 987456321A1    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
     # | 15556 | MAPD-RRID        |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | RRID     | John      | Doe      | rrr012345678   | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | false      | true       | true        | true        |	NO					| NO	  |
     # | 15557 | MAPD-PFFS-MBI    |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)            | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        |	NO					| NO	  |
    #  | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | HICN     | John      | Doe      | 121242525p     | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
    # | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
     # | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
      #| 15572 | DSNP-HICN        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | HICN     | John      | Doe      | 998877665t     | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
    #| 15573 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | RRID     | John      | Doe      | rr000000000    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
     # | 15574 | PCP-DSNP-MBI     |   33143 | NO              | Miami-Dade County  | SNP      | Preferred Medicare Assist (HMO SNP)                | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
     
     
     
     
     
     
     