import java.util.regex.Pattern;

class Solution {
    private static final Pattern VALID = Pattern.compile(
        "^(?=.{3,})(?=.*[aeiouAEIOU])(?=.*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])[A-Za-z0-9]+$"
    );

    public boolean isValid(String word) {
        return VALID.matcher(word).matches();
    }
}
