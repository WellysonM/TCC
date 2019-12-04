<template>
    <div>
        <notificacao/>
        <section class="main">
            <div class="layer">
                <div class="bottom-grid">
                    <router-link tag="a" to="/entrar">
                        <div class="logo">
                            <div><a><span class="fa fa-ravelry"></span>Sistema</a></div>
                        </div>
                    </router-link>
                    <div class="links">
                        <ul class="links-unordered-list">
                            <ul class="links-unordered-list">
                                <li class="active">
                                    <v-btn flat class="acao-sair" router-link to="/">Entrar</v-btn>
                                </li>
                                <li class="active">
                                    <v-btn flat class="acao-sair" router-link to="/cadastrar">Cadastrar</v-btn>
                                </li>
                            </ul>
                        </ul>
                    </div>
                </div>
                <div class="content-form">
                    <div class="content-bottom">
                        <div class="main-icon">
                            <span class="fa fa-eercast"></span>
                        </div>
                        <form @submit.prevent="inserirUsuario">
                            <div class="field-group">
                                <span aria-hidden="true" class="fa fa-user-circle-o"></span>
                                <div class="wthree-field">
                                    <input name="name" placeholder="Nome" type="text" v-model="usuario.name">
                                </div>
                            </div>
                            <div class="field-group">
                                <span aria-hidden="true" class="fa fa-user"></span>
                                <div class="wthree-field">
                                    <input id="text1" name="username" placeholder="Nome de usuário" type="text"
                                           v-model="usuario.username">
                                </div>
                            </div>
                            <div class="field-group">
                                <span aria-hidden="true" class="fa fa-lock"></span>
                                <div class="wthree-field">
                                    <input id="myInput" name="password" placeholder="Senha" type="Password"
                                           v-model="usuario.password">
                                </div>
                            </div>
                            <div class="wthree-field">
                                <button class="btn" type="submit">Cadastrar</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="copyright">
                    <p>© 2019 Trabalho De Conclusão De Curso
                    </p>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
    import notificacao from '../Notifications'
    import {mapMutations} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        name: "Cadastrar",
        components: {notificacao},
        data() {
            return {
                notificacao: {},
                usuario: {
                    username: '',
                    password: '',
                    name: '',
                    admin: false
                }
            }
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
            async inserirUsuario() {
                try {
                    await this.$store.dispatch(actionTypes.INSERIR_USUARIO, this.usuario)
                    await this.$router.push({path: '/entrar'})
                    this.abrirNotificacaoSucesso()
                } catch (e) {
                    this.abrirNotificacaoErro()
                }
            }
        }
    }
</script>
<style lang="scss">
    @import 'css/style.css';
    @import 'css/font-awesome.min.css';
</style>