package service;

import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PhoneRepository;

public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(Integer id) {
        Phone phone = phoneRepository.findOne(id);
        if (phone == null) {
            return null;
        }
        return phone;
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone remove(Integer id) {
        Phone phone = phoneRepository.findOne(id);
        phoneRepository.delete(id);
        return phone;
    }
}
