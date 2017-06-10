Feature: Read policies
  As a policy maker
  I want to get all the policies available in the system
  So I can browse them/

  Scenario: Can get all policies
    Given a policy "policy1"
    When get all policies
    Then I receive 1 policy
    And its name is "policy1"
