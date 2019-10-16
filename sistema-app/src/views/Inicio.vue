<template>
    <div>
        <notificacao/>
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
                                <v-card
                                        style="cursor: pointer"
                                        :class="`elevation-${hover ? 24 : 2}`"
                                        class="pa-4 card transition-swing"
                                        :color="definirCorDaMesa(mesa)"
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
    import notificacao from './Notifications'
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        name: 'Inicio',
        components: {notificacao},
        data() {
            return {
                notificacao: {},
                mesas: [],
                pedidos: []
            }
        },
        mounted() {
            this.buscarMesas()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirNotificacaoSucesso() {
                this.notificacao = {
                    cor: 'secondary',
                    mensagem: 'Operação realizada com sucesso !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErro() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Ops... algo deu errado, contate seu administrador',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async buscarMesas() {
                this.mesas = await this.$store.dispatch(actionTypes.BUSCAR_MESAS)
            },
            async buscarPedidoPorMesa(mesaId) {
                this.pedidos = await this.$store.dispatch(actionTypes.BUSCAR_PEDIDO_POR_MESA, mesaId)
                console.log(this.pedidos)
            },
            definirCorDaMesa(mesa) {
                if (mesa.status === 'ocupada') {
                    return 'warning'
                }
                if (mesa.status === 'disponivel') {
                    return 'secondary'
                }
                if (mesa.status === 'pago') {
                    return 'error'
                }
            },
            async inserirMesa(mesa) {
                try {
                    await this.$store.dispatch(actionTypes.INSERIR_MESA, mesa)
                    this.buscarMesas()
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            montarMesa() {
                let numero = this.mesas.length
                let mesa = {
                    numero: numero + 1,
                    status: 'disponivel'
                }
                this.inserirMesa(mesa)
            }
        }
    }
</script>