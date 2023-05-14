package lesson6;

import java.util.ArrayList;

public class Lesson6 {
    public static void main(String[] args){
        Movie movie1 = new Movie("The Terminator", 180,8.0);
        System.out.println(movie1);
        System.out.println(movie1.getAverageRating());
        System.out.println(movie1.getTotalDuration());

        ArrayList<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(45,8.1));
        episodes.add(new Episode(47,8.3));
        episodes.add(new Episode(43,7.9));
        Serial serial1 = new Serial(45, "The Mandalorian", episodes);
        System.out.println(serial1);
        System.out.println(serial1.getCount());
        System.out.println(serial1.getAverageRating());
        System.out.println(serial1.getTotalDuration());
    }
}
