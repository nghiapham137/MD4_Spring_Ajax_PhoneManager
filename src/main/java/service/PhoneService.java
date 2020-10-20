package service;

import model.Phone;

public interface PhoneService {
    Iterable<Phone> findAll();
    Phone findById(Integer id);
    Phone save(Phone phone);
    Phone remove(Integer id);
}
