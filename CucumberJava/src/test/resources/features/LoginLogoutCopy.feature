#This feature describes login log out behaviour

Feature:

Scenario Outline: Check login logout is successful

Given browser is open
And user is on the login page
When user enters "<email>" and "<password>"
And clicks enter
When user clicks logout
Then user is on the home page



Examples:

| email | password |
| sarah.moqeem@gmail.com | Abdullah! |