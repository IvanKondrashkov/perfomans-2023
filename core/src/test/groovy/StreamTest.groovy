import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.util.stream.Collectors
import ru.kondrashkov.stream.model.Like
import ru.kondrashkov.stream.model.Film
import ru.kondrashkov.stream.model.Genre

class StreamTest {
    List<Film> films = []

    @BeforeEach
    void init() {
        def likes1 = [new Like(1, true), new Like(2, true), new Like(3, true)] as Set
        films << new Film(1, 'Побег из Шоушенга', 9.7, new Genre(1, 'Драма'), likes1)
        def likes2 = new HashSet<>(likes1)
        likes2.add(new Like(4, true))
        films << new Film(2, 'Один дома', 8.8, new Genre(2, 'Комедия'), likes2)
    }

    @AfterEach
    void tearDown() {
        films = null
    }

    @Test
    void checkCollectorsToCollection() {
        def films = films.stream()
                .collect(Collectors.toList())

        assert films instanceof List
        assert films.size() == 2

        films = films.stream()
                .collect(Collectors.toSet())

        assert films instanceof Set
        assert films.size() == 2

        films = films.stream()
                .collect(Collectors.toMap({it -> it.id}, {it -> it.name}))

        assert films instanceof Map
        assert films.size() == 2
    }

    @Test
    void checkCollect() {
        def genre = films.stream()
                .map {it.genre}.collect()

        assert genre.size() == 2
    }

    @Test
    void checkFilter() {
        def filtered = films.stream()
                .filter {it.rating > 9}
                .collect()

        assert filtered[0].id == 1
        assert filtered[0].name == 'Побег из Шоушенга'
        assert filtered[0].rating == 9.7
    }

    @Test
    void checkSorted() {
        def sorted = films.stream()
                .sorted {o1, o2 -> o2.likes.findAll {it.isLike}.size() <=> o1.likes.findAll {it.isLike}.size()}
                .collect()

        assert sorted[0].id == 2
        assert sorted[0].name == 'Один дома'
        assert sorted[0].rating == 8.8
        assert sorted[0].likes.size() == 4
        assert sorted[1].id == 1
        assert sorted[1].name == 'Побег из Шоушенга'
        assert sorted[1].rating == 9.7
        assert sorted[1].likes.size() == 3
    }
}