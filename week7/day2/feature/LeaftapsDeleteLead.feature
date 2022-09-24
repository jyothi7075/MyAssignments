Feature: Leaftaps Delete Lead

Scenario Outline: TC004 Delete Lead

Given launch the browser
And Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on phone and enter phone number as <phone>
And click on find leads button.
And Capture lead ID of First Resulting lead and click
And click Delete
And Click Find leads
And Enter captured lead ID
And Click find leads button
And verify message
And close the browser.

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|phone|
|'99'|
