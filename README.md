# Deutsche Bahn Case study - Distance Calculation of Two Stops
### frameworks & language
 - Java
 - Spring Boot
 - Maven

## Description 
If you apply for a **traineeship** position, this is an implementation of a case study from Deutsche Bahn. I attached a copy of the case study to the information file. The task is to set up a backend that calculates the distance between two railway stops. The Deutsche Bahn gives you a **CSV** file and expects a **JSON** object as a response. You can choose any framework and language, and they prefer Kotlin and Java. In my case, I used **MongoDB** as a database and the **Spring Boot** framework to implement and API. If you use **Atlas Cloudplatform** for your MongoDB database, you can easily upload all files using the **Compass GUI** ( [Link](https://www.mongodb.com/try/download/compass) ) instead of uploading them via the terminal. You can check the requests by using Postman  ( [Link](https://learning.postman.com/docs/sending-requests/requests/) ) . 

The password link for the MongoDB database is part of the .env file which is not uploaded to this repo due to security issues. Please use your own MongoDB database.

Good luck and may the force be with you !

# Server 

## MongodB Models
Railway station - stopsSchema
```

{
  Station information model
  EVA_NR: { type: String },
  DS100: { type: String },
  IFOPT: { type: String },
  NAME: { type: String },
  Verkehr: { type: String },
  Laenge: { type: String },
  Breite: { type: String },
  Betreiber_Name: { type: String },
  Status: { type: String },
}
```

## Backend

### Result router

| HTTP Method | URL            | Request Body                                                 | Success status | Error Status | Description                                                  |
| ----------- | -------------- | ------------------------------------------------------------ | -------------- | ------------ | ------------------------------------------------------------ |
| GET         | `/api/v1/distance/DS1/DS2     |  [NAME, DS100 Laenge, Breite ]                                                            | 200            | 404          | Get station information for calculation.           |
| GET         | `/api/v1/distance/stops     |                                                              | 200            | 404          | Get all stations.          |
| GET         | `/api/v1/distance/id     |                                                              | 200            | 404          | Get station by id.          |


 ## Mathematical model to calculate the distance
 You can use either the Haversine formula to find distance between two points on a sphere and implement it by yourself [Link](https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/) .
              
---
## Links
#### [Git repository](https://github.com/akolundzic/DBCaseStudyJava.git)
#### [CSV File Deutsche Bahn](https://data.deutschebahn.com/dataset/data-haltestellen.html#)












