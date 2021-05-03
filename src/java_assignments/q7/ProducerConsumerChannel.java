package java_assignments.q7;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerChannel <T> {
    private Queue<T> channel;
    final private int capacity;
    private Producer producer;
    private Consumer consumer;

    ProducerConsumerChannel(int capacity){
        this.capacity = capacity;
        channel = new LinkedList<T>();
        producer = new Producer();
        consumer = new Consumer();
    }
    private void produceItem(){

    }
    class Producer {
        public void produce(T value) throws InterruptedException
        {
            synchronized (ProducerConsumerChannel.this) {
                Queue<T> list = ProducerConsumerChannel.this.channel;
                //producer will wait when the channel is full
                while (list.size() == capacity)
                    ProducerConsumerChannel.this.wait();

                channel.add(value);

                ProducerConsumerChannel.this.notifyAll();
            }
        }
    }

    public class Consumer{
        public T consume() throws InterruptedException
        {
            synchronized (ProducerConsumerChannel.this) {
                T value;
                //consumer thread waits when channel is empty
                while (channel.size() == 0)
                    ProducerConsumerChannel.this.wait();

                value = channel.remove();

                ProducerConsumerChannel.this.notifyAll();

                return value;
            }
        }
    }


    public Consumer getConsumer() {
        return consumer;
    }

    public Producer getProducer() {
        return producer;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getSize(){
        return channel.size();
    }
}
