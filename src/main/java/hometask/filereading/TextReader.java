package hometask.filereading;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;

public class TextReader {
    public static void main(String[] args) {
        final Logger LOG_TEXT = LogManager.getLogger(TextReader.class.getName());
        File artificialIntelligence = new File("src/main/resources/artificialIntelligence.txt");
        String fileContent = null;
        try {
            fileContent = FileUtils.readFileToString(artificialIntelligence, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!(fileContent.isEmpty())) {
            String[] words = fileContent.split(" ");
            HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            long countOfUniqueWords = uniqueWords.stream().count();
            String countWords = "Quantity of unique words is " + countOfUniqueWords;
            LOG_TEXT.info(countWords);
            try {
                File result = new File("src/main/resources/result.txt");
                FileUtils.touch(result);
                FileUtils.writeStringToFile(result, countWords, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
