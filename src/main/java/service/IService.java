package service;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T> {
    Page<T> findAll(Pageable pageable);
    T findById(Long id);
    void save(T model);
    void delete(Long id);
}
