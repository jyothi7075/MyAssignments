Feature: Leaftaps automation

Scenario Outline: TC001-Create Lead 

Given Login with valid credentials username as <username> and password as <password>
And click on create lead
And enter company name as <cname> first name as <fname> and last name as <lname>
Then click submit button

Examples:
|username|password|cname|fname|lname|
|'Demosalesmanager'|'crmsfa'|'AOI'|'Kyathi'|'S'|