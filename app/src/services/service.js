import {http} from './config'

export default {
    login:() =>{
        return http.get('/USER/all')
    }
}