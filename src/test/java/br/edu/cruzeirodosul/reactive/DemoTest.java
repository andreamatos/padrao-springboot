package br.edu.cruzeirodosul.reactive;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.cruzeirodosul.controller.ArchetypeV2Controller;

@DisplayName("Archetype 2")
public class DemoTest {
	
	private static Logger log = LoggerFactory.getLogger(DemoTest.class);
	
	@Autowired
	ArchetypeV2Controller archetypeController;
	
	@BeforeAll
	static void setup() {
	    log.info("@BeforeAll - executa antes de todos os métodos de teste desta classe");
	}

	@DisplayName("assertEquals")
    @Test
    void testGet() {
        assertEquals("1", archetypeController.get("1"));
    }
	
	@Test
    @DisplayName("Exception")
    void shouldThrowCorrectException() {
        assertThrows(
                NullPointerException.class,
                () -> { throw new NullPointerException(); }
        );
    }
	
	@AfterEach
    void after(TestInfo testInfo) {
        String callingTest = testInfo.getTestMethod().get().getName();
        System.out.println(callingTest);
    }


	
}
