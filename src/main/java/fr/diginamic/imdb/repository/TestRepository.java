package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
