package RedBox.Movies;

public class Movie implements Comparable<Movie> {
    private String title;
    Integer Available;
    Integer Rented;

    public Movie(){
        title = "";
        Available = 0;
        Rented = 0;
    }
    public Movie(String title, Integer available, Integer rented) {
        this.title = title;
        Available = available;
        Rented = rented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailable() {
        return Available;
    }

    public void setAvailable(Integer available) {
        Available = available;
    }

    public Integer getRented() {
        return Rented;
    }

    public void setRented(Integer rented) {
        Rented = rented;
    }

    public int compareTo(Movie m) {
        return this.getTitle().trim().compareToIgnoreCase(m.getTitle().trim());
    }
    
}
