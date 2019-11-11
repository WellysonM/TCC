<template>
    <div>
        <v-container fill-height grid-list-xl>
            <v-layout wrap>
                <v-flex md6 lg4 py-6 :key="pedido.id" v-for="pedido in pedidosEmEspera">
                    <v-card class="mx-auto" max-width="344" outlined>
                        <v-list-item three-line>
                            <v-list-item-content>
                                <div class="overline mb-4">PEDIDO</div>
                                <v-list-item-title class="headline mb-1">MESA {{pedido.mesa.numero}}</v-list-item-title>
                                <v-list-item-subtitle>usuário: {{pedido.usuario.name}}</v-list-item-subtitle>
                            </v-list-item-content>
                            <v-list-item-avatar
                                    icon
                                    size="80"
                                    color="grey"
                            >
                                <v-icon large>
                                    mdi-stove
                                </v-icon>
                            </v-list-item-avatar>
                        </v-list-item>
                        <v-list-item three-line>
                            <v-list-item-content>
                                <v-data-table :headers="headers" :items="pedido.produtos" hide-default-footer/>
                                <v-btn depressed color="white green--text" @click="atualizarPedido(pedido)">finalizar
                                </v-btn>
                            </v-list-item-content>
                        </v-list-item>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
        <notificacao/>
    </div>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'
    import notificacao from './Notifications'

    export default {
        name: 'Pedidos',
        components: {notificacao},
        data: () => ({
            usuarios: [],
            headers: [
                {
                    sortable: false,
                    text: 'Produto',
                    value: 'produto'
                },
                {
                    sortable: false,
                    text: 'Quantidade',
                    value: 'quantidade'
                }
            ]
        }),
        computed: {
            ...mapState(['pedidosEmEspera'])
        },
        mounted() {
            window.setInterval(this.buscarPedidosEmEspera, 30000)
            this.buscarPedidosEmEspera()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirNotificacaoSucesso() {
                this.notificacao = {
                    cor: '#4caf50',
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
            async atualizarPedido(pedido) {
                pedido.status = 'pronto'
                try {
                    await this.$store.dispatch(actionTypes.ATUALIZAR_PEDIDO_COZINHA, pedido)
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
                this.buscarPedidosEmEspera()
            },
            async buscarPedidosEmEspera() {
                await this.$store.dispatch(actionTypes.BUSCAR_PEDIDOS_EMESPERA)
            },
        }
    };
</script>
