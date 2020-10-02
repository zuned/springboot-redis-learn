## Redis-spring-learn
- Redis is powerful open source , noSql , inMemory Database.
- Store Data in key-value format
- Master Slave Replication
- Redis has Lua Scripting Language Support

## Redis Usage In Web-Application
- User Session Management
- Caching
- Pub/Sub [ Queues & Notification ]
- LeaderBoard For Gaming App
- GeoSpatial

***
### ACID 
### Vertical Scaling vs Horizontal Scaling
### Sql Vs NoSql
***
## Installing Redis on Widnows 
- Redis Project Doesn't officially Support windows, however microsoft integrated give alternative
- [Click Here to download Redis for windows](https://github.com/ServiceStack/redis-windows/tree/master/downloads)
- Extract Zip File And Execute **redis-server** and **redis-cli**
- [For How to download Redis for Mac/Linux click here](https://redis.io/download)
- [To Learn Redis Cloud Please click here and Register to get free redis cloud access](https://app.redislabs.com/#/login)
- [To access redis using GUI tool click here](https://docs.redisdesktop.com/en/latest/install/)

### Redis Data Types [To Know more click here to see documentation](https://redis.io/topics/data-types)
### Redis Commands [Click Here and Select Group to know all available command and there description](https://redis.io/commands)

- [Command to Get All the Keys using patterns](https://redis.io/commands/keys)

- to update key Only if key exist use additional parameter **XX**
- to add key Only if key does not exist use additional parameter **NX**
- TTL is used to specify time to live 
- Exist command is used to see if key exists or not
- OtherCommands [append , strlen , incr , incrby , decr , decrby , mget , mset ]
