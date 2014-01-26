package geekhub.grails

class Device {

    String token
    Date dateCreated, lastUpdated

    static constraints = {
        token(nullable:false, blank:false, unique:true)
    }
}
