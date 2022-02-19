package java8.collectiongroup;

import java8.model.BlogPost;
import java8.model.BlogPostType;
import java8.model.Tuple;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {

        List<BlogPost> posts = Arrays.asList(
            new BlogPost("Java", "Semika", BlogPostType.NEWS, 10),
            new BlogPost("Java", "Semika", BlogPostType.GUIDE, 10),
            new BlogPost("C++", "Yumeth", BlogPostType.REVIEW, 25),
            new BlogPost("EJB", "Yumeth", BlogPostType.NEWS, 110),
            new BlogPost("Java", "Yumeth", BlogPostType.NEWS, 10),
            new BlogPost("Java", "Semika", BlogPostType.NEWS, 10),
            new BlogPost("Java", "Dhanushka", BlogPostType.GUIDE, 10),
            new BlogPost("Java", "Viraj", BlogPostType.REVIEW, 10)
        );
        //groupByBlogPostType(posts);
        //groupByTwoFiels(posts);
        groupIntoSet(posts);
        String s = "";
    }

    private static void groupByBlogPostType(List<BlogPost> posts) {

        Function<BlogPost, BlogPostType> blogPostFunction = (BlogPost blogPost) -> { return blogPost.getType();};

        Function<BlogPost, BlogPostType> blogPostFunction1 = (BlogPost blogPost) -> blogPost.getType();

        Function<BlogPost, BlogPostType> blogPostFunction2 = BlogPost::getType;

        Map<BlogPostType, List<BlogPost>> map = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        System.out.print(map);
    }

    private static void groupByTwoFields(List<BlogPost> posts) {
        Map<Tuple, List<BlogPost>> map = posts.stream().collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        System.out.println(map);
    }

    private static void groupIntoSet(List<BlogPost> posts) {
        Map<BlogPostType, Set<BlogPost>> map = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
    }
}
