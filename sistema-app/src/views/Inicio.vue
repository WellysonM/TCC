<template>
    <div>
        <v-btn class="acao-sucesso" flat style="float: left; margin: 4% 1% -2%" @click="montarMesa">inserir mesa
        </v-btn>
        <v-container fill-height
                     fluid
                     grid-list-xl>
            <v-layout wrap>
                <div v-for="mesa of mesas" :key="mesa.id">
                    <v-flex lg2 md2>
                        <v-hover>
                            <template v-slot="{ hover }">
                                <v-card style="cursor: pointer"
                                        :class="`elevation-${hover ? 24 : 2}`"
                                        class="pa-4 card transition-swing"
                                        color="padrao2"
                                        dark
                                        slot="offset"
                                >
                                <span style="font-size: 30px; display: flex; justify-content: center; letter-spacing: 2px; font-weight: bold;">
                                   {{mesa.numero}}
                                </span>
                                </v-card>
                            </template>
                        </v-hover>
                    </v-flex>
                </div>
            </v-layout>
        </v-container>
    </div>
</template>
<script>
    import {actionTypes} from '@/commons/constants'

    export default {
        name: 'Inicio',
        data() {
            return {
                mesas: []
            }
        },
        mounted() {
            this.buscarMesas()
        },
        methods: {
            async inserirMesa(mesa) {
                await this.$store.dispatch(actionTypes.INSERIR_MESA, mesa)
                this.buscarMesas()
            },
            async buscarMesas() {
                this.mesas = await this.$store.dispatch(actionTypes.BUSCAR_MESAS)
            },
            montarMesa() {
                let numero = this.mesas.length
                let mesa = {
                    numero: numero + 1
                }
                this.inserirMesa(mesa)
            }
        }
    }
</script>