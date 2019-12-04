<template>
    <div>
        <v-snackbar
                :color="notificacao.cor"
                :right="right"
                :top="top"
                dark
                v-model="notificacao.mostrar"
        >
            <v-icon
                    class="mr-3"
                    color="white"
            >
                mdi-bell-plus
            </v-icon>
            <div>{{notificacao.mensagem}}</div>
            <v-icon
                    @click="notificacao.mostrar = false"
                    size="16"
            >
                mdi-close-circle
            </v-icon>
        </v-snackbar>
    </div>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        name: 'notifications',
        data: () => ({
            top: true,
            right: true,
        }),
        computed: {
            ...mapState(['notificacao'])
        }
    }
</script>
