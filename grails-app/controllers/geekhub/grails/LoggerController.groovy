package geekhub.grails

class LoggerController {

    def info = {
        log.info "info() - params: $params"
        render "params are logged"
    }

    def index() { }


}
