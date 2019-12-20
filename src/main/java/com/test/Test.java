package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FbLike {

    private static final String TEMPLATE = "%s and %s like this";

    public static String whoLikesIt(String... names) {
        if (names == null || names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length == 2) {
            return String.format(TEMPLATE, names[0], names[1]);
        } else {
            String first = String.join(", ", names[0], names[1]);
            return String.format(TEMPLATE, first, names.length == 3 ? names[2] : (names.length - 2 + " others"));
        }
    }

}

class FindOdd {
    public static int findIt(int[] a) {
        List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
        return list.stream().filter(i -> Collections.frequency(list, i) % 2 == 1).findFirst().orElseThrow();
    }

}

class Dubstep {
    public static String SongDecoder(String song) {
        if (song == null || song.isBlank()) {
            return "";
        }
        return song.replaceAll("(WUB)+", " ").trim();
    }

}

class BinaryArrayToNumber {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        if (binary == null || binary.isEmpty()) {
            return 0;
        }

        String binaryString = binary.stream().map(Object::toString).collect(Collectors.joining());
        return Integer.parseInt(binaryString, 2);
    }

}

class OddOrderArray {
    public static int[] sortArray(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        } else {
            int[] sortedOdd = Arrays.stream(array).filter(i -> i % 2 != 0).sorted().toArray();
            int[] res = new int[array.length];
            for (int i = 0, k = 0; i < array.length; i++) {
                res[i] = array[i] % 2 == 0 ? array[i] : sortedOdd[k++];
            }
            return res;
        }
    }

}

class HumanReadableTime {
    public static String makeReadable(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, seconds / 60 % 60, seconds % 60);
    }

}

class FactorialZero {
    public static int zeros(int n) {
        int res = 0;
        int i = 5;
        while (n / i >= 1) {
            res += n / i;
            i *= 5;
        }
        return res;
    }

}

class PangramChecker {
    public boolean check(String sentence) {
        return sentence.toLowerCase().chars()
                       .filter(Character::isAlphabetic)
                       .distinct()
                       .count() == 26;
    }

}

class LexicoSubstring {

    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                     .filter(s1 -> Arrays.stream(array2)
                                         .anyMatch(s2 -> s2.endsWith(s1)))
                     .distinct()
                     .sorted()
                     .toArray(String[]::new);

    }

}

class Encryption {

    public static String encrypt(final String text, final int n) {
        if (text == null || text.isBlank()) {
            return text;
        }
        String result = text;
        for (int k = 0; k < n; k++) {
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            int length = result.length();
            for (int i = 0; i < length - 1; i += 2) {
                prefix.append(result.charAt(i + 1));
                suffix.append(result.charAt(i));
            }
            result = prefix.toString() + suffix.toString() + (length % 2 == 1 ? result.charAt(length - 1) : "");
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.isBlank()) {
            return encryptedText;
        }
        String result = encryptedText;

        for (int k = 0; k < n; k++) {
            int length = result.length();
            int mid = length >> 1;
            char[] temp = new char[result.length()];
            for (int i = 0, j = 0; i < length - 1; i += 2, j++) {
                temp[i] = result.charAt(mid + j);
                temp[i + 1] = result.charAt(j);
            }
            temp[length - 1] = length % 2 == 1 ? result.charAt(length - 1) : result.charAt(mid - 1);
            result = new String(temp);
        }
        return result;
    }

}

class Matrix {

    private static int[][] minorMatrix(int[][] matrix, int pivotColumn) {
        int[][] minorMatrix = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0, column = 0; j < matrix.length; j++) {
                if (j != pivotColumn) {
                    minorMatrix[i - 1][column++] = matrix[i][j];
                }
            }
        }
        return minorMatrix;
    }

    public static int determinant(int[][] matrix) {
        if (matrix.length == 0 || Arrays.stream(matrix).noneMatch(line -> line.length == matrix[0].length)) {
            throw new IllegalArgumentException("Matrix should be N x N 2D array");
        }
        if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int result = 0;
            for (int i = 0, factor = 1; i < matrix.length; i++, factor *= -1) {
                result += factor * matrix[0][i] * determinant(minorMatrix(matrix, i));
            }
            return result;
        }
    }

}

class Accumul {

    public static String accum(String str) {
        return Stream.iterate(0, n -> n + 1)
                     .limit(str.length())
                     .map(n -> ("" + str.charAt(n)).toLowerCase().repeat(n + 1))
                     .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                     .collect(Collectors.joining("-"));
    }

}

class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("seconds should be positive");
        }
        if (seconds == 0) {
            return "now";
        }

        String result = Stream.of(
                getTimeText(seconds / 31536000, "year"),
                getTimeText(seconds / 86400 % 365, "day"),
                getTimeText(seconds / 3600 % 24, "hour"),
                getTimeText(seconds / 60 % 60, "minute"),
                getTimeText(seconds % 3600 % 60, "second"))
                               .filter(s -> !s.isEmpty())
                               .collect(Collectors.joining(", "));
        int index = result.lastIndexOf(", ");
        if (index > 0)
            result =  result.substring(0, index) + result.substring(index).replaceFirst(", ", " and ");
        return result;
    }

    public static String getTimeText(int time, String text) {
        String result =  time != 0 ? String.format("%d %s", time, text) : "";
        return result + (time > 1 ? "s" : "");
    }

}
