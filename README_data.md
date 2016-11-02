Test Ecomm Service

1. http://localhost:8090/shoppingcartservice/v1/cart

{
  "content": [
    {
      "id": 1,
      "cartTotalValue": 39.99,
      "cartDate": "2016-10-24",
      "cartItems": [],
      "rating": 4,
      "cartProducts": []
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 30,
  "number": 0,
  "sort": null,
  "first": true,
  "numberOfElements": 1
}

2. Create User

http://localhost:8090/userservice/v1/users

{
  	"firstName": "Varun",
    "lastName": "Sharma",
    "creditAmount": 50000,
    "bonusPoints": 10000,
    "memberSince": "2016-10-30",
    "addresses": [
        {
            "streetAddress": "Pebblestone",
            "state": "IL",
            "city": "Naperville",
            "zipCode": "60565",
            "country": "USA"
        }
    ],
    "rating": 7
}

3. PUT Body

http://localhost:8090/userservice/v1/users/5

{
    "id":5,
  	"firstName": "Manaswini Jhilik",
    "lastName": "Datta",
    "creditAmount": 50000,
    "bonusPoints": 10000,
    "memberSince": "2016-10-29",
    "addresses": [
        {
            "streetAddress": "Pebblestone",
            "state": "IL",
            "city": "Naperville",
            "zipCode": "60565",
            "country": "USA"
        }
    ],
    "rating": 7
}

4. DELETE

http://localhost:8090/userservice/v1/users/6


Cart Service

1. GET	    http://localhost:8090/shoppingcartservice/v1/cart

{
  "content": [
    {
      "id": 1,
      "user": {
        "id": 2,
        "firstName": "David",
        "lastName": "Jackson",
        "creditAmount": 50000,
        "bonusPoints": 10000,
        "memberSince": "2016-10-14",
        "addresses": [
          {
            "id": 2,
            "streetAddress": "Main Street",
            "state": "IL",
            "city": "Weaton",
            "zipCode": "60541",
            "country": "USA"
          }
        ],
        "rating": 7
      },
      "cartTotalValue": 37,
      "cartDate": "2016-10-31",
      "cartItems": [
        {
          "id": 1,
          "product": {
            "id": 1,
            "productName": "Shirt",
            "productShortDescription": "Shirt",
            "productLongDescription": "Mens Shirt",
            "imageUrl": "abc",
            "productType": "formalwear",
            "productPrice": 18.99
          },
          "quantity": 1
        }
      ],
      "rating": 7
    },
    {
      "id": 5,
      "user": {
        "id": 2,
        "firstName": "David",
        "lastName": "Jackson",
        "creditAmount": 50000,
        "bonusPoints": 10000,
        "memberSince": "2016-10-14",
        "addresses": [
          {
            "id": 2,
            "streetAddress": "Main Street",
            "state": "IL",
            "city": "Weaton",
            "zipCode": "60541",
            "country": "USA"
          }
        ],
        "rating": 7
      },
      "cartTotalValue": 68,
      "cartDate": "2016-09-30",
      "cartItems": [
        {
          "id": 3,
          "product": {
            "id": 1,
            "productName": "Shirt",
            "productShortDescription": "Shirt",
            "productLongDescription": "Mens Shirt",
            "imageUrl": "abc",
            "productType": "formalwear",
            "productPrice": 18.99
          },
          "quantity": 2
        },
        {
          "id": 2,
          "product": {
            "id": 2,
            "productName": "Trousar",
            "productShortDescription": "Trousar",
            "productLongDescription": "Mens Trousar",
            "imageUrl": "abc",
            "productType": "formalwear",
            "productPrice": 18.99
          },
          "quantity": 2
        }
      ],
      "rating": 7
    }
  ],
  "last": true,
  "totalElements": 2,
  "totalPages": 1,
  "size": 30,
  "number": 0,
  "sort": null,
  "numberOfElements": 2,
  "first": true
}

2. POST	   http://localhost:8090/shoppingcartservice/v1/cart

{
    "user": {
        "id": 1,
        "firstName": "Binit",
        "lastName": "Datta",
        "creditAmount": 100000,
        "bonusPoints": 50000,
        "memberSince": "2016-11-01",
        "addresses": [],
        "rating": 7
    },
    "cartTotalValue": 38,
    "cartDate": "2016-11-01",
    "cartItems": [
        {
            "product": {
                "id": 2,
                "productName": "Trousar",
                "productShortDescription": "Trousar",
                "productLongDescription": "Mens Trousar",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 17.99
            },
            "quantity": 1
        },
        {
            "product": {
                "id": 1,
                "productName": "Shirt",
                "productShortDescription": "Shirt",
                "productLongDescription": "Mens Shirt",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 17.99
            },
            "quantity": 1
        }
    ],
    "rating": 7
}


3. PUT	  http://localhost:8090/shoppingcartservice/v1/cart/5

{
    "id":5,
  	"user": {
        "id": 2,
        "firstName": "Binit",
        "lastName": "Datta",
        "creditAmount": 100000,
        "bonusPoints": 50000,
        "memberSince": "2016-10-01",
        "addresses": [],
        "rating": 7
    },
    "cartTotalValue": 68,
    "cartDate": "2016-10-01",
    "cartItems": [
        {
          	"id":2,
            "product": {
                "id": 2,
                "productName": "Trousar",
                "productShortDescription": "Trousar",
                "productLongDescription": "Mens Trousar",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 17.99
            },
            "quantity": 2
        },
        {
            "id": 3,
          	"product": {
                "id": 1,
                "productName": "Shirt",
                "productShortDescription": "Shirt",
                "productLongDescription": "Mens Shirt",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 17.99
            },
            "quantity": 2
        }
    ],
    "rating": 7
}

DELETE : http://localhost:8090/shoppingcartservice/v1/cart/5

Order Service

1. GET http://localhost:8090//orderingservice/v1/order

{
  "content": [
    {
      "id": 1,
      "user": {
        "id": 2,
        "firstName": "David",
        "lastName": "Jackson",
        "creditAmount": 50000,
        "bonusPoints": 10000,
        "memberSince": "2016-10-14",
        "addresses": [
          {
            "id": 2,
            "streetAddress": "Main Street",
            "state": "IL",
            "city": "Weaton",
            "zipCode": "60541",
            "country": "USA"
          }
        ],
        "rating": 7
      },
      "orderTotalValue": 70,
      "orderDate": "2016-11-01",
      "orderItems": [
        {
          "id": 2,
          "product": {
            "id": 2,
            "productName": "Trousar",
            "productShortDescription": "Trousar",
            "productLongDescription": "Mens Trousar",
            "imageUrl": "abc",
            "productType": "formalwear",
            "productPrice": 18.99
          },
          "quantity": 2,
          "unitPrice": 18.99
        },
        {
          "id": 1,
          "product": {
            "id": 1,
            "productName": "Shirt",
            "productShortDescription": "Shirt",
            "productLongDescription": "Mens Shirt",
            "imageUrl": "abc",
            "productType": "formalwear",
            "productPrice": 18.99
          },
          "quantity": 2,
          "unitPrice": 18.99
        }
      ],
      "rating": 7
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 30,
  "number": 0,
  "first": true,
  "sort": null,
  "numberOfElements": 1
}

2. POST	  http://localhost:8090//orderingservice/v1/order

{
    "user": {
        "id": 2,
        "firstName": "David",
        "lastName": "Jackson",
        "creditAmount": 50000,
        "bonusPoints": 10000,
        "memberSince": "2016-10-14",
        "addresses": [
            {
                "id": 2,
                "streetAddress": "Main Street",
                "state": "IL",
                "city": "Weaton",
                "zipCode": "60541",
                "country": "USA"
            }
        ],
        "rating": 7
    },
    "orderTotalValue": 70,
    "orderDate": "2016-11-01",
    "orderItems": [
        {
            
            "product": {
                "id": 2,
                "productName": "Trousar",
                "productShortDescription": "Trousar",
                "productLongDescription": "Mens Trousar",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 18.99
            },
            "quantity": 2,
            "unitPrice": 18.99
        },
        {
            
            "product": {
                "id": 1,
                "productName": "Shirt",
                "productShortDescription": "Shirt",
                "productLongDescription": "Mens Shirt",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 18.99
            },
            "quantity": 2,
            "unitPrice": 18.99
        }
    ],
    "rating": 7
}

3. PUT http://localhost:8090//orderingservice/v1/order/2

{
    "id":2,
  	"user": {
        "id": 2,
        "firstName": "David",
        "lastName": "Jackson",
        "creditAmount": 50000,
        "bonusPoints": 10000,
        "memberSince": "2016-10-14",
        "addresses": [
            {
                "id": 2,
                "streetAddress": "Main Street",
                "state": "IL",
                "city": "Weaton",
                "zipCode": "60541",
                "country": "USA"
            }
        ],
        "rating": 7
    },
    "orderTotalValue": 78,
    "orderDate": "2016-11-01",
    "orderItems": [
        {
            "id":3,
            "product": {
                "id": 2,
                "productName": "Trousar",
                "productShortDescription": "Trousar",
                "productLongDescription": "Mens Trousar",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 18.99
            },
            "quantity": 3,
            "unitPrice": 18.99
        },
        {
            "id":4,
            "product": {
                "id": 1,
                "productName": "Shirt",
                "productShortDescription": "Shirt",
                "productLongDescription": "Mens Shirt",
                "imageUrl": "abc",
                "productType": "formalwear",
                "productPrice": 18.99
            },
            "quantity": 3,
            "unitPrice": 18.99
        }
    ],
    "rating": 7
}

4. DELETE http://localhost:8090//orderingservice/v1/order/2
Useful

https://github.com/hellokoding/jpa-onetomany-springboot-maven-mysql

https://hellokoding.com/jpa-one-to-many-relationship-mapping-example-with-spring-boot-maven-and-mysql/

http://www.mysqltutorial.org/mysql-on-delete-cascade/

http://www.objectdb.com/api/java/jpa/OneToMany
https://vladmihalcea.com/2015/03/05/a-beginners-guide-to-jpa-and-hibernate-cascade-types/
http://www.oracle.com/technetwork/middleware/ias/toplink-jpa-annotations-096251.html
http://www.techferry.com/articles/hibernate-jpa-annotations.html#OneToMany

ActiveMQ Spring Tutorial

1. http://briansjavablog.blogspot.com/2012/09/spring-jms-tutorial-with-activemq.html

https://github.com/briansjavablog/spring-jms-activemq-tutorial

http://www.jakubkorab.net/2011/11/understanding-activemq-broker-networks.html

http://www.source4code.info/2014/11/jms-publish-subscribe-messaging-example-activemq-maven.html

https://github.com/source4code/repo/tree/master/jms-activemq-publish-subscribe

*******************************************
VIP : http://websystique.com/spring/spring-4-jms-activemq-example-with-annotations/

http://websystique.com/spring-4-tutorial/

Spring Boot JMS

http://xpadro.blogspot.com/2015/04/configure-spring-jms-application-with.html

VIP http://javasampleapproach.com/spring-framework/spring-boot/use-spring-jms-activemq-jms-consumer-jms-producer-spring-boot

RabbitMQ Spring

1. http://krams915.blogspot.com/2011/03/spring-integration-2-integrating.html

2. http://krams915.blogspot.com/2011/09/spring-mvc-integrating-mysql-mongodb_8914.html