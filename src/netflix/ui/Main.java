package netflix.ui;

import netflix.repository.DocumentariesRepository;
import netflix.repository.MoviesRepository;
import netflix.repository.SeriesRepository;
import netflix.repository.UserRepository;
import netflix.service.UserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        CompletableFuture<MoviesRepository> moviesFuture = CompletableFuture.supplyAsync(MoviesRepository::new);
        CompletableFuture<SeriesRepository> seriesFuture = CompletableFuture.supplyAsync(SeriesRepository::new);
        CompletableFuture<DocumentariesRepository> documentariesFuture = CompletableFuture.supplyAsync(DocumentariesRepository::new);

        try {
            MoviesRepository movieRepository = moviesFuture.get();
            SeriesRepository seriesRepository = seriesFuture.get();
            DocumentariesRepository documentariesRepository = documentariesFuture.get();
            UserService userService = new UserService(userRepository);

            new LoginMenu(userService).displayMenu();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
