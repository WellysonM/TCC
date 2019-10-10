<template>
    <v-dialog max-width="500px" persistent v-model="modalPedido">
        <v-card>
            <v-card-title>
                <span class="headline">Dados do Pedido</span>
            </v-card-title>
            <v-card-text>
                <v-container>
                    <v-form>
                        <v-flex cols="12" md="4" pa-2 sm="6">
                            <div v-for="mesa of mesas" :key="mesa.id">
                                <v-select
                                        :items="mesa.numero"
                                        hide-details
                                        label="Escolha o numero da mesa"
                                        single-line
                                ></v-select>
                            </div>
                        </v-flex>
                        <v-flex cols="12" md="4" pa-2 sm="6">
                            <v-select
                                    :items="funcionario"
                                    hide-details
                                    label="Funcionario"
                                    single-line
                            ></v-select>
                        </v-flex>
                        <v-flex cols12 md12 pa-2 sm6>
                            <v-text-field
                                    class="info-input"
                                    label="Cliente"
                            />
                        </v-flex>
                    </v-form>
                </v-container>
            </v-card-text>
            <v-card-actions>
                <v-divider></v-divider>
                <v-btn @click="fecharModalPedido" class="acao-fechar" flat style="margin: 0% 2%">
                    fechar
                </v-btn>
                <v-btn @click="enviarMesaEscolhida" class="acao-sucesso" flat
                       style="margin: 0% 2%">
                    Salvar
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>
<script>
    import service from "../services/service";

    export default {
        name: 'ModalPedido',
        data() {
            return {
                mesas: [],
                funcionario: []
            }
        },
        props: {
            modalPedido: {
                required: true
            }
        },
        mounted() {
            this.getMesas()
        },
        methods: {
            abrirModalPedido() {
                this.$emit('abrirModalPedido')
            },
            fecharModalPedido() {
                this.$emit('fecharModalPedido')
            },
            enviarMesaEscolhida() {
                this.$emit('enviarMesaEscolhida')
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
<style lang="stylus">
    .v-dialog:not(.v-dialog--fullscreen) {
        max-height: 91%
    }
</style>