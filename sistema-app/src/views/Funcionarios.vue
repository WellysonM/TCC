<template>
    <div>
        <notificacao/>
        <v-container fill-height fluid grid-list-xl>
            <v-layout justify-center wrap>
                <v-flex md10>
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
                                              color="secondary" @change="atualizarUsuario(item)"></v-switch>
                                </td>
                                <td class="text-xs-right">
                                    <v-btn @click="removerUsuario(item.id)" class="acao-fechar" flat
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
    </div>
</template>

<script>
    import notificacao from './Notifications'
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        components: {notificacao},
        data: () => ({
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
            async buscarUsuarios() {
                this.usuarios = await this.$store.dispatch(actionTypes.BUSCAR_USUARIOS)
            },
            async atualizarUsuario(usuario) {
                await this.$store.dispatch(actionTypes.ATUALIZAR_USUARIO, usuario)
                this.buscarUsuarios()
            },
            async remover(usuarioId) {
                await this.$store.dispatch(actionTypes.REMOVER_USUARIO, usuarioId)
            },
            removerUsuario(usuarioId) {
                try {
                    this.remover(usuarioId)
                    this.buscarUsuarios()
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            }
        }
    }
</script>
<style>
    .v-label {
        color: black !important;
        font-style: italic;
        font-size: 16.66px !important;
    }
</style>
