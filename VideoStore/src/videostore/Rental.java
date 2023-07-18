package videostore;

import videostore.Movie;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double determineAmount(){
        return movie.determineAmount(daysRented);
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    int determineFrequentRenterPoints(){
        return movie.determineFrequentRenterPoints(daysRented);
    }

}
