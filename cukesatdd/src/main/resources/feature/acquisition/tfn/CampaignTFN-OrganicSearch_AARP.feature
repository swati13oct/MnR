@tfnulayer
Feature: To test Campaign TFN in all flows on AARP site

  @Scenario6A @Campaign_Precedence_Logic @campaign
  Scenario Outline: -6.1 validating TFN from Home Page
    Given user visits AMP using Direct URL and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then coming from dircet url and navigate to medsup to varify TFN
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                               |
      | 1-877-699-5710 | 1-877-699-5710 | http://www.aarpmedicareplans.com/ |

  @Scenario6B_GoogleSearch @Campaign_Precedence_Logic @tfn_aarp
  Scenario Outline: - 6.2 Google and search AARP Medicare Advantage Plan
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP home page
    Then the user validates PSC code for AARP site
      | PSC Code | <pscCode> |

    Examples: 
      | pscCode |
      |  810106 |
