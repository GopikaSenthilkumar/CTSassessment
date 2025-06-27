public interface PaymentProcessor {
    void processPayment(double amount);
}
class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal processed payment of Rs." + amount);
    }
}
class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Stripe processed payment of Rs." + amount);
    }
}
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;
    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }
    public void processPayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}
