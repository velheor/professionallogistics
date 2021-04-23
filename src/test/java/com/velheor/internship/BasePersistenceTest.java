package com.velheor.internship;

import com.velheor.internship.config.PersistenceTestConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {PersistenceTestConfig.class})
public abstract class BasePersistenceTest extends BaseTest {

}
