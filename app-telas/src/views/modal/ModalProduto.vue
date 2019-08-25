<template>
    <v-dialog
            persistent
            v-model="modalProduto"
            width="600">
        <v-card style="max-height: 600px;">
            <v-card-title
                    class="title color darken-1 white--text"
                    primary-title>
                Nova Categoria
            </v-card-title>
            <v-form>
                <v-container py-3>
                    <v-layout row wrap>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Titulo"
                                    v-model="styleCard.titulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Margem de preço"
                                    v-model="styleCard.preco"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Informação Adicional"
                                    v-model="styleCard.subtitulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-select
                                    :items="tamanhos"
                                    :prepend-icon="styleCard.icone"
                                    hide-details
                                    label="Icone"
                                    menu-props="auto"
                                    single-line
                                    v-model="styleCard.icone"
                            ></v-select>
                        </v-flex>
                        <v-container py-3 v-model="styleCard.cor">
                            <v-layout wrap>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="primary"
                                            hide-details
                                            label="Preto"
                                            v-model="styleCard.cor"
                                            value="primary"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="#33691e"
                                            hide-details
                                            label="Verde"
                                            v-model="styleCard.cor"
                                            value="#33691e"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="#004d40"
                                            hide-details
                                            label="Teal"
                                            v-model="styleCard.cor"
                                            value="#004d40"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="indigo darken-3"
                                            hide-details
                                            label="Indigo"
                                            v-model="styleCard.cor"
                                            value="indigo darken-3"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="accent"
                                            hide-details
                                            label="Cinza"
                                            v-model="styleCard.cor"
                                            value="accent"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="#4a148c"
                                            hide-details
                                            label="Roxo"
                                            v-model="styleCard.cor"
                                            value="#4a148c"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="#0d47a1"
                                            hide-details
                                            label="Azul"
                                            v-model="styleCard.cor"
                                            value="#0d47a1"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="success"
                                            hide-details
                                            label="Verde Sucesso"
                                            v-model="styleCard.cor"
                                            value="success"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="red"
                                            hide-details
                                            label="Vermelho"
                                            v-model="styleCard.cor"
                                            value="red"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="color"
                                            hide-details
                                            label="Padrão Sistema"
                                            v-model="styleCard.cor"
                                            value="color"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="warning"
                                            hide-details
                                            label="Amarelo"
                                            v-model="styleCard.cor"
                                            value="warning"
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            color="#c51162"
                                            hide-details
                                            label="Rosa Escuro"
                                            v-model="styleCard.cor"
                                            value="#c51162"
                                    ></v-switch>
                                </v-flex>
                            </v-layout>
                        </v-container>
                        <v-divider></v-divider>
                            <v-btn @click="fecharModalProduto" class="acao-fechar" flat style="margin: 4% 2%">fechar
                            </v-btn>
                            <v-btn @click="enviarCategoriaProduto" class="acao-sucesso" flat style="margin: 4% 2%">enviar
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
                tamanhos: [
                    {text: 'pizza', value: 'mdi-pizza'},
                    {text: 'bebida', value: 'mdi-beer'},
                    {text: 'bebida 2', value: 'mdi-glass-mug'},
                    {text: 'taça', value: 'mdi-glass-cocktail'},
                    {text: 'peixe', value: 'mdi-fish'},
                    {text: 'browne', value: 'mdi-bowl'},
                    {text: 'bolo', value: 'mdi-cake'},
                    {text: 'cookie', value: 'mdi-cookie'},
                    {text: 'sorvete', value: 'mdi-rice'},
                    {text: 'comida e bebida', value: 'mdi-food-fork-drink'},
                    {text: 'lanche e bebida', value: 'mdi-food'},
                    {text: 'hamburgue', value: 'mdi-hamburger'},
                    {text: 'pastel', value: 'mdi-food-croissant'},
                    {text: 'jantar', value: 'mdi-silverware'},
                    {text: 'jantar 2', value: 'mdi-silverware-fork-knife'},
                    {text: 'jantar 3', value: 'mdi-silverware-variant'},
                    {text: 'taco', value: 'mdi-taco'}
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
            modalProduto: {
                required: true
            }
        },
        methods: {
            abrirModalProduto() {
                this.$emit('abrirModalProduto')
            },
            fecharModalProduto() {
                this.$emit('fecharModalProduto')
            },
            enviarCategoriaProduto() {
                this.$emit('enviarCategoriaProduto', this.styleCard)
            }
        }
    }
</script>
<style lang="stylus">
    #nome-sistema-modal
        max-width 340px
</style>