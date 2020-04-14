Feature: To Validate the Search option in Advance screen

Enter some data in the chat box which has less than 100 characters in the text to validate chat

  #EA - 63, 18, 39, 20, 148
  @Automation @EA-63 
  Scenario: Validating Search button in Trade Capture/Advance
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    Then user clicks on "Trade Capture" option
    Then user select the "Advance" option
    And user verify "Untitled" with title in advance
    Then user select 'ST-FIX' from "Product" textbox under "Key Attributes"
    Then user select 'BANK OF NY' from "Member" textbox under "Key Attributes"
    When user right click under "TradingEvents" section
    Then user click on +Add option
    #Then user enters "05/17/2018" in "Valuation Date" textbox under "Analytics"
    #Then User click on "CALCULATE" button under "Analytics"
    And user click on 'Save' in "Dots" menu under "Key Attributes"
    Then user validate status as "DRAFT"
    And user click on 'Execute' in "Dots" menu under "Key Attributes"
    Then user validate status as "DONE"
    And user click on 'ConfirmWMember' in "Dots" menu under "Key Attributes"
    Then user validate status as "CONFIRMED"
    And user click on 'Verify' in "Dots" menu under "Key Attributes"
    Then user validate status as "Verified"
    And user click "chat" button in Advance
    And user enters some "Enter some data in the chat box which has less than 100 characters in the text to validate chat" words below "100" characters
    #And user click "Attachment"
    And user click "Send" options
    And user verify "notifications" in the above chatbox
    And user click "chat" button to close window
    