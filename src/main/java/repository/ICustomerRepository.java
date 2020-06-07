package repository;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long>, PagingAndSortingRepository<Customer, Long>, JpaRepository<Customer,Long> {

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}

