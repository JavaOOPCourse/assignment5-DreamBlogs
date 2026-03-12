import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("0 — Exit");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // ODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;

        for (char ch:input.toCharArray()) {
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                count+=1;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // ODO: Вывести строку в обратном порядке

        String reversed = "";
        for(int i=input.length()-1; i>=0; i--) {

            reversed+=input.charAt(i);
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // ODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        // что такое регистр?
        boolean isPalindrome = true;
        String reversed = "";
        for(int i=input.length()-1;i>=0;i--) {
            reversed+=input.charAt(i);
        }
        for(int i=input.length()/2-1; i>=0;i--) {
            if (input.charAt(i)!=reversed.charAt(i)) {
                isPalindrome=false;
            }
        }


        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // ODO: Подсчитать количество слов в предложении
        int wordCount = 0;

        String trimmedInput = sentence.trim();

        if (!trimmedInput.isEmpty()) {
            String[] words = trimmedInput.split("\\s+");

            wordCount = words.length;
        }

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // ODO: Удалить все пробелы из строки
        String noSpaces = "";
        for(char ch:input.toCharArray()) {
            if (ch!=' ') {
                noSpaces+=ch;
            }
        }

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Преобразовать первую букву каждого слова в заглавную

        if (sentence == null || sentence.isEmpty()) {
            System.out.println("");
            return;
        }

        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // 1. Первая буква в верхний регистр
                String firstLetter = word.substring(0, 1).toUpperCase();

                // 2. Остальная часть слова (со 2-го символа)
                String restOfWord = word.substring(1);

                // 3. Добавляем в StringBuilder и не забываем пробел после слова
                sb.append(firstLetter).append(restOfWord).append(" ");
            }
        }

        String result = sb.toString().trim();
        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // ODO: Найти символ, который встречается чаще всего

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch:input.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        char mostFrequent = ' ';
        int maxCount = -1;

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        String cleanStr1 = str1.replaceAll("\\s+", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("\\s+", "").toLowerCase();

        // ODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams;

        if (cleanStr1.length() != cleanStr2.length()) {
            areAnagrams = false;
        } else {
            char[] charArray1 = cleanStr1.toCharArray();
            char[] charArray2 = cleanStr2.toCharArray();

            java.util.Arrays.sort(charArray1);
            java.util.Arrays.sort(charArray2);

            areAnagrams = java.util.Arrays.equals(charArray1, charArray2);
        }

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}
