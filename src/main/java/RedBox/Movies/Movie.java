package RedBox.Movies;

public class Movie implements Comparable<Movie> {

    private String title;
    private int available;
    private int rented;

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
        this.available = 1;
        this.rented = 0;
    }
    
    public Movie(String title, int available, int rented) {
        this.title = title;
        this.available = available;
        this.rented = rented;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }
    
    public void setRented(int rented) {
        this.rented = rented;
    }

    public int getRented() {
        return rented;
    }

    public String toString() {
        return title + " " + available + " " + rented;
    }

    public void add(int numAdd) {
        available = available + numAdd;
    }
    
    public void remove(int numRemove)
	{
		if(numRemove > available)
		{
			numRemove = numRemove - available;
			available = 0;
			rented = rented - numRemove;
		}
		else
		{
			available = available - numRemove;
		}
	}
	
	public void rent()
	{
		available--;
		rented++;
	}
	
	public void ret()
    {
        available++;
        rented--;
    }
    
	@Override
	public int compareTo(Movie o) {
		return this.getTitle().compareToIgnoreCase(o.getTitle());
	}
    
}
