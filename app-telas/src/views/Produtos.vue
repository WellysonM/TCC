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
                @inserirProduto="inserirProduto"
                @abrirModalProduto="abrirModalProduto"
                @fecharModalProduto="fecharModalProduto"
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
    import ModalCategoria from './modal/ModalCategoria'
    import ModalProduto from "./modal/ModalProduto";
    import service from "../services/service";

    export default {
        name: 'Produtos',
        components: {ModalProduto, ModalCategoria},
        data() {
            return {
                modalProduto: false,
                modalCategoria: false,
                categoria: '',
                styleCard: {
                    id: '',
                    icone: '',
                    titulo: '',
                    subTitulo: '',
                    preco: '',
                    cor: ''
                },
                produtos: [
                    {
                        id: '',
                        produto: '',
                        preco: '',
                        tempoPreparo: '',
                        categoria: {
                            id: '',
                            icone: '',
                            titulo: '',
                            subTitulo: '',
                            preco: '',
                            cor: ''
                        }
                    }
                ]
            }
        },
        mounted() {
            this.buscarCategorias()
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
                this.categoria = categoria
                this.fecharModalCategoria()
                this.inserirCategoria()
                this.buscarCategorias()
            },
            inserirCategoria() {
                service.postCategoria(this.styleCard)
                this.buscarCategorias()
            },
            buscarCategorias() {
                service.getCategoria().then(resposta => {
                    this.styleCard = resposta.data
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
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
                    //this.produtos = resposta.data
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
                this.getProdutosCategoria()
            },
        }
    }
</script>