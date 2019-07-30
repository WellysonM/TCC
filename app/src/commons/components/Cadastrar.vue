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
                            <a href="http://localhost:8095/entrar" class="">Entrar</a>
                        </li>
                        <li class="active">
                            <a href="" class="">Cadastrar</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="content-form">
                <div class="content-bottom">
                    <div class="main-icon">
                        <span class="fa fa-eercast"></span>
                    </div>
                    <form action="/salvarCadastro" method="post">
                        <div class="field-group">
                            <span class="fa fa-user-circle-o" aria-hidden="true"></span>
                            <div class="wthree-field">
                                <input name="name" type="text" placeholder="Nome">
                            </div>
                        </div>
                        <div class="field-group">
                            <span class="fa fa-user" aria-hidden="true"></span>
                            <div class="wthree-field">
                                <input name="username" id="text1" type="text" placeholder="Nome de usuário">
                            </div>
                        </div>
                        <div class="field-group">
                            <span class="fa fa-lock" aria-hidden="true"></span>
                            <div class="wthree-field">
                                <input name="password" id="myInput" type="Password" placeholder="Senha">
                            </div>
                        </div>
                        <div class="wthree-field">
                            <button type="submit" class="btn">Cadastrar</button>
                        </div>
                        <ul class="list-login-bottom">
                            <li class="">
                                <span class="fa fa-reply-all" aria-hidden="true" style="color: white"></span>
                                <a href="http://localhost:8095/entrar" class=""> Voltar</a>
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
    export default {
        name: "Cadastrar"
    }
</script>
<style src="../css/style.css"></style>
<style src="../css/font-awesome.min.css"></style>
<style href="//fonts.googleapis.com/css?family=Quattrocento+Sans:400,400i,700,700i" rel="stylesheet"></style>
<style href="//fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800" rel="stylesheet"></style>