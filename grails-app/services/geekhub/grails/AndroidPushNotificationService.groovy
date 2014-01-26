package geekhub.grails

import grails.transaction.Transactional

@Transactional
class AndroidPushNotificationService {

    enum Types {NOTIFICATION, RELEASE};

    def batchSize = 500

    def androidGcmService
    def deviceService

    def pushNotification(String title, String description){
        Map data = [
            type: String.valueOf(Types.NOTIFICATION.ordinal()),
            title: title,
            body: description
        ]

        push(data, String.valueOf(Types.NOTIFICATION.ordinal()))
    }

    def pushReleaseDate(Date date, String version){

        def differ = String.valueOf(date.getTime() - Calendar.getInstance().getTimeInMillis())

        Map data = [
                type: String.valueOf(Types.RELEASE.ordinal()),
                date_differ: differ,
                version: version
        ]

        println data

        push(data, String.valueOf(Types.RELEASE.ordinal()))
    }

    def push( Map data, String collapseKey = '' ) {

        def lastId = 1
        def messages = []

        while(lastId > 0){

            def devices = deviceService.getNFrom(lastId, batchSize)

            if(devices.size() <= 0){
                break
            }

            def tokens = devices.collect { it.token }

            messages.add androidGcmService.sendMessage(data, tokens, collapseKey).toString()

            if(devices.size() < batchSize){
                lastId = -1
            }
        }

        messages.join("\n")
    }
}
