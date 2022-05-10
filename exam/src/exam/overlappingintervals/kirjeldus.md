### 02 - `popularLetters` (50p)

Sisendiks on list listidest, mis tähistab lõike tähestikus formaadis {esimene vahemiku täht, viimane vahemiku täht}
Tähed võivad alamlistides olla suvalises järjekorras ehk {c, a} on üks võimalik sisend.
Sisendis on ainult väiksed tähed ja me kasutame inglise tähestikku, et täpitähti pole vaja arvestada.
On vaja leida kõige populaarsem(ad) tähed, mis esinevad nendes tähtede intervallides.
Tagastada tuleb list tähest või kui on mitu sama populaarset tähte siis tähtedest, mis on sorteeritud tähestiku järgi kasvavalt.

Vaata näiteid mallist.


```java
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
```

