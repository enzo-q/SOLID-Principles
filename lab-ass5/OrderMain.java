public class OrderMain {
    public static void main(String[] args) {
        
        // Example 1: A complete order with all services
        OrderService standardOrder = new OrderService(
            new StandardOrderCalculator(),
            new DatabaseOrderRepository(),
            new PdfInvoiceGenerator(),
            new EmailNotificationSender()
        );

        System.out.println("--- Processing Standard Order ---");
        standardOrder.processOrder(10.0, 2, "John Peterson", "67 Ever Street", "order_1.pdf", "jpeterson@gmain.com");

        System.out.println("\n--- Processing Simple Order (No Invoice/Email) ---");
        
        // Example 2: A simple order omitting invoice and email entirely
        OrderService simpleOrder = new OrderService(
            new StandardOrderCalculator(),
            new DatabaseOrderRepository(),
            null, 
            null  
        );
        
        simpleOrder.processOrder(5.0, 1, "Jane Petrason", "76 Green Avenue", null, null);
    }
}