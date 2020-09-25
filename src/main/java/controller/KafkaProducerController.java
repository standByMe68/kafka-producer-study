package controller;


import util.KafkaUtil;

import java.util.ArrayList;
import java.util.List;

public class KafkaProducerController {

    public static void main(String[] args) {

        List<String> datas = new ArrayList<>();

        for (int i = 0 ; i < 1; i++){
            datas.add("study_"+i);
        }
        KafkaUtil.send(datas);
    }

}
