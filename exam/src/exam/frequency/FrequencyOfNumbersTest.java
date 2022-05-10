package exam.frequency;

import org.testng.annotations.Test;
import ee.ttu.java.studenttester.annotations.Gradable;
import ee.ttu.java.studenttester.annotations.TestContextConfiguration;
import ee.ttu.java.studenttester.enums.ReportMode;
import static ee.taltech.iti0202.exam.Exam.frequencyBasedSort;
import static org.testng.Assert.assertEquals;
import java.util.*;


@TestContextConfiguration(mode = ReportMode.MAXVERBOSE, identifier = 4)
public class FrequencyOfNumbersTest {


    @Test(timeOut = 1000)
   public void testFrequencyBasedSortSimple (){
       assertEquals(Exam.frequencyBasedSort("1,2"), List.of(2,1));
       assertEquals(Exam.frequencyBasedSort("5,6,7,8,5"), List.of(5,5,8,7,6));
       assertEquals(Exam.frequencyBasedSort("1,2,3,4,5,6,7,8,9,10,11,12,13,14,1,2,11,5,100,1,11"), List.of(11, 11, 11, 1, 1, 1, 5, 5, 2, 2, 100, 14, 13, 12, 10, 9, 8, 7, 6, 4, 3));
       assertEquals(Exam.frequencyBasedSort("66,2,3,3,5,6,7,8,9,8,11,12,100,14,70,50,11,5,100,6,15"), List.of(100, 100, 11, 11, 8, 8, 6, 6, 5, 5, 3, 3, 70, 66, 50, 15, 14, 12, 9, 7, 2));

    }

    @Test(timeOut = 1000)
   public void testFrequencyBasedSortMultipleMaximumFrequencyNumbers (){
       assertEquals(Exam.frequencyBasedSort("1,2,1,2,1,2,1,2,3,3,3,3"), List.of(3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1));
       assertEquals(Exam.frequencyBasedSort("5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6"), List.of(6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5));
       assertEquals(Exam.frequencyBasedSort("1,1,1,1,1,11,11,11,111,111,111,5,6,7,1111,1111,1111,1111,1111"), List.of(1111, 1111, 1111, 1111, 1111, 1, 1, 1, 1, 1, 111, 111, 111, 11, 11, 11, 7, 6, 5));
        assertEquals(Exam.frequencyBasedSort("6,6,6,6,3,3,3,3,9,9,9,9,1,7,8,116,15,11,19"), List.of(9, 9, 9, 9, 6, 6, 6, 6, 3, 3, 3, 3, 116, 19, 15, 11, 8, 7, 1));
    }

    @Test(timeOut = 1000)
    public void testFrequencyBasedSortRandomSmall() {
        int inputSize = 10;
        String input = generateRandomStringOfNumbers(inputSize);
        assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        for (int i = 0; i < 10; i++) {
            inputSize += 10;
            input = generateRandomStringOfNumbers(inputSize);
            assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        }
    }

    @Test(timeOut = 1000)
    public void testFrequencyBasedSortRandomMedium() {
        int inputSize = 100;
        String input = generateRandomStringOfNumbers(inputSize);
        assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        for (int i = 0; i < 10; i++) {
            inputSize += 100;
            input = generateRandomStringOfNumbers(inputSize);
            assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        }

    }


    @Test(timeOut = 1000)
    public void testFrequencyBasedSortRandomLarge() {
        String input = generateRandomStringOfNumbers(1000);
        assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        input = generateRandomStringOfNumbers(10000);
        assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
       input = generateRandomStringOfNumbers(100000);
       assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
        input = generateRandomStringOfNumbers(100000);
        assertEquals(Exam.frequencyBasedSort(input), frequencyBasedSortSolved(input));
    }


    public String generateRandomStringOfNumbers(int size) {
        Random random = new Random();
        int upperbound = 100;
        StringBuilder str = new StringBuilder();
        str.append(random.nextInt(upperbound));
        for (int i = 0; i < size; i++) {
            str.append(',');
            str.append(random.nextInt(upperbound));
        }
        return str.toString();
    }

    public List<Integer> frequencyBasedSortSolved(String input) {
        List<String> numbersString =   Arrays.stream(input.split(",")).toList();
        List<Integer> numbersInteger = numbersString
                .stream()
                .map(Integer::parseInt)
                .toList();
        HashMap<Integer, Integer> numbersCountMap = new HashMap<>();
        for (int i = 0; i < numbersString.size(); i++) {
            int number = numbersInteger.get(i);
            if (!numbersCountMap.containsKey(number)) {
                numbersCountMap.put(number, 1);
            } else {
                int numberCount = numbersCountMap.get(number);
                numberCount++;
                numbersCountMap.replace(number, numberCount);
            }
        }
        List<Map.Entry<Integer, Integer>> numbersCountList =
                numbersCountMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < numbersCountList.size(); i++) {
            Map.Entry<Integer, Integer> entry = numbersCountList.get(i);
            int counter = 0;
            while (counter < entry.getValue()) {
                answer.add(entry.getKey());
                counter++;
            }
        }
        return answer;
    }


}


