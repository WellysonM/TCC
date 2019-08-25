<template>
    <div>
        <v-snackbar
                :color="cor"
                :right="right"
                :top="top"
                dark
                v-model="notificacao"
        >
            <v-icon
                    class="mr-3"
                    color="white"
            >
                mdi-bell-plus
            </v-icon>
            <div>{{this.mensagem}}</div>
            <v-icon
                    @click="fecharNotificacao"
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
            top: true,
            right: true,
        }),
        props: {
            notificacao: {
                required: true
            },
            cor: {
                required: true
            },
            mensagem: {
                required: true
            }
        },
        methods: {
            abrirNotificacao() {
                this.$emit('abrirNotificacao')
            },
            fecharNotificacao(){
                this.$emit('fecharNotificacao')
            }
        }
    }
</script>
