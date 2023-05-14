package lesson6;

public class Movie extends Cinema{
    public double rating;
    private int duration;

    public Movie(){
        super();
        this.setDuration(0);
        this.setRating(0);
    }
    public Movie(String title, int duration, double rating){
        super(title);
        this.setDuration(duration);
        this.setRating(rating);
    }

    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getDuration(){
        return this.duration;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int getTotalDuration() {
        return this.getDuration();
    }

    @Override
    public double getAverageRating() {
        return this.getRating();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.rating, rating) == 0;
    }

    @Override
    public int hashCode() {
        return 31*this.getTotalDuration();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                "; duratin=" + getDuration() +
                "; title=" + getTitle() +
                '}';
    }
}
