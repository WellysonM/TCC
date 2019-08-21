<template>
    <v-dialog
            persistent
            width="600"
            v-model="abrirModalProduto">
        <v-card style="max-height: 600px;">
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
                                    v-model="styleCard.titulo"
                                    label="Titulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    v-model="styleCard.preco"
                                    label="Margem de preço"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    v-model="styleCard.subtitulo"
                                    label="Informação Adicional"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-select
                                    :items="tamanhos"
                                    menu-props="auto"
                                    label="Icone"
                                    hide-details
                                    v-model="styleCard.icone"
                                    :prepend-icon="styleCard.icone"
                                    single-line
                                    @change="trocarTamanho"
                            ></v-select>
                        </v-flex>
                        <v-container py-3 v-model="styleCard.cor">
                            <v-layout wrap>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="red"
                                            color="red"
                                            value="red"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="red darken-3"
                                            color="red darken-3"
                                            value="red darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="indigo"
                                            color="indigo"
                                            value="indigo"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="indigo darken-3"
                                            color="indigo darken-3"
                                            value="indigo darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="orange"
                                            color="orange"
                                            value="orange"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="orange darken-3"
                                            color="orange darken-3"
                                            value="orange darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="primary"
                                            color="primary"
                                            value="primary"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="secondary"
                                            color="secondary"
                                            value="secondary"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="success"
                                            color="success"
                                            value="success"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="info"
                                            color="info"
                                            value="info"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="warning"
                                            color="warning"
                                            value="warning"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="error"
                                            color="error"
                                            value="error"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                            </v-layout>
                        </v-container>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn @click="fecharModalProduto" class="acao-fechar">fechar</v-btn>
                            <v-btn @click="statusCardM" class="acao-sucesso" outlined>enviar</v-btn>
                        </v-card-actions>
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
                tamanhos: [
                    {text: 'pizza', value: 'mdi-pizza'},
                    {text: 'bebida', value: 'mdi-beer'},
                    {text: 'pão', value: 'mdi-baguette'},
                    {text: 'browne', value: 'mdi-bowl'},
                    {text: 'bolo', value: 'mdi-cake'},
                    {text: 'cookie', value: 'mdi-cookie'},
                    {text: 'sorvete', value: 'mdi-rice'}
                ],
                styleCard: {
                    icone: '',
                    titulo: '',
                    subtitulo: '',
                    preco: '',
                    cor: 'info'
                }
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
            },
            trocarTamanho(tamanho) {
                console.log(tamanho)
                this.icone = tamanho
            },
            statusCardM() {
                this.$emit('statusCardM', this.styleCard)
            }
        }
    }
</script>
<style lang="stylus">
    #nome-sistema-modal
        max-width 340px
</style>