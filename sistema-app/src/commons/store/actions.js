import axios from 'axios'
import {actionTypes, mutationTypes} from '@/commons/constants'

export default {

    async [actionTypes.BUSCAR_CATEGORIAS]({commit}) {
        const {data} = await axios.get('categoria/login')
        commit(mutationTypes.SET_CATEGORIAS, data)
    },

    async [actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA](context, categoriaId) {
        const {data} = await axios.get(`produto/produto/all/${categoriaId}`)
        return data
    },

    async [actionTypes.INSERIR_CATEGORIA](context, categoria) {
        return await axios.post('categoria/cadastrar', categoria)
    },

    async [actionTypes.INSERIR_PRODUTO](context, produto) {
        return await axios.post('produto/cadastrar', produto)
    }
}
