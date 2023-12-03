import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.io.WriterText

class WriteTextTest {
    File file

    @BeforeEach
    void init() {
        file = new File('output.txt')
    }

    @AfterEach
    void tearDown() {
        file.delete()
    }

    @Test
    void checkSaveText() {
        WriterText.saveText(file)
        def actual

        file.withReader { reader ->
            actual = reader.readLine()
        }

        assert actual == 'Hello World!'
    }

    @Test
    void checkSaveTextWithResource() {
        WriterText.saveTextWithResource(file)
        def actual

        file.withReader { reader ->
            actual = reader.readLine()
        }

        assert actual == 'Hello World!'
    }
}