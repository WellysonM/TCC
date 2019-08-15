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
                        <v-btn @click="fecharModalProduto" color="info">fechar</v-btn>
                        <v-btn @click="statusCardM" color="info">enviar</v-btn>
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
                    {text: 'sorvete', value: 'mdi-rice'},
                    {text: '24', value: '24pt'},
                    {text: '30', value: '30pt'},
                    {text: '36', value: '36pt'},
                    {text: '48', value: '48pt'},
                    {text: '60', value: '60pt'},
                    {text: '72', value: '72pt'},
                    {text: '96', value: '96pt'}
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
                preco: ''
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
            statusCardM(){
                this.$emit('statusCardM', this.statusCard)
            }
        }
    }
</script>
<style lang="stylus">
    #nome-sistema-modal
        max-width 340px
</style>