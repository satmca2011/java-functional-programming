package streams;

import java.util.*;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        //String stream
        Stream<String> stringStream = Stream.of("A","B","C");
        stringStream.forEach(System.out::println);

        // Stream for collection
        Collection<String> stringCollections = Arrays.asList("Java", "React","Springboot");
        Stream<String> stringStreamCollection = stringCollections.stream();
        stringStreamCollection.forEach(System.out::println);

        // Stream for list
        List<String> stringList = Arrays.asList("Java", "React","Springboot");
        Stream<String> stringStreamList = stringList.stream();
        stringStreamList.forEach(System.out::println);

        // Stream for set
        Set<String> strSet = new HashSet<>(stringList);
        Stream<String> strStreamUsingSet = strSet.stream();
        strStreamUsingSet.forEach(System.out::println);

        // Stream for string array
        String[] strArr = {"a","b","c","d"};
        Stream<String> streamUsingStringArray = Arrays.stream(strArr);
        streamUsingStringArray.forEach(System.out::println);

    }
}
