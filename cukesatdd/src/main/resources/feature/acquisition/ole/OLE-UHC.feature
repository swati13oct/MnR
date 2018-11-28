@fastandfurious @OLE @OLE_UHC
Feature:1.13-VBF-ACQ-To test OLE common tool flow flow UMS site

  @OLE_VPP_UHC @junerelease2018  @september_release_2018 @december_release_2018
  @OLE_PCP_Medica_UHC @OEP_CHANGES
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #    Then the user validates TFN in Welcome OLE Right Rail
    #    Then the user validates Learn more modal for Welcome OLE
    #    Then the user validates Leave OLE modal for Welcome OLE
    #    Then the user validates cancellation modal for Welcome OLE
    Then the user validates and selects the Disclaimer Checkbox
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #   Then the user validates TFN in Medicare Info OLE Right Rail
    #   Then the user validates Leave OLE modal for Medicare Information Page
    #   Then the user validates Learn more modal for Medicare Information Page
    #    Then the user validates cancellation modal for Medicare Information Page
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    #   Then the user validates TFN in Right Rail on Preliminary Questions Page
    #   Then the user validates Leave OLE modal for Preliminary Questions Page
    #   Then the user validates Learn more modal for Preliminary Questions Page
    #   Then the user validates cancellation modal for Preliminary Questions Page
    Then the user navigates to Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    #    Then the user validates TFN in Right Rail on Personal Information Page
    #    Then the user validates Leave OLE modal for Personal Information Page
    #    Then the user validates Learn more modal for Personal Information Page
    #    Then the user validates cancellation modal for Personal Information Page
    Then the user navigates to SEP Page
    Then the user validates the Plan details in SEP Page OLE Right Rail
    #    Then the user validates TFN in Right Rail on SEP Page
    #    Then the user validates Leave OLE modal for SEP Page
    #    Then the user validates Learn more modal for SEP Page
    #    Then the user validates cancellation modal for SEP Page
    
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
#    Then the user clicks on Submit Enrollment to complete enrollment
#    Then the user validates Plan and Member Details on Confirmation Page
#    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | zipcode | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag |
#      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 987456321t     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | true      |
#      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | MBI      | John      | Doe      | 2A22C22cc22    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |
#      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321c     | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |
#      |   28035 | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | MBI      | John      | Doe      | 3A33C22YK22    | true    |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |


#      |   35045 | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | MBI      | John      | Doe      | 2A22C33YK33    | false   |  01012010 |  01012010 |      012345569 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |
#      |   85923 | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)            | HICN     | John      | Doe      | 123456789d     | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                         |                   | yes     | no           | false     |
#      |   85923 | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)     | HICN     | John      | Doe      | 123456789f     | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                       | other reason text | yes     | no           | false     |
 #     |   33143 | Miami-Dade County | MAPD     | Preferred Choice Dade (HMO)                        | HICN     | John      | Doe      | 987654333p     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     |
