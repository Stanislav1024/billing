package com.programmer.gate.model;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Модель счета пользователя
 */
@Entity
@Table(name = "user_bill")
public class UserBill {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "bill")
    private double bill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public Date getBirthday () {
        return birthday;
    }

    public String getBirthdayString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
