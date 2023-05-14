package lesson6;

public abstract class Cinema {
    private String title;

    public Cinema(){
        this.title = "";
    }
    public Cinema(String title){
        this.title = title;
    }

    public abstract int getTotalDuration();
    public abstract double getAverageRating();


    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
