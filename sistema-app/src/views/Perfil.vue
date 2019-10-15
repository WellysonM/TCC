<template>
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
                                            v-model="usuarioLogado.name"
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            class="info-input"
                                            label="Nome"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            v-model="usuarioLogado.username"
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            class="info-input"
                                            label="Nome de usuario"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            :type="'password'"
                                            label="Senha Atual"
                                    ></v-text-field>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            :type="'password'"
                                            required
                                            label="Nova Senha"
                                    ></v-text-field>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            required
                                            :rules="[val => (val || '').length > 0 || 'Esse campo é obrigatório']"
                                            :type="'password'"
                                            label="Repita Novamente a Nova Senha"
                                    ></v-text-field>
                                </v-flex>
                                <v-sheet class="pa-4">
                                    <v-switch v-model="usuarioLogado.admin" error label="Usuario Administrador"
                                              color="green"></v-switch>
                                </v-sheet>
                                <v-flex text-xs-right xs12>
                                    <v-btn @click="atualizarUsuario(usuarioLogado)"
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
</template>

<script>
    import {mapState} from 'vuex'
    import {actionTypes} from '@/commons/constants'

    export default {
        data() {
            return {}
        },
        computed: {
            ...mapState(['usuarioLogado'])
        },
        mounted() {
            //  this.teste()
        },
        methods: {
            async atualizarUsuario(usuario) {
                console.log(usuario)
                await this.$store.dispatch(actionTypes.ATUALIZAR_USUARIO, usuario)
            },
            async efetuarLogout() {
                await this.$store.dispatch(actionTypes.EFETUAR_LOGOUT)
                this.buscarUsuarioLogado()
               await this.$router.push({path: '/entrar'})
            },
            async buscarUsuarioLogado() {
                await this.$store.dispatch(actionTypes.BUACAR_USUARIO_LOGADO)
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