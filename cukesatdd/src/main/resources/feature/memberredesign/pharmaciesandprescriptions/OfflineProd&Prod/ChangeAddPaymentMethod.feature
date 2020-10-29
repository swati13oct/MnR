Feature: Change or Add Payment Details 
To validate Change or Add Payment Details

	  @Regression
	  Scenario Outline: To verify Change or Add Payment Details
		Given the user is on member auth login flow page
		When the member is able to login with correct username and password
		  | Username | kjadha10 |
		  | Password | Free@123 |
		And Member Enters the Username he wants to search
		  | Member |
		  |        |
		And user clicks on member to select
		When user navigates to the pharmacies and prescriptions page from testharness page
		And user clicks View all medications link to view the My Medications page
		Then user will view the Refill All Medications CTA on MY Medications Page
 		When user select the Refill All Medications CTA
 		Then user will be brought to the "Complete Your Refill" page for that medication
 		When user view the Payment section
 		When user select Add Payment
 		Then user will view Add Payment in a full page modal