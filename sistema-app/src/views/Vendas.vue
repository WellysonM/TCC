<template>
    <div>
        <v-container fill-height
                     fluid
                     grid-list-xl
                     style="width: 50%; float: left">
            <v-layout wrap>
                <template>
                    <v-flex :key="categoria.id" v-for="categoria of categorias">
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
        </v-container>
        <v-container fill-height
                     fluid
                     grid-list-xl
                     style="width: 50%; float: right;">
            <v-layout wrap style="justify-content: flex-end;">
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
                                    <v-btn @click="deleteItem(item)" class="acao-fechar" flat
                                           style="min-width: 10px">
                                        <v-icon>mdi-close-circle-outline</v-icon>
                                    </v-btn>
                                </td>
                            </tr>
                        </template>
                    </v-data-table>

                    <div>
                        <v-btn class="acao-fechar" flat style="float: right" @click="resetarTabela">Desistir</v-btn>
                        <v-btn :disabled="comanda" @click="montarPedido" class="acao-sucesso" flat
                               style="float: left">
                            enviar pedido
                        </v-btn>
                        <v-btn @click="abrirModalPedido" class="acao-sucesso" flat style="float: none;">
                            comanda
                        </v-btn>
                    </div>
                </material-card>
            </v-layout>
        </v-container>
        <modal-produto
                :categoria="categoria"
                :modal-produto="modalProduto"
                :produtos="produtos"
                @abrirModalProduto="abrirModalProduto"
                @inserirProdutoPedido="inserirProdutoPedido"
                @fecharModalProduto="fecharModalProduto"
                @inserirProduto="inserirProduto"
        />
        <modal-pedido
                :modal-pedido="modalPedido"
                @abrirModalPedido="abrirModalPedido"
                @enviarPedido="enviarPedido"
                @fecharModalPedido="fecharModalPedido"
        />
    </div>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'
    import ModalPedido from '../components/ModalPedido'
    import ModalProduto from '../components/ModalProduto'

    export default {
        name: 'Vendas',
        components: {ModalPedido, ModalProduto},
        data: () => ({
            modalProduto: false,
            modalCategoria: false,
            categoria: '',
            mesa: {},
            usuario: {},
            produtos: [],
            comanda: true,
            modalPedido: false,
            styleCard: [],
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
            desistirPedido() {
                const produtos = this.$store.state.pedido.produtos
                const index = produtos.indexOf(0)
                while (produtos.length) {
                    produtos.splice(index, 1)
                }
            },
            deleteItem(item) {
                const produtos = this.$store.state.pedido.produtos
                const index = produtos.indexOf(item)
                confirm('Are you sure you want to delete this item?') && produtos.splice(index, 1)
            },
            enviarPedido(pedido) {
                this.mesa = pedido.mesa
                this.usuario = pedido.usuario
                this.comanda = false
                this.fecharModalPedido()
            },
            fecharModalProduto() {
                this.modalProduto = false
            },
            fecharModalPedido() {
                this.modalPedido = false
            },
            inserirProdutoPedido(produtos) {
                if (produtos) {
                    produtos.forEach((produto) => {
                        produto.quantidade = '1'
                        this.setProdutoPedido(produto)
                    })
                    this.fecharModalProduto()
                }
            },
            async inserirProduto(produto) {
                await this.$store.dispatch(actionTypes.INSERIR_PRODUTO, produto)
            },
            async inserirPedido(pedido) {
                await this.$store.dispatch(actionTypes.INSERIR_PEDIDO, pedido)
            },
            montarPedido() {
                this.$store.state.pedido.status = 'em espera'
                this.$store.state.pedido.valorTotal = this.calcularValorTotal()
                this.$store.state.pedido.mesa = this.mesa
                this.$store.state.pedido.usuario = this.usuario
                this.$store.state.pedido.cliente = 'cliente padrão'
                const pedido = this.$store.state.pedido
                this.inserirPedido(pedido)
                this.resetarTabela()
            },
            resetarTabela() {
                this.desistirPedido()
                this.comanda = true
                this.mesa = {}
            },
            setCategoria(categoria) {
                this.categoria = categoria
            }
        }
    }
</script>