package geekhub.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PushNotificationController)
@Mock(AndroidPushNotificationService)
class PushNotificationControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test notification"() {

        when:
        request.method = "POST"
        params.title = 'title'
        params.description = 'descr'

        controller.notification()

        expect:

        1 * controller.androidPushNotificationService.pushNotification('title', 'descr')

    }
}
