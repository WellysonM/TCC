<template>
    <div>
        <v-btn class="acao-sucesso" flat style="float: left; margin: 4% 1% -2%" @click="inserirMesa">inserir mesa</v-btn>
        <v-container fill-height
                     fluid
                     grid-list-xl>
            <v-layout wrap>
                <template>
                    <v-flex lg2 md2>
                        <v-hover>
                            <template v-slot="{ hover }">
                                <v-card
                                        :class="`elevation-${hover ? 24 : 2}`"
                                        class="pa-4 card transition-swing"
                                        color="padrao2"
                                        dark
                                        slot="offset"
                                >
                                <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   {{card.numero}}
                                </span>
                                </v-card>
                            </template>
                        </v-hover>
                    </v-flex>
                </template>
            </v-layout>
        </v-container>
    </div>
</template>
<script>
    export default {
        name: 'Inicio',
        data() {
            return {
                card: []
            }
        },
        methods: {
            inserirMesa() {
                this.card = {
                    numero: '02'
                }
            }
        }
    }
</script>