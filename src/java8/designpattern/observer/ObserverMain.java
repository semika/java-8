package java8.designpattern.observer;

public class ObserverMain {

    public static void main(String args[]) {

        //There is a subject which triggers an event
        //There are observers which listen to those event
        NewsFeed newsFeed = new NewsFeed();

        //newsFeed.addObserver(new DailyNewsObserver());
        //newsFeed.addObserver(new SundayObserver());
        //newsFeed.notifyObservers("Terrorist Attacked!");




        // using consumer. The functional approach
        newsFeed.addConsumer((String message) -> {
            if (message.contains("Terrorist")) {
                System.out.print("Daily news picked the news");
            }
        });
        newsFeed.addConsumer((String message) -> {
            if (message.contains("Music")) {
                System.out.print("Sunday observer pick the news");
            }
        });

        newsFeed.notifyConsumers("Terrorist Attacked!");

    }
}
