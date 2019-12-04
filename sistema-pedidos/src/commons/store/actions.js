import axios from 'axios'
import {actionTypes, mutationTypes} from '@/commons/constants'

export default {

    async [actionTypes.ATUALIZAR_PEDIDO_COZINHA](context, pedido) {
        return await axios.post('pedido/atualizar/cozinha', pedido)
    },

    async [actionTypes.BUSCAR_PEDIDOS_EMESPERA]({commit}) {
        const {data} = await axios.get('pedidos/espera')
        commit(mutationTypes.SET_PEDIDOS_EMESPERA, data)
    }
}