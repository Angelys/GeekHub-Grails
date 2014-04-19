package geekhub.grails

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.plugins.codecs.HTMLCodec
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(Html5TagLib)
class Html5TagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test header"() {
        expect:
        applyTemplate('<g:header>Body</g:header>').decodeHTML() == '<header>Body</header>'
    }
}
