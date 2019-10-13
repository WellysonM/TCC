<template>
    <div>
        <modal-categoria
                :modal-categoria="modalCategoria"
                @abrirModalCategoria="abrirModalCategoria"
                @inserirNovaCategoriaProduto="inserirNovaCategoriaProduto"
                @fecharModalCategoria="fecharModalCategoria"
        />

        <modal-produto
                :categoria="categoria"
                :modal-produto="modalProduto"
                :produtos="produtos"
                @abrirModalProduto="abrirModalProduto"
                @inserirProdutoPedido="inserirProdutoPedido"
                @fecharModalProduto="fecharModalProduto"
                @inserirNovoProduto="inserirNovoProduto"
        />

        <v-container fill-height fluid grid-list-xl>
            <v-layout wrap>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            style="cursor: pointer"
                            color="padrao2"
                            icon="mdi-plus-box-outline"
                            sub-icon="mdi-plus-outline"
                            sub-text="clique aqui para adicionar outras categorias"
                            title="Nova Categoria"
                            value="Clique aqui"
                            @click="abrirModalCategoria"
                    />
                </v-flex>
                <v-flex v-for="categoria of this.$store.state.categorias" :key="categoria.id" lg4 md6 sm6 xs12>
                    <material-stats-card
                            style="cursor: pointer"
                            :color=categoria.cor
                            :icon="categoria.icone"
                            :sub-text=categoria.subTitulo
                            :title=categoria.titulo
                            :value=categoria.preco
                            @click="abrirCategoria(categoria)"
                            sub-icon="mdi-message-plus"
                    />
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'
    import ModalCategoria from '../components/ModalCategoria'
    import ModalProduto from '../components/ModalProduto'

    export default {
        name: 'Produtos',
        components: {ModalProduto, ModalCategoria},
        data() {
            return {
                modalProduto: false,
                modalCategoria: false,
                categoria: [],
                produtos: []
            }
        },
        async mounted() {
            await this.buscarCategorias()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_PRODUTO_PEDIDO]),
            abrirModalCategoria() {
                this.modalCategoria = true
            },
            abrirModalProduto() {
                this.modalProduto = true
            },
            abrirCategoria(categoria) {
                this.setCategoria(categoria)
                this.buscarProdutosPorCategoria()
                this.abrirModalProduto()
            },
            async buscarCategorias() {
                await this.$store.dispatch(actionTypes.BUSCAR_CATEGORIAS)
            },
            async buscarProdutosPorCategoria() {
                this.produtos = await this.$store.dispatch(actionTypes.BUSCAR_PRODUTOS_POR_CATEGORIA, this.categoria.id)
            },
            inserirProdutoPedido(produtos) {
                if (produtos) {
                    produtos.forEach((produto) => {
                        produto.quantidade = '1'
                        this.setProdutoPedido(produto)
                    })
                    this.fecharModalProduto()
                }
                this.$router.push('Vendas')
            },
            fecharModalProduto() {
                this.modalProduto = false
            },
            fecharModalCategoria() {
                this.modalCategoria = false
            },
            async inserirCategoriaProduto(categoria) {
                await this.$store.dispatch(actionTypes.INSERIR_CATEGORIA, categoria)
            },
            async inserirProduto(produto) {
                await this.$store.dispatch(actionTypes.INSERIR_PRODUTO, produto)
            },
            async inserirNovaCategoriaProduto(categoria) {
                try {
                    await this.inserirCategoriaProduto(categoria)
                    await this.buscarCategorias()
                    this.fecharModalCategoria()
                } catch (e) {
                    alert('Ocorreu algum erro. Tente novamente!')
                }
            },
            async inserirNovoProduto(produto) {
                try {
                    await this.inserirProduto(produto)
                    await this.buscarProdutosPorCategoria()
                } catch (e) {
                    alert('Ocorreu algum erro. Tente novamente!')
                }
            },
            setCategoria(categoria) {
                this.categoria = categoria
            }
        }
    }
</script>
