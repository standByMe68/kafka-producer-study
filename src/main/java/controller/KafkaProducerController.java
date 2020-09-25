package controller;


import scala.actors.threadpool.Arrays;
import util.KafkaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KafkaProducerController {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("请输入需要发送的内容");
            String data = scanner.next();
            String[] datas = data.split(",");
            KafkaUtil.send(Arrays.asList(datas));

        }
    }

}
