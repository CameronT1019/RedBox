// Cameron Testerman cxt200003 2021550951
package RedBox.Movies;

public class Movie implements Comparable<Movie> {
    String title = "";
    public Integer available = 0;
    public Integer rented = 0;

    Movie() {}

    public Movie(String title) {
        this.title = title;
    }
    
    public Movie(String title, Integer available, Integer rented) {
        this.title = title;
        this.available = available;
        this.rented = rented;
    }

    //overloaded constructor for adding and removing
    public Movie(String title, Integer avail)
    {
        this.title = title;
        available = avail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getRented() {
        return rented;
    }

    public void setRented(Integer rented) {
        this.rented = rented;
    }

    @Override
    public int compareTo(Movie m)
    {
        int val = 0;
        val = title.compareTo(m.title);
        return val;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-33s%-8d%-8d", title, available, rented);
    }
    
    public void add(int num)
    {
       available += num;
    }
    
    public void remove(int num)
    {
       available -= num;
    }
    
    public void rent()
    {
       rented++;
       available--;
    }

    public void returned()
    {
       rented--;
       available++;
    }
    
}
