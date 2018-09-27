package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.PersonForEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CompareTest {
    @Test
    void should_test_compare() {
        PersonForEquals person1 = new PersonForEquals("Aline", (short) 1990);
        PersonForEquals person2 = new PersonForEquals("James", (short) 1990);
        PersonForEquals person3 = new PersonForEquals("James", (short) 1992);

        PersonForEquals[] personForEquals = new PersonForEquals[]{person1, person2, person3};

        PersonForEquals[] actual = getCompareOfPerson(personForEquals);
        PersonForEquals[] excepted = new PersonForEquals[]{person1, person2, person3};
        assertArrayEquals(excepted, actual);
    }

    private PersonForEquals[] getCompareOfPerson(PersonForEquals[] personForEquals) {
        PersonForEquals[] result = new PersonForEquals[personForEquals.length];

        for (int number = 0; number < personForEquals.length; number++) {
            PersonForEquals max = personForEquals[number];
            for (int i = number + 1; i < personForEquals.length; i++) {
                if (max.compareTo(personForEquals[i]) > 0) {
                    max = personForEquals[number];
                }
            }
            result[number] = max;
        }
        return result;
    }
}
