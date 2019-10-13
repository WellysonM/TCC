import {http} from './config'

export default {
    cadastrar: (usuario) => {
        return http.post('usuario/entrar', usuario)
    },

    getCategoria: () => {
        return http.get('categoria/inserir')
    },

    postCategoria: (categoria) => {
        return http.post('categoria/all', categoria)
    },

    postProduto: (produto) => {
        return http.post('produto/inserir', produto)
    },

    getProdutosPorCategoria: (categoriaId) => {
        return http.get(`produto/produto/all/${categoriaId}`)
    },

    postPedido: (pedido) => {
        return http.post('pedido/inserir', pedido)
    },

    postMesa: (mesa) => {
        return http.post('mesa/inserir', mesa)
    },

    getMesas: () => {
        return http.get('mesa/all')
    }
}
