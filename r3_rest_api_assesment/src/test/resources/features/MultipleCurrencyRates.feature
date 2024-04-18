






@dev @stage
@r3_api_regression
Feature: As a QE, I want to validate the API "v6/latest/USD" for multiple currency rates

  Scenario: Validate the API "v6/latest/USD" returns success response and its valid price
    GIVEN I call the API with the endpoint "v6/latest/USD"
    AND the response status should be 200

