package exam.overlappingintervals;


import org.testng.annotations.Test;
import ee.ttu.java.studenttester.annotations.Gradable;
import ee.ttu.java.studenttester.annotations.TestContextConfiguration;
import ee.ttu.java.studenttester.enums.ReportMode;
import static ee.taltech.iti0202.exam.Exam.decodeMessage;
import static org.testng.Assert.assertEquals;
import java.util.*;
import java.util.stream.Collectors;



@TestContextConfiguration(mode = ReportMode.MAXVERBOSE, identifier = 3)
public class PopularLettersTest {
    private HashMap<Integer, String> testingAlphabetHashMapIntStr;
    private HashMap<String, Integer> testingAlphabetHashMapStrInt;
    private List<String> testAlphabet;

    public PopularLettersTest() {
        testAlphabet = List.of("abcdefghijklmnopqrstuvwxyz".split(""));
        testingAlphabetHashMapIntStr = new HashMap<>();
        testingAlphabetHashMapStrInt = new HashMap<>();
        for (int i = 0; i < testAlphabet.size(); i++) {
            testingAlphabetHashMapIntStr.put(i, testAlphabet.get(i));
            testingAlphabetHashMapStrInt.put(testAlphabet.get(i), i);
        }


    }


    @Test(timeOut = 1000)
    public void testPopularLettersSimple() {
        assertEquals(Exam.popularLetters(List.of(List.of("a","a"))), List.of("a"));
        assertEquals(Exam.popularLetters(List.of(List.of("x","z"))), List.of("x", "y", "z"));
        assertEquals(Exam.popularLetters(List.of(List.of("a","c"))), List.of("a", "b", "c"));
        assertEquals(Exam.popularLetters(List.of(List.of("a","c"), List.of("a","d"), List.of("a","d")))
                , List.of("a", "b", "c"));
        assertEquals(Exam.popularLetters(List.of(List.of("p", "s"), List.of("p", "s"))), List.of("p", "q", "r", "s"));
        assertEquals(Exam.popularLetters(List.of(List.of("a", "z"))), List.of("abcdefghijklmnopqrstuvwxyz".split("")));
    }

    @Test(timeOut = 1000)
    public void testPopularLetterBackwardsInput() {
        assertEquals(Exam.popularLetters(List.of(List.of("z","x"))), List.of("x", "y", "z"));
        assertEquals(Exam.popularLetters(List.of(List.of("c","a"))), List.of("a", "b", "c"));
        assertEquals(Exam.popularLetters(List.of(List.of("c","f"), List.of("d","a"), List.of("d","a")))
                , List.of("c", "d"));
        assertEquals(Exam.popularLetters(List.of(List.of("s", "p"), List.of("s", "p"))), List.of("p", "q", "r", "s"));
        assertEquals(Exam.popularLetters(List.of(List.of("z", "a"))), List.of("abcdefghijklmnopqrstuvwxyz".split("")));
    }

    @Test(timeOut = 1000)
    public void testPopularLettersBothWaysInput() {
        assertEquals(Exam.popularLetters(List.of(List.of("r", "t"), List.of("t", "r"))), List.of("r", "s", "t"));
        assertEquals(Exam.popularLetters(List.of(List.of("f", "i"), List.of("h", "h") , List.of("i", "f"))), List.of("h"));
        assertEquals(Exam.popularLetters(List.of(List.of("d", "f"), List.of("g", "f"))), List.of("f"));
        assertEquals(Exam.popularLetters(List.of(List.of("p", "r"), List.of("s", "o"))), List.of("p", "q", "r"));
        assertEquals(Exam.popularLetters(List.of(List.of("w", "x"), List.of("z", "y"), List.of("f", "x"), List.of("x", "f"))), List.of("w", "x"));
    }

    @Test(timeOut = 1000)
    public void testRandomInputSmall() {
        int inputSize = 10;
        List<List<String>> inpt = generateRandomTestInputs(inputSize);
        for (int i = 0; i < 8; i++) {
            assertEquals(Exam.popularLetters(inpt), popularLettersSolution(inpt));
            inputSize += 5;
            inpt = generateRandomTestInputs(inputSize);
        }
    }

    @Test(timeOut = 1000)
    public void testRandomInputLarge() {
        int inputSize = 10;
        List<List<String>> inpt = generateRandomTestInputs(inputSize);
        for (int i = 0; i < 5; i++) {
            assertEquals(Exam.popularLetters(inpt), popularLettersSolution(inpt));
            inputSize *= 10;
            inpt = generateRandomTestInputs(inputSize);
        }
    }

    public List<String> generateRandomString() {
        Random rnd = new Random();
        return List.of(testingAlphabetHashMapIntStr.get(rnd.nextInt(26)), testingAlphabetHashMapIntStr.get(rnd.nextInt(26)));
    }

    public List<List<String>> generateRandomTestInputs(int inputSize) {
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            output.add(generateRandomString());
        }
        return output;
    }


    public List<String> popularLettersSolution(List<List<String>> input) {
        HashMap<Integer, Integer> countLetters = new HashMap<>();
        List<String> current;
        int firstIndex;
        int lastIndex;
        for (int i = 0; i < input.size(); i++) {
            current = input.get(i).stream().sorted().collect(Collectors.toList());
            firstIndex = testingAlphabetHashMapStrInt.get(current.get(0));
            lastIndex = testingAlphabetHashMapStrInt.get(current.get(1));
            for (int j = firstIndex; j < lastIndex + 1; j++) {
                if (countLetters.containsKey(j)) {
                    countLetters.replace(j, countLetters.get(j) + 1);
                } else {
                    countLetters.put(j, 1);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> sortedEntry = countLetters.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();
        List<String> answer = new LinkedList<>();
        int max = sortedEntry.get(0).getValue();
        firstIndex = 0;
        while (firstIndex != sortedEntry.size() && sortedEntry.get(firstIndex).getValue().equals(max)) {
            answer.add(testingAlphabetHashMapIntStr.get(sortedEntry.get(firstIndex).getKey()));
            firstIndex++;
        }
        return answer;

    }


}
