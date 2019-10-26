export default {
    categorias: [],
    comanda: {},
    mesas: [],
    notificacao: {
        cor: null,
        mensagem: null,
        mostrar: false
    },
    pedido: {
        status: '',
        produtos: [],
        valorTotal: '',
        mesa: {},
        usuario: {},
        data: new Date()
    },
    pedidosFinalizados: {},
    usuarioLogado: {}
}