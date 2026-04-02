public class StandardOrderCalculator implements OrderCalculator {
    @Override
    public double calculateTotal(double price, int quantity) {
        double total = price * quantity;
        System.out.println("Order total: $" + total);
        return total;
    }
}