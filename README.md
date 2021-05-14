# Chatobotto-server
A backend web-socket-based chat application implemented in Springboot. Intended to be small project to play around with web sockets. 
Minimal security on the application means it is not yet suited for deployment. I hope you have fun with it as I have enjoyed creating it :)
The corresponding client can be found at [Chatobotto-client](https://github.com/Tsoyuzhu/chatobotto-client).

# Features
* Unique otaku-themed usernames enforced on the server-side. Usernames collated by scouring the internet. 
* Randomly selected chat colours for clients
* Unique and randomly selected messages on client connection and client disconnection
* Anime themed. Extremely cringey. Made with much love for all my tomodachis. 

# Requirements
* Java 8
* Maven

# Quickstart
The server can be started using the maven executable:
`./mvnw spring-boot:run`

Alternatively, the .jar can be compiled using:
`./mvnw clean package`

And executed using:
`java -jar target/chatobotto-{VERSION}.jar` where {VERSION} is the maven project version.

Please see [Chatobotto-client](https://github.com/Tsoyuzhu/chatobotto-client) for instructions on launching the client.
