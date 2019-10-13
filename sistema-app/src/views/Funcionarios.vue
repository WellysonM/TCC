<template>
    <div>
        <notificacao
                :cor="cor"
                :mensagem="mensagem"
                :notificacao="notificacao"
                @abrirNotificacao="abrirNotificacao"
                @fecharNotificacao="fecharNotificacao"
        />
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
                                    <v-switch v-model="item.admin" error color="green" @change="atualizarUsuario(item)"
                                              label="Usuario Administrador"></v-switch>
                                </td>
                                <td class="text-xs-right">
                                    <v-btn @click="abrirNotificacao" class="acao-fechar" flat style="min-width: 10px">
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
    import {actionTypes} from '@/commons/constants'

    export default {
        components: {notificacao},
        data: () => ({
            notificacao: false,
            cor: null,
            mensagem: '',
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
            abrirNotificacao() {
                this.notificacao = true
                this.cor = 'green'
                this.mensagem = 'teste'
            },
            async buscarUsuarios() {
                this.usuarios = await this.$store.dispatch(actionTypes.BUSCAR_USUARIOS)
            },
            fecharNotificacao() {
                this.notificacao = false
            },
            atualizarUsuario(usuario) {
                console.log(usuario)
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
