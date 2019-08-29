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
                            primary-title>
                        <v-flex md4>
                            Nova Categoria
                        </v-flex>
                        <v-flex md4>
                            <v-text-field
                                    append-icon="mdi-pizza"
                                    color="white"
                                    label="Procurar"
                                    v-model="search"
                            ></v-text-field>
                        </v-flex>
                        <v-flex md4>
                            <v-btn class="acao-sair" flat
                                   style="float: right">
                                Excluir
                            </v-btn>
                        </v-flex>
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
                                    <td>{{ item.funcionario }}</td>
                                    <td>{{ item.funcao }}</td>
                                    <td>{{ item.contato }}</td>
                                    <td class="text-xs-right">
                                        <v-btn class="acao-sucesso" flat
                                               style="float: right">
                                            Editar
                                        </v-btn>
                                    </td>
                                    <td class="text-xs-right">
                                        <v-btn class="acao-fechar" flat
                                               style="float: right">
                                            Excluir
                                        </v-btn>
                                    </td>
                                </template>
                            </v-data-table>
                        </v-flex>
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
                        funcionario: 'vet',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        funcionario: 'adão',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        funcionario: 'Jão',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    },
                    {
                        funcionario: 'mm',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        funcionario: 'v',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        funcionario: 'g',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    },
                    {
                        funcionario: 's',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        funcionario: 'q',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        funcionario: 'u',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    },
                    {
                        funcionario: 'p',
                        funcao: 'Caixa',
                        contato: '(67) 9 9999-9999'
                    },
                    {
                        funcionario: 'k',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }, {
                        funcionario: 'm',
                        funcao: 'Garçom',
                        contato: '(99) 9 9999-9999'
                    }
                ]
            }
        },
        methods: {}
    }
</script>
<style>
    table.v-table tbody td {
        height: 30px;
    }

    .theme--light.v-icon {
        color: white;
    }
    .v-text-field__slot .v-label {
        color: white !important;
    }
    .theme--light.v-input:not(.v-input--is-disabled) input{
        color: white;
    }
</style>
