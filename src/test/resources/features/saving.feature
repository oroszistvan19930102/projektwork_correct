Feature: New Saving
  Background:
    Given the user is loged in to the Digital Bank System
    And the user navigates to "Saving" in the left menu
    And the user selects "New Saving" form the drop down menu

  Rule: User with successful saving creation see the newly created saving
    Scenario Outline: Successful saving creation
      When the user selects a "Saving Account Type" "<accountType>" and an "Account Ownership" "<ownership>"
      And the user types an "Account Name" "<accountName>" and an "Initial Deposit Amount" "<depositAmount>"
      And the user clicks on the "Submit" button
      Then the "View Saving Accounts" page should be displayed
      And a confirmation message should be displayed

      Examples:
        | accountType     | ownership     | accountName      | depositAmount     |
        | Savings         | Individual    | MySaving1        | 100               |
        | Savings         | Joint         | MySaving2        | 500               |
        | Money Market    | Individual    | MySaving3        | 1000              |
        | Money Market    | Joint         | MySaving4        | 2000              |

  Rule: User with successful saving creation see an error message
    Scenario Outline: Unsuccessful saving creation
      When the user selects a "Saving Account Type" "<accountType>" and an "Account Ownership" "<ownership>"
      And the user types an "Account Name" "<accountName>" and an "Initial Deposit Amount" "<depositAmount>"
      And the user clicks on the "Submit" button
      Then an error message should be displayed

      Examples:
        | accountType     | ownership     | accountName           | depositAmount    |
        | Savings         | Individual    | MyWrongSaving1        | 1                |
        | Savings         | Joint         | MyWrongSaving2        | 5                |
        | Money Market    | Individual    | MyWrongSaving3        | 10               |
        | Money Market    | Joint         | MyWrongSaving4        | 20               |
