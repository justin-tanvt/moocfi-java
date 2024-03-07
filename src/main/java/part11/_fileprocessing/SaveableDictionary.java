package part11._fileprocessing;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SaveableDictionary {

    private final String DELIMITER = ":";
    BiMap<String, String> translations;
    private final String dictSaveFilePath;

    public SaveableDictionary(String file) {
        this.translations = HashBiMap.create();
        this.dictSaveFilePath = file;
    }

    public boolean load() {
        try (Stream<String> lines = Files.lines(Paths.get(this.dictSaveFilePath))) {
            lines.map(line -> line.split(DELIMITER))
                    .filter(parts -> parts.length == 2)
                    .forEach(parts -> {
                        String word = parts[0];
                        String translation = parts[1];

                        this.add(word, translation);
                    });
        } catch (IOException x) {
            x.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(this.dictSaveFilePath)) {
            this.translations.forEach((word, translation) -> {
                writer.print(word);
                writer.print(DELIMITER);
                writer.println(translation);
            });
        } catch (FileNotFoundException x) {
            x.printStackTrace();
            return false;
        }

        return true;
    }

    public void add(String word, String translation) {
        if (this.translations.containsKey(word)
                || this.translations.containsValue(word)) {
            System.out.println("ERROR: [" + word + "] is already in dictionary!");
        } else if (this.translations.containsKey(translation)
                || this.translations.containsValue(translation)) {
            System.out.println("ERROR: [" + translation + "] is already in dictionary!");
        }

        this.translations.put(word, translation);
    }

    public String translate(String word) {
        if (this.translations.containsKey(word)) {
            return this.translations.get(word);
        } else if (this.translations.containsValue(word)) {
            return this.translations.inverse().get(word);
        }

        return null;
    }

    public void delete(String word) {
        if (this.translations.containsKey(word)) {
            this.translations.remove(word);
        } else if (this.translations.containsValue(word)) {
            this.translations.inverse().remove(word);
        }
    }
}
