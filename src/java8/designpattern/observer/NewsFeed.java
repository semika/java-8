package java8.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.Data;

@Data
public class NewsFeed {

    private List<NewsFeedObserver> newsFeedObserverList = new ArrayList<>();
    private List<Consumer<String>> newsFeedConsumerList = new ArrayList<>();

    public void addObserver(NewsFeedObserver newsFeedObserver) {
        this.newsFeedObserverList.add(newsFeedObserver);
    }

    //using a consumer
    public void addConsumer(Consumer<String> messageConsumer) {
        newsFeedConsumerList.add(messageConsumer);
    }

    public void notifyObservers(String message) {
        this.newsFeedObserverList.forEach((NewsFeedObserver nfo) -> {
            nfo.observe(message);
        });
    }

    public void notifyConsumers(String message) {
        this.newsFeedConsumerList.forEach((Consumer<String> consumer) -> {
            consumer.accept(message);
        });
    }
}
