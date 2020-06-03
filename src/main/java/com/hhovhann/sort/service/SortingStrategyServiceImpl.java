package com.hhovhann.sort.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SortingStrategyServiceImpl implements SortingStrategyService {

    /***
     * Alphabetically sorts not empty input array, ignoring case and accent. Otherwise returns empty array
     */
    @Override
    public String[] sortWords(String[] names) {
        if (names.length == 0) {
            return new String[]{};
        }
        int arrSize = names.length;
        // Time Complexity a * b
        for (int a = 0; a < arrSize - 1; a++) {
            for (int b = a + 1; b < arrSize; b++) {
                if (ignoreAccent(names[a]).compareToIgnoreCase(ignoreAccent(names[b])) > 0) {
                    String bubbleName = names[a];
                    names[a] = names[b];
                    names[b] = bubbleName;
                }
            }
        }
        return names;
    }

    @Override
    // The time complexity of this approach is O(n) and space complexity is also O(n).
    public String sortCharacters(String input) {
        char[] characters = input.toCharArray();
        int size = characters.length;
        StringBuilder sb = new StringBuilder(size);
        // Populate map with char -> frequency
        Map<Character, Integer> charactersStorage = getCharacterFrequencyMap(characters);
        // Sort this map by frequency
        return sortByCharFrequency(sb, charactersStorage);
    }

    /***
     * Sort this map by frequency
     */
    private String sortByCharFrequency(StringBuilder sb, Map<Character, Integer> charactersStorage) {
        charactersStorage.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(record -> {
                    Character key = record.getKey();
                    int value = record.getValue();
                    //Append the character by the number of times it occurs.
                    for (int i = 0; i < value; i++) {
                        sb.append(key);
                    }
                });
        return sb.toString();
    }

    /***
     * Populate map with char -> frequency
     */
    private Map<Character, Integer> getCharacterFrequencyMap(char[] characters) {
        Map<Character, Integer> charactersStorage = new HashMap<>();
        for (char character : characters) {
            Integer currentCount = charactersStorage.get(character);
            if (Objects.isNull(currentCount)) {
                charactersStorage.put(character, 1);
            } else {
                charactersStorage.put(character, currentCount + 1);
            }
        }
        return charactersStorage;
    }

    /***
     * Ignore/Replace all accents
     */
    public static String ignoreAccent(String name) {
        return name.replaceAll("[^\\p{ASCII}]", "");
    }
}
