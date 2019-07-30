<template>
    <div id="app">
        <router-view></router-view>
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