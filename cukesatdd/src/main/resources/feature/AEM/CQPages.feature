@CQPages
Feature: To validate pages on AEM

  @CQAcqPages
  Scenario Outline: To validate Acquisition pages on AEM are loading
    Given the user is on the AEM login page and logs in
      | Username | <username> |
      | Password | <password> |
    And the user navigates to acquisition pages on AEM and validates

    Examples: 
      | username | password |
      | admin    | admin    |

  @CQMemberPages
  Scenario Outline: To validate Member pages on AEM are loading
    Given the user is on the AEM login page and logs in
      | Username | <username> |
      | Password | <password> |
    And the user navigates to member pages on AEM and validates

    Examples: 
      | username | password |
      | admin    | admin    |

  Scenario Outline: To validate AEM OLE pages are loading
    Given the user is on the AEM login page and logs in
      | Username | <username> |
      | Password | <password> |
    And the user navigates to ole pages on AEM and validates

    Examples: 
      | username | password |
      | admin    | admin    |

  Scenario Outline: To validate AEM VPP pages are loading
    Given the user is on the AEM login page and logs in
      | Username | <username> |
      | Password | <password> |
    And the user navigates to vpp pages on AEM and validates

    Examples: 
      | username | password |
      | admin    | admin    |

  Scenario Outline: To Validate AEM Data Layer for Static Pages
    Given the user login in AEM
      | Username | <username> |
      | Password | <password> |
    Then the user nagivates to Data Layer Page
    Then the user validates the static tab components
      | StaticURL | <staticurl> |

    @AEM_DataLayer
    Examples: 
      | username | password | staticurl                                       |
      #| admin    | admin    | /content/aarpmedicareplans/en/shop/compare/compare-ms    |
      | admin    | admin    | /content/aarpmedicareplans/en/medicare-articles |

  Scenario Outline: To Validate AEM Data Layer for Dynamic Pages
    Given the user login in AEM
      | Username | <username> |
      | Password | <password> |
    Then the user nagivates to Data Layer Page
    Then the user validates the Dynamic Apps tab components

    @AEM_DataLayer
    Examples: 
      | username | password |
      | admin    | admin    |


  Scenario Outline: To Validate AEM Data Layer for Header and Footer
    Given the user login in AEM
      | Username | <username> |
      | Password | <password> |
    Then the user nagivates to Data Layer Page
    Then the user validates the Header and Footer tab components

    @AEM_DataLayer
    Examples:
      | username | password |
      | admin    | admin    |