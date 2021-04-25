Feature: Simple examples of how dataTables work2
@datatable
  Scenario: User should be able to see all 12 month
    Given User is on the dropdowns page of practice tool
    Then User see below info in month dropdown
    |January|
    |February|
    |March|
    |April|
    |May|
    |June|
    |July|
    |August|
    |September|
    |October|
    |November|
    |December|