package geekhub.grails

class Setting {

    String name
    String value
    Date lastUpdated

    static constraints = {
        name(nullable:false, unique:true)
    }

}
