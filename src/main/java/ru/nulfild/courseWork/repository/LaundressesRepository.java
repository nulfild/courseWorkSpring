package ru.nulfild.courseWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nulfild.courseWork.model.Laundress;

@Repository
public interface LaundressesRepository extends JpaRepository<Laundress, Integer> {
}
