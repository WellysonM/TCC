<template>
    <div>
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
                        </v-form>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-divider></v-divider>
                    <v-btn @click="fecharModalPedido" class="acao-fechar" flat style="margin: 0% 2%">
                        cancelar
                    </v-btn>
                    <v-btn @click="enviarPedido" class="acao-sucesso" flat
                           style="margin: 0% 2%">
                        Salvar
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
        <notificacao/>
    </div>
</template>
<script>
    import notificacao from '../views/Notifications'
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'


    export default {
        name: 'ModalPedido',
        components: {notificacao},
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
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirModalPedido() {
                this.$emit('abrirModalPedido')
            },
            abrirNotificacaoAlerta(mesa) {
                this.notificacao = {
                    cor: 'warning',
                    mensagem: 'Atenção a mesa ' + mesa.numero + ' estar com o status ocupada!',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErro(mesa) {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Atenção a mesa ' + mesa.numero + ' precisa ser limpa!',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            fecharModalPedido() {
                this.$emit('fecharModalPedido')
            },
            enviarPedido() {
                this.$emit('enviarPedido', this.pedido)
            },
            buscarMesas() {
                this.mesas = this.$store.state.mesas
            },

            async buscarUsuarios() {
                this.usuarios = await this.$store.dispatch(actionTypes.BUSCAR_USUARIOS)
            },

            verificarMesasEscolhida(mesa) {
                if (mesa.status === 'disponivel') {
                    this.pedido.mesa = mesa;
                }
                if (mesa.status === 'ocupada') {
                    this.pedido.mesa = mesa;
                    this.abrirNotificacaoAlerta(mesa)
                }
                if (mesa.status === 'pago') {
                    this.$router.push({path: '/inicio'})
                    this.abrirNotificacaoErro(mesa)
                }
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