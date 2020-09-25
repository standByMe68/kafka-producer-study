package controller;


import config.KafkaConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaConsumerController {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        //往map中设置对应的主题和分区
        map.put("study",10);

        ConsumerConnector kafkaConsumer = KafkaConsumerConfig.getKafkaConsumer();
        Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = kafkaConsumer.createMessageStreams(map);

        List<KafkaStream<byte[], byte[]>> study = messageStreams.get("study");

        for (KafkaStream<byte[], byte[]> messageAndMetadata : study) {
            ConsumerIterator<byte[], byte[]> iterator = messageAndMetadata.iterator();

            while(iterator.hasNext()){

                MessageAndMetadata<byte[], byte[]> next = iterator.next();
                System.out.println("接受数据");

                System.out.println(next.message().toString());

                kafkaConsumer.commitOffsets();

            }

        }


    }

}
