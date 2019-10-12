import axios from 'axios'
import {actionTypes, mutationTypes} from '@/commons/constants'

export default {

    async [actionTypes.BUSCAR_CATEGORIAS]({commit}) {
        const {data} = await axios.get('categoria/all')
        commit(mutationTypes.SET_CATEGORIAS, data)
    },

    async [actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA](context, categoriaId) {
        const {data} = await axios.get(`produtos/all/${categoriaId}`)
        return data
    },

    async [actionTypes.BUSCAR_USUARIOS]() {
        const {data} = await axios.get('usuarios/all')
        return data
    },

    async [actionTypes.BUSCAR_USUARIO_LOGADO]({commit}) {
        const {data} = await axios.get('usuario/usuarioLogado')
        commit(mutationTypes.SET_USUARIO_LOGADO, data)
    },

    async [actionTypes.BUSCAR_MESAS]() {
        const {data} = await axios.get('mesas/all')
        return data
    },

    async [actionTypes.INSERIR_CATEGORIA](context, categoria) {
        return await axios.post('categoria/inserir', categoria)
    },

    async [actionTypes.INSERIR_PRODUTO](context, produto) {
        return await axios.post('produto/inserir', produto)
    },

    async [actionTypes.INSERIR_PEDIDO](context, pedido) {
        return await axios.post('pedido/inserir', pedido)
    },

    async [actionTypes.INSERIR_MESA](context, mesa) {
        return await axios.post('mesa/inserir', mesa)
    },

    async [actionTypes.INSERIR_USUARIO](context, usuario) {
        return await axios.post('usuario/inserir', usuario)
    }
}
