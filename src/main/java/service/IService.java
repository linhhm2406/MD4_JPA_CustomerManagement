package service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T model);
    void delete(Long id);
}
