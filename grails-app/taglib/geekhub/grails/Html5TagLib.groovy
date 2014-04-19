package geekhub.grails

class Html5TagLib {
    static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

    def header = { attrs, body ->

        out << "<header>" << body() << "</header>"

    }
}
