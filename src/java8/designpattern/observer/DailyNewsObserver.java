package java8.designpattern.observer;

public class DailyNewsObserver implements NewsFeedObserver {
    @Override
    public void observe(String news) {
        if (news.contains("Terrorist")) {
            System.out.print("Daily news picked the news");
        }
    }
}
