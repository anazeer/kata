package com.test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        OptionalInt candidate = Stream.of(number, number + 1, number + 2)
                                      .filter(i -> i > 99)
                                      .map(String::valueOf)
                                      .filter(s -> Arrays.stream(awesomePhrases).anyMatch(phrase -> s.equals(String.valueOf(phrase)))
                                              || (s.chars().skip(1).allMatch(digit -> (char) digit == '0'))
                                              || (s.chars().allMatch(digit -> (char) digit == s.toCharArray()[0]))
                                              || s.equals(new StringBuilder(s).reverse().toString())
                                              || sequence(s, -1, '9', '0')
                                              || sequence(s, 1, '0', '9')
                                      )
                                      .mapToInt(Integer::parseInt)
                                      .findAny();
        return candidate.isPresent() ? candidate.getAsInt() == number ? 2 : 1 : 0;
    }

    public static boolean sequence(String number, int way, char limit1, char limit2) {
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if ((chars[i] != (chars[i + 1] + way)) && !(chars[i] == limit1 && chars[i + 1] == limit2)) {
                return false;
            }
        }
        return true;
    }

}
