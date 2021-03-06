<template>
    <div>
        <v-container fill-height>
            <v-layout wrap>
                <template>
                    <v-flex :key="categoria.id" v-for="categoria of categorias" lg4 m4>
                        <v-hover>
                            <template v-slot="{ hover }">
                                <v-card style="cursor: pointer"
                                        :class="`elevation-${hover ? 24 : 2}`"
                                        :color=categoria.cor
                                        @click="abrirCategoria(categoria)"
                                        class="pa-4 card transition-swing"
                                        dark
                                        slot="offset">
                                    <v-icon size="40">
                                        {{categoria.icone}}
                                    </v-icon>
                                </v-card>
                            </template>
                        </v-hover>
                    </v-flex>
                </template>
            </v-layout>
            <v-flex md1></v-flex>
            <v-flex md8 lg7 style="justify-content: flex-end;">
                <material-card
                        color="padrao2"
                        text="Tabela de produtos"
                        title="Comanda">
                    <v-data-table
                            :headers="headers"
                            :items="pedido.produtos"
                            style="text-align: center;">
                        <template slot="headerCell" slot-scope="{ header }">
                                    <span class="subheading font-weight-light text--darken-3"
                                          v-text="header.text"
                                    />
                        </template>
                        <template slot="items" slot-scope="{ item }">
                            <tr>
                                <td>{{item.produto}}</td>
                                <td>{{ item.preco}}</td>
                                <td>
                                    <v-text-field
                                            style="width: 50%"
                                            type="number"
                                            v-model="item.quantidade"
                                    />
                                </td>
                                <td>{{calcularSubValor(item)}}</td>
                                <td class="text-xs-right">
                                    <v-btn @click="abrirModalAtencao(item)" depressed fab small
                                           color="white red--text">
                                        <v-icon>mdi-close-circle-outline</v-icon>
                                    </v-btn>
                                </td>
                            </tr>
                        </template>
                    </v-data-table>
                    <div>
                        <v-btn depressed color="white red--text" style="float: right" @click="abrirModalAtencaoDesistir">
                            Desistir
                        </v-btn>
                        <v-btn :disabled="enviarPedidoCozinha" @click="abrirModalAtencaoEnviarPedido"
                               depressed color="white green--text"
                               style="float: left">
                            enviar pedido
                        </v-btn>
                        <v-btn @click="abrirModalPedido" depressed color="white green--text" style="float: none;">
                            comanda
                        </v-btn>
                    </div>
                </material-card>
            </v-flex>
        </v-container>
        <modal-produto
                :categoria="categoria"
                :modal-produto="modalProduto"
                :produtos="produtos"
                @abrirModalProduto="abrirModalProduto"
                @inserirProdutoPedido="inserirProdutoPedido"
                @fecharModalProduto="fecharModalProduto"
                @inserirNovoProduto="inserirNovoProduto"
                @removerProduto="removerProduto"
        />
        <modal-pedido
                :modal-pedido="modalPedido"
                @abrirModalPedido="abrirModalPedido"
                @enviarPedido="enviarPedido"
                @fecharModalPedido="fecharModalPedido"
        />
        <notificacao/>
        <atencao
                :dialog="dialog"
                :mensagem="mensagem"
                @cancelar="cancelar"
                @confirmar="confirmar"
        />
    </div>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'
    import atencao from '../components/Atencao'
    import notificacao from './Notifications'
    import ModalPedido from '../components/ModalPedido'
    import ModalProduto from '../components/ModalProduto'
    import StatsCard from "../commons/theme/material/StatsCard";

    export default {
        name: 'Vendas',
        components: {StatsCard, ModalPedido, ModalProduto, notificacao, atencao},
        data: () => ({
            mensagem: '',
            dialog: false,
            acaoDesistir: false,
            acaoEnviarPedido: false,
            produtoRemover: {},
            modalProduto: false,
            modalCategoria: false,
            categoria: '',
            produtos: [],
            enviarPedidoCozinha: true,
            modalPedido: false,
            styleCard: [],
            notificacao: {},
            headers: [
                {
                    text: 'Produto',
                    value: 'produto'
                },
                {
                    text: 'Preço',
                    value: 'preco'
                },
                {
                    text: 'Quantidade',
                    value: 'quantidade'
                },
                {
                    text: 'Sub Valor',
                    value: 'subValor'
                }
            ]
        }),
        async mounted() {
            await this.buscarCategorias()
        },
        computed: {
            ...mapState(['categorias', 'pedido'])
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            ...mapMutations([mutationTypes.SET_PRODUTO_PEDIDO]),
            abrirCategoria(categoria) {
                this.setCategoria(categoria)
                this.buscarProdutosPorCategoria()
                this.abrirModalProduto()
            },
            abrirModalPedido() {
                this.modalPedido = true
            },
            abrirModalProduto() {
                this.modalProduto = true
            },
            abrirModalAtencao(item) {
                this.acaoEnviarPedido = false
                this.acaoDesistir = false
                this.mensagem = 'Tem certeza que deseja excluir este produto?'
                this.produtoRemover = item
                this.dialog = true
            },
            abrirModalAtencaoDesistir() {
                this.acaoEnviarPedido = false
                this.acaoDesistir = true
                this.mensagem = 'Tem certeza que deseja desistir do pedido?'
                this.dialog = true
            },
            abrirModalAtencaoEnviarPedido() {
                this.acaoEnviarPedido = true
                this.acaoDesistir = false
                this.mensagem = 'Tem certeza que deseja enviar o pedido a cozinha? \n ' +
                    'após enviar o pedido não será possível editá-lo'
                this.dialog = true
            },
            abrirNotificacaoSucesso() {
                this.notificacao = {
                    cor: 'secondary',
                    mensagem: 'Operação realizada com sucesso !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErro() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Ops... algo deu errado, contate seu administrador',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErroRemover() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Existe pedidos vinculados a este produto',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoTabelaVazia() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'A comanda estar vazia',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async atualizarMesa() {
                const mesa = this.$store.state.pedido.mesa
                try {
                    await this.$store.dispatch(actionTypes.ATUALIZAR_MESA, mesa)
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            async buscarCategorias() {
                await this.$store.dispatch(actionTypes.BUSCAR_CATEGORIAS)
            },
            async buscarProdutosPorCategoria() {
                this.produtos = await this.$store.dispatch(actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA, this.categoria.id)
            },
            calcularSubValor(item) {
                if (item) {
                    let subPreco = parseFloat(item.preco.replace(",", "."))
                    subPreco = subPreco * item.quantidade
                    return subPreco.toFixed(2).replace(".", ",")
                }
            },
            calcularValorTotal() {
                let valor = 0
                const produtos = this.$store.state.pedido.produtos
                if (produtos) {
                    produtos.forEach((produto) => {
                        valor = valor + (parseFloat(produto.quantidade) * parseFloat(produto.preco))
                    })
                }
                return valor.toFixed(2).replace(".", ",")
            },
            cancelar() {
                this.dialog = false
            },
            confirmar() {
                if (!this.acaoDesistir && !this.acaoEnviarPedido) {
                    this.deleteItem(this.produtoRemover)
                    this.cancelar()
                }
                if (this.acaoDesistir) {
                    this.resetarTabela()
                    this.cancelar()
                }
                if (this.acaoEnviarPedido) {
                    this.montarPedido()
                }
            },
            desistirPedido() {
                this.$store.state.pedido.id = null
                const produtos = this.$store.state.pedido.produtos
                const index = produtos.indexOf(0)
                while (produtos.length) {
                    produtos.splice(index, 1)
                }
                this.abrirNotificacaoSucesso()
            },
            deleteItem(item) {
                const produtos = this.$store.state.pedido.produtos
                const index = produtos.indexOf(item)
                produtos.splice(index, 1)
                this.abrirNotificacaoSucesso()
            },
            enviarPedido(pedido) {
                this.$store.state.pedido.mesa = pedido.mesa
                this.$store.state.pedido.usuario = pedido.usuario
                this.enviarPedidoCozinha = false
                this.fecharModalPedido()
                this.abrirNotificacaoSucesso()
            },
            fecharModalProduto() {
                this.modalProduto = false
            },
            fecharModalPedido() {
                this.modalPedido = false
            },
            async inserirNovoProduto(produto) {
                try {
                    await this.inserirProduto(produto)
                    await this.buscarProdutosPorCategoria()
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            inserirProdutoPedido(produtos) {
                if (produtos) {
                    produtos.forEach((produto) => {
                        produto.quantidade = '1'
                        this.setProdutoPedido(produto)
                    })
                    this.fecharModalProduto()
                    this.abrirNotificacaoSucesso()
                }
            },
            async inserirProduto(produto) {
                try {
                    await this.$store.dispatch(actionTypes.INSERIR_PRODUTO, produto)
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            async inserirPedido(pedido) {
                try {
                    await this.$store.dispatch(actionTypes.INSERIR_PEDIDO, pedido)
                    this.montarMesaParaPedido()
                    this.resetarTabela()
                    this.abrirNotificacaoSucesso()
                    await this.$router.push({path: '/inicio'})
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            montarMesaParaPedido() {
                this.$store.state.pedido.mesa.status = 'ocupada'
                this.atualizarMesa()
            },
            montarPedido() {
                if (this.verificaTabelaVazia()) {
                    this.$store.state.pedido.data = new Date()
                    this.$store.state.pedido.status = 'em espera'
                    this.$store.state.pedido.valorTotal = this.calcularValorTotal()
                    const pedido = this.$store.state.pedido
                    this.inserirPedido(pedido)
                } else {
                    this.abrirNotificacaoTabelaVazia()
                    this.cancelar()
                }
            },
            async removerProduto(produtoId) {
                if (await this.$store.dispatch(actionTypes.REMOVER_PRODUTO, produtoId)) {
                    this.abrirNotificacaoSucesso()
                    this.buscarProdutosPorCategoria()
                } else {
                    this.abrirNotificacaoErroRemover()
                }
            },
            resetarTabela() {
                this.desistirPedido()
                this.enviarPedidoCozinha = true
            },
            setCategoria(categoria) {
                this.categoria = categoria
            },
            verificaTabelaVazia() {
                return this.pedido.produtos.length !== 0;
            }
        }
    }
</script>
<style>
    table.v-table thead th:not(:first-child) {
        padding: 0 !important;
    }
</style>