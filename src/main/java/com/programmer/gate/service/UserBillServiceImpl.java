package com.programmer.gate.service;

import com.programmer.gate.model.UserBill;
import com.programmer.gate.repository.UserBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Имплементация сервиса счетов пользователей
 */
@Service
public class UserBillServiceImpl implements UserBillService {

    @Autowired
    private UserBillRepository userBillRepository;

    @Override
    public Iterable<UserBill> findAll() {
        return userBillRepository.findAll();
    }

    public UserBill findOne(long id){
        return userBillRepository.findOne(id);
    }

    @Override
    public UserBill save(UserBill userBill){
        return userBillRepository.save(userBill);
    }
}
