# FetchRewards - Web service
## Tech Stack
1. Java (11+)
1. Maven
1. SpringBoot

## Pre-requisite
1. JDK 11, [Install JDK](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
1. Maven, [Install Maven](http://maven.apache.org/install.html)

## Steps to Run
1. git clone https://github.com/Rahul-Wahi/FetchRewards
1. cd FetchRewards
1. mvn spring-boot:run

## My Development Environment
1. Windows 10 OS 
1. Java version 11.0.9
1. Apache Maven version 3.6.2

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
        "balance": 400
    },
    {
        "payer": "dannon",
        "balance": 100
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
    },
    {
        "id": 3,
        "payer": "dannon",
        "points": -200,
        "transactionDate": "2021-02-09 00:44:12"
    },
    {
        "id": 4,
        "payer": "Uniliver",
        "points": 200,
        "transactionDate": "2021-02-09 00:46:36"
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

