import org.junit.jupiter.api.Test
import ru.kondrashkov.eval.Eval

class EvalTest {

    @Test
    void byExpression() {
        def actual = Eval.byExpression(10, 5, 2, 'x + y * z')

        assert actual == 20
    }
}