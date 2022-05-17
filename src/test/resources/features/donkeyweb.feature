Feature: Go DonkeyItTest and upload file

  @donkey
  Scenario: Upload a file in donkeyit page
    Given User opens the browser and goes the url
    When User uploads the file
    Then User should see uploaded file

  @donkeysize
  Scenario: Changing the size of file from configurations
    Given User opens the given browser
    When User clicks on conf page and changes the size
    And User uploads the changed size file
    Then User should upload bigger sized file than default

  @donkeytype
  Scenario: Adding new type of file to configurations
    Given User opens the browser
    When User clicks on conf page and adds the new file type
    And User uploads an empty file with txt format
    Then User should see an error





