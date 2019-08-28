import {http} from './config'

export default {
    cadastrar: (usuario) => {
        return http.post('usuario/cadastrar', usuario)
    },

    getUsuario: () => {
        return http.get('usuario/login')
    },

    getCategoria:() =>{
        return http.get('categoria/login')
    },

    postCategoria:(categoria) =>{
        return http.post('categoria/cadastrar', categoria)
    }
}