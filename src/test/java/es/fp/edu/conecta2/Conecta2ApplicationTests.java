package es.fp.edu.conecta2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class Conecta2ApplicationTests {
    @Sql({ "/schema.sql", "/data.sql" })

    @Test
    void contextLoads() {
    }

}
