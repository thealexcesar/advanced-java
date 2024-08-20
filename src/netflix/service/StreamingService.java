package netflix.service;

import netflix.domain.Content;
import netflix.domain.GenreType;
import netflix.domain.CategoryType;
import netflix.repository.DocumentariesRepository;
import netflix.repository.MoviesRepository;
import netflix.repository.SeriesRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StreamingService {
    private final MoviesRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final DocumentariesRepository documentariesRepository;

    public StreamingService(MoviesRepository movieRepository, SeriesRepository seriesRepository, DocumentariesRepository documentariesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
        this.documentariesRepository = documentariesRepository;
    }

    public List<Content> searchByTitle(String title) {
        List<Content> movies = movieRepository.findAll().stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        List<Content> series = seriesRepository.findAll().stream()
                .filter(serie -> serie.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());

        movies.addAll(series);
        return movies;
    }

    public List<Content> searchByGenre(GenreType genre) {
        List<Content> movies = movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
        List<Content> series = seriesRepository.findAll().stream()
                .filter(serie -> serie.getGenre() == genre).collect(Collectors.toList());

        movies.addAll(series);
        return movies;
    }

    public List<Content> searchByCategory(CategoryType category) {
        List<Content> movies = movieRepository.findAll().stream()
                .filter(movie -> movie.getCategory() == category).collect(Collectors.toList());
        List<Content> series = seriesRepository.findAll().stream()
                .filter(serie -> serie.getCategory() == category).collect(Collectors.toList());

        movies.addAll(series);
        return movies;
    }
}
