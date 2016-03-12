package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LettersCounter {
    public static void main(String[] args) {
        Set<String> letters = new HashSet<>(33);
        String text;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<11; i++){
            try {
                text = reader.readLine();
                for(char letter : text.toCharArray())
                    if (Character.isLetter(letter))
                    letters.add(String.valueOf(letter));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("letters amount in lines: " + letters.size());
    }
}
