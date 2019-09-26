import {mutationTypes} from '@/commons/constants'
import {set, toggle} from '@/commons/theme/utils/vuex'

export default {

    [mutationTypes.SET_CATEGORIAS](state, categorias) {
        state.categorias =  categorias
    },

    setPedido: set('pedido'),
    togglePedido: toggle('pedido')
}
