package repository;

import model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
