<template>
    <v-dialog
            persistent
            width="600"
            v-model="abrirModalProduto">
        <v-card style="max-height: 600px; overflow-y: auto">
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
                                    v-model="statusCard.titulo"
                                    label="Titulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    v-model="statusCard.preco"
                                    label="Margem de preço"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    v-model="statusCard.subtitulo"
                                    label="Informação Adicional"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-select
                                    :items="tamanhos"
                                    menu-props="auto"
                                    label="Icone"
                                    hide-details
                                    v-model="statusCard.icone"
                                    :prepend-icon="statusCard.icone"
                                    single-line
                                    @change="trocarTamanho"
                            ></v-select>
                        </v-flex>
                        <v-container py-3 v-model="statusCard.cor">
                            <v-layout wrap>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="red"
                                            color="red"
                                            value="red"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="red darken-3"
                                            color="red darken-3"
                                            value="red darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="indigo"
                                            color="indigo"
                                            value="indigo"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="indigo darken-3"
                                            color="indigo darken-3"
                                            value="indigo darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="orange"
                                            color="orange"
                                            value="orange"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="orange darken-3"
                                            color="orange darken-3"
                                            value="orange darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="primary"
                                            color="primary"
                                            value="primary"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="secondary"
                                            color="secondary"
                                            value="secondary"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="success"
                                            color="success"
                                            value="success"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="info"
                                            color="info"
                                            value="info"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="warning"
                                            color="warning"
                                            value="warning"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="statusCard.cor"
                                            label="error"
                                            color="error"
                                            value="error"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </v-layout>
                    <v-btn @click="fecharModalProduto" color="info">fechar</v-btn>
                    <v-btn @click="statusCardM" color="info">enviar</v-btn>
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
                tamanhos: [
                    {text: 'pizza', value: 'mdi-pizza'},
                    {text: 'bebida', value: 'mdi-beer'},
                    {text: 'pão', value: 'mdi-baguette'},
                    {text: 'browne', value: 'mdi-bowl'},
                    {text: 'bolo', value: 'mdi-cake'},
                    {text: 'cookie', value: 'mdi-cookie'},
                    {text: 'sorvete', value: 'mdi-rice'}
                ],
            }
        },
        props: {
            abrirModalProduto: {
                required: true
            },
            statusCard: {
                icone: '',
                titulo: '',
                subtitulo: '',
                preco: '',
                cor: 'info'
            }
        },
        methods: {
            enviarDadosCategoria() {
                this.$emit('enviarDadosCategoria')
            },
            fecharModalProduto() {
                this.$emit('fecharModalProduto')
            },
            trocarTamanho(tamanho) {
                console.log(tamanho)
                this.icone = tamanho
            },
            statusCardM() {
                this.$emit('statusCardM', this.statusCard)
            }
        }
    }
</script>
<style lang="stylus">
    #nome-sistema-modal
        max-width 340px
</style>