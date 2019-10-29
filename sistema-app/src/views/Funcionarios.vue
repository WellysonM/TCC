<template>
    <div>
        <notificacao/>
        <v-container fill-height fluid grid-list-xl>
            <v-layout justify-center wrap>
                <v-flex md9>
                    <material-card
                            color="padrao2"
                            text="Selecione um usuario para editar"
                            title="Gerenciar Usuarios">
                        <v-data-table :headers="headers" :items="usuarios" style="text-align: center !important">
                            <template slot="headerCell" slot-scope="{ header }">
                                <span class="subheading font-weight-light text--darken-3" v-text="header.text"/>
                            </template>
                            <template slot="items" slot-scope="{ item }">
                                <td>{{ item.name }}</td>
                                <td>{{ item.username }}</td>
                                <td>
                                    <v-switch v-model="item.admin" :input-value="item.admin" error
                                              label="Usuario Administrador"
                                              color="secondary" @change="abrirModalAtencao(item)"></v-switch>
                                </td>
                                <td class="text-xs-right">
                                    <v-btn @click="abrirModalAtencaoParaExcluir(item)" class="acao-fechar" flat
                                           style="min-width: 10px">
                                        <v-icon>mdi-close-circle-outline</v-icon>
                                    </v-btn>
                                </td>
                            </template>
                        </v-data-table>
                    </material-card>
                </v-flex>
            </v-layout>
        </v-container>
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
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        components: {notificacao, atencao},
        data: () => ({
            acaoRemover: false,
            mensagem: '',
            usuarioAtual: {},
            dialog: false,
            notificacao: {},
            usuarios: [],
            headers: [
                {
                    sortable: true,
                    text: 'Nome',
                    value: 'name'
                },
                {
                    sortable: true,
                    text: 'Nome de usuario',
                    value: 'username'
                },
                {
                    sortable: true,
                    text: 'Permissões',
                    value: 'admin'
                }
            ]
        }),
        mounted() {
            this.buscarUsuarios()
            this.tenhoPermissao()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirModalAtencao(item) {
                this.mensagem = 'Tem certeza que deseja atualizar este usuario?'
                this.acaoRemover = false
                this.usuarioAtual = item
                this.dialog = true
            },
            abrirModalAtencaoParaExcluir(item) {
                this.acaoRemover = true
                this.mensagem = 'Tem certeza que deseja excluir este usuario?'
                this.usuarioAtual = item
                this.dialog = true
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
            abrirNotificacaoErroRemover() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Existe pedidos vinculados a este usuário',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErroAcesso() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Seu usuário não tem acesso a essa página !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async atualizarUsuario() {
                await this.$store.dispatch(actionTypes.ATUALIZAR_USUARIO, this.usuarioAtual)
                this.buscarUsuarios()
            },
            async buscarUsuarios() {
                this.usuarios = await this.$store.dispatch(actionTypes.BUSCAR_USUARIOS)
                this.verificarUsuario()
            },
            confirmar() {
                if (!this.acaoRemover) {
                    this.atualizarUsuario()
                    this.cancelar()
                }
                if (this.acaoRemover) {
                    this.removerUsuario(this.usuarioAtual.id)
                    this.cancelar()
                }
            },
            cancelar() {
                this.buscarUsuarios()
                this.dialog = false
            },
            async remover(usuarioId) {
                if (await this.$store.dispatch(actionTypes.REMOVER_USUARIO, usuarioId)) {
                    this.abrirNotificacaoSucesso()
                } else {
                    this.abrirNotificacaoErroRemover()
                }
            },
            removerUsuario(usuarioId) {
                this.remover(usuarioId)
                this.buscarUsuarios()
            },
            tenhoPermissao() {
                const usuario = this.$store.state.usuarioLogado
                if (usuario.admin) {
                    return
                } else {
                    this.$router.push({path: '/inicio'})
                    this.abrirNotificacaoErroAcesso()
                }
            },
            verificarUsuario() {
                const usuarioLogado = this.$store.state.usuarioLogado
                this.usuarios.forEach((usuario) => {
                    if (usuario.id === usuarioLogado.id) {
                        this.usuarios.splice(this.usuarios.indexOf(usuario), 1)
                    }
                })
            }
        }
    }
</script>
<style>
    .v-label {
        color: black !important;
        font-size: 16.66px !important;
    }
</style>
