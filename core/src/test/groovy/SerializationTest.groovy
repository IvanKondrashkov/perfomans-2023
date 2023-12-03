import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.serialization.Person

class SerializationTest {
    Person person
    Gson gson

    @BeforeEach
    void init() {
        person = new Person(33, 'Djon')
        gson = new GsonBuilder()
                .serializeNulls()
                .create()
    }

    @AfterEach
    void tearDown() {
        person = null
        gson = null
    }

    @Test
    void checkSerializationPerson() {
        def json = gson.toJson(person)

        assert json == "{\"age\":33,\"name\":\"Djon\"}"
    }

    @Test
    void checkDeserializationPerson() {
        def json = gson.toJson(person)

        assert json == "{\"age\":33,\"name\":\"Djon\"}"

        def person = gson.fromJson(json, Person.class)

        assert person.age == 33
        assert person.name == 'Djon'
    }
}