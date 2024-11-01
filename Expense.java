public class Expense {
    private String description; // Description of the expense
    private double amount; // Amount of the expense
    private String category; // Category of the expense (optional)
    private String date; // Date of the expense (optional)

    // Constructor to initialize the expense
    public Expense(String description, double amount, String category, String date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters for accessing the properties
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    // Override toString() for easy printing of the expense
    @Override
    public String toString() {
        return String.format("Description: %s | Amount: %.2f | Category: %s | Date: %s", 
                             description, amount, category, date);
    }
}
