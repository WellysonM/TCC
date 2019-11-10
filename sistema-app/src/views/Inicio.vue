<template>
    <div>
        <v-btn depressed color="white green--text" style="float: left; margin: 4% 1% -2%" @click="comfirmarInserirMesa">
            inserir
            mesa
        </v-btn>
        <v-container fill-height
                     fluid
                     grid-list-xl>
            <v-layout wrap>
                <div v-for="mesa of mesas" :key="mesa.id">
                    <v-flex lg2 md2>
                        <v-hover>
                            <template v-slot="{ hover }">
                                <v-card @click="buscarPedidoPorMesa(mesa)"
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
        <modal-comanda
                :modal-comanda="modalComanda"
                @fecharModalComanda="fecharModalComanda"
                @confirmar="efetuarPagamento"
        />
        <notificacao/>
        <atencao
                :dialog="dialog"
                :mensagem="mensagem"
                @cancelar="cancelar"
                @confirmar="confirmar"
        />
    </div>
</template>
<script>
    import notificacao from './Notifications'
    import atencao from '../components/Atencao'
    import modalComanda from '../components/ModalComanda'
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        name: 'Inicio',
        components: {notificacao, modalComanda, atencao},
        data() {
            return {
                devoInserirMesa: false,
                mensagem: '',
                notificacao: {},
                modalComanda: false,
                dialog: false,
                mesa: {}
            }
        },
        computed: {
            ...mapState(['mesas'])
        },
        mounted() {
            this.buscarMesas()
            this.buscarPedidosFinalizados()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            ...mapMutations([mutationTypes.SET_COMANDA]),
            abrirModalComanda() {
                this.modalComanda = true
            },
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
            abrirNotificacaoAlerta(mesa) {
                this.notificacao = {
                    cor: 'warning',
                    mensagem: 'A mesa ' + mesa.numero + ' não possui comanda',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async atualizarMesa(mesa) {
                try {
                    await this.$store.dispatch(actionTypes.ATUALIZAR_MESA, mesa)
                    this.abrirNotificacaoSucesso()
                    this.buscarMesas()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            },
            async buscarMesas() {
                await this.$store.dispatch(actionTypes.BUSCAR_MESAS)
            },
            async buscarPedidoPorMesa(mesa) {
                let comanda = await this.$store.dispatch(actionTypes.BUSCAR_PEDIDO_POR_MESA, mesa.id)
                if (comanda) {
                    this.setComanda(comanda)
                } else {
                    comanda = {}
                    this.setComanda(comanda)
                }
                this.verificarEstadoAtualMesa(mesa)
            },
            async buscarPedidosFinalizados() {
                await this.$store.dispatch(actionTypes.BUSCAR_PEDIDOS_FINALIZADOS)
                this.formatarData()
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
            confirmar() {
                if (this.devoInserirMesa) {
                    this.montarMesa()
                    this.cancelar()
                } else {
                    this.mesa.status = 'disponivel'
                    this.atualizarMesa(this.mesa)
                    this.cancelar()
                }
            },
            comfirmarInserirMesa() {
                this.devoInserirMesa = true
                this.dialog = true
                this.mensagem = 'Deseja mesmo inserir uma nova mesa? após inserir não há como excluir'
            },
            cancelar() {
                this.dialog = false
                this.devoInserirMesa = false
            },
            efetuarPagamento() {
                this.prepararPedidoParaPagamento()
                this.fecharModalComanda()
                this.buscarPedidosFinalizados()
            },
            formatarData() {
                const pedidos = this.$store.state.pedidosFinalizados
                if (pedidos) {
                    pedidos.forEach((pedido) => {
                        pedido.data = new Date(pedido.data)
                    })
                }
            },
            fecharModalComanda() {
                this.modalComanda = false
                let comanda = {}
                this.setComanda(comanda)
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
                let numero = this.$store.state.mesas.length
                let mesa = {
                    numero: numero + 1,
                    status: 'disponivel'
                }
                this.inserirMesa(mesa)
            },
            async prepararPedidoParaPagamento() {
                const comanda = this.$store.state.comanda
                try {
                    if (comanda) {
                        comanda.forEach((pedido) => {
                            pedido.status = 'finalizado'
                            pedido.data = new Date()
                            pedido.mesa.status = 'pago'
                            this.atualizarMesa(pedido.mesa)
                        })
                    }
                    await this.$store.dispatch(actionTypes.ATUALIZAR_PEDIDO, comanda)
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }

            },
            verificarEstadoAtualMesa(mesa) {
                if (mesa.status === 'ocupada') {
                    this.abrirModalComanda()
                }
                if (mesa.status === 'disponivel') {
                    this.abrirNotificacaoAlerta(mesa)
                }
                if (mesa.status === 'pago') {
                    this.mensagem = 'A mesa estar suja, deseja limpar ela agora?'
                    this.dialog = true
                    this.mesa = mesa
                }
            }
        }
    }
</script>