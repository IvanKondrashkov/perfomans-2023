package grails.task.manager

import grails.rest.Resource
import java.time.LocalDateTime

@Resource(uri='/epic')
class Epic {
    Long id
    String name
    LocalDateTime created

    static hasMany = [tasks: Task]

    static constraints = {
        name blank: false, nullable: false
        created nullable: false
    }

    static mapping = {
        id id: 'id', generator: 'sequence'
        version false
    }
}