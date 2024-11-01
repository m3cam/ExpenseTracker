import java.util.ArrayList;
import java.util.Scanner;

public class FinanceApp {
    private static ArrayList<Expense> expenses = new ArrayList<>(); // List to hold expenses
    private static Scanner scanner = new Scanner(System.in); // Scanner for input

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to the finance program!");
            System.out.println("Please select an option:");
            System.out.println("1: Add Transaction");
            System.out.println("2: Update Transaction");
            System.out.println("3: Delete Transaction");
            System.out.println("4: View All Transactions");
            System.out.println("5: View Summary Of Transactions");
            System.out.println("6: View Monthly Summary");
            System.out.println("7: Exit");

            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (menuChoice) {
                case 1:
                    addTransaction(); // done
                    break;
                case 2:
                   updateTransaction();
                   break;
                case 3:
                    deleteTransactions(); 
                    break;
                case 4:
                    viewAllTransactions(); // done
                    break;
                case 5:
                    viewSummaryExpense(); // done
                    break;
                case 6:
                   viewSummaryExpenseMonthly();
                   break;

                case 7:
                    System.out.println("Exiting Program");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void addTransaction() {
        System.out.print("Enter the expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the expense category: ");
        String category = scanner.nextLine();

        System.out.print("Enter the expense date (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();

        // Create and add the new Expense
        Expense expense = new Expense(description, amount, category, date);
        expenses.add(expense);
        System.out.println("Expense added.");
    }

    public static void updateTransaction() {
        System.out.println("Enter description of expense you wish to update: ");
        String description = scanner.nextLine();
    
        boolean found = false; // Flag to check if the expense was found
    
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            if (expense.getDescription().equalsIgnoreCase(description)) {
                found = true; // Set the flag to true
                System.out.print("Enter the new expense description: ");
                String descriptionUpdate = scanner.nextLine();
    
                System.out.print("Enter the new expense amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
    
                System.out.print("Enter the new expense category: ");
                String category = scanner.nextLine();
    
                System.out.print("Enter the new expense date (e.g., YYYY-MM-DD): ");
                String date = scanner.nextLine();
    
                // Create and replace the existing Expense
                Expense updatedExpense = new Expense(descriptionUpdate, amount, category, date);
                expenses.set(i, updatedExpense); // Replace old expense at index with new element, updatedExpense
                System.out.println("Expense updated successfully.");
                break; // Exit the loop after updating
            }
        }
    
        if (!found) {
            System.out.println("Expense not found.");
        }
    }

    public static void deleteTransactions() {
        System.out.println("Enter the description of the expense you wish to delete: ");
        String description = scanner.nextLine();
    
        boolean found = false; // Flag to check if the expense was found
    
        // Loop through expenses
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i); // Get the current expense
    
            // Check if the expense description matches (case insensitive)
            if (expense.getDescription().equalsIgnoreCase(description)) {
                expenses.remove(i); // Remove the expense at index i
                System.out.println("Expense deleted successfully.");
                found = true; // Set the flag to true
                break; // Exit the loop after deleting
            }
        }
    
        if (!found) {
            System.out.println("Expense not found.");
        }
    }
    

    public static void viewAllTransactions() {
        if (expenses.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }
    
        System.out.println("All Transactions:");
        for (Expense expense : expenses) { // declares a variable of type Expense holding current element from expenses
            System.out.println(expense); // This calls the toString() method
        }
    }

    public static void viewSummaryExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return; // Exit the method if there are no expenses
        }
    
        double total = 0.0; // Initialize the total amount
    
        // Loop through each expense and accumulate the total
        for (Expense expense : expenses) {
            total += expense.getAmount(); // 
        }
    
        System.out.printf("Total Expenses: %.2f\n", total);

    }

    public static void viewSummaryExpenseMonthly() {
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the year (YYYY): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        double total = 0.0; // Initialize total expenses for the month
    
        // Format the month to ensure it's two digits for comparison (e.g., 01, 02, ... 12)
        String monthString = String.format("%02d", month); // Format month to two digits
    
        for (Expense expense : expenses) {
            // Get the date from the expense
            String date = expense.getDate();
            
            // Check if the date matches the specified year and month
            if (date.startsWith(year + "-" + monthString)) {
                total += expense.getAmount(); // Add to total
            }
        }
    
        // Display the result
        System.out.printf("Total Expenses for %02d/%d: %.2f\n", month, year, total);
    }
    
    

}
