Feature: register new users



  @registerNewUserUI
  Scenario Outline: Register new users for GMI Bank
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    Then user enters firstname and lastname as "<firstname>" and "<lastname>"
    When user provides address "<address>"
    Then user provides mobilephone as "<mobilephone>"
    And user provides a username "<username>"
    Then user provides email id as "<email>"
    When user enters the password as "<firstpassword>"
    And user confirms the new password "<secondpassword>"
    Then user clicks on register button and sees the success message as "<message>"


    Examples:
      |SSN|firstname|lastname|address|mobilephone|username|email|firstpassword|secondpassword|message|
#    |393-45-5678|newUser|lastbatch|Milky way|456-679-5588|utilisateur|kalin54@gmail.com|Utilisateur123.|Utilisateur123.|successfully registered|
      |333-45-2345|Ben|Student|Long Island|689-345-2354|StakeHolder|stakeholder@gmail.com|stakeholder[1].|stakeholder[1].|successfully registered|