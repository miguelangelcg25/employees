package com.leantech.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.employee.model.Person;
import com.leantech.employee.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
	return personRepository.save(person);
    }

    @Override
    public void update(Person person) {
	personRepository.findById(person.getId()).orElseThrow();
	personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
	personRepository.findById(id).orElseThrow();
	personRepository.deleteById(id);
    }

}
