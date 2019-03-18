#Author:shiva
#created Date:2/12/2019
@testcase @Shopforaplan
Feature: Acq-To test request Mailed information with an agent flow in UHC site (GATED)

  @UHCshopforaplan
  Scenario Outline: Verify tools that help you choose a plan tools from the shop for a plan Drop down 
    Given the user is on the uhcmedicaresolutions site landing page
    And the user hovesr screen over the shop for a plan drop down
    When user enters the email address and click on the submit button
      | Email | <email> |
    Then user should be able to see the Message on the screen
      | Message | <message> |
    When user clicks on the plan selector tool from the shop for a plan drop down
    Then user should be able to see Get started button the plan selector screen
    When user clicks on the Drug cost estimator tool from the shop for plan drop down
    Then user should be able to see Cancel drug search button on the screen
    When user clicks on the pharmacy search tool from the shop for a plan drop down
    Then user should be able to see the choose a plan drop down
    When user clicks on the provider search tool from the shop for a plan drop down
    Then user should be able to see the zip code text box on the screen

    Examples: 
      | email          | message                                       |
      | test@optum.com | Your guide will arrive in your inbox shortly. |
