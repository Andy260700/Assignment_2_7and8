package java_assignments.q7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capacity of the producer consumer buffer : ");
        int capacity = sc.nextInt();
        sc.nextLine();
        final ProducerConsumerChannel<Integer> channel = new ProducerConsumerChannel<>(capacity);
        ProducerConsumerChannel<Integer>.Producer producer = channel.getProducer();
        ProducerConsumerChannel<Integer>.Consumer consumer = channel.getConsumer();
        //create producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<capacity*2;i++) {
                    try {
                        producer.produce(i);
                        System.out.println("produced value :"+i);
                        Thread.sleep(300);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        //create consumer thread
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<capacity*2;i++){
                  try{
                      System.out.println("consumed value : "+consumer.consume());
                      Thread.sleep(50);
                  }
                  catch (InterruptedException e){
                      e.printStackTrace();
                  }
                }
            }
        });
        //start the threads
        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
