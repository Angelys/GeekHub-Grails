package geekhub.grails

import grails.transaction.Transactional

@Transactional
class DeviceService {

    def getNFrom(int fromId, int limit) {
        Device.findAll( max: limit ) {
            id >= fromId
        }
    }

    def getTokens(List<Device> list){

        list.collect {
            it.token
        }

    }
}
