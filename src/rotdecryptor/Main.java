package rotdecryptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    // The string to decode
    private static String encoded = "YnFPRANvAPHVVYCREFBANTTVBCEVaPVCnYRZHBERABAZVCvNPR";

    private static List<Character> staticAlphabetLowercase = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z')
    );
    private static List<Character> rotationalAlphabetLowercase = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z')
    );
    private static List<Character> staticAlphabetUppercase = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z')
    );
    private static List<Character> rotationalAlphabetUppercase = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z')
    );

    private static List<String> decoded = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < staticAlphabetLowercase.size(); i++) {
            System.out.println("Static lowercase  : " + staticAlphabetLowercase);
            System.out.println("Rotated lowercase : " + rotationalAlphabetLowercase);
            System.out.println("Static uppercase  : " + staticAlphabetUppercase);
            System.out.println("Rotated uppercase : " + rotationalAlphabetUppercase);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < encoded.length(); j++) {
                int index = rotationalAlphabetLowercase.indexOf(encoded.toCharArray()[j]);
                if (index == -1) {
                    index = rotationalAlphabetUppercase.indexOf(encoded.toCharArray()[j]);
                    stringBuilder.append(staticAlphabetUppercase.get(index));
                } else {
                    stringBuilder.append(staticAlphabetLowercase.get(index));
                }
            }
            System.out.println(stringBuilder.toString());
            decoded.add(stringBuilder.toString());
            Collections.rotate(rotationalAlphabetLowercase, 1);
            Collections.rotate(rotationalAlphabetUppercase, 1);
            System.out.println("Rotation " + i + "\n");
        }

        for (String dec : decoded) System.out.println(dec);
    }

}
