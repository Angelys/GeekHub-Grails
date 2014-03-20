package geekhub.grails

class Notification implements Serializable {

    String title
    String description
    Date postTime

    static constraints = {
    }
}
