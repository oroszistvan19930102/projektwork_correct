Feature: New Checking
  Background:
    Given the user is loged in to the Digital Bank System
    And the user navigates to "Checking" in the left menu
    And the user selects "New Checking" form the drop down menu

  Rule: User with successful checking creation see the newly created check
    Scenario Outline: Successful checking creation
      When the user selects a "Checking Account Type" "<accountType>" and an "Account Ownership" "<ownership>"
      And the user types an "Account Name" "<accountName>" and an "Initial Deposit Amount" "<depositAmount>"
      And the user clicks on the "Submit" button
      Then the "View Checking Accounts" page should be displayed
      And a confirmation message should be displayed

      Examples:
        | accountType | ownership     | accountName      | depositAmount     |
        | Standard    | Individual    | MyChecking1      | 100               |
        | Standard    | Joint         | MyChecking2      | 500               |
        | Interest    | Individual    | MyChecking3      | 1000              |
        | Interest    | Joint         | MyChecking4      | 2000              |

  Rule: User with unsuccessful checking creation see an error message
    Scenario Outline: Unsuccessful checking creation
      When the user selects a "Checking Account Type" "<accountType>" and an "Account Ownership" "<ownership>"
      And the user types an "Account Name" "<accountName>" and an "Initial Deposit Amount" "<depositAmount>"
      And the user clicks on the "Submit" button
      Then an error message should be displayed

      Examples:
        | accountType | ownership     | accountName           | depositAmount    |
        | Standard    | Individual    | MyWrongChecking1      | 1                |
        | Standard    | Joint         | MyWrongChecking2      | 5                |
        | Interest    | Individual    | MyWrongChecking3      | 10               |
        | Interest    | Joint         | MyWrongChecking4      | 20               |
