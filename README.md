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
- List Other Commands [ lrange , rpop , lpop , lpush ]
### Set 
	127.0.0.1:6379> sadd email e1 e2 e3 e4 e1
	(integer) 4
	127.0.0.1:6379> smembers email
	1) "e2"
	2) "e1"
	3) "e4"
	4) "e3"
	127.0.0.1:6379> scard email
	(integer) 4
	127.0.0.1:6379> sadd newEmail e4 e5 e6
	(integer) 3
	127.0.0.1:6379> sdiff email newEmail
	1) "e1"
	2) "e2"
	3) "e3"
	127.0.0.1:6379> sunion email newEmail
	1) "e2"
	2) "e4"
	3) "e3"
	4) "e6"
	5) "e5"
	6) "e1"
	127.0.0.1:6379> sinter email newEmail
	1) "e4"

### Ordered Set
	127.0.0.1:6379> zadd num 1 2 5 6 7 9 4 0
	(integer) 4
	127.0.0.1:6379> zadd randTest 1 abc 2 pqr 1 abd 14 zzz
	(integer) 4
	127.0.0.1:6379> zrange num 0 1
	1) "2"
	2) "0"
	127.0.0.1:6379> zrange num 0 -1
	1) "2"
	2) "0"
	3) "6"
	4) "9"
	127.0.0.1:6379> zrange randTest 0 -1
	1) "abc"
	2) "abd"
	3) "pqr"
	4) "zzz"
	127.0.0.1:6379> zadd randTest 1 klm
	(integer) 1
	127.0.0.1:6379> zrange randTest 0 -1
	1) "abc"
	2) "abd"
	3) "klm"
	4) "pqr"
	5) "zzz"
	127.0.0.1:6379> zcount randTest -inf +inf
	(integer) 5
	127.0.0.1:6379> zrank randTest klm
	(integer) 2
	127.0.0.1:6379> zscore randTest klm
	"1"
	127.0.0.1:6379> zadd test abc abc pqr pqr klm klm
	(error) ERR value is not a valid float

### Hash
	127.0.0.1:6379> hset student name zuned
	(integer) 1
	127.0.0.1:6379> hget student name
	"zuned"
	127.0.0.1:6379> hmset student name zuned gender male grade A
	OK
	127.0.0.1:6379> hmget student name gender and grade
	1) "zuned"
	2) "male"
	3) (nil)
	4) "A"
	127.0.0.1:6379> hgetall student
	1) "name"
	2) "zuned"
	3) "gender"
	4) "male"
	5) "grade"
	6) "A"
	127.0.0.1:6379> hexists student name
	(integer) 1
	127.0.0.1:6379> hkeys student
	1) "name"
	2) "gender"
	3) "grade"
	127.0.0.1:6379> hvals student
	1) "zuned"
	2) "male"
	3) "A"
	127.0.0.1:6379> hdel student grade
	(integer) 1
	127.0.0.1:6379> hlen student
	(integer) 2
	127.0.0.1:6379>

***
