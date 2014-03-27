package geekhub.grails

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class PushNotificationController {

    def androidPushNotificationService

    def index(){

    }


    def notification() {
        if(request.method == 'POST'){
            androidPushNotificationService.pushNotification(params.title, params.description)

            flash.message = 'Successful push'
        }
    }

    def release(){

        if(request.method == 'POST'){
            Setting dateSetting = Setting.findOrCreateByName("release_date")
            dateSetting.value = params.date.format('yyyy-MM-dd HH:mm:ss')
            dateSetting.save()

            Setting versionSetting = Setting.findOrCreateByName("release_version")
            versionSetting.value = params.version
            versionSetting.save()

            androidPushNotificationService.pushReleaseDate(params.date, params.version);
        }

        def strDate = Setting.findByName("release_date")?.value
        Date date = null
        if(strDate){
            date = Date.parse('yyyy-MM-dd HH:mm:ss',strDate)
        }

        String version = Setting.findByName("release_version")?.value?:0

        render view: 'release', model: [date: date, version: version]
    }

    def list() {

        render view: 'list', model: [notifications: Notification.getAll()]
    }

    def notificationBuildFlow = {
        enter  {
            action {
                Notification notification = new Notification()
                flow.notification = notification

                [notification: flow.notification]
            }

            on("success").to("title")
            on(Exception).to("error")
        }
        title {
            on('next') { BuildTitleCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command
                    return error()
                }
                bindData(flow.notification, command)
                [notification: flow.notification]
            }.to('description')
            on('cancel').to('finish')
        }
        description {
            on('next') { BuildDescriptionCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command
                    return error()
                }
                bindData(flow.notification, command)
                [notification: flow.notification]
            }.to('postTime')
            on('previous').to('title')
            on('cancel').to('finish')
        }
        postTime {
            on('next') { BuildPostTimeCommand command ->
                if (command.hasErrors()) {
                    flash.message = "Validation error"
                    flow.command = command

                    return error()
                }
                bindData(flow.notification, command)
                [notification: flow.notification]
            }.to('complete')
            on('previous').to('description')
            on('cancel').to('finish')
        }
        complete {
            on('next') {
                if (!flow.notification.save()) {
                    flash.message = "Couldn't save the contact"
                    return error()
                }
            }.to('finish')
            on('previous').to('postTime')
            on('cancel').to('finish')
        }
        error {
            on('confirm').to('finish')
        }
        finish {
            redirect(controller: 'pushNotification', action: 'list')
        }
    }

}

class BuildTitleCommand implements Serializable {
    String title

    static constraints = {
        title(blank:false, nullable:false, maxSize: 50)
    }

}

class BuildDescriptionCommand implements Serializable {
    String description

    static constraints = {
        description(blank:false, nullable:false, maxSize: 250)
    }

}

class BuildPostTimeCommand implements Serializable {
    Date postTime

    static constraints = {
        postTime(blank:false, nullable:false)
    }

}