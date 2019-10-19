import {mutationTypes} from '@/commons/constants'
import {toggle} from '@/commons/theme/utils/vuex'

export default {

    [mutationTypes.SET_CATEGORIAS](state, categorias) {
        state.categorias = categorias
    },

    [mutationTypes.SET_PRODUTO_PEDIDO](state, produto) {
        state.pedido.produtos.push(produto)
    },

    [mutationTypes.SET_USUARIO_LOGADO](state, usuarioLogado) {
        state.usuarioLogado = usuarioLogado
    },

    [mutationTypes.SET_PEDIDO](state, pedido) {
        state.pedido = pedido
    },

    [mutationTypes.SET_NOTIFICACAO](state, notificacao) {
        state.notificacao = notificacao
    },

    togglePedido: toggle('pedido')
}
