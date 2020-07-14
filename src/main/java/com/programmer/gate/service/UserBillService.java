package com.programmer.gate.service;

import com.programmer.gate.model.UserBill;

/**
 * Сервис счетов пользователей
 */
public interface UserBillService {

    Iterable<UserBill> findAll();

    UserBill findOne(long id);

    UserBill save(UserBill userBill);
}
