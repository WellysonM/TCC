<template>
    <div>
        <v-btn @click="snack" color="success" text>
            <v-icon color="white">{{this.icone}}</v-icon>
        </v-btn>
        <v-snackbar
                :color="color"
                :right="right"
                :top="top"
                dark
                v-model="snackbar"
        >
            <v-icon
                    class="mr-3"
                    color="white"
            >
                mdi-bell-plus
            </v-icon>
            <div>{{this.mensagem}}</div>
            <v-icon
                    @click="snackbar = false"
                    size="16"
            >
                mdi-close-circle
            </v-icon>
        </v-snackbar>
    </div>
</template>

<script>
    export default {
        name: 'notifications',
        data: () => ({
            color: null,
            colors: [
                'purple',
                'info',
                'success',
                'warning',
                'error'
            ],
            top: true,
            right: false,
            snackbar: false,
        }),
        props: {
            cor: null,
            mensagem: '',
            icone: '',
            corBtn: ''
        },
        methods: {
            snack() {
                this.mensagem
                this.top = true
                this.right = true
                this.color = this.cor
                this.snackbar = true
            }
        }
    }
</script>
