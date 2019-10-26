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
                            <li class="active">
                                <v-btn flat class="acao-sair" router-link to="/entrar">Entrar</v-btn>
                            </li>
                            <li class="active">
                                <v-btn flat class="acao-sair" router-link to="/">Cadastrar</v-btn>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="content-form">
                    <div class="content-bottom">
                        <div class="main-icon">
                            <span class="fa fa-eercast"></span>
                        </div>
                        <form @submit.prevent="entrar">
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
                                <button class="btn" type="submit">Entrar</button>
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
    import {mapMutations, mapState} from 'vuex'
    import {actionTypes, mutationTypes} from '@/commons/constants'

    export default {
        name: "Entrar",
        components: {notificacao},
        data() {
            return {
                notificacao: {},
                usuario: {
                    username: '',
                    password: ''
                },
                usuarioAutenticado: {}
            }
        },
        computed: {
            ...mapState(['usuarioLogado'])
        },
        methods: {
            ...mapMutations([mutationTypes.SET_USUARIO_LOGADO]),
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
                    mensagem: 'Usuario ou senha inválidos !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            async entrar() {
                try {
                    this.usuarioAutenticado = await this.$store.dispatch(actionTypes.EFETUAR_LOGIN, this.usuario)
                    if (this.usuarioAutenticado) {
                        this.setUsuarioLogado(this.usuarioAutenticado)
                        await this.$router.push({path: '/inicio'})
                        this.abrirNotificacaoSucesso()
                    } else {
                        return this.abrirNotificacaoErro()
                    }
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