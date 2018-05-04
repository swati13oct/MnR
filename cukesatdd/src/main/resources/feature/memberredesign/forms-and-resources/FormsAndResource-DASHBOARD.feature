@dashBoardFormsAndResources @gladiators
Feature: G1.1 To validate forms and resources page in dashboard site

  @fnrvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    #And the user verifies that the correct pdfs are coming
    # | BENEFIT-HIGHLIGHT | SUMMARY-OF-BENEFIT | EVIDENCE OF COVERAGE | UNITED HEALTH PASSPORT PROGRAM |COMPREHENSIVE FORMULARY |PRIOR AUTHORIZATION |
    # |
    And the user changes the laguage in the language dropdown
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that My document section is displayed
    When the user clicks on the Search Documents button the user is navigated to the MyDocuments page
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And both the Pharmacy locator and provider search links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType         |
      | MAPD     | IndAARPPharmacyFnR |

  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And click on the forms and resource link and navigate to forms and resource page for active member
    Then validate plan materials section
    And for active member both the links are displayed
    Then validate the anoc section
      | ANOC_SECTION | <Anoc_section> |
    Then validate the annual directories section
      | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
      | PROVIDER_SEARCHLINK        | <Provider_Searchlink>      |
      | PHARMACY_SEARCHLINK        | <Pharmacy_Searchlink>      |
    Then validate EOB section
      | EOB_MEDICAL_LINK | <EOBMedicalLinkVisible> |
      | EOB_DRUG_LINK    | <EOBDrugLinkVisible>    |
    And validate my document section
      | MY_DOCUMENT_SECTION | <MyDocumentVisible> |
    And validate that the forms and resources section is displayed
    And validate renew magazine section
      | RENEW_MAGAZINE_SECTION | <RenewMagazineVisible> |

    Examples: 
      | planType       | memberType | Anoc_section | AnnualDirectoriesSection | Provider_Searchlink | Pharmacy_Searchlink | EOBMedicalLinkVisible | EOBDrugLinkVisible | MyDocumentVisible | RenewMagazineVisible |
      # mauhc
      | MAPD           | Individual | NO           | NO                       | NO                  | NO                  | YES                   | NO                 | YES               | YES                  |
      # mapdaarp
      | q1_aarp_feb197 | Password@1 | YES          | YES                      | YES                 | YES                 | YES                   | YES                | YES               | YES                  |
      #pdpuhc
      | q1_feb_uhc202  | Password@1 | NO           | NO                       | NO                  | NO                  | NO                    | YES                | YES               | NO                   |
      #magroup
      | q1_grp_feb053  | Password@1 | NO           | NO                       | NO                  | NO                  | YES                   | NO                 | YES               | YES                  |
      #ssup
      | q1_grp_feb528  | Password@1 | NO           | NO                       | NO                  | NO                  | NO                    | NO                 | YES               | NO                   |

  @activememberscenario
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And click on the forms and resource link and navigate to forms and resource page for active member
    Then validate plan materials section
    And for active member both the links are displayed
    And clicking on the order plan materials link the user is navigated back to the forms and resources page
    And clicks on the view temporary id card link

    Examples: 
      | userId         | password   |
      # uhc
      | q1_aarp_feb197 | Password@1 |

  @terminatedmembervalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And for terminated member order plan materials link is not displayed
    And Renew Magazine section is not displayed for termibated members

    Examples: 
      | planType | memberType      |
      # uhc
      | MA       | TerminatedGroup |

  @shipscenario
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate plan materials section
    And for active member both the links are displayed
    And validate that the EOB statemnets section is displayed
    And validate that the forms and resources section is displayed

    Examples: 
      | userId         | password   |
      # uhc
      | q1_ship_feb239 | Password@1 |
