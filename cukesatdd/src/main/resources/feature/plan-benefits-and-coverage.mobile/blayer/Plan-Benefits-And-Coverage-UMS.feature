@bnc-mobile
#For login use the LoginUmsStepDefinition along with LoginPage.java override the
Feature: To test my medical cost and benefit summary on UMS mobile site
  Scenario: Group MAPD  - My Medical Costs & Benefits Summary
    Given the user is on the UHC medicare site mobile login page
    Given "MAPD" user logs-in and lands on the Benefit Summary Page in UMS mobile site


  Scenario: Group MAPD-NONLIST Only - My Medical Costs & Benefits Summary
    Given the user is on the UHC medicare site mobile login page
    Given "MAPD-NONLIST" user logs-in and lands on the Benefit Summary Page in UMS mobile site

  Scenario: Group MA Only - My Medical Costs & Benefits Summary
    Given the user is on the UHC medicare site mobile login page
    Given "MA" user logs-in and lands on the Benefit Summary Page in UMS mobile site
