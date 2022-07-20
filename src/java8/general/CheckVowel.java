package java8.general;

public class CheckVowel {

    public static void main(String args[]) {
        System.out.print(isVowelCharacter("x"));
    }

    private static boolean isVowelCharacter(String c) {
        String vowelString = "aeiou";
        if (vowelString.contains(c)) {
            return true;
        }
        return false;
    }
}
