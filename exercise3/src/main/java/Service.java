import java.util.ArrayList;
import java.util.List;

public class Service {

    boolean LOG;
    boolean TRIM;

    Service() {
        this(false, false);
    }

    Service(boolean trim) {
        this(trim, false);
    }

    Service(boolean trim, boolean log) {
        LOG = log;
        TRIM = trim;
    }


    public String getPalindrome(String str) {   //  O(N^3+N)=O(N^3)
        if (TRIM) str = clearString(str);
        String palindrome;

        List<String> palindromeList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {    //  O(N^2 * N)=O(N^3)
            for (int j = str.length(); j > i + 2; j--) {
                logger("i=" + i + " j=" + j + " " + str.substring(i, j));
                if (isPalindrome(str.substring(i, j))) {    // O(N)
                    palindromeList.add(str.substring(i, j));
                    break;
                }
            }
        }
        logger(palindromeList.toString());

        int max = 0, index = 0;
        for (int i = 0; i < palindromeList.size(); i++) {   // O(N)
            if (palindromeList.get(i).length() > max) {
                max = palindromeList.get(i).length();
                index = i;
            }
        }
        return palindromeList.size() != 0 ? palindromeList.get(index) : "";
    }

    private boolean isPalindrome(String palindrome) {   // O(N)
        int length = palindrome.length();
        int j = length - 1;

        for (int i = 0; i < length / 2; i++) {
            if (palindrome.charAt(i) != palindrome.charAt(j - i)) return false;
        }
        return true;
    }

    private String clearString(String str) {
        str = str.toLowerCase();
        return String.join("", str.split("\\s*(\\s|,|!|-|\\.)\\s*"));
    }

    private void logger(String str) {
        if (!LOG) return;
        System.out.println(str);
    }
}