<template>
    <v-container
            fill-height
            fluid
            grid-list-xl>
        <v-layout wrap>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-hamburger"
                        title="Lanches"
                        value="10 a 24 R$"
                        sub-icon="mdi-message-plus"
                        sub-text="Adicionais 1 R$"
                />
            </v-flex>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-pizza"
                        title="Pizzas"
                        value="28 a 32 R$"
                        sub-icon="mdi-loupe"
                        sub-text="Borda 3 R$"
                />
            </v-flex>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-silverware-fork-knife"
                        title="Panquecas"
                        value="4 a 6 R$"
                        sub-icon="mdi-plus-outline"
                        sub-text="Molho vermelho 2 R$"
                />
            </v-flex>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-food-croissant"
                        title="Pastel"
                        value="4 a 6 R$"
                        sub-icon="mdi-plus-outline"
                        sub-text="Adicional 1 R$"
                />
            </v-flex>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-silverware-variant"
                        title="Jantares"
                        value="15 a 30 R$"
                        sub-icon="mdi-plus-outline"
                        sub-text="Adicional 2 R$"
                />
            </v-flex>
            <v-flex sm6 xs12 md6 lg3>
                <material-stats-card
                        color="info"
                        icon="mdi-glass-wine"
                        title="Bebidas"
                        value="3.50 a 6 R$"
                        sub-icon="mdi-plus-outline"
                        sub-text="Adicional 2 R$"
                />
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        data() {
            return {}
        }
    }
</script>
