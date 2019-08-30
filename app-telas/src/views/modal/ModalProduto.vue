<template>
    <div>
        <v-dialog
                persistent
                v-model="modalCategoria"
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
                                            <v-text-field label="Produto"
                                            ></v-text-field>
                                        </v-flex>
                                        <v-flex cols="12" md="4" sm="6">
                                            <v-text-field label="Preço"
                                            ></v-text-field>
                                        </v-flex>
                                        <v-flex cols="12" md="4" sm="6">
                                            <v-text-field label="Tempo Médio de Preparo"></v-text-field>
                                        </v-flex>
                                    </v-container>
                                </v-card-text>
                                <v-card-actions>
                                    <v-divider></v-divider>
                                    <v-btn @click="dialog = false" class="acao-fechar" flat style="margin: 0% 2%">
                                        fechar
                                    </v-btn>
                                    <v-btn class="acao-sucesso" flat style="margin: 0% 2%">Salvar</v-btn>
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
                                    :items="items"
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
                                    <td><v-checkbox v-model="seleted" :value="item.id" :label=" item.funcionario" color="success"/></td>
                                    <td>{{ item.funcao }}</td>
                                    <td>{{ item.contato }}</td>
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
                        <v-btn class="acao-fechar" flat style="margin: 0% 2%">fechar</v-btn>
                        <v-btn class="acao-sucesso" flat style="margin: 0% 2%" @click="teste"   >pedido</v-btn>
                    </v-layout>
                </v-container>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                seleted:[],
                dialog: false,
                search: '',
                modalCategoria: true,
                headers: [
                    {
                        sortable: true,
                        text: 'Funcionário',
                        value: 'funcionario'
                    },
                    {
                        sortable: true,
                        text: 'Função',
                        value: 'funcao'
                    },
                    {
                        sortable: true,
                        text: 'Contato',
                        value: 'contato'
                    },

                ],
                items: [
                    {
                        id: '1',
                        funcionario: 'vet',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        id: '2',
                        funcionario: 'adão',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        id: '3',
                        funcionario: 'Jão',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    },
                    {
                        id: '4',
                        funcionario: 'mm',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        id: '5',
                        funcionario: 'v',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        id: '6',
                        funcionario: 'g',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }
                ]
            }
        },
        methods: {
            teste(){
                console.log(this.seleted)
            }
        }
    }
</script>
<style>
    table.v-table tbody td {
        height: 30px;
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
    .v-input--selection-controls.v-input .v-label{
        color: black;
    }
</style>
