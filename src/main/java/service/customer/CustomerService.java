package service.customer;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    public ICustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer model) {
        customerRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
