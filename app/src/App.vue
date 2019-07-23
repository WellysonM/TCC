<template>
    <div id="app">
        <SignIn />
    </div>
</template>

<script>
    import SignIn from './commons/components/SignIn.vue'

    export default {
        name: 'app',
        components: {
            SignIn
        }
    }
</script>

<style lang="scss">
    #app {
        font-family: sans-serif, fantasy;
        font-size: 1.6rem;
        color: #222;
        background: #00416A;
        background: -webkit-linear-gradient(to right, #E4E5E6, #00416A);
        background: linear-gradient(to right, #E4E5E6, #00416A);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>