Feature: scenario1

Scenario: defenition of client
Given create the client
When set address to client as "Brest"
When get message from client
Then the message should be "I'm from Brest"


Scenario: defenition of client
Given create the client
Given the template is "Hello from Brest"
When set address to client as "Brest"
When the mailserver is created
When the templateEngine is created
Then generating template "SEND TO: Brest MESSAGE: Hello from Brest"




