package geekhub.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PushNotificationController)
@TestMixin(WebFlowUnitTestMixin)
@Mock(Notification)
class PushNotificationControllerSpec extends Specification {

    AndroidPushNotificationService AndroidPushNotificationServiceMock

    def setup() {
        AndroidPushNotificationServiceMock = Mock(AndroidPushNotificationService)
    }

    def cleanup() {
    }

    void "test notification"() {

        when:
        request.method = "POST"
        params.title = 'title'
        params.description = 'descr'
        controller.androidPushNotificationService = AndroidPushNotificationServiceMock

        controller.notification()

        then:

        1 * AndroidPushNotificationServiceMock.pushNotification('title', 'descr')

    }

}
