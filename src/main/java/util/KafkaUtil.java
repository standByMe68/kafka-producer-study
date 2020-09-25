package util;

import config.KafkaProducerConfig;
import kafka.producer.KeyedMessage;
import kafka.producer.Producer;

import java.util.ArrayList;
import java.util.List;

public class KafkaUtil {


    public static void send(List<String> datas){

        kafka.javaapi.producer.Producer<String, String> kafkaProducer = KafkaProducerConfig.getKafkaProducer();

        String topic = "study";

        List<KeyedMessage<String, String>> keyedMessages = new ArrayList<KeyedMessage<String, String>>();

        int count = 0;

        for (String data : datas) {
            count++;
            keyedMessages.add(new KeyedMessage<String, String>(topic,count+"",data));

        }
        kafkaProducer.send(keyedMessages);

        keyedMessages.clear();

        System.out.println("全部发送完成");

    }



}
