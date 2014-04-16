package geekhub.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(DeviceService)
@Mock(Device)
class DeviceServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test getNFrom"() {
        when:
        service.getNFrom(1,10)

        then:
        1 * Device.findAll( max: 1 ) {
            id >= 10
        }
    }
}
