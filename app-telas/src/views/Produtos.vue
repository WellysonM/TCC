<template>
    <div>
        <modal-categoria
                :modal-categoria="modalCategoria"
                @abrirModalCategoria="abrirModalCategoria"
                @enviarCategoriaProduto="enviarCategoriaProduto"
                @fecharModalCategoria="fecharModalCategoria"
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
                    <material-stats-card
                            :color=categoria.cor
                            :icon="categoria.icone"
                            :sub-text=categoria.subTitulo
                            :title=categoria.titulo
                            :value=categoria.preco
                            sub-icon="mdi-message-plus"
                    />
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import ModalCategoria from './modal/ModalCategoria'
    import service from "../services/service";

    export default {
        name: 'Produtos',
        components: {ModalCategoria},
        data() {
            return {
                modalCategoria: false,
                styleCard: {
                    icone: '',
                    titulo: '',
                    subTitulo: '',
                    preco: '',
                    cor: ''
                }
            }
        },
        mounted() {
            this.buscarCategorias()
        },
        methods: {
            abrirModalCategoria() {
                this.modalCategoria = true
            },
            fecharModalCategoria() {
                this.modalCategoria = false
            },
            enviarCategoriaProduto(styleCard) {
                this.styleCard = styleCard
                this.fecharModalCategoria()
                this.inserirCategoria()
                this.buscarCategorias()
            },
            inserirCategoria() {
                service.postCategoria(this.styleCard)
            },
            buscarCategorias() {
                service.getCategoria().then(resposta => {
                    this.styleCard = resposta.data
                    console.log(resposta.data)
                }).catch(e => {
                    console.log(e)
                })
            }
        }
    }
</script>