Feature: Transfer
  Background:
    Given the user is loged in to the Digital Bank System
    And the user navigates to "Transfer Between" in the left menu

  Rule: After successful transfer the transaction details should be displayed
    Scenario Outline: Successful transfer
      When the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the transfer amount "<Transfer Amount>"
      And the user clicks on the "Submit" button
      Then the transfer details should be displayed

      Examples:
        | Source Account  | Target Account   | Target Amount    |
        | MyChecking1     | MySaving2        | 500.05           |
        | MySaving3       | MyChecking2      | 130.00           |

  Rule: If the transfer amount is bigger than the amount on the source account a warning message should be displayed
    Scenario Outline: Unsuccessful transfer
      When the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the transfer amount "<Transfer Amount>"
      And the user clicks on the "Submit" button
      Then a warning message should be displayed

      Examples:
        | Source Account  | Target Account   | Target Amount       |
        | MyChecking1     | MySaving2        | 500000.05           |
        | MySaving3       | MyChecking2      | 130000.00           |

  Rule: If the source and target accounts are the same a warning message should be displayed
    Scenario Outline: Unsuccessful transfer regarding same source and target accounts
      When the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the transfer amount "<Transfer Amount>"
      And the user clicks on the "Submit" button
      Then a warning message should be displayed

      Examples:
        | Source Account  | Target Account | Target Amount    |
        | MyChecking1     | MyChecking1    | 500.05           |
        | MySaving3       | MySaving3      | 130.00           |