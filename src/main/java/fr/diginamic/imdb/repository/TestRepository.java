package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
