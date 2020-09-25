package util;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class MyPartitionsUtil implements Partitioner {

    //这个是必须需要的
    public MyPartitionsUtil(VerifiableProperties props){

    }

    @Override
    public int partition(Object key, int numPartitions) {
        int count = (int) key;
        System.out.println(numPartitions);
        return count%numPartitions;
    }
}
