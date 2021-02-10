package com.company.course.application.service.impl;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Address;
import com.company.course.application.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IService<Address> {

    private final IDao<Address> addressDao;

    @Autowired
    public AddressService(@Qualifier("addressDaoSpringJDBC") IDao<Address> addressDao) {
        this.addressDao = addressDao;
    }


    @Override
    public List<Address> showAll() {
        return addressDao.showAll();
    }

    @Override
    public Address add(Address type) {
        addressDao.add(type);
        return type;
    }

    @Override
    public void deleteById(Long id) {
        addressDao.delete(id);
    }

    @Override
    public Address update(Long id, Address type) {
        Address address = addressDao.updateById(id, type);
        return address;
    }

    @Override
    public Address findById(Long id) {
        return addressDao.findById(id);
    }

    @Override
    public List<Address> findByCoachId(Long coachId) {
        return null;
    }
}
