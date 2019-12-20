package com.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void staticTests() {
        assertEquals("no one likes this", FbLike.whoLikesIt());
        assertEquals("Peter likes this", FbLike.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", FbLike.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", FbLike.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", FbLike.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    @Test
    public void findTest() {
        assertEquals(5, FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, FindOdd.findIt(new int[]{10}));
        assertEquals(10, FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }

    @Test
    public void convertBinaryArrayToInt() throws Exception {

        assertEquals(1, BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 0, 0, 1))));
        assertEquals(15, BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,0,0,1))));
    }

    @Test
    public void oddOrderArray() {
        assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, OddOrderArray.sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, OddOrderArray.sortArray(new int[]{ 5, 3, 1, 8, 0 }));
        assertArrayEquals(new int[]{}, OddOrderArray.sortArray(new int[]{}));
    }

    @Test
    public void Tests() {
        assertEquals("00:00:00", HumanReadableTime.makeReadable(0));
        assertEquals("00:00:05", HumanReadableTime.makeReadable(5));
        assertEquals("00:00:59", HumanReadableTime.makeReadable(59));
        assertEquals("00:01:00", HumanReadableTime.makeReadable(60));
        assertEquals("23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("99:59:59", HumanReadableTime.makeReadable(359999));
    }

    @Test
    public void testFactorialZeros() throws Exception {
        assertThat(FactorialZero.zeros(0), is((0)));
        assertThat(FactorialZero.zeros(6), is(1));
        assertThat(FactorialZero.zeros(14), is(2));
    }

    @Test
    public void pangram1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertTrue(pc.check(pangram1));
    }
    @Test
    public void pangram2() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertFalse(pc.check(pangram2));
    }

    @Test
    public void lexicoSubstring() {
        String[] a = new String[]{ "arp", "live", "strong" };
        String[] b = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String[] r = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, LexicoSubstring.inArray(a, b));
    }

    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", Encryption.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", Encryption.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", Encryption.encrypt("This is a test!", 3));
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", 4));
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", Encryption.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", 0));
        assertEquals("This is a test!", Encryption.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", Encryption.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", Encryption.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", 4));
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", Encryption.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", Encryption.encrypt("", 0));
        assertEquals("", Encryption.decrypt("", 0));
        assertNull(Encryption.encrypt(null, 0));
        assertNull(Encryption.decrypt(null, 0));
    }



    @Test
    public void matrixTest() {
        int[][][] matrix = { {{1}},
                {{1, 3}, {2,5}},
                {{2,5,3}, {1,-2,-1}, {1, 3, 4}}};

        int[] expected = {1, -1, -20};

        String[] msg = {"Determinant of a 1 x 1 matrix yields the value of the one element",
                "Should return 1 * 5 - 3 * 2 == -1 ",
                ""};
        for (int n = 0 ; n < expected.length ; n++)
            assertEquals(expected[n], Matrix.determinant(matrix[n]), msg[n]);
    }

    @Test
    public void test() {
        assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", Accumul.accum("ZpglnRxqenU"));
        assertEquals("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb", Accumul.accum("NyffsGeyylB"));
        assertEquals("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu", Accumul.accum("MjtkuBovqrU"));
        assertEquals("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm", Accumul.accum("EvidjUnokmM"));
        assertEquals("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc", Accumul.accum("HbideVbxncC"));
    }

    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

    @Test
    public void testInteresting() {
        assertEquals(0, CarMileage.isInteresting(996, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(997, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(999, new int[]{}));
        assertEquals(0, CarMileage.isInteresting(1997, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(1998, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(1999, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(2000, new int[]{}));

        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));

        assertEquals(2, CarMileage.isInteresting(1234321, new int[]{}));

        assertEquals(2, CarMileage.isInteresting(6789, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(67890123, new int[]{}));

        assertEquals(2, CarMileage.isInteresting(98765, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(3210987, new int[]{}));

        assertEquals(2, CarMileage.isInteresting(999999999, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(98, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(99, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(100, new int[]{}));

    }

}
