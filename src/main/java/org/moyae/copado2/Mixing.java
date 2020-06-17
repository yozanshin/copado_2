package org.moyae.copado2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mixing {

    private static final int A_CODE = 97;
    private static final int Z_CODE = 122;
    private static final String PREFIX_1 = "1:";
    private static final String PREFIX_2 = "2:";
    private static final String PREFIX_EQUALS = "=:";

    public static String mix(String s1, String s2) {

        Map<Character, Integer> s1CharMap = new HashMap<>();
        Map<Character, Integer> s2CharMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int value = s1CharMap.getOrDefault(c, 0);
                s1CharMap.put(c, value+1);
            }
        }
        for (char c : s2.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int value = s2CharMap.getOrDefault(c, 0);
                s2CharMap.put(c, value+1);
            }
        }

        List<String> subStrings = buildSubstringList(s1CharMap, s2CharMap);

        sortSubstrings(subStrings);

        return String.join("/", subStrings);
    }

    private static List<String> buildSubstringList(final Map<Character, Integer> s1CharMap,
                                                   final Map<Character, Integer> s2CharMap) {

        ArrayList<String> subStrings = new ArrayList<>();
        for (int i = A_CODE; i <= Z_CODE; i++) {
            if (s1CharMap.containsKey((char)i) || s2CharMap.containsKey((char)i)) {
                int value1 = s1CharMap.getOrDefault((char)i, 0);
                int value2 = s2CharMap.getOrDefault((char)i, 0);
                if (value1 > 1 || value2 > 1) {
                    int max;
                    String prefix;
                    if (value1 > value2) {
                        max = value1;
                        prefix = PREFIX_1;
                    } else if (value2 > value1) {
                        max = value2;
                        prefix = PREFIX_2;
                    } else {
                        max = Math.max(value1, value2);
                        prefix = PREFIX_EQUALS;
                    }
                    String substring = buildSubstring(prefix, max, i);
                    subStrings.add(substring);
                }
            }
        }
        return subStrings;
    }

    private static String buildSubstring(final String prefix, final int maxOccurrences, final int codepoint) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int j = 1; j <= maxOccurrences; j++) {
            sb.append((char) codepoint);
        }
        return sb.toString();
    }

    private static void sortSubstrings(final List<String> subStrings) {
        subStrings.sort((ss1, ss2) -> {
            if (ss1.length() == ss2.length()) {
                return ss1.compareTo(ss2);
            } else {
                return (-1) * Integer.compare(ss1.length(), ss2.length());
            }
        });
    }
}
