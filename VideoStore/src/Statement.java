
import java.util.ArrayList;
import java.util.List;

public class Statement {

    private double totalAmount;
    private int frequentRenterPoints;
    private String customerName;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public Double getTotal() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String generate() {
        clearTotals();

        String statementText = header();
        statementText += rentalLines();
        statementText += footer();

        return statementText;
    }

    private void clearTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String header() {
        return String.format("Rental Record for %s%n", customerName);
    }

    private String rentalLines() {
        String rentalLines = "";
        for (Rental rental : rentals) {
            rentalLines += rentalLine(rental);
        }
        return rentalLines;
    }

    private String rentalLine(Rental rental) {
        double rentalAmount = rental.determineAmount();
        frequentRenterPoints += rental.determineFrequentRenterPoints();
        totalAmount += rentalAmount;

        return formatRentalLine(rental, rentalAmount);
    }

    private static String formatRentalLine(Rental rental, double rentalAmount) {
        return String.format("\t%s\t%s%n", rental.getTitle(), rentalAmount);
    }

    private String footer() {
        return String.format(
                "You owed %s%n" +
                        "You earned %s frequent renter points%n",
                totalAmount, frequentRenterPoints);
    }
}
