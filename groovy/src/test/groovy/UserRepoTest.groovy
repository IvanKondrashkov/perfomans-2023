import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.sql.UserRepo
import ru.kondrashkov.model.User
import ru.kondrashkov.model.UserCredentials

class UserRepoTest {
    UserRepo userRepo

    @BeforeEach
    void init() {
        userRepo = new UserRepo()
        userRepo.createTable()
    }

    @AfterEach
    void tearDown() {
        userRepo.dropTable()
    }

    @Test
    void findById() {
        def user = userRepo.save(new User(null, 'Djon'))

        assert user.id == 1
        assert user.name == 'Djon'

        user = userRepo.findById(user.id)

        assert user.id == 1
        assert user.name == 'Djon'
    }

    @Test
    void findAll() {
        def names = ['Djon', 'Bob', 'Nik']

        names.each {
            userRepo.save(new User(null, it))
        }

        def users = userRepo.findAll()
        assert users.size() == 3
        assert users[0].id == 1
        assert users[1].id == 2
        assert users[2].id == 3
    }

    @Test
    void save() {
        def names = ['Djon', 'Bob', 'Nik']
        def users = []

        names.each {
            def user = userRepo.save(new User(null, it))
            users << user
        }

        assert users.size() == 3
        assert users[0].id == 1
        assert users[1].id == 2
        assert users[2].id == 3
    }

    @Test
    void updateById() {
        def user = userRepo.save(new User(null, 'Djon'))

        assert user.id == 1
        assert user.name == 'Djon'

        user = userRepo.updateById(user.id, new User(null, user.name, new UserCredentials('qwerty', '123456')))

        assert user.id == 1
        assert user.name == 'Djon'
        assert user.credentials.login == 'qwerty'
        assert user.credentials.password == '123456'
    }

    @Test
    void deleteById() {
        def user = userRepo.save(new User(null, 'Djon'))

        assert user.id == 1
        assert user.name == 'Djon'

        userRepo.deleteById(user.id)
        user = userRepo.findById(user.id)

        assert user.id == null
    }
}