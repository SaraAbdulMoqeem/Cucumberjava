//Feature: Login Logout Functionality

  //Scenario Outline: Check login logout is successful
    Given user logs in with "<email>" and "<password>"
    Then user logs out

 // Examples:
   | email                  | password |
   | sarah.moqeem@gmail.com | Abdullah1! |