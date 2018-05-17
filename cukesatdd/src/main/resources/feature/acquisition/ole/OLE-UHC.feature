@fastandfurious @junerelease2018 @OLE @OLE_UHC
Feature: To test OLE common tool flow flow UMS site

  @OLE_VPP_UHC
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
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user validates Leave OLE modal for Medicare Information Page
    Then the user validates Learn more modal for Medicare Information Page
    Then the user validates cancellation modal for Medicare Information Page
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates TFN in Right Rail on Preliminary Questions Page
    Then the user validates Leave OLE modal for Preliminary Questions Page
    Then the user validates Learn more modal for Preliminary Questions Page
    Then the user validates cancellation modal for Preliminary Questions Page
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
    Then the user validates TFN in Right Rail on Personal Information Page
    Then the user validates Leave OLE modal for Personal Information Page
    Then the user validates Learn more modal for Personal Information Page
    Then the user validates cancellation modal for Personal Information Page
    Then the user navigates to SEP Page
    Then the user validates the Plan details in SEP Page OLE Right Rail
    Then the user validates TFN in Right Rail on SEP Page
    Then the user validates Leave OLE modal for SEP Page
    Then the user validates Learn more modal for SEP Page
    Then the user validates cancellation modal for SEP Page
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page

    Examples: 
      | zipcode | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | HICN     | John      | Doe      | 123456789a     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CALIFORNIA   |      90210 | test@test.com |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 123456789a     | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    |               |             | CALIFORNIA   |      90210 | test@test.com |
      |   28035 | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | MBI      | John      | Doe      | 2A22C22YK22    | true    |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CALIFORNIA   |      90210 | test@test.com |
      |   90210 | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | MBI      | John      | Doe      | 2A22C22YK22    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CALIFORNIA   |      90210 | test@test.com |

  #|   35045 | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          		| MBI      | John      | Doe      | 2A22C22YK22    | false   |  01012010 |  01012010 |	012345569			| true			|
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
