public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(1500.00);
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(2200.75);
    }
}
