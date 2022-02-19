package java8.designpattern.observer;

public class SundayObserver implements NewsFeedObserver {
    @Override
    public void observe(String news) {
        if (news.contains("Music")) {
            System.out.print("Sunday observer pick the news");
        }
    }
}
