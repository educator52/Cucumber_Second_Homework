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
    Then I fill the order form and confirm
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum |          | Albert Einstein  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
    And I confirm Error in Quantity and click reset
    Then I fill the order form and confirm
      | Product     | Quantity | CostumerName     | Street          | City         | State   | Zip   | CardType        | CardNo     | Exp.Date |
      | FamilyAlbum | 3        |                  | Bahnhofstr. 30  | Weissenthurm | Germany | 56575 | Visa            | 0123456789 | 03/22    |
    And I confirm Error in CostumerName and click reset



#  Fill the order form (button is on the left side)
#
#  Create a all the negative scenarios. (For example do not enter the customer name )
#
#  Test all possible options.
#
#    And verify order is not created.