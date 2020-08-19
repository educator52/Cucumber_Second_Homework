Feature: Second Homework

  Background: Login
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try to login in by username and password.

  Scenario: Successful the Part1 to complete.
    And I verify "8" items are displayed in the view all orders page
    Then I delete all items in the table
    And I verify item count is "0"

  Scenario: Successful the Part2 to complete.
    When I click on Order
    Then I fill the order form and confirm with 3 different product
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
      | ScreenSaver | 2        | Thomas Edison    | Devorastr. 10   | Koblenz      | Germany | 56400 | MasterCard      | 0987654321 | 01/21    |
      | MyMoney     | 5        | Nicola Tesla     | Am Gulser Weg 1 | Bassenheim   | Germany | 56100 | American Express| 2138472934 | 01/21    |
    And I click on View All Order button
    Then I verify my orders.
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
      | ScreenSaver | 2        | Thomas Edison    | Devorastr. 10   | Koblenz      | Germany | 56400 | MasterCard      | 0987654321 | 01/21    |
      | MyMoney     | 5        | Nicola Tesla     | Am Gulser Weg 1 | Bassenheim   | Germany | 56100 | American Express| 2138472934 | 01/21    |
    And I verified that the items count are increased in the view all orders page

  Scenario: Successful the Part3 to complete.
    When I click on Order
    Then I fill the order with all possible negative options form and I confirm error messages.
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType | CardNo     | Exp.Date |
      | FamilyAlbum |          | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 0        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        |                  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  |                 | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  |              | Germany | 56575 | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany |       | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | zip   | Visa     | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 |          | 0123456789 | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     |            | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | cardNo     | 03/22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 |          |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 03.22    |
      | FamilyAlbum | 3        | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa     | 0123456789 | 23/Sep   |
    And I verify order is not created.

  Scenario: Successful the Part4 to complete.
    Then I verify the data for the "Bob Feather"
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType | CardNo        | Exp.Date |
      |FamilyAlbum  |          |                  |14, North av.    |Milltown, WI  | US      |81734  |VISA      | 111222111222  |06/08 |