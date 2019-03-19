package com.xlk.kafkaConfigure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerGroup {

	String brokerList = "192.168.72.128:9092";
    String groupId = "test";
    String topic = "topic-ideal";
    int consumerNum = 3;
	/* private List<ConsumerRunnable> consumers;
	  
     public ConsumerGroup(int consumerNum, String groupId, String topic, String brokerList) {
         consumers = new ArrayList<ConsumerRunnable>(consumerNum);
         for (int i = 0; i < consumerNum; i++) {
             ConsumerRunnable consumerThread = new ConsumerRunnable(brokerList, groupId, topic);
             consumers.add(consumerThread);
         }
     }*/
 
     public ConsumerGroup() {
	}

	public void execute() {
    	ExecutorService threadPools =  Executors.newFixedThreadPool(3);
    	threadPools.execute(new ConsumerRunnable(brokerList, groupId, topic));
         /*for (ConsumerRunnable task : consumers) {
             new Thread(task).start();
         }*/
    }
}
