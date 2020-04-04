@OLEMicroAPP_SNP
Feature: OLE Testharness page for AARP for SNP

  @OLEMicoAppSNP01
  Scenario Outline: TID: <TID> -plan type: <PlanType> - Ole Testharness page to confirmation page for SNP
    Given the user is on OLE TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user navigates to OLE WelcomePage using following information
      | SiteId          | <siteId>          |
      | PBPNumber       | <pBPNumber>       |
      | ClientCode      | <clientCode>      |
      | SegmentId       | <segmentId>       |
      | PlanTypeTH      | <PlanTypeTH>      |
      | TFN             | <TFN>             |
      | Plan Name       | <planName>        |
      | psc             | <psc>             |
      | Plan Year       | <planYear>        |
      | env             | <env>             |
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | FipsCode        | <FipsCode>        |
      | StateCode       | <StateCode>       |
      | CMScode         | <CMScode>         |
      | HNumber         | <HNumber>         |
      | Is Multi County | <isMultutiCounty> |
      | Plan Type       | <plantype>        |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
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
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
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
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | isMultutiCounty | plantype | siteName | THPage | siteId | pBPNumber | clientCode | segmentId | PlanTypeTH | TFN            | planName                              | psc    | planYear | env     | zipcode | county            | FipsCode | StateCode | CMScode | HNumber | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 00001 | NO              | SNP      | Ulayer   | ole    | aarp   |       012 | UHCMS1     |       000 | SNP        | 1-877-596-3258 | Preferred Medicare Assist (HMO D-SNP) | 880180 |     2020 | nonProd |   33143 | Miami-Dade County |      120 | FL        |     000 | H1045   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |
      | 00002 | NO              | SNP      | Blayer   | ole    | uhc    |       012 | UHCMS1     |       000 | SNP        | 1-877-596-3258 | Preferred Medicare Assist (HMO D-SNP) | 880180 |     2020 | nonProd |   33143 | Miami-Dade County |      120 | FL        |     000 | H1045   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |
