package geekhub.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(DeviceService)
class DeviceServiceSpec extends Specification {

    def setup() {
        mockDomain(Device)
    }

    def cleanup() {
    }

    void "test getNFrom"() {

        when:
        def methodCalled = false

        //Not that good as i wanted it, but im not sure how to test the params
        Device.metaClass.static.findAll { methodCalled = true }

        service.getNFrom(1,10)

        then:
        assert methodCalled
    }
}
