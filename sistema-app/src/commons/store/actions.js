import axios from 'axios'
import {actionTypes, mutationTypes} from '@/commons/constants'

export default {

    async [actionTypes.ATUALIZAR_PEDIDO](context, pedido) {
        return await axios.post('pedido/atualizar', pedido)
    },

    async [actionTypes.ATUALIZAR_USUARIO](context, usuario) {
        return await axios.post('usuario/atualizar', usuario)
    },

    async [actionTypes.ATUALIZAR_MESA](context, mesa) {
        return await axios.post('mesa/atualizar', mesa)
    },

    async [actionTypes.ATUALIZAR_PRODUTO](context, produto) {
        return await axios.post('produto/atualizar', produto)
    },

    async [actionTypes.BUSCAR_CATEGORIAS]({commit}) {
        const {data} = await axios.get('categoria/all')
        commit(mutationTypes.SET_CATEGORIAS, data)
    },

    async [actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA](context, categoriaId) {
        const {data} = await axios.get(`produtos/all/${categoriaId}`)
        return data
    },

    async [actionTypes.BUSCAR_PEDIDO_POR_MESA](contex, mesaId) {
        const {data} = await axios.get(`/pedidos/${mesaId}`)
        return data
    },

    async [actionTypes.BUSCAR_PEDIDOS_FINALIZADOS]({commit}) {
        const {data} = await axios.get('/pedidos/finalizados')
        commit(mutationTypes.SET_PEDIDOS_FINALIZADOS, data)
    },

    async [actionTypes.BUSCAR_USUARIOS]() {
        const {data} = await axios.get('usuarios/all')
        return data
    },

    async [actionTypes.BUACAR_USUARIO_LOGADO]({commit}) {
        const {data} = await axios.get('usuario/usuarioLogado')
        commit(mutationTypes.SET_USUARIO_LOGADO, data)
    },

    async [actionTypes.BUSCAR_MESAS]({commit}) {
        const {data} = await axios.get('mesas/all')
        commit(mutationTypes.SET_MESAS, data)
    },

    async [actionTypes.INSERIR_CATEGORIA](context, categoria) {
        return await axios.post('categoria/inserir', categoria)
    },

    async [actionTypes.INSERIR_COMANDA](context, comanda) {
        return await axios.post('comanda/inserir', comanda)
    },

    async [actionTypes.INSERIR_PRODUTO](context, produto) {
        await axios.post('produto/inserir', produto)
    },

    async [actionTypes.INSERIR_PEDIDO](context, pedido) {
        await axios.post('pedido/inserir', pedido)
    },

    async [actionTypes.INSERIR_MESA](context, mesa) {
        return await axios.post('mesa/inserir', mesa)
    },

    async [actionTypes.INSERIR_USUARIO](context, usuario) {
        return await axios.post('usuario/inserir', usuario)
    },

    async [actionTypes.EFETUAR_LOGIN](context, usuario) {
        const {data} = await axios.post('usuario/entrar', usuario)
        return data
    },

    async [actionTypes.EFETUAR_LOGOUT]() {
        await axios.get('usuario/sair')
    },

    async [actionTypes.REMOVER_USUARIO](context, usuarioId) {
        await axios.post(`usuario/remover/${usuarioId}`)
    },

    async [actionTypes.REMOVER_PRODUTO](conext, produtoId) {
        await axios.post(`produto/remover/${produtoId}`)
    }
}
