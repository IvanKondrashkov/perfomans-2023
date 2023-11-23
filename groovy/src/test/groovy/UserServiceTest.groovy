import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.model.User
import ru.kondrashkov.service.LoginService
import ru.kondrashkov.service.UserService
import ru.kondrashkov.exception.UserNotFoundException
import static org.junit.jupiter.api.Assertions.assertThrows

class UserServiceTest {
    UserService userService
    LoginService loginService

    @BeforeEach
    void init() {
        userService = new UserService()
        loginService = new LoginService()
    }

    @AfterEach
    void tearDown() {
        userService = null
        loginService = null
    }

    @Test
    void getMapByUser() {
        def users = [new User(1, 'Djon'), new User(2, 'Bob'), new User(3, 'Nik')]
        def map = userService.getMapByUsers(users)

        assert map.size() == 3
        assert map.get(1) == 'Djon'
        assert map.get(2) == 'Bob'
        assert map.get(3) == 'Nik'
    }

    @Test
    void getMapByTwoList() {
        def names = ['Djon', 'Bob', 'Nik']
        def ages = [22, 33, 45]
        def map = userService.getMapByTwoList(names, ages)

        assert map.size() == 3
        assert map.get('Djon') == 22
        assert map.get('Bob') == 33
        assert map.get('Nik') == 45
    }

    @Test
    void createUser() {
        def data = [1, 'Djon']
        def user = userService.createUser(data)

        assert user instanceof User
        assert user.id == 1
        assert user.name == 'Djon'
    }

    @Test
    void createLogin() {
        def user = new User(1, 'Djon')
        def credentials = loginService.createLogin(user, 'qwerty', '123456')

        assert user instanceof User
        assert credentials.login == 'qwerty'
        assert credentials.password == '123456'

        Exception ex = assertThrows(ReadOnlyPropertyException.class, () -> {
            credentials.login = '123456'
        })

        assert ex instanceof ReadOnlyPropertyException
    }

    @Test
    void createLoginByNotUser() {
        try {
            loginService.createLogin(null, 'qwerty', '123456')
        } catch (Exception ex) {
            assert ex instanceof UserNotFoundException
        }
    }

    @Test
    void getUserAgeInterval() {
        def indx = userService.getUserAgeInterval(10..100)

        assert indx.from == 10
        assert indx.to == 100
    }
}