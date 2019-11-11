import {mutationTypes} from '@/commons/constants'

export default {

    [mutationTypes.SET_NOTIFICACAO](state, notificacao) {
        state.notificacao = notificacao
    },

    [mutationTypes.SET_PEDIDOS_EMESPERA](state, pedidosEmEspera) {
        state.pedidosEmEspera = pedidosEmEspera
    }
}
