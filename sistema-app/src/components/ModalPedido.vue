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
                            <v-select
                                    item-text="numero"
                                    item-value="id"
                                    :items="mesas"
                                    return-object
                                    @change="verificarMesasEscolhida"
                                    label="Escolha o numero da mesa"
                            ></v-select>
                        </v-flex>
                        <v-flex cols="12" md="4" pa-2 sm="6">
                            <v-select
                                    item-text="name"
                                    item-value="id"
                                    return-object
                                    @change="verificarUsuarioEscolhido"
                                    :items="usuarios"
                                    label="Funcionario"
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
                <v-btn @click="enviarPedido" class="acao-sucesso" flat
                       style="margin: 0% 2%">
                    Salvar
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>
<script>
    import {actionTypes} from '@/commons/constants'

    export default {
        name: 'ModalPedido',
        data() {
            return {
                pedido: {
                    mesa: {},
                    usuario: {},
                },
                mesas: [],
                usuarios: []
            }
        },
        props: {
            modalPedido: {
                required: true
            }
        },
        mounted() {
            this.buscarMesas()
            this.buscarUsuarios()
        },
        methods: {
            abrirModalPedido() {
                this.$emit('abrirModalPedido')
            },
            fecharModalPedido() {
                this.$emit('fecharModalPedido')
            },
            enviarPedido() {
                this.$emit('enviarPedido', this.pedido)
            },
            async buscarMesas() {
                this.mesas = await this.$store.dispatch(actionTypes.BUSCAR_MESAS)
            },

            async buscarUsuarios() {
                this.usuarios = await this.$store.dispatch(actionTypes.BUSCAR_USUARIOS)
            },

            verificarMesasEscolhida(mesa) {
                this.pedido.mesa = mesa;
            },
            verificarUsuarioEscolhido(usuario) {
                this.pedido.usuario = usuario;
            }
        }
    }
</script>
<style lang="stylus">
    .v-dialog:not(.v-dialog--fullscreen) {
        max-height: 91%
    }
</style>