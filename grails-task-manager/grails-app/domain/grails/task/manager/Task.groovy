package grails.task.manager

import grails.rest.Resource
import java.time.LocalDateTime

@Resource(uri='/task')
class Task {
    Long id
    String name
    LocalDateTime created

    static belongsTo = [epic: Epic]

    static constraints = {
        name blank: false, nullable: false
        created nullable: false
    }

    static mapping = {
        id id: 'id', generator: 'sequence'
        version false
    }
}