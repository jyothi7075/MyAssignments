Feature: Leaftaps Merge Lead

Scenario Outline: TC005: Merge Lead

Given Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on Merge Leads
And click on first widget
And handle the windows
And enter first name 
And click on find leads button
And Capture lead ID of First Resulting lead and click
And click second widget
And handle the child window
And enter name 
And click on find leads button
And Capture lead ID of First Resulting lead and click
And back to parent window
And click on Merge Leads
And Click Find leads and Enter captured lead ID
And Click find leads button
And verify message

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
