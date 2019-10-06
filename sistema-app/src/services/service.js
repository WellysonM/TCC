import {http} from './config'

export default {
    cadastrar: (usuario) => {
        return http.post('usuario/cadastrar', usuario)
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
    }
}