public class AdapterPatternExample {

    // Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee Class 1
    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing PayPal payment of Rs." + amount);
        }
    }

    // Adaptee Class 2
    static class StripeGateway {
        public void payAmount(double amount) {
            System.out.println("Processing Stripe payment of Rs." + amount);
        }
    }

    // Adapter for PayPal
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        @Override
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    // Adapter for Stripe
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.payAmount(amount);
        }
    }

    // Test Class
    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        paypal.processPayment(5000);
        stripe.processPayment(7500);
    }
}