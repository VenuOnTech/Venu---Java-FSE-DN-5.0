public class StrategyPatternExample {

    // Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Concrete Strategy - Credit Card Payment
    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Credit Card.");
        }
    }

    // Concrete Strategy - PayPal Payment
    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using PayPal.");
        }
    }

    // Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Test Class
    public static void main(String[] args) {

        // Using Credit Card Payment
        PaymentContext paymentContext =
                new PaymentContext(new CreditCardPayment());

        paymentContext.executePayment(5000);

        // Switching to PayPal Payment at runtime
        paymentContext.setPaymentStrategy(new PayPalPayment());

        paymentContext.executePayment(3000);
    }
}