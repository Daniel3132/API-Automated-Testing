## API Automated Testing - Bank Transactions

A Maven project to Test HTTP requests on a [mockapi.io](https://mockapi.io/) API
by simulating Clients of a bank

# Set up

1. Clone the repo
2. Run the suite.xml file 

The test order is mean to ensure all Test pass, but all should work property alone
while there is any data in endpoint.

There is a HTTP code response validation for all request.

### Post Test

    - Validate there is not data and post 10 clients
    - Check the clients to post doesn't have email duplicates 

### Getting Test
    - Get all clients 
    - Check there are no email duplicates 

### Delete Test 
    *AfterTest: Validate there is data in the endpoint  
    
    - Delete all clients
    - Check endpoint now has no data

### Update Test 
    - Get all clients
    - Pick one and modify its Account number
    - Update client with new Account number value


