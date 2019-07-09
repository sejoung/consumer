### 모니터링을 위한 컨슈머 프로젝트

* [kafka quickstart](https://kafka.apache.org/quickstart)

```
bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

```