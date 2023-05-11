package ru.nulfild.courseWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nulfild.courseWork.auth.UserService;
import ru.nulfild.courseWork.model.Customer;
import ru.nulfild.courseWork.repository.CustomersRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomersRepository customersRepository;

    private final UserService userService;

    @Autowired
    public CustomerService(CustomersRepository customersRepository, UserService userService) {
        this.customersRepository = customersRepository;
        this.userService = userService;
    }

    public List<Customer> getAll() {
        return customersRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customersRepository.findById(id).orElse(null);
    }

    @Transactional
    public ResponseEntity<String> saveCustomer(Customer customer, HttpServletRequest request) {
        if (!userService.checkAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: you don't have enough authorities");
        }
        customersRepository.save(customer);
        return new ResponseEntity<>("Save successfull", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> updateCustomer(int id, Customer customer, HttpServletRequest request) {
        if (!userService.checkAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: you don't have enough authorities");
        }
        Customer customerToUpdate = getCustomer(id);
        customerToUpdate.setLaundress(customer.getLaundress());
        customerToUpdate.setPersonalManager(customer.getPersonalManager());
        customerToUpdate.setFullName(customer.getFullName());
        customersRepository.save(customerToUpdate);

        return new ResponseEntity<>("Update successfull", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> deleteCustomer(int id, HttpServletRequest request) {
        if (!userService.checkAdmin(request)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: you don't have enough authorities");
        }
        customersRepository.deleteById(id);
        return new ResponseEntity<>("Delete successfull", HttpStatus.OK);
    }
}
