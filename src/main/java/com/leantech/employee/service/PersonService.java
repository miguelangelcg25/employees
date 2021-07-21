package com.leantech.employee.service;

import com.leantech.employee.model.Person;

public interface PersonService {

    Person save(Person person);

    void update(Person person);

    void delete(Long id);

}
