@memberAuth
Feature: To test Member Auth Dashboard page.	

@memb
Scenario Outline: To validate the error message for invalid user name and correct password or viseversa.
Given the user is on member auth login page
Then the member tries to login with invalid username and correct password and verify the error message
|Username| <username>  |
|Password| <password>  |
| Error Message | <errormessage> |


  

Examples:
            |       username   |  password                    | errormessage                            |
            |       qavgogine  |   password            | Either your UserName or Password was incorrect.|
           # |       username   |   qavgogine           | Either your UserName or Password was incorrect.|