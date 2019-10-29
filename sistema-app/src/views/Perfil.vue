<template>
    <div>
        <notificacao/>
        <v-container
                fill-height
                fluid
                grid-list-xl>
            <v-layout justify-center wrap>
                <v-flex md8 xs12>
                    <material-card
                            color="padrao2"
                            text="Não deixe campos vazios :)"
                            title="Atualizar Perfil">
                        <v-form>
                            <v-container py-0>
                                <v-layout wrap>
                                    <v-flex md6 xs12>
                                        <v-text-field
                                                disabled
                                                v-model="usuario.name"
                                                required
                                                :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                                class="info-input"
                                                label="Nome"/>
                                    </v-flex>
                                    <v-flex md6 xs12>
                                        <v-text-field
                                                v-model="usuario.username"
                                                required
                                                :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                                class="info-input"
                                                label="Nome de usuario"/>
                                    </v-flex>
                                    <v-flex md6 xs12>
                                        <v-text-field
                                                v-model="usuario.password"
                                                required
                                                :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                                :type="'password'"
                                                required
                                                label="Nova senha"
                                        ></v-text-field>
                                    </v-flex>
                                    <v-flex md6 xs12>
                                        <v-text-field
                                                v-model="novaSenha"
                                                required
                                                :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                                :type="'password'"
                                                label="Repita novamente a nova senha"
                                        ></v-text-field>
                                    </v-flex>
                                    <v-sheet class="pa-3" v-show="usuario.admin">
                                        <v-switch style="font-family: sans-serif;" v-model="usuario.admin" error
                                                  label="Usuario Administrador"
                                                  color="secondary"></v-switch>
                                    </v-sheet>
                                    <v-flex text-xs-right xs12>
                                        <v-btn @click="abrirModalAtencao()"
                                               class="acao-sucesso"
                                               flat>
                                            Atualizar
                                        </v-btn>
                                    </v-flex>
                                </v-layout>
                            </v-container>
                        </v-form>
                    </material-card>
                </v-flex>
            </v-layout>
        </v-container>
        <atencao
                :dialog="dialog"
                :mensagem="'Tem certeza que deseja atualizar seu usuario?'"
                @cancelar="cancelar"
                @confirmar="confirmar"
        />
    </div>
</template>

<script>
    import _ from 'lodash'
    import notificacao from './Notifications'
    import atencao from '../components/Atencao'
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        components: {notificacao, atencao},
        data() {
            return {
                novaSenha: '',
                usuario: {},
                dialog: false,
                notificacao: {}
            }
        },
        mounted() {
            this.preencherUsuario()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirModalAtencao() {
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
                    mensagem: 'Digite as senhas novamente !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoUsernameExistente() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Já existe um usuário com esse nome !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async atualizarUsuario() {
                try {
                    await this.$store.dispatch(actionTypes.ATUALIZAR_USUARIO, this.usuario)
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoUsernameExistente()
                }
            },
            confirmar() {
                if (this.validarSenha()) {
                    this.atualizarUsuario()
                } else {
                    this.abrirNotificacaoErro()
                }
                this.dialog = false

            },
            cancelar() {
                this.dialog = false
                this.usuario.admin = this.$store.state.usuarioLogado.admin
            },
            preencherUsuario() {
                this.usuario = _.clone(this.$store.state.usuarioLogado)
                this.usuario.password = ''
            },
            validarSenha() {
                if (this.usuario.password === this.novaSenha) {
                    return true
                } else {
                    return false
                }
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