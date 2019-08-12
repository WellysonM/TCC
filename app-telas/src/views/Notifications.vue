<template>
    <div>
        <v-btn text color="success" @click="snack">
                <v-icon color="white">{{this.icone}}</v-icon>
        </v-btn>
        <v-snackbar
                :color="color"
                :top="top"
                :right="right"
                v-model="snackbar"
                dark
        >
            <v-icon
                    color="white"
                    class="mr-3"
            >
                mdi-bell-plus
            </v-icon>
            <div>{{this.mensagem}}</div>
            <v-icon
                    size="16"
                    @click="snackbar = false"
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
            icone:'',
            corBtn:''
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
