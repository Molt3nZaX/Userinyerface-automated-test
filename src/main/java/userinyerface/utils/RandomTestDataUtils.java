package userinyerface.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static aquality.selenium.browser.AqualityServices.getLogger;

public class RandomTestDataUtils {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String cyrillicCharacters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String cyrillicRandomString = generateRandomCyrillicString(1);

    public static List<Integer> ThreeRandomIndexForCheckbox() {
        int quantityRandomNumbers = 3;
        Random random = new Random();
        List<Integer> randomNumbersList = new ArrayList<>();

        for (int i = 0; i <= quantityRandomNumbers; i++) {
            int number;
            number = random.nextInt(20) + 1;
            if (!randomNumbersList.contains(number) && number != 18) {
                randomNumbersList.add(number);
            }
        }
        return randomNumbersList;
    }

    public static String generateRandomCyrillicString(int quantity) {
        int randomCharIndex = RANDOM.nextInt(cyrillicCharacters.length());
        List<String> cyrillicList = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            cyrillicList.add(String.valueOf(cyrillicCharacters.charAt(randomCharIndex)));
        }
        return String.join("", cyrillicList);
    }

    public static String generateRandomValidPassword() {
        getLogger().info("Generating a random valid password");
        String upperCaseRandomString = RandomStringUtils.random(1, 65, 90, true, true);
        String lowerCaseRandomString = RandomStringUtils.random(1, 97, 122, true, true);
        String numbersRandomString = RandomStringUtils.randomNumeric(1);
        String randomAlphanumericString = RandomStringUtils.randomAlphanumeric(6);
        String demoPassword = upperCaseRandomString.concat(lowerCaseRandomString)
                .concat(numbersRandomString)
                .concat(cyrillicRandomString)
                .concat(randomAlphanumericString);
        return getShuffleString(demoPassword);
    }

    public static String generateRandomEmail(int quantitySymbols) {
        getLogger().info("Generating a random valid email");
        String randomString = RandomStringUtils.randomAlphanumeric(quantitySymbols);
        String demoEmail = randomString.concat(cyrillicRandomString);
        return getShuffleString(demoEmail);
    }

    public static String generateRandomDomain(int quantitySymbols) {
        getLogger().info("Generating a random valid domain");
        return getShuffleString(RandomStringUtils.randomAlphanumeric(quantitySymbols));
    }

    private static String getShuffleString(String unshuffleString) {
        List<Character> listOfChar = unshuffleString.chars()
                .mapToObj(data -> (char) data)
                .collect(Collectors.toList());
        Collections.shuffle(listOfChar);
        return listOfChar.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}