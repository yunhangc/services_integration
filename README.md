# services_integration
This project integrates different types of micro-services based on Kafka and MongoDB

## How does it work?
This is the central hub for integration of all different micro-services for building a micro-service type of application. 

1. Kafka consumers can be added to the hub with the url to a micro-service to call when a new message is consumed from the queue.
2. A micro-service subscribes to the hub with the consumer name and a call back URL. 
3. when a message is pushed to kafka queue, the hub consume the message and find out which subscriber is the message for.
4. the hub will loop through all the services the hub subscribes and post the message/object to all the url/microservices it subscribes to; after each post, the hub will also invoke the call back url in the subscription.
