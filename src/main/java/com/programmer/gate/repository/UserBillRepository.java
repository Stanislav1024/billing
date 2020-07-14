package com.programmer.gate.repository;

import com.programmer.gate.model.UserBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий счетов пользователей
 */
@Repository
public interface UserBillRepository extends CrudRepository<UserBill, Long> {
}
