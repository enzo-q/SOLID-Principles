public class OrderService {
    private final OrderCalculator calculator;
    private final OrderRepository repository;
    private final InvoiceGenerator invoiceGenerator;
    private final NotificationSender notificationSender;

    // Dependencies are injected via the constructor
    public OrderService(OrderCalculator calculator, 
                        OrderRepository repository,
                        InvoiceGenerator invoiceGenerator, 
                        NotificationSender notificationSender) {
        this.calculator = calculator;
        this.repository = repository;
        this.invoiceGenerator = invoiceGenerator;
        this.notificationSender = notificationSender;
    }

    // Orchestrates the flow
    public void processOrder(double price, int quantity, String customerName, 
                             String address, String fileName, String contact) {
        calculator.calculateTotal(price, quantity);
        repository.placeOrder(customerName, address);
        
        // Handling optional dependencies gracefully
        if (invoiceGenerator != null) {
            invoiceGenerator.generateInvoice(fileName);
        }
        if (notificationSender != null) {
            notificationSender.sendNotification(contact);
        }
    }
}