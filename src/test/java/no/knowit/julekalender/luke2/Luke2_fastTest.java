package no.knowit.julekalender.luke2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Luke2_fastTest {

    @Test
    public void test_solve(){
        assertThat(Luke2.solve(3), is(311));
        assertThat(Luke2.solve(5), is(53113));
        assertThat(Luke2.solve(9), is(971131737));
    }
}
