public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        if (id.equals("C101")) {
            return "Customer Name: Gopika Senthilkumar";
        } else {
            return "Customer Not Found";
        }
    }
}
