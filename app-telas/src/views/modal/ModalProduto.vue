<template>
    <div>
        <v-dialog
                persistent
                v-model="modalProduto"
                width="700">
            <v-card>
                <div>
                    <v-card-title
                            class="title padrao2 white--text"
                            primary-title
                            style="padding: 5px 10px">
                        <v-flex md4>
                            Categoria:
                        </v-flex>
                        <v-flex md4>
                            <v-text-field
                                    append-icon="mdi-magnify"
                                    class="v-text-field__slot2  "
                                    color="white"
                                    id="search"
                                    label="Procurar"
                                    v-model="search"
                            ></v-text-field>
                        </v-flex>
                        <v-dialog max-width="500px" v-model="dialog">
                            <template v-slot:activator="{ on }">
                                <v-flex md4>
                                    <v-btn class="acao-sair" flat
                                           style="float: right"
                                           v-on="on">
                                        Novo produto
                                    </v-btn>
                                </v-flex>
                            </template>
                            <v-card>
                                <v-card-title>
                                    <span class="headline">Cadastrar Produto</span>
                                </v-card-title>

                                <v-card-text>
                                    <v-container>
                                        <v-flex cols="12" md="4" sm="6">
                                            <v-text-field label="Produto" v-model="produto.produto"
                                            ></v-text-field>
                                        </v-flex>
                                        <v-flex cols="12" md="4" sm="6">
                                            <v-text-field label="Preço" v-model="produto.preco"
                                            ></v-text-field>
                                        </v-flex>
                                        <v-flex cols="12" md="4" sm="6">
                                            <v-text-field label="Tempo Médio de Preparo"
                                                          v-model="produto.tempoPreparo"></v-text-field>
                                        </v-flex>
                                    </v-container>
                                </v-card-text>
                                <v-card-actions>
                                    <v-divider></v-divider>
                                    <v-btn @click="dialog = false" class="acao-fechar" flat style="margin: 0% 2%">
                                        fechar
                                    </v-btn>
                                    <v-btn @click="inserirProduto" class="acao-sucesso" flat style="margin: 0% 2%">
                                        Salvar
                                    </v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-card-title>
                </div>
                <v-container
                        fill-height
                        fluid
                        grid-list-xl
                >
                    <v-layout justify-center wrap
                    >
                        <v-flex md12>
                            <v-data-table
                                    :headers="headers"
                                    :items="produtos"
                                    :search="search"
                            >
                                <template
                                        slot="headerCell"
                                        slot-scope="{ header }"
                                >

                                    <span class="subheading font-weight-light text--darken-3"
                                          v-text="header.text"/>
                                </template>
                                <template
                                        slot="items"
                                        slot-scope="{ item }"
                                >
                                    <td>
                                        <v-checkbox :label="item.produto" :multiple=true :value="item" color="success"
                                                    style="font-size: 14px" v-model="seleted"/>
                                    </td>
                                    <td>{{ item.preco}}</td>
                                    <td>{{ item.tempoPreparo}}</td>
                                    <td class="text-xs-right">
                                        <v-btn class="acao-fechar" flat
                                               style="float: right; min-width: 10px">
                                            <v-icon>mdi-close-circle-outline</v-icon>
                                        </v-btn>
                                    </td>
                                    <td class="text-xs-right">
                                        <v-btn class="acao-sucesso" flat
                                               style="float: right; min-width: 10px">
                                            <v-icon>mdi-circle-edit-outline</v-icon>
                                        </v-btn>
                                    </td>
                                </template>
                            </v-data-table>
                        </v-flex>
                        <v-divider></v-divider>
                        <v-btn @click="fecharModalProduto" class="acao-fechar" flat style="margin: 0% 2%">fechar</v-btn>
                        <v-btn @click="teste" class="acao-sucesso" flat style="margin: 0% 2%">pedido</v-btn>
                    </v-layout>
                </v-container>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    import service from "../../services/service";

    export default {
        name: 'ModalProduto',
        data() {
            return {
                seleted: [],
                dialog: false,
                search: '',
                produto: {
                    produto: '',
                    preco: '',
                    tempoPreparo: '',
                    categoria: {
                        id: '',
                        icone: '',
                        titulo: '',
                        subTitulo: '',
                        preco: '',
                        cor: ''
                    }
                },
                headers: [
                    {
                        sortable: true,
                        text: 'Produto',
                        value: 'produto'
                    },
                    {
                        sortable: true,
                        text: 'Preço',
                        value: 'preco'
                    },
                    {
                        sortable: true,
                        text: 'Tempo De Preparo',
                        value: 'tempoPreparo'
                    },

                ],
                produtos: [
                    {
                        id: '',
                        produto: '',
                        preco: '',
                        tempoPreparo: '',
                        categoria: {
                            id: '',
                            icone: '',
                            titulo: '',
                            subTitulo: '',
                            preco: '',
                            cor: ''
                        }
                    }
                ],
            }
        },
        props: {
            modalProduto: {
                required: true
            },
            categoria: {
                required: true
            }
        },
        mounted() {
            this.buscarProdutos()
        },
        methods: {
            abrirModalProduto() {
                this.$emit('abrirModalProduto')
            },
            fecharModalProduto() {
                this.$emit('fecharModalProduto')
            },
            receberCategoria(categoria) {
                this.$emit('receberCategoria')
                this.preencherCategoria(categoria)
            },
            preencherCategoria(categoria) {
                this.categoria = categoria
            },
            buscarProdutos() {
                service.getProdutos().then(resposta => {
                    this.produtos = resposta.data
                }).catch(e => {
                    console.log(e)
                })
            },
            inserirProduto() {
                this.produto.categoria = this.categoria
                service.postProduto(this.produto)
                this.dialog = false
                this.buscarProdutos()
            },
            teste() {
                console.log(this.categoria)
            }
        }
    }
</script>
<style>
    table.v-table tbody td {
        height: 30px;
        text-align: center;
    }

    #search {
        color: white !important;
    }

    .v-datatable__actions__select {
        color: black;
    }

    .v-datatable__actions__select .v-select__selections .v-select__selection--comma {
        color: black;
    }

    .v-datatable__actions__pagination {
        color: black;
    }

    .v-datatable__actions .v-btn:last-of-type {
        color: black !important;
    }

    .v-btn.v-btn--icon {
        color: black !important;
    }

    .v-input--selection-controls.v-input .v-label {
        color: black;
        font-size: 14px;
        padding: 2px 8px;
    }

    .v-input--selection-controls:not(.v-input--hide-details) .v-input__slot {
        margin-bottom: 0px;
    }
</style>
