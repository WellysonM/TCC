<template>
    <v-dialog persistent v-model="modalCategoria" width="550">
        <v-card>
            <v-card-title class="title padrao2 white--text" primary-title>
                Nova Categoria
            </v-card-title>
            <v-form v-model="form" ref="form">
                <v-container py-3>
                    <v-layout row wrap>
                        <v-flex md6 xs12>
                            <v-text-field
                                    :rules="[rules.required]"
                                    class="info-input"
                                    label="Título"
                                    v-model="styleCard.titulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    :rules="[rules.required]"
                                    class="info-input"
                                    label="Margem de preço"
                                    v-model="styleCard.preco"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-text-field
                                    class="info-input"
                                    label="Informação Adicional"
                                    v-model="styleCard.subTitulo"/>
                        </v-flex>
                        <v-flex md6 xs12>
                            <v-select
                                    :rules="[rules.required]"
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
                            <h4 class="title font-weight-light">Escolha uma cor</h4>
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
                                            :rules="[rules.required]"
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
                        <v-btn @click="fecharModalCategoria" text depressed color="white gray--text"
                               style="margin: 4% 2%">cancelar
                        </v-btn>
                        <v-btn @click="copiaCategoria" text depressed :disabled="!form" color="white green--text"
                               style="margin: 4% 2%">salvar
                        </v-btn>
                    </v-layout>
                </v-container>
            </v-form>
        </v-card>
    </v-dialog>
</template>

<script>
    import _ from 'lodash'

    export default {
        name: 'ModalCategoria',
        data() {
            return {
                rules: {
                    required: v => !!v || 'Campo obrigatório',
                },
                form: false,
                tamanhos: [
                    {text: 'Pizza', value: 'mdi-pizza'},
                    {text: 'Bebida', value: 'mdi-beer'},
                    {text: 'Cerveja', value: 'mdi-glass-mug'},
                    {text: 'Vinho', value: 'mdi-glass-cocktail'},
                    {text: 'Peixe', value: 'mdi-fish'},
                    {text: 'Massa', value: 'mdi-bowl'},
                    {text: 'Bolo', value: 'mdi-cake'},
                    {text: 'Cookie', value: 'mdi-cookie'},
                    {text: 'Sorvete', value: 'mdi-rice'},
                    {text: 'Comida e bebida', value: 'mdi-food-fork-drink'},
                    {text: 'Lanche e bebida', value: 'mdi-food'},
                    {text: 'Hamburgue', value: 'mdi-hamburger'},
                    {text: 'Pastel', value: 'mdi-food-croissant'},
                    {text: 'Jantar', value: 'mdi-silverware'},
                    {text: 'Almoço', value: 'mdi-silverware-fork-knife'},
                    {text: 'Garfo e faca', value: 'mdi-silverware-variant'},
                    {text: 'Taco', value: 'mdi-taco'}
                ],
                styleCard: {
                    icone: '',
                    titulo: '',
                    subTitulo: '',
                    preco: '',
                    cor: 'color'
                }
            }
        },
        props: {
            modalCategoria: {
                required: true
            }
        },
        methods: {
            abrirModalCategoria() {
                this.$emit('abrirModalCategoria')
            },
            copiaCategoria() {
                let cloneCategoria = _.clone(this.styleCard)
                this.inserirNovaCategoriaProduto(cloneCategoria)
                this.styleCard.icone = ''
                this.styleCard.titulo = ''
                this.styleCard.subTitulo = ''
                this.styleCard.preco = ''
                this.styleCard.cor = 'color'
            },
            fecharModalCategoria() {
                this.$emit('fecharModalCategoria')
            },
            inserirNovaCategoriaProduto(cloneCategoria) {
                this.$emit('inserirNovaCategoriaProduto', cloneCategoria)
            }
        }
    }
</script>
<style lang="stylus">
    .v-dialog:not(.v-dialog--fullscreen) {
        max-height: 91%
    }
</style>
