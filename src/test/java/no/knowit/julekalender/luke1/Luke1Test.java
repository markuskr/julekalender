package no.knowit.julekalender.luke1;


import no.knowit.julekalender.Helpers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Luke1Test {

    @Test
    public void solve() {
        assertThat(Luke1.solve(10), is (8));
        assertThat(Luke1.solve(1000000), is (25));
    }

    @Test
    public void test_pallindrom(){
        assertThat(Helpers.isPalindrom("1496941"), is(true));
        assertThat(Helpers.isPalindrom("5553555"), is(true));
        assertThat(Helpers.isPalindrom("123"), is(false));
        assertThat(Helpers.isPalindrom(""), is(true));
        assertThat(Helpers.isPalindrom("aa"), is(true));
        assertThat(Helpers.isPalindrom("ab"), is(false));
        assertThat(Helpers.isPalindrom("aba"), is(true));
    }
}
