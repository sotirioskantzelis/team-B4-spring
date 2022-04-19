package com.example.teamb4spring.service;


import com.example.teamb4spring.base.BaseComponent;
import com.example.teamb4spring.domain.BaseModel;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements
    BaseService<T, Long> {

  public abstract JpaRepository<T, Long> getRepository();

  public T create(T item) {
    return getRepository().save(item);
  }

  public List<T> createAll(List<T> items) {
    return getRepository().saveAll(items);
  }

  public List<T> createAll(T... items) {
    return createAll(Arrays.asList(items));
  }

  public void update(T item) {
    getRepository().save(item);
  }

  public void delete(T item) {
    getRepository().delete(item);
  }

  public void deleteById(Long id) {
    getRepository().deleteById(id);
  }

  @Transactional(readOnly = true)
  public T get(Long id) {
    return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Transactional(readOnly = true)
  public boolean exists(T item) {
    return getRepository().existsById(item.getId());
  }

  @Transactional(readOnly = true)
  public List<T> findAll() {
    return getRepository().findAll();
  }
}
