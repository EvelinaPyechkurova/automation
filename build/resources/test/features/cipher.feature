Feature: Cipher encoding and decoding

  Scenario Outline: Encode text using Caesar Cipher
    Given a shift of <shift>
    When the text "<text>" is encoded
    Then the encoded result should be "<encoded>"

    Examples:
      | shift | text            | encoded          |
      | 1     | abc             | bcd              |
      | 3     | xyz             | abc              |
      | 5     | Hello, World!   | Mjqqt, Btwqi!    |

  Scenario Outline: Decode text using Caesar Cipher
    Given a shift of <shift>
    When the text "<encoded>" is decoded
    Then the decoded result should be "<text>"

    Examples:
      | shift | encoded         | text             |
      | 1     | bcd             | abc              |
      | 3     | abc             | xyz              |
      | 5     | Mjqqt, Btwqi!   | Hello, World!    |