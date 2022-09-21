Feature: Service now create incident

Scenario Outline: TC001 Create incident

Given chrome browser is opened
And Load the application URL
And maximise and set the timeout
And Login with valid credentials username as <username> and password as <password>
And click All
And Click  Incidents in Filter navigator
And Click on Create new option and fill the mandatory fields
And Verify the newly created incident
And Confirm incident exists

Examples:
|username|password|
|'admin'|'Service@123'|

Scenario Outline: TC002 Edit an incident

Given chrome browser is opened
And Load the application URL
And maximise and set the timeout
And Login with valid credentials username as <username> and password as <password>
And click All
And Click  Incidents in Filter navigator
And Search for the existing incident and click on the incident
And Update the incident with Urgency as High and State as In Progress
And Verify the update information

Examples:
|username|password|
|'admin'|'Service@123'|


Scenario Outline: TC003 Delete incident

Given chrome browser is opened
And Load the application URL
And maximise and set the timeout
And Login with valid credentials username as <username> and password as <password>
And click All
And Click  Incidents in Filter navigator
And Delete the incident
And Verify the deleted incident

Examples:
|username|password|
|'admin'|'Service@123'|



