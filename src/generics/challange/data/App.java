package generics.challange.data;

import generics.challange.data.domain.CsvData;
import generics.challange.data.domain.DataProcessor;
import generics.challange.data.domain.TextData;
import generics.challange.data.domain.CsvDataProcessor;
import generics.challange.data.domain.TextDataProcessor;

import java.util.List;

public class App {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        String textFilePath = currentDir + "/java/assets/textfile.txt";
        String csvFilePath = currentDir + "/java/assets/csvfile.csv";

        try {
            DataProcessor<TextData> textDataProcessor = new TextDataProcessor();
            List<TextData> textData = textDataProcessor.process(textFilePath);
            textDataProcessor.analyze(textData);

            DataProcessor<CsvData> csvDataProcessor = new CsvDataProcessor();
            List<CsvData> csvData = csvDataProcessor.process(csvFilePath);
            csvDataProcessor.analyze(csvData);
        } catch (Exception e) {
            System.err.println("ERRO: "+e.getMessage());
        }
    }
}
