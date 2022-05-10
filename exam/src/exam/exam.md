## Ülesanded

### 01 - `frequencyBasedSort` (50p)

Sisendiks on sõne arvudest, mis eraldatud komadega ehk on fromaadis `arv,arv,arv`.
Tagasta list, milles on kõige enim esinenud arvud eespool,
kui kahte arvu on esinenud sama palju siis peab olema suurem arv eespool.

Vaata näiteid mallist.

### 02 - `popularLetters` (50p)

Sisendiks on list listidest, mis tähistab lõike tähestikus formaadis {esimene vahemiku täht, viimane vahemiku täht}
Tähed võivad alamlistides olla suvalises järjekorras ehk {c, a} on üks võimalik sisend.
Sisendis on ainult väiksed tähed ja me kasutame inglise tähestikku, et täpitähti pole vaja arvestada.
On vaja leida kõige populaarsem(ad) tähed, mis esinevad nendes tähtede intervallides.
Tagastada tuleb list tähest või kui on mitu sama populaarset tähte siis tähtedest, mis on sorteeritud tähestiku järgi kasvavalt.

Vaata näiteid mallist.

## Mall

```java

package ee.taltech.iti0202.exam;

public class Exam {

    /**
     You are given a string as an input where which represents a sequence of numbers in the format `num, num, num`
     Make a function frequencyBasedSort that returns a list where the most popular numbers of the input
     are at the front and the least popular numbers are at the back of the list.
     If two numbers are equally popular then the bigger number must come first.

     Examples:
     frequencyBasedSort("3,1") => {3, 1}
     frequencyBasedSort("3,3,2,4,5,1,5") => {5, 5, 3, 3, 4, 2, 1}
     frequencyBasedSort("1,2,3,4,5,1,2,2,3,3,1") => {3, 3, 3, 2, 2, 2, 1, 1, 1, 5, 4}

     @param input the sequence of numbers as a string, separate the numbers by coma and leave no empty spaces
     @return a list that is sorted by to number popularity
     */
    public static int frequencyBasedSort(String input) {
        return null;
    }
    
    /**
     * Method takes input as a nested list where each sublist contains a pair of letters that represents an interval.
     * The pairs represent intervals in the alphabet so for instance {a, d} should actually be {a, b, c, d}.
     * Find the most popular letters in the intervals and return them in a list.
     * If there is only one most popular letter then only add that to the returnable list.
     * Else return list containing the most popular letters that have the same amount of occurrences,
     * the list should be sorted ascending according to the alphabet.
     * There aren`t any unique estonian letters so the letters in user are abcdefghijklmnopqrstuvwxyz.
     * The letters aren`t ordered correctly all the time so there could be a pair that is in format {c, a},
     * also {a, a} is a valid interval as well.
     *
     * Examples: 
     * popularLetters(List.of(List.of("z","z"))) => {z}
     * popularLetters(List.of(List.of("a","b"))) => {a, b}
     * popularLetters(List.of(List.of("c","a"))) => {a, b, c}
     * popularLetters(List.of(List.of("a","b"), List.of("b","c"), List.of("c","d"), List.of("a","c"))) => {a, b}
     * popularLetters(List.of(List.of("a","b"), List.of("c","d"), List.of("z","z"), List.of("a","c"))) => {a, b, c}

     *
     * @param input is a nested list where each sublist is a pair of letters that represents an interval
     * @return return a list with the most popular letters in those intervals
     */
    public static List<String> popularLetters(List<List<String>> input) {
        return null;
    }
}
```