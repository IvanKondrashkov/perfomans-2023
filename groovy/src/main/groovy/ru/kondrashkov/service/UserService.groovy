package ru.kondrashkov.service

import ru.kondrashkov.model.User

class UserService {

    User createUser(List data) {
        Integer id
        String name

        (id, name) = data
        return new User(id, name)
    }

    Map<Integer, String> getMapByUsers(List<User> users) {
        return users.collectEntries {
            [it.id, it.name]
        }
    }

    Map<String, Integer> getMapByTwoList(List<String> names, List<Integer> ages) {
        return [names, ages].transpose().collectEntries {
            [it[0], it[1]]
        }
    }

    Map getUserAgeInterval(IntRange range) {
        return [from: range.from, to: range.to]
    }
}