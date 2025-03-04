package finctional_interface;

import java.util.*;

class Movie{
    private String title;
    private double rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    Movie(String title, double rating){
        this.title=title;
        this.rating=rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}

class MovieComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Movie> movies = movieMock();
        printMovies(movies);
        System.out.println("Traditional Way: Movies List after sorting them by higher rating");
        Collections.sort(movies, new MovieComparator());
        printMovies(movies);
        System.out.println("Lambda Way: Movies List after re-sorting them by lower rating");
        movies.sort((o1, o2) -> Double.compare(o1.getRating(), o2.getRating()));
        printMovies(movies);
        System.out.println("Method Ref: Movies List after re-sorting them by higher rating");
        movies.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        printMovies(movies);

        // using streams
        System.out.println("************* Using Streams **********************");
        System.out.println("Ascending Order:");
        movies.stream().sorted(Comparator.comparingDouble(Movie::getRating)).forEach(System.out::println);
        System.out.println("Descending Order:");
        movies.stream().sorted(Comparator.comparingDouble(Movie::getRating).reversed()).forEach(System.out::println);

        }

    private static void printMovies(List<Movie> movies) {
        for(Movie movie : movies){
            System.out.println(movie.getTitle() + "- "+ movie.getRating());
        }
    }

    private static List<Movie> movieMock() {
        List<Movie> movies = new ArrayList<>();
        for(int i = 1; i<10;i++){
            movies.add(new Movie(i+"a", i-0.5));
        }
        return movies;
    }
}
