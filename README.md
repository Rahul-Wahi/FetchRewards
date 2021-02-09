# FetchRewards - Web service
# Tech Stack
1. Java (11+)
2. Maven
3. SpringBoot

# End Points
1. *Add points: POST http://localhost:8080/points/add
1. Deduct Points: PUT http://localhost:8080/points/deduct
1. Get Balance: http://localhost:8080/points/balance
1. Get Transactions: http://localhost:8080/points/transactions

### API Resources

  - [GET /balance](#get-balance)
  - [GET /transacations](#get-transactions)
  - [POST /add](#post-add)
  - [PUT /deduct](#put-deduct)

### GET /balance

Example: http://localhost:8080/points/balance

Response body:

    [
    {
        "payer": "Uniliver",
        "balance": 200
    },
    {
        "payer": "dannon",
        "balance": 300
    }
]

### GET /transactions

Example: http://localhost:8080/points/transactions

Response body:

    [
    {
        "id": 1,
        "payer": "dannon",
        "points": 300,
        "transactionDate": "2021-02-09 00:36:42"
    },
    {
        "id": 2,
        "payer": "Uniliver",
        "points": 200,
        "transactionDate": "2021-02-09 00:37:00"
    }
]



### POST /add

Example: Create – POST  http://localhost:8080/points/add

Request body:

      {
        "payer": "Uniliver",
        "points":200
      }
       

Response body:

    {
    "message": "Successfully added Points",
    "point": {
        "id": 2,
        "payer": "Uniliver",
        "points": 200,
        "transactionDate": "2021-02-09 00:37:00"
      }
    }


### PUT /deduct

Example: Create – POST  http://localhost:8080/points/deduct

Request body:

      {
        "points" :200
      }
       

Response body:

    [
    {
        "id": 3,
        "payer": "dannon",
        "points": -200,
        "transactionDate": "2021-02-09 00:44:12"
    }
    ]

