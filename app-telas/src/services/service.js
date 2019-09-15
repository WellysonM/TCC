import {http} from './config'

export default {
    cadastrar: (usuario) => {
        return http.post('usuario/cadastrar', usuario)
    },

    getUsuario: () => {
        return http.get('usuario/login')
    },

    getCategoria: () => {
        return http.get('categoria/login')
    },

    postCategoria: (categoria) => {
        return http.post('categoria/cadastrar', categoria)
    },
    getProdutos: () => {
        return http.get('produto/login')
    },
    postProduto: (produto) => {
        return http.post('produto/cadastrar', produto)
    },
    getProdutosPorCategoria: (categoriaId) => {
        return http.get(`produto/produto/all/${categoriaId}`)
    },
    postPedido: (pedido) => {
        return http.post('pedido/cadastrar', pedido)
    }
}