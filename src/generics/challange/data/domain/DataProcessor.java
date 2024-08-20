package generics.challange.data.domain;

import java.util.List;

public interface DataProcessor<T> {
    List<T> process(String filePath);
    void analyze(List<T> data);
}
