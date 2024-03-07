package vocabulary;

import java.util.*;

public class Dictionary {
    private final Map<String, String> translations;
    private final List<String> words;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.words = new ArrayList<>();

        add("sana", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        this.translations.put(word, translation);
    }

    public String getRandomWord() {
        Random rd = new Random();
        return this.words.get(rd.nextInt(this.words.size()));
    }

    Set<Map.Entry<String, String>> getAllPairs() {
        return this.translations.entrySet();
    }

    int size() {
        return this.translations.size();
    }
}

