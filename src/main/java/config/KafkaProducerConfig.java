package config;


import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import java.util.Properties;

public class KafkaProducerConfig {

    public static Properties kafkaProperties = new Properties();

    private static Properties getKafkaProperties(){

        //访问地址
        kafkaProperties.setProperty("bootstrap.servers","192.168.2.100:9092");
        //请求响应方式
        kafkaProperties.setProperty("acks", "all");
        //请求失败重试次数
        kafkaProperties.setProperty("retries", "3");
        //指定key的序列化方式
        kafkaProperties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //指定value的序列化方式
        kafkaProperties.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        kafkaProperties.setProperty("metadata.broker.list","192.168.2.100:9092");

        kafkaProperties.setProperty("serializer.class", StringEncoder.class.getName());
        kafkaProperties.setProperty("compression.codec", "1");
        // 同步还是异步，默认2表同步，1表异步。异步可以提高发送吞吐量，但是也可能导致丢失未发送过去的消息
        //properties.put("producer.type", "sync");
        kafkaProperties.setProperty("zookeeper.connect", "192.168.2.100:2181");

        return kafkaProperties;
    }

    /**
     * 必须要使用kafka。javaAPi的producer对象
     * @return
     */
    public static Producer getKafkaProducer(){

        Producer producer = new Producer<String, String>(new ProducerConfig(getKafkaProperties()));

        return producer;
    }
}
