<template>
    <v-dialog v-model="dialog" persistent max-width="290">
        <v-card>
            <v-card-title class="headline">Atenção</v-card-title>
            <v-card-text>{{mensagem}}
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn depressed color="white gray--text" @click="cancelar">cancelar</v-btn>
                <v-btn depressed color="white green--text" @click="confirmar">confirmar</v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        name: "Atencao",
        props: {
            dialog: {
                required: true
            },
            mensagem: {
                required: true
            }
        },
        methods: {
            confirmar() {
                this.$emit('confirmar')
            },
            cancelar() {
                this.$emit('cancelar')
            }
        }
    }
</script>