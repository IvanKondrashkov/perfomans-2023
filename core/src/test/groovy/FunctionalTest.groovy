import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.stream.model.Film
import ru.kondrashkov.stream.model.Like
import ru.kondrashkov.stream.model.Genre
import ru.kondrashkov.functional.service.FilmService

class FunctionalTest {
    List<Film> films = []
    FilmService filmService

    @BeforeEach
    void init() {
        def likes1 = [new Like(1, true), new Like(2, true), new Like(3, true)] as Set
        films << new Film(1, 'Побег из Шоушенга', 9.7, new Genre(1, 'Драма'), likes1)
        def likes2 = new HashSet<>(likes1)
        likes2.add(new Like(4, true))
        films << new Film(2, 'Один дома', 8.8, new Genre(2, 'Комедия'), likes2)

        filmService = new FilmService()
    }

    @AfterEach
    void tearDown() {
        films = null
        filmService = null
    }

    @Test
    void checkPredicate() {
        def filtered = filmService.filter(films, film -> film.likes.size() > 3)

        assert filtered.size() == 1
        assert filtered[0].id == 2
        assert filtered[0].name == 'Один дома'
        assert filtered[0].rating == 8.8
        assert filtered[0].likes.size() == 4
    }

    @Test
    void checkFunction() {
        def likes = filmService.getLikes(films, film -> film.likes)

        assert likes instanceof Set
        assert likes.size() == 2
    }

    @Test
    void checkSupplier() {
        def ratings = filmService.getFilmsRandomRating(films, () -> Math.random())

        assert ratings.size() == 2
    }

    @Test
    void checkConsumer() {
        filmService.setRating(films, film -> film.rating = film.rating + 1)

        assert films[0].id == 1
        assert films[0].name == 'Побег из Шоушенга'
        assert films[0].rating == 10.7
        assert films[1].id == 2
        assert films[1].name == 'Один дома'
        assert films[1].rating == 9.8
    }

    @Test
    void checkUnaryOperator() {
        def ratings = filmService.getFilmsRatingX2(films, rating -> rating * 2)

        assert ratings[0] == 19.4
        assert ratings[1] == 17.6
    }

    @Test
    void checkBinaryOperator() {
        def filmsNames = filmService.getFilmsShortDescription(films, (filmName, filmGenre) -> "${filmName} - ${filmGenre}")

        assert filmsNames.size() == 2
        assert filmsNames[0] == 'Побег из Шоушенга - Драма'
        assert filmsNames[1] == 'Один дома - Комедия'
    }
}