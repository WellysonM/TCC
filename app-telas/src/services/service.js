import {http} from './config'

export default {
    cadastrar: (usuario) => {
        return http.post('usuario/cadastrar', usuario)
    },

    getUsuario: () => {
        return http.get('usuario/login')
    }
}