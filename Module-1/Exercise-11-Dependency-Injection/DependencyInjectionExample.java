public class DependencyInjectionExample {

    // Repository Interface
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Concrete Repository
    static class CustomerRepositoryImpl implements CustomerRepository {

        @Override
        public String findCustomerById(int id) {
            return "Customer ID: " + id + ", Name: John Doe";
        }
    }

    // Service Class
    static class CustomerService {
        private CustomerRepository customerRepository;

        // Constructor Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public void getCustomerDetails(int id) {
            String customer = customerRepository.findCustomerById(id);
            System.out.println(customer);
        }
    }

    // Test Class
    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService customerService =
                new CustomerService(repository);

        customerService.getCustomerDetails(101);
    }
}