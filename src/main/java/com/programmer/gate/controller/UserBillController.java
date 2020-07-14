package com.programmer.gate.controller;

import com.programmer.gate.dto.UserBillDTO;
import com.programmer.gate.model.UserBill;
import com.programmer.gate.service.UserBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Контроллер счетов пользователей
 */
@Controller
public class UserBillController {

    @Autowired
    UserBillService userBillService;

    /**
     * Показывает стартовую страницу
     * @return адрес страницы
     */
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {

        System.out.println("UserBill");

        return "index";
    }

    /**
     * Показавает список пользователей
     * @return адрес страницы
     */
    @GetMapping("/users")
    public String users(Map<String, Object> model) {

        Iterable<UserBill> userBills = userBillService.findAll();

        model.put("userBills", userBills);

        return "userList";
    }

    /**
     * Добавление пользователя
     * @return адрес страницы
     */
    @GetMapping("/adduser")
    public String addUser(Map<String, Object> model) {

        System.out.println("addUser");

        return "newUser";
    }

    /**
     * Сохранение пользователя
     * @return адрес страницы
     */
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("userBillDTO") UserBillDTO userBillDTO, Map<String, Object> model) {

        UserBill userBill = new UserBill();

        userBill.setSurname(userBillDTO.getSurname());
        userBill.setName(userBillDTO.getName());
        userBill.setPatronymicName(userBillDTO.getPatronymicName());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            userBill.setBirthday(simpleDateFormat.parse(userBillDTO.getBirthday()));
        } catch (ParseException e) {
            return "userList";
        }
        try {
            userBill.setBill(Double.parseDouble(userBillDTO.getBill()));
        } catch (Exception e){
            return "userList";
        }

        userBillService.save(userBill);

        Iterable<UserBill> userBills = userBillService.findAll();
        model.put("userBills", userBills);

        return "userList";
    }

    /**
     * Редактирование счета пользователя
     * @return адрес страницы
     */
    @GetMapping("/editbill/{id}")
    public String editBill(@PathVariable long id, Map<String, Object> model) {

        UserBill userBill = userBillService.findOne(id);
        model.put("user", userBill);

        return "editBill";
    }

    /**
     * Сохраниение счета пользователя
     * @return адрес страницы
     */
    @PostMapping("/savebill")
    public String saveBill(@RequestParam("id") long id,
                           @RequestParam("change") String change, Map<String, Object> model) {

        double changeDouble = 0;
        try {
            changeDouble = Double.parseDouble(change);
        } catch (Exception e) {
            return "userList";
        }

        UserBill userBill = userBillService.findOne(id);

        double bill = userBill.getBill();
        bill = bill + changeDouble;
        userBill.setBill(bill);

        userBillService.save(userBill);

        Iterable<UserBill> userBills = userBillService.findAll();
        model.put("userBills", userBills);

        return "userList";
    }
}
