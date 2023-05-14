package lesson6;

import java.util.ArrayList;
import java.util.Objects;

public class Serial extends Cinema{

    ArrayList<Episode> episodes = new ArrayList<>();

    public Serial(){
        super();
        this.episodes = new ArrayList<>();
    }
    public Serial(int duration, String title, ArrayList<Episode> episodes){
        super(title);
        this.setEpisodes(episodes);
    }

    public void setEpisodes(ArrayList<Episode> episodes){
        this.episodes = episodes;
    }
    public int getCount(){
        return this.episodes.size();
    }
    @Override
    public int getTotalDuration() {
        int duration=0;
        // Использование обычного цикла
        for(int i = 0; i<this.episodes.size(); i++) {
            Episode episode = this.episodes.get(i);
            duration += episode.duration;
        }
        return duration;
    }

    @Override
    public double getAverageRating() {
        double rating=0;
        // Использование обычного цикла
        for(int i = 0; i<this.episodes.size(); i++) {
            Episode episode = this.episodes.get(i);
            rating += episode.rating;
        }
        return rating/this.episodes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serial serial = (Serial) o;
        return Objects.equals(episodes, serial.episodes);
    }

    @Override
    public int hashCode() {
        return 31*this.getTotalDuration();
    }

    @Override
    public String toString() {
        return "Serial{" +
                "episodes=" + episodes +
                '}';
    }
}
