package service.customer;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import service.IService;

@Service
public interface ICustomerService extends IService<Customer> {

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
