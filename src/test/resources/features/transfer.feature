Feature: Transfer
  Background:
    Given the user is loged in to the Digital Bank System

  @successful_transfer_between_accounts
  Rule: After successful transfer the transaction details should be displayed
    Scenario Outline: Successful transfer
      When the user navigates to transaction between
      And the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the amount "<Target Amount>"
      And the user allows the transaction
      Then the transfer details "<Target Account>" should be displayed

      Examples:
        | Source Account  | Target Account   | Target Amount    |
        | MyChecking1     | MySaving2        | 500.05           |
        | MySaving3       | MyChecking2      | 130.00           |

  @unsuccessful_transfer_between_accounts_too_high_amount
  Rule: If the transfer amount is bigger than the amount on the source account a warning message should be displayed
    Scenario Outline: Unsuccessful transfer
      When the user navigates to transaction between
      And the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the amount "<Target Amount>"
      And the user allows the transaction
      Then a warning message should be displayed

      Examples:
        | Source Account  | Target Account   | Target Amount       |
        | MyChecking1     | MySaving2        | 500000.05           |
        | MySaving3       | MyChecking2      | 130000.00           |

  @unsuccessful_transfer_between_accounts_same_source_target_account
  Rule: If the source and target accounts are the same a warning message should be displayed
    Scenario Outline: Unsuccessful transfer regarding same source and target accounts
      When the user navigates to transaction between
      And the user selects the source account "<Source Account>"
      And the user selects the target account "<Target Account>"
      And the user types the amount "<Target Amount>"
      And the user allows the transaction
      Then a warning message should be displayed

      Examples:
        | Source Account  | Target Account | Target Amount    |
        | MyChecking1     | MyChecking1    | 500.05           |
        | MySaving3       | MySaving3      | 130.00           |