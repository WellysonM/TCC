<template>
    <v-dialog
            persistent
            width="600"
            v-model="modalProduto">
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
                                            label="Preto"
                                            color="primary"
                                            value="primary"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Verde"
                                            color="#33691e"
                                            value="#33691e"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Teal"
                                            color="#004d40"
                                            value="#004d40"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Indigo"
                                            color="indigo darken-3"
                                            value="indigo darken-3"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Cinza"
                                            color="accent"
                                            value="accent"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Roxo"
                                            color="#4a148c"
                                            value="#4a148c"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Azul"
                                            color="#0d47a1"
                                            value="#0d47a1"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Verde Sucesso"
                                            color="success"
                                            value="success"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Vermelho"
                                            color="red"
                                            value="red"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Padrão Sistema"
                                            color="color"
                                            value="color"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Amarelo"
                                            color="warning"
                                            value="warning"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                                <v-flex md4 xs12>
                                    <v-switch
                                            v-model="styleCard.cor"
                                            label="Rosa Escuro"
                                            color="#c51162"
                                            value="#c51162"
                                            hide-details
                                    ></v-switch>
                                </v-flex>
                            </v-layout>
                        </v-container>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn @click="fecharModalProduto" flat color="red" class="acao-fechar">fechar</v-btn>
                            <v-btn @click="enviarCategoriaProduto"  flat color="black" class="acao-sucesso" outlined>enviar</v-btn>
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
                    {text: 'peixe', value: 'mdi-fish'},
                    {text: 'browne', value: 'mdi-bowl'},
                    {text: 'bolo', value: 'mdi-cake'},
                    {text: 'cookie', value: 'mdi-cookie'},
                    {text: 'sorvete', value: 'mdi-rice'},
                    {text: 'bebida 2', value: 'mdi-glass-mug-variant'},
                    {text: 'hamburgue', value: 'mdi-hamburger'}
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
            trocarTamanho(tamanho) {
                console.log(tamanho)
                this.icone = tamanho
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