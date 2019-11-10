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
                                            label="Nome de usuário"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            v-model="usuario.password"
                                            label="Nova senha"
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            :type="'password'"
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
                                <v-sheet class="pa-3" v-show="usuarioLogado.admin">
                                    <v-switch style="font-family: sans-serif;" v-model="usuario.admin" error
                                              label="Usuário Administrador"
                                              color="secondary"></v-switch>
                                </v-sheet>
                                <v-flex text-xs-right xs12>
                                    <v-btn @click="abrirModalAtencao()"
                                           depressed color="white green--text">
                                        salvar
                                    </v-btn>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </material-card>
                </v-flex>
            </v-layout>
        </v-container>
        <atencao
                :dialog="dialog"
                :mensagem="'Tem certeza que deseja atualizar seu usuário?'"
                @cancelar="cancelar"
                @confirmar="confirmar"
        />
    </div>
</template>

<script>
    import _ from 'lodash'
    import notificacao from './Notifications'
    import atencao from '../components/Atencao'
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        components: {notificacao, atencao},
        data() {
            return {
                form: true,
                novaSenha: '',
                usuario: {},
                dialog: false,
                notificacao: {}
            }
        },
        computed: {
            ...mapState(['usuarioLogado']),
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
                    mensagem: 'Operação realizada com sucesso, saia e entre novamente no sistema!',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoErro() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Verifique os campos abaixo e tente novamente !',
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
                if (this.validarSenha() && this.validarCamposVazios()) {
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
                this.usuario = _.cloneDeep(this.$store.state.usuarioLogado)
                this.usuario.password = ''
            },
            validarSenha() {
                return this.usuario.password === this.novaSenha;
            },
            validarCamposVazios() {
                return this.usuario.username.length !== 0 && this.usuario.password.length !== 0 && this.novaSenha.length !== 0;
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