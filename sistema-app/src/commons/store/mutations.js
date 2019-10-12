import {mutationTypes} from '@/commons/constants'
import {toggle} from '@/commons/theme/utils/vuex'

export default {

    [mutationTypes.SET_CATEGORIAS](state, categorias) {
        state.categorias =  categorias
    },

    [mutationTypes.SET_PRODUTO_PEDIDO](state, produto) {
        state.pedido.produtos.push(produto)
    },

    togglePedido: toggle('pedido')
}
