public class Test {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Gopika S");
        context.setPaymentStrategy(creditCard);
        context.makePayment(500.0);
        System.out.println();
        PaymentStrategy payPal = new PayPalPayment("gopika@example.com");
        context.setPaymentStrategy(payPal);
        context.makePayment(1000.0);
    }
}
