<template>
    <div>
        <article>
            <div class="container" :class="{'sign-up-active' : signUp}">
                <div class="overlay-container">
                    <div class="overlay">
                        <div class="overlay-left">
                            <h2>Olá, Amigo(a)!</h2>
                            <p>Seja bem vindo :)</p>
                            <p>Já tem cadastro? que tal entrar no sistema?</p>
                            <button class="invert" id="signIn" @click="signUp = !signUp">Entrar
                            </button>
                        </div>
                        <div class="overlay-right">
                            <h2>Olá, Amigo(a)!</h2>
                            <p>É novo por aqui?</p>
                            <p>Que tal se cadastrar para ter acesso ao sistema?</p>
                            <button class="invert" id="signUp" @click="signUp = !signUp">Cadastrar</button>
                        </div>
                    </div>
                </div>
                <form class="sign-up" action="#">
                    <h2>Cadastro</h2>
                    <div>Crie um nome de usuário e senha</div>
                    <v-input type="text" placeholder="Seu nome"/>
                    <v-input type="text" placeholder="Nome de usuário"/>
                    <v-input type="password" placeholder="Senha"/>
                    <button>Sign Up</button>
                </form>
                <form class="sign-in" action="#">
                    <h2>Bem Vindo</h2>
                    <div>Use seu nome de usuário e senha para entrar no sistema.</div>
                    <div class="input">
                        <v-text-field
                                v-validate="'required|min:6'" type="text" name="username"
                                label="Nome de usuário"
                        ></v-text-field>
                        <v-text-field
                                :append-icon="show1 ? 'visibility' : 'visibility_off'"
                                :type="show1 ? 'text' : 'password'"
                                name="password"
                                label="Senha"
                                counter
                                @click:append="show1 = !show1"
                        ></v-text-field>
                    </div>
                    <button>Entrar</button>
                </form>
            </div>
        </article>
    </div>
</template>
<script>
    export default {
        name: "SingIn",
        data() {
            return {
                signUp: false,
                show1: false,
            }
        }
    }
</script>

<style lang="scss" scoped>
    .container {
        position: relative;
        width: 768px;
        height: 480px;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 15px 30px rgba(0, 0, 0, .3),
        0 10px 10px rgba(0, 0, 0, .3);
        background: linear-gradient(to bottom, #efefef, #ccc);

        .overlay-container {
            position: absolute;
            top: 0;
            left: 50%;
            width: 50%;
            height: 100%;
            overflow: hidden;
            transition: transform .5s ease-in-out;
            z-index: 100;
        }

        .overlay {
            position: relative;
            left: -100%;
            height: 100%;
            width: 200%;
            background: #000428;
            background: -webkit-linear-gradient(to right, #004e92, #000428);
            background: linear-gradient(to right, #004e92, #000428);

            color: #fff;
            transform: translateX(0);
            transition: transform .5s ease-in-out;
        }

        @mixin overlays($property) {
            position: absolute;
            top: 0;
            display: flex;
            align-items: center;
            justify-content: space-around;
            flex-direction: column;
            padding: 70px 40px;
            width: calc(66% - 120px);
            height: calc(130% - 180px);
            text-align: center;
            transform: translateX($property);
            transition: transform .5s ease-in-out;
        }

        .overlay-left {
            @include overlays(-20%);
        }

        .overlay-right {
            @include overlays(0);
            right: 0;
        }
    }

    h2 {
        margin: 0;
    }

    p {
        margin: 20px 0 30px;
    }

    a {
        color: #222;
        text-decoration: none;
        margin: 15px 0;
        font-size: 1rem;
    }

    button {
        border-radius: 20px;
        border: 1px solid #009345;
        background-color: #009345;
        color: #fff;
        font-size: 1rem;
        font-weight: bold;
        padding: 10px 40px;
        letter-spacing: 1px;
        text-transform: uppercase;
        cursor: pointer;
        transition: transform .1s ease-in;

        &:active {
            transform: scale(.9);
        }

        &:focus {
            outline: none;
        }
    }

    button.invert {
        background-color: transparent;
        border-color: #fff;
    }

    form {
        position: absolute;
        top: 0;
        display: flex;
        align-items: center;
        justify-content: space-around;
        flex-direction: column;
        padding: 70px 60px;
        width: calc(66% - 120px);
        height: calc(130% - 180px);
        text-align: center;
        background: linear-gradient(to bottom, #efefef, #ccc);
        transition: all .5s ease-in-out;

        div {
            font-size: 1rem;
        }

        .input {
            margin: 6px 0;
            width: calc(100% - 20px);
        }
    }

    .sign-in {
        left: 0;
        z-index: 2;
    }

    .sign-up {
        left: 0;
        z-index: 1;
        opacity: 0;
    }

    .sign-up-active {
        .sign-in {
            transform: translateX(100%);
        }

        .sign-up {
            transform: translateX(100%);
            opacity: 1;
            z-index: 5;
            animation: show .5s;
        }

        .overlay-container {
            transform: translateX(-100%);
        }

        .overlay {
            transform: translateX(50%);
        }

        .overlay-left {
            transform: translateX(0);
        }

        .overlay-right {
            transform: translateX(20%);
        }
    }

    @keyframes show {
        0% {
            opacity: 0;
            z-index: 1;
        }
        49% {
            opacity: 0;
            z-index: 1;
        }
        50% {
            opacity: 1;
            z-index: 10;
        }
    }
</style>
