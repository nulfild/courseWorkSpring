package ru.nulfild.courseWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nulfild.courseWork.model.Customer;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer> {
}
