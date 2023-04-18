import java.util.*;

public class Main {
    public static void main(String[] args) {
        int maxAmountWords = 2;
        String[] randomWords = new String[]{"carcade", "mother", "papa", "gydini", "Danny", "varteq", "mama"};
        List<String> wordArrayList = resultDubl(randomWords, maxAmountWords);
        System.out.println();
    }

    public static List<String> resultDubl(String[] randomWords, int maxAmountWords) {
        List<String> result = new ArrayList<>();

          for (String word : randomWords) {
            char[] chars = word.toCharArray();

            Map<Character, Integer> duplicate = new HashMap<>();

            for (Character element : chars) {
                boolean isDuplicatesContainsChar = duplicate.containsKey(element);
                if (isDuplicatesContainsChar) {
                    int currentElementCount = duplicate.get(element);
                    duplicate.put(element, currentElementCount + 1);
                } else {
                    duplicate.put(element, 1);
                }


                Collection<Integer> values = duplicate.values();
                boolean isGoodWord = false;
                for (Integer value : values) {
                    if (value % 2 != 0) {
                        isGoodWord = false;
                        break;
                    } else {
                        isGoodWord = true;
                    }
                }
                if (isGoodWord) {
                    result.add(word);
                }
                if (result.size() == maxAmountWords) {
                    break;
                }

            }

        }
        Set<Character> set = new HashSet<>();
          for (String word : result) {
              for(Character uniqueChar : word.toCharArray()) {
                  set.add(uniqueChar);
              }
          }
        return result;
    }
}