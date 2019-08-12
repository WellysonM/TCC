<template>
    <v-container
            fill-height
            fluid
            grid-list-xl>
        <v-layout justify-center wrap>
            <v-flex xs12 md8>
                <material-card
                        color="info"
                        title="Atualizar Perfil"
                        text="Não deixe campos vazios :)">
                    <v-form>
                        <v-container py-0>
                            <v-layout wrap>
                                <v-flex xs12 md6>
                                    <v-text-field
                                            label="Nome"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md6>
                                    <v-text-field
                                            label="Sobrenome"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md6>
                                    <v-text-field
                                            label="Nome de usuario"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md6>
                                    <v-text-field
                                            label="Last Name"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md12>
                                    <v-text-field
                                            label="Adress"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md4>
                                    <v-text-field
                                            label="City"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md4>
                                    <v-text-field
                                            label="Country"
                                            class="info-input"/>
                                </v-flex>
                                <v-flex xs12 md4>
                                    <v-text-field
                                            class="info-input"
                                            label="Postal Code"
                                            type="number"/>
                                </v-flex>
                                <v-flex xs12 text-xs-right>
                                    <v-btn
                                            class="mx-0 font-weight-light"
                                            color="success">
                                        Atualizar
                                    </v-btn>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </v-form>
                </material-card>
            </v-flex>
            <v-flex xs12 md2>
                <material-card class="v-card-profile">
                    <v-avatar
                            slot="offset"
                            class="mx-auto d-block"
                            size="130">
                        <img
                                src="https://avatars.servers.getgo.com/2205256774854474505_medium.jpg">
                    </v-avatar>
                    <v-card-text class="text-xs-center">
                        <h6 class="category text-gray font-weight-thin mb-3">Foto de perfil</h6>
                        <h4 class="card-title font-weight-light">Nome</h4>
                        <v-btn
                                color="success"
                                round
                                class="font-weight-light">Salvar
                        </v-btn>
                    </v-card-text>
                </material-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        //
    }
</script>
