<template>
    <v-dialog
            persistent
            width="500"
            v-model="abrirModalProduto">
        <v-card style="max-height: 400px; overflow-y: auto">
            <v-card-title
                    class="title color darken-1 white--text"
                    primary-title>
                Nova Categoria
            </v-card-title>
            <v-form>
                <v-container py-3>
                    <v-layout wrap>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Titulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Sub Titulo"/>
                        </v-flex>
                        <v-container fluid>
                            <v-row align="center">
                                <v-col cols="6">
                                    <v-subheader>Prepended icon</v-subheader>
                                </v-col>
                                <v-col cols="6">
                                    <v-select
                                            v-model="e1"
                                            :items="states"
                                            menu-props="auto"
                                            label="Select"
                                            hide-details
                                            prepend-icon="mdi-pizza"
                                            single-line
                                    ></v-select>
                                </v-col>
                            </v-row>
                        </v-container>
                        <v-btn
                                class="mx-0 font-weight-light"
                                color="success">
                            Atualizar
                        </v-btn>
                    </v-layout>
                </v-container>
            </v-form>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        name: 'ModalSistema',
        data() {
            return {
                e1: 'Florida',
                e2: 'Texas',
                e3: null,
                e4: null,
                items: [
                    {text: 'State 1'},
                    {text: 'State 2'},
                    {text: 'State 3'},
                    {text: 'State 4'},
                    {text: 'State 5'},
                    {text: 'State 6'},
                    {text: 'State 7'},
                ],
                states: [
                    'Alabama', 'Alaska', 'American Samoa', 'Arizona',
                    'Arkansas', 'California', 'Colorado', 'Connecticut',
                    'Delaware', 'District of Columbia', 'Federated States of Micronesia',
                    'Florida', 'Georgia', 'Guam', 'Hawaii', 'Idaho',
                    'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky',
                    'Louisiana', 'Maine', 'Marshall Islands', 'Maryland',
                    'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi',
                    'Missouri', 'Montana', 'Nebraska', 'Nevada',
                    'New Hampshire', 'New Jersey', 'New Mexico', 'New York',
                    'North Carolina', 'North Dakota', 'Northern Mariana Islands', 'Ohio',
                    'Oklahoma', 'Oregon', 'Palau', 'Pennsylvania', 'Puerto Rico',
                    'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee',
                    'Texas', 'Utah', 'Vermont', 'Virgin Island', 'Virginia',
                    'Washington', 'West Virginia', 'Wisconsin', 'Wyoming',
                ],
            }
        },
        props: {
            abrirModalProduto: {
                required: true
            }
        },
        methods: {
            enviarDadosCategoria() {
                this.$emit('enviarDadosCategoria')
            },
            fecharModalProduto() {
                this.$emit('fecharModalProduto')
            }
        }
    }
</script>
<style lang="stylus">
    #nome-sistema-modal
        max-width 340px
</style>
