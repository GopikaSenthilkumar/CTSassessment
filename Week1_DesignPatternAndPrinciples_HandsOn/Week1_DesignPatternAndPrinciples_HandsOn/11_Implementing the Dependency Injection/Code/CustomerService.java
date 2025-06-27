public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void displayCustomer(String id) {
        String result = customerRepository.findCustomerById(id);
        System.out.println(result);
    }
}
