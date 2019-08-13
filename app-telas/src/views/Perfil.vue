<template>
    <v-container
            fill-height
            fluid
            grid-list-xl>
        <v-layout justify-center wrap>
            <v-flex md8 xs12>
                <material-card
                        color="info"
                        text="Não deixe campos vazios :)"
                        title="Atualizar Perfil">
                    <v-form>
                        <v-container py-0>
                            <v-layout wrap>
                                <v-flex md6 xs12>
                                    <v-text-field
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
                                            class="info-input"
                                            label="Last Name"/>
                                </v-flex>
                                <v-flex md12 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="Adress"/>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="City"/>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="Country"/>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-text-field
                                            class="info-input"
                                            label="Postal Code"
                                            type="number"/>
                                </v-flex>
                                <v-flex text-xs-right xs12>
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
            <v-flex md2 xs12>
                <material-card class="v-card-profile">
                    <v-avatar
                            class="mx-auto d-block"
                            size="130"
                            slot="offset">
                        <img
                                src="https://avatars.servers.getgo.com/2205256774854474505_medium.jpg">
                    </v-avatar>
                    <v-card-text class="text-xs-center">
                        <h6 class="category text-gray font-weight-thin mb-3">Foto de perfil</h6>
                        <h4 class="card-title font-weight-light">Nome</h4>
                        <v-btn
                                class="font-weight-light"
                                color="success"
                                round>Salvar
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
