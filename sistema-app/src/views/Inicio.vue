<template>
    <div>
        <v-btn class="acao-sucesso" flat style="float: left; margin: 4% 1% -2%" @click="inserirMesa">inserir mesa
        </v-btn>
        <v-container fill-height
                     fluid
                     grid-list-xl>
            <v-layout wrap>
                <div v-for="mesa of mesas" :key="mesa.id">
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
    import service from "../services/service";

    export default {
        name: 'Inicio',
        data() {
            return {
                mesas: []
            }
        },
        mounted() {
            this.getMesas()
        },
        methods: {
            async inserirMesa() {
                this.getMesas()
                let numero = this.mesas.length
                let mesa = {
                    numero: numero + 1
                }
                await service.postMesa(mesa)
                this.getMesas()
            },
            async getMesas() {
                await service.getMesas().then(resposta => {
                    this.mesas = resposta.data
                }).catch(e => {
                    console.log(e)
                })
            }
        }
    }
</script>