package no.knowit.julekalender.luke2;

import no.knowit.julekalender.Helpers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Luke2Test {

    @Test
    public void test_is_prime(){
        assertThat(Helpers.isPrime(7), is(true));
        assertThat(Helpers.isPrime(8), is(false));
        assertThat(Helpers.isPrime(9), is(false));
        assertThat(Helpers.isPrime(0), is(true));

        assertThat(Helpers.isPrime(53113), is(true));
        assertThat(Helpers.isPrime(941083981), is(true));
    }

    @Test
    public void test_solve(){
        assertThat(Luke2.solve(5), is(53113));
        assertThat(Luke2.solve(9), is(971131737));
    }

    @Test
    public void test_sekvensAtIndex(){
        assertThat(Luke2.sekvensAtLastIndex(53113), is(13));
    }

    @Test
    public void test_tallsekvenser(){
        assertThat(Luke2.primeTallsekvenser(53113), is(Arrays.asList(13,11,31,53)));
        assertThat(Luke2.primeTallsekvenser(53112).size(), is(0));
        assertThat(Luke2.primeTallsekvenser(44113), is(Arrays.asList(13,11,41)));
    }
}
