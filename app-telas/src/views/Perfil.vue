<template>
    <v-container
            fill-height
            fluid
            grid-list-xl>
        <v-layout justify-center wrap>
            <v-flex md8 xs12>
                <material-card
                        color="padrao2"
                        text="Não deixe campos vazios :)"
                        title="Atualizar Perfil">
                    <v-form>
                        <v-container py-0>
                            <v-layout wrap>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            required
                                            :rules="[val => (val || '').length > 0 || 'This field is required']"
                                            class="info-input"
                                            label="Nome"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="Sobrenome"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="Nome de usuario"/>
                                </v-flex>
                                <v-flex md6 xs12>
                                    <v-text-field
                                            :type="'password'"
                                            label="Senha Atual"
                                    ></v-text-field>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-text-field
                                            :type="'password'"
                                            required
                                            label="Nova Senha"
                                    ></v-text-field>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-text-field
                                            :type="'password'"
                                            label="Repita Novamente a Nova Senha"
                                    ></v-text-field>
                                </v-flex>
                                <v-flex text-xs-right xs12>
                                    <v-btn
                                            class="acao-sucesso"
                                            flat>
                                        Atualizar
                                    </v-btn>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </v-form>
                </material-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        data() {
            return {}
        },
        mounted() {
          //  this.teste()
        },
        methods: {
            //teste() {
                //window.location.href = "http://localhost:8095/"
            //}
        }
    }
</script>