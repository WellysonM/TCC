<template>
    <div>
        <modal-categoria
                :modal-categoria="modalCategoria"
                @abrirModalCategoria="abrirModalCategoria"
                @enviarCategoriaProduto="enviarCategoriaProduto"
                @fecharModalCategoria="fecharModalCategoria"
        />

        <modal-produto
                :categoria="categoria"
                :modal-produto="modalProduto"
                :produtos="produtos"
                @abrirModalProduto="abrirModalProduto"
                @enviarPedido="enviarPedido"
                @fecharModalProduto="fecharModalProduto"
                @inserirProduto="inserirProduto"
        />

        <v-container
                fill-height
                fluid
                grid-list-xl>
            <v-layout wrap>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            @click="abrirModalCategoria"
                            color="padrao2"
                            icon="mdi-plus-box-outline"
                            sub-icon="mdi-plus-outline"
                            sub-text="clique aqui para adicionar outras categorias"
                            title="Nova Categoria"
                            value="Clique aqui"
                    />
                </v-flex>
                <v-flex :key="categoria.id" lg4 md6 sm6 v-for="categoria of styleCard" xs12>
                    <material-stats-card :color=categoria.cor
                                         :icon="categoria.icone"
                                         :sub-text=categoria.subTitulo
                                         :title=categoria.titulo
                                         :value=categoria.preco
                                         @click="receberCategoria(categoria)"
                                         sub-icon="mdi-message-plus"
                    />
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import {mapMutations} from 'vuex'
    import {actionTypes} from '@/commons/constants'
    import ModalCategoria from '../components/ModalCategoria'
    import ModalProduto from '../components/ModalProduto'
    import service from '../services/service'

    export default {
        name: 'Produtos',
        components: {ModalProduto, ModalCategoria},
        data() {
            return {
                modalProduto: false,
                modalCategoria: false,
                categoria: [],
                styleCard: [],
                produtos: []
            }
        },
        async mounted() {
            await this.buscarCategorias()
            this.setarCategorias()
        },
        methods: {
            abrirModalProduto() {
                this.modalProduto = true
            },
            abrirModalCategoria() {
                this.modalCategoria = true
            },
            fecharModalProduto() {
                this.modalProduto = false
            },
            fecharModalCategoria() {
                this.modalCategoria = false
            },
            receberCategoria(categoria) {
                this.categoria = categoria
                this.getProdutosCategoria()
                this.abrirModalProduto()
            },
            enviarCategoriaProduto(categoria) {
                this.inserirCategoria(categoria)
                this.fecharModalCategoria()
            },
            inserirCategoria(categoria) {
                service.postCategoria(categoria).then(resposta => {
                    this.buscarCategorias()
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
            },
            async buscarCategorias() {
                await this.$store.dispatch(actionTypes.BUSCAR_CATEGORIAS)
            },
            getProdutosCategoria() {
                service.getProdutosPorCategoria(this.categoria.id).then(resposta => {
                    this.produtos = resposta.data
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
            },
            inserirProduto(produto) {
                service.postProduto(produto).then(resposta => {
                    this.getProdutosCategoria()
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
            },
            ...mapMutations(['setPedido', 'togglePedido']),
            enviarPedido(seleted) {
                let pedido = {
                    status: 'sem status',
                    produtos: seleted,
                    subValor: ''
                }
                if (this.$store.state.pedido.produtos.length === 0) {
                    this.setPedido(pedido)
                } else {
                    let produtos = this.$store.state.pedido.produtos
                    Array.prototype.push.apply(produtos, seleted)
                    pedido.produtos = produtos
                    this.setPedido(pedido)
                }
                this.fecharModalProduto()
                this.$router.push('Vendas')
            },
            setarCategorias() {
                this.styleCard = this.$store.state.categorias
            }
        }
    }
</script>
