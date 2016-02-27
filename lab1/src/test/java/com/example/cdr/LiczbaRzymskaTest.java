package com.example.cdr;

    import static org.junit.Assert.*;

    import org.junit.Rule;
    import org.junit.Test;
    import org.junit.rules.ExpectedException;


    public class LiczbaRzymskaTest {

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        private LiczbaRzymska test = new LiczbaRzymska(10);

        @Test
        public void Test() {
            assertEquals("X", test.toString());

        }
        private LiczbaRzymska test2 = new LiczbaRzymska(5);

        @Test
        public void Test2() {
            assertEquals("V", test2.toString());

        }

    }
