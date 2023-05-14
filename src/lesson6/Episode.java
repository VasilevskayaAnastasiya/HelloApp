package lesson6;

public class Episode{
    public int duration;
    public double rating;

    public Episode(int duration, double rating){
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "duration=" + duration +
                ", rating=" + rating +
                '}';
    }
}
