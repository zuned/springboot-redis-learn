# Setup redis-cli on AWS EC2

SSH into your EC2 instance. Run the following:

`$ sudo yum install gcc` This may return an "already installed" message. That's OK.

`$ wget http://download.redis.io/redis-stable.tar.gz && tar xvzf redis-stable.tar.gz && cd redis-stable && make `

See: http://docs.aws.amazon.com/AmazonElastiCache/latest/UserGuide/GettingStarted.ConnectToCacheNode.Redis.html

Since we have TLS enable so we have to create tunnel to connect with server our secure channel https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/in-transit-encryption.html#connect-tls

once done we are able connect to awselastic cache using [redis-demo](https://github.com/zuned/springboot-redis-learn/tree/main/springboot-redis-jedis) through with host localhost and password as provided.
