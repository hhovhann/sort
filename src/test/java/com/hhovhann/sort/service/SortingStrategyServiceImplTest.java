package com.hhovhann.sort.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SortingStrategyServiceImplTest {

    @Autowired
    private SortingStrategyService sortingStrategyService;

    @Test
    void whenInputNamesAreEmpty_thenShouldReturnEmptyList() {
        String[] actualResult = sortingStrategyService.sortWords(new String[]{});
        assertArrayEquals(new String[]{}, actualResult);
    }

    @Test
    void whenInputNamesAreNotEmpty_thenSortShouldReturnSortedNamesList() {
        String[] actualResult = sortingStrategyService.sortWords(new String[]{"Erik", "blažej", "Zdenko", "Dezider", "Blazena", "Arpád", "zdenka"});
        assertArrayEquals(new String[]{"Arpád", "blažej", "Blazena", "Dezider", "Erik", "zdenka", "Zdenko"}, actualResult);
    }

    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * "tree"
     * <p>
     * Output:
     * "eert"
     * Output:
     * "eetr"

     * Example 2:
     * <p>
     * Input:
     * "dddbbb"
     * <p>
     * Output:
     * "bbbddd"
     * Output:
     * "dddbbb"
     **/
    @Test
    void whenCharactersInputNotEmpty_thenSortCharactersShouldReturnSortedInputByFrequency() {
        // Given
        String input1 = "tree";
        String input2 = "dddbbb";
        // When
        String actualResult1 = sortingStrategyService.sortCharacters(input1);
        String actualResult2 = sortingStrategyService.sortCharacters(input2);
        // Then Expected Results:
        assertEquals("eert", actualResult1);
        assertEquals("bbbddd", actualResult2);
    }
}