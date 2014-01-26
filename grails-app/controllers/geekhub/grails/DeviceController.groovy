package geekhub.grails

import org.springframework.security.access.annotation.Secured

class DeviceController {

    def add() {

        println params

        if(!params.get("regId")){
            render( status: 400 )
            return
        }

        Device dev = Device.findOrCreateByToken(params.regId)
        dev.save()

        render(satus: 200)
    }

    @Secured(['ROLE_ADMIN'])
    def list(){

        render view: 'list', model: [devices: Device.getAll()]

    }
}
