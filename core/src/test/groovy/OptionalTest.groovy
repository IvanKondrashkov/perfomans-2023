import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.serialization.Person

class OptionalTest {
    Optional<Person> person

    @BeforeEach
    void init() {
        person = Optional.of(new Person(33, 'Djon'))
    }

    @AfterEach
    void tearDown() {
        person = null
    }

    @Test
    void checkOptionalNotEmpty() {
        person.isPresent() == true
    }

    @Test
    void checkOptionalOfEmpty() {
        person = Optional.empty()

        person.isPresent() == false
        person.isEmpty() == true
    }

    @Test
    void checkOptionalOrElseGet() {
        person = Optional.ofNullable(null).orElseGet(
                () -> Optional.of(new Person(22, 'Nik'))
        )

        assert person.get().age == 22
        assert person.get().name == 'Nik'
    }

    @Test
    void checkOptionalOrElseThrow() {
        try {
            person = Optional.ofNullable(null).orElseThrow(
                    () -> new IllegalArgumentException()
            )
        } catch (Exception ex) {
            assert ex instanceof IllegalArgumentException
        }
    }
}