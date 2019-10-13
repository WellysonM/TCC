<template>
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
</template>

<script>
    import service from "../../services/service";

    export default {
        name: "Entrar",
        data() {
            return {
                usuario: {
                    username: '',
                    password: ''
                },
                usuarioLogado: null
            }
        },
        methods: {
            async entrar() {
                console.log(this.usuario)
                alert(this.usuario)
                this.usuarioLogado = await service.cadastrar(this.usuario)
                console.log(this.usuarioLogado)
            }
        }
    }
</script>
<style lang="scss">
    @import 'css/style.css';
    @import 'css/font-awesome.min.css';
</style>