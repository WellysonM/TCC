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
                                <v-card
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
                            :items="items"
                            style="text-align: center;">
                        <template
                                slot="headerCell"
                                slot-scope="{ header }">
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
                                           style="float: right; min-width: 10px">
                                        <v-icon>mdi-close-circle-outline</v-icon>
                                    </v-btn>
                                </td>
                            </tr>
                        </template>
                    </v-data-table>
                    <div>
                        <v-btn class="botao-acao-fechar" flat style="float: right">Desistir</v-btn>
                        <v-btn :disabled="info" @click="inserirPedido" class="acao-sucesso" flat
                               style="float: left; margin:0 2%">
                            enviar pedido
                        </v-btn>
                        <v-btn @click="abrirModalPedido" class="botao-acao-sucesso" flat style="float: none;">
                            info
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
                @enviarPedido="enviarPedido"
                @fecharModalProduto="fecharModalProduto"
                @inserirProduto="inserirProduto"
        />
        <modal-pedido
                :modal-pedido="modalPedido"
                @abrirModalPedido="abrirModalPedido"
                @enviarMesaEscolhida="enviarMesaEscolhida"
                @fecharModalPedido="fecharModalPedido"
        />
    </div>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes} from '@/commons/constants'
    import ModalPedido from '../components/ModalPedido'
    import service from '../services/service'
    import ModalProduto from '../components/ModalProduto'

    export default {
        name: 'Vendas',
        components: {ModalPedido, ModalProduto},
        data: () => ({
            modalProduto: false,
            modalCategoria: false,
            categoria: '',
            produtos: [],
            info: false,
            modalPedido: false,
            styleCard: [],
            headers: [
                {
                    sortable: true,
                    text: 'Produto',
                    value: 'produto'
                },
                {
                    sortable: true,
                    text: 'Preço',
                    value: 'preco'
                },
                {
                    sortable: true,
                    text: 'Quantidade',
                    value: 'quantidade'
                },
                {
                    sortable: true,
                    text: 'Sub Valor',
                    value: 'subValor'
                }
            ],
            items: []
        }),
        mounted() {
            this.carregaPedido()
            this.buscarCategorias()
        },
        computed: {
          ...mapState(['categorias']),
        },
        methods: {
            ...mapMutations(['setPedido']),
            abrirModalPedido() {
                this.modalPedido = true
            },
            abrirModalProduto() {
                this.modalProduto = true
            },
            abrirNotificacao() {
                this.notificacao = true
                this.cor = 'green'
                this.mensagem = 'teste'
            },
            async buscarCategorias() {
                await this.$store.dispatch(actionTypes.BUSCAR_CATEGORIAS)
            },
            calcularSubValor(item) {
                let subPreco = parseFloat(item.preco.replace(",", "."))
                subPreco = subPreco * item.quantidade
                return subPreco.toFixed(2).replace(".", ",")
            },
            carregaPedido() {
                this.items = this.$store.state.pedido.produtos
            },
            deleteItem(item) {
                const index = this.items.indexOf(item)
                confirm('Are you sure you want to delete this item?') && this.items.splice(index, 1)
            },
            enviarMesaEscolhida() {
                this.info = false
                this.fecharModalPedido()
            },
            enviarPedido(seleted) {
                let pedido = {
                    status: 'sem status',
                    produtos: seleted,
                    subValor: ''
                }
                if (this.$store.state.pedido.produtos.length === 0) {
                    this.setPedido(pedido)
                    this.carregaPedido()
                } else {
                    debugger
                    let produtos = this.$store.state.pedido.produtos
                    Array.prototype.push.apply(produtos, seleted)
                    pedido.produtos = produtos
                    this.setPedido(pedido)
                    this.items = []
                    this.carregaPedido()
                }
                this.fecharModalProduto()
            },
            fecharModalProduto() {
                this.modalProduto = false
            },
            fecharModalPedido() {
                this.modalPedido = false
            },
            fecharNotificacao() {
                this.notificacao = false
            },
            async inserirProduto(produto) {
                await this.$store.dispatch(actionTypes.INSERIR_PRODUTO, produto)
            },
            inserirPedido(pedido) {
                service.postPedido(pedido)
            },
            async buscarProdutosPorCategoria() {
                this.produtos = await this.$store.dispatch(actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA, this.categoria.id)
            },
            abrirCategoria(categoria) {
                this.setCategoria(categoria)
                this.buscarProdutosPorCategoria()
                this.abrirModalProduto()
            },
            setCategoria(categoria) {
                this.categoria = categoria
            }
        }
    }
</script>
<style lang="stylus">


</style>
