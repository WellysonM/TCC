<template>
    <div>
        <modal-produto
                :abrir-modal-produto="abrirModalProduto"
                @enviarDadosCategoria="enviarDadosCategoria"
                @fecharModalProduto="fecharModalProduto"
        />
        <v-container
                fill-height
                fluid
                grid-list-xl>
            <v-layout wrap>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-hamburger"
                            sub-icon="mdi-message-plus"
                            sub-text="Adicionais 1 R$"
                            title="Lanches"
                            value="10 a 24 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-pizza"
                            sub-icon="mdi-loupe"
                            sub-text="Borda 3 R$"
                            title="Pizzas"
                            value="28 a 32 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-silverware-fork-knife"
                            sub-icon="mdi-plus-outline"
                            sub-text="Molho vermelho 2 R$"
                            title="Panquecas"
                            value="4 a 6 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-food-croissant"
                            sub-icon="mdi-plus-outline"
                            sub-text="Adicional 1 R$"
                            title="Pastel"
                            value="4 a 6 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-silverware-variant"
                            sub-icon="mdi-plus-outline"
                            sub-text="Adicional 2 R$"
                            title="Jantares"
                            value="15 a 30 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-glass-wine"
                            sub-icon="mdi-plus-outline"
                            sub-text="Adicional 2 R$"
                            title="Bebidas"
                            value="3.50 a 6 R$"
                    />
                </v-flex>
                <v-flex lg4 md6 sm6 xs12>
                    <material-stats-card
                            color="info"
                            icon="mdi-plus-box-outline"
                            sub-icon="mdi-plus-outline"
                            sub-text="clique aqui para adicionar outras categorias"
                            title="Nova Categoria"
                            value="Clique aqui"
                            @click="enviarDadosCategoria"
                    />
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import ModalProduto from './modal/ModalProduto'

    export default {
        name: 'Produtos',
        components: {ModalProduto},
        data() {
            return {
                abrirModalProduto: false,
            }
        },
        methods: {
            enviarDadosCategoria() {
                this.abrirModalProduto = true
            },
            fecharModalProduto() {
                this.abrirModalProduto = false
            }
        }
    }
</script>
