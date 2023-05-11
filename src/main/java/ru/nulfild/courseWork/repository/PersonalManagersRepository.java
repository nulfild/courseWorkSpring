package ru.nulfild.courseWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nulfild.courseWork.model.PersonalManager;

@Repository
public interface PersonalManagersRepository extends JpaRepository<PersonalManager, Integer> {
}
