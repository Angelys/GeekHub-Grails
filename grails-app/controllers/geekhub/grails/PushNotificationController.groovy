package geekhub.grails

import org.springframework.security.access.annotation.Secured

import java.text.DateFormat

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

}
