import org.junit.jupiter.api.Test
import ru.kondrashkov.annotation.Id
import ru.kondrashkov.stream.model.Like
import ru.kondrashkov.stream.model.Film
import ru.kondrashkov.stream.model.Genre

class AnnotationTest {

    @Test
    void checkAnnotationIsId() {
        def likes = [new Like(1, true), new Like(2, true), new Like(3, true)] as Set
        def film = new Film(1, 'Побег из Шоушенга', 9.7, new Genre(1, 'Драма'), likes)

        def isId
        def name

        film.getClass().getDeclaredFields().each {
            if (it.isAnnotationPresent(Id.class)) {
                isId = true
                name = it.name
            }
        }

        assert name == 'id'
        assert isId == true
    }
}