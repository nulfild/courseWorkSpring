package ru.nulfild.courseWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nulfild.courseWork.model.Subscription;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscription, Integer> {
}