#      |   33143 | Miami-Dade County | MAPD     | Medica HealthCare Plans MedicareMax (HMO)          | MBI      | John      | Doe      | 1e11e11ee11    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                  |          01012018 | yes     | no           | false     |
#      |   33143 | Miami-Dade County | SNP      | Preferred Medicare Assist (HMO SNP)                | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |
#      |   33143 | Miami-Dade County | SNP      | Medica HealthCare Plans MedicareMax Plus (HMO SNP) | MBI      | John      | Doe      | 2A22C33YK33    | false   |  01012010 |  01012010 |      012345569 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     |

      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 987456321A1    | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com |  Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA)| /12202018/12202018/ / / / | yes     | no           | true      |
      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | MBI      | John      | Doe      | 1EG4TE6MK78    | false   |  11012018 |  11012018 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com |  Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA)| /12202018/12202018/ / /  | yes     | no           | false     |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com |  Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA)| /12202018/12202018/ / / | yes     | no           | false     |
      |   28035 | Mecklenburg County | SNP     | UnitedHealthcare Dual Complete (HMO SNP)             | HICN     | John     | Doe      | AAA998877665   | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com |  Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA)| /12202018/12202018/ / / | yes     | no           | false     | #     |   78006 | Bexar County       | CSNP     | UnitedHealthcare Chronic Complete (HMO SNP)          | HICN     | John      | Doe      | AA112233445    | true    |  01012010 |  01012010 |     0923456789 | true     | 01011905 | Male   | 005 Morris Rd | Los Angeles | Yes                    | 804 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | (MA OEP)/ newly got Medicaid/Medicare (or my state)/ or my state helps pay for my Medicare premiums/ major disaster  | //01012018/01012018/// | yes     | no           | false     |


  @NegativeValidations_MedicareInfoPage
  Scenario Outline: OLE Negative Validations for Required Fields
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user validates and selects the Disclaimer Checkbox
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user validates error messages for Negative values and required fields on Medicare Info Page

    Examples: 
      | zipcode | county             | plantype | planName                                          | cardtype | firstname          | lastname | medicarenumber | ssnflag | partadate | partbdate |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) | HICN     |                 34 |          |       12345679 | false   | aisu323   |  01012020 |
      |   28035 | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | MBI      | Jo                 | Jo       |                | true    | 321651465 |  01012010 |
      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   | HICN     | )089$              | Doe      | 2A22C22YK22    | false   |  12042020 | aisu323   |
      |   35045 | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | MBI      | asdassdfsadfsdfsdf |    99898 | 123456789a     | false   |  01012010 |  01012010 |

  @OLE_PlanDetails_UHC
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Details
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |
      |   35045 | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          |

  @OLE_PlanCompare_UHC
  Scenario Outline: OLE Landing from UHC Acuisition site VPP Plan Compare
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user selects plans to add to plan compare and navigates to Plan compare page in UHC site
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

      
 @DSNP_Enroll_Now @september_release_2018
  Scenario Outline: To test OLE Button for DSNP Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |        
    Then the user validates the Enroll Now Button present for the plan type
      | Plan Name | <planName> |    
      
 Examples: 
      | zipcode | county   | plantype  |      planName                              | 
      |   28105 | Union County | SNP | UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |
 
 @CSNP_Enroll_Now @december_18
  Scenario Outline: To test OLE Button for CSNP Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code    | <zipcode> |     
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |        
    Then the user validates the Enroll Now Button present for the plan type
      | Plan Name | <planName> |    
      
 Examples: 
      | zipcode | plantype  |      planName                              | 
      |   73301 |  SNP | UnitedHealthcare Medicare Silver (Regional PPO SNP)  |
 
 
 @UHC_Disclosure @december_18
  Scenario Outline: To test Disclosure page for Chronic Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |        
    Then the user validates the Enroll Now Button present for the Chronic plan type
      | Plan Name | <planName> |    
    Then the user validates and selects the Disclaimer Checkbox
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user navigates to Diabetic Preliminary Questions Page
    Then the user navigates to Use and Disclosure Page
      
 Examples: 
      | zipcode | county   | plantype  |      planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate |
      |   78006 | Kendall County | SNP | UnitedHealthcare Chronic Complete (HMO SNP) |HICN     | John      | Doe      | 987456321t     | false   |  01012010 |  01012010 |
      
      
  #-------------------
  @preliminaryQuestion @spartans @december_release2018
 Scenario Outline: Test to check new question added to ole flow cardiovascular diabeties and chronic heart failure in UHC 
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    #Then the user validates the Plan details on OLE
    Then the user validates and selects the Disclaimer Checkbox
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user validates the presence for Preliminary Questions on Page
    | Plan Name | <planName> |
     
    Examples: 
      | zipcode | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag |
      |   78006 | Bexar County | SNP     | UnitedHealthcare Chronic Complete (HMO SNP) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |
      |   78006 | Bexar County | SNP     | UnitedHealthcare Medicare Silver (Regional PPO SNP)  | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |
      
   
      
 
@oleVBF @oleVppUhc
Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
Then the user validates the Plan details on OLE
Then the user validates and selects the Disclaimer Checkbox
Then the user navigates to Medicare Information Page
Then the user validates Medicare Information Page required fields
Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
Then the user navigates to Preliminary Questions Page
Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
Then the user navigates to Personal Information Page
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
Then the user validates the Plan details in Personal Information Page OLE Right Rail
Then the user validates the Member details dynamic display in Personal Information Page
Then the user navigates to SEP Page
#Then the user validates the Plan details in SEP Page OLE Right Rail
#Then the user validates SEP options and Required Fields for PlanType in SEP Page
#Then the user selects the following options for SEP Page
#      | Select Options | <selectoptions> |
#      | Option Data    | <optiondata>    |
Then the user navigates to Coverage and Health Information Page
Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
Then the user navigates to Proposed Effective Date Page
Then the user validates Proposed Effective Date is Displayed
Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
Then the user navigates to Monthly Plan Premium Page
Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
Then the user validates required fields for Authorization Page
Then the user navigates to Review and Submit Page
Then the user validates the Plan and Member details on Review and Submit Page
Then the user clicks on Submit Enrollment to complete enrollment
Then the user validates Plan and Member Details on Confirmation Page
Examples: 
       | zipcode | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 123456787t     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA   |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | true      |
      
      
 @StandaloneZipcode @Feb_18
  Scenario Outline: To reach VPP page via standalone Zipcode
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs Standalone zipcode search on TeamC using following information in UMS site
      | Zip Code    | <zipcode> |    
      
 Examples: 
      | zipcode | 
      |   78006 | 
      
 @StandaloneMA @Feb_18
  Scenario Outline: To reach VPP page via standalone Zipcode
    Given the user is on the uhcmedicaresolutions site landing page
    When the user goes to MA Landing page
      | Zip Code    | <zipcode> |    
      
 Examples: 
      | zipcode | 
      |   78006 | 
      
  @MALandigPlanOptions @Feb_18
  Scenario Outline: To reach VPP page via standalone Zipcode
    Given the user is on the uhcmedicaresolutions site landing page
    When the user goes to MA Landing page Options
      | Zip Code    | <zipcode> |    
      
 Examples: 
      | zipcode | 
      |   78006 | 