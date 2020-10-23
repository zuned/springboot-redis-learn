# Setup redis-cli on AWS EC2

SSH into your EC2 instance. Run the following:

`$ sudo yum install gcc` This may return an "already installed" message. That's OK.

`$ wget http://download.redis.io/redis-stable.tar.gz && tar xvzf redis-stable.tar.gz && cd redis-stable && make `

See: http://docs.aws.amazon.com/AmazonElastiCache/latest/UserGuide/GettingStarted.ConnectToCacheNode.Redis.html