package com.velheor.internship;

import com.velheor.internship.config.PersistenceTestConfig;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {PersistenceTestConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
        "classpath:beforeTest.sql"})
public abstract class BasePersistenceTest {

}
