@fastandfurious @OLE 
@OLE_UHC
Feature:1.13-VBF-ACQ-To test OLE common tool flow flow UMS site

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
    #Then the user validates the Plan and Member details on Review and Submit Page
    
    Examples: 
       | zipcode | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 123456787t     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA   |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | true      |
  
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
#      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
       

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
#      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
