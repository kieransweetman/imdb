package fr.diginamic.imdb.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import fr.diginamic.imdb.ImdbApplication;
import fr.diginamic.imdb.entity.TestEntity;
import fr.diginamic.imdb.repository.TestRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ImdbApplication.class)
@ActiveProfiles("test")
public class DatabaseConfigTest {

    @Autowired
    private TestRepository testEntityRepository;

    @Test
    public void testDatabaseConnection() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("Test Name");
        testEntity = testEntityRepository.save(testEntity);

        assertThat(testEntity.getId()).isNotNull();
        assertThat(testEntityRepository.findById(testEntity.getId())).isPresent();

        testEntityRepository.delete(testEntity);
    }
}