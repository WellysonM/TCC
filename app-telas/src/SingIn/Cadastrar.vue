<template>
    <section class="main">
        <div class="layer">
            <div class="bottom-grid">
                <div class="logo">
                    <h1><a href="http://localhost:8095/entrar"><span class="fa fa-ravelry"></span> Sistema</a></h1>
                </div>
                <div class="links">
                    <ul class="links-unordered-list">
                        <li class="">
                            <a class="" href="http://localhost:8095/entrar">Entrar</a>
                        </li>
                        <li class="active">
                            <a class="" href="">Cadastrar</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="content-form">
                <div class="content-bottom">
                    <div class="main-icon">
                        <span class="fa fa-eercast"></span>
                    </div>
                    <form @submit.prevent="teste">
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
                        <ul class="list-login-bottom">
                            <li class="">
                                <span aria-hidden="true" class="fa fa-reply-all" style="color: white"></span>
                                <a class="" href="http://localhost:8095/entrar"> Voltar</a>
                            </li>
                            <li class="clearfix"></li>
                        </ul>
                    </form>
                </div>
            </div>
            <div class="copyright">
                <p>© 2019 Trabalho De Conclusão De Curso
                </p>
            </div>
        </div>
    </section>
</template>

<script>
    import service from '../services/service'
    import inicio from './Layout'

    export default {
        name: "Cadastrar",
        data() {
            return {
                usuario: {
                    name: '',
                    username: '',
                    password: ''
                },
                usuarioLogado: []
            }
        },
        methods: {
            teste() {
                this.$route.router.go(inicio)
               // service.cadastrar(this.usuario)
            }
        }
    }
</script>
<style lang="scss">
    @import './css/style.css';
    @import './css/font-awesome.min.css';
</style>