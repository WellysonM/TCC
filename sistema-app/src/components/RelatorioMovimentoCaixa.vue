<template>
    <div>
        <v-dialog
                persistent
                v-model="dialog"
                width="700">
            <v-card>
                <v-card-title
                        class="title padrao2 white--text"
                        id="card-title"
                        primary-title>
                    <v-flex md6>
                        Movimento do caixa
                    </v-flex>
                </v-card-title>
                <v-container fill-height fluid grid-list-xl :key="pedido.id" v-for="pedido of pedidosFiltrados">
                    <v-layout justify-center wrap>
                        <v-flex md12>
                            <v-data-table
                                    style="text-align: center"
                                    :headers="headers"
                                    :items="pedido.produtos"
                                    hide-actions
                            >
                                <template slot="headerCell" slot-scope="{ header }">
                                    <span
                                            class="subheading font-weight-light text--darken-3"
                                            v-text="header.text"
                                    />
                                </template>
                                <template slot="items" slot-scope="{ item }">
                                    <td>{{ item.produto}}</td>
                                    <td>{{ item.preco}}</td>
                                    <td>{{ item.quantidade}}</td>
                                    <td>{{calcularSubValor(item)}}</td>
                                    <td>{{pedido.usuario.name}}</td>
                                    <td>{{pedido.mesa.numero}}</td>
                                    <td>{{pedido.data}}</td>
                                </template>
                            </v-data-table>
                        </v-flex>
                        <v-divider/>
                    </v-layout>
                </v-container>
                <v-container fill-height fluid grid-list-xl style="justify-content: flex-end;">
                    <div>Valor das vendas: {{totalVendido()}}</div>
                    <v-divider/>
                    <div>Total de vendas: {{quantidadeVendido()}}</div>
                    <v-btn depressed color="white gray--text" @click="fecharRelatorio">cancelar</v-btn>
                </v-container>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        name: "RelatorioMovimentoCaixa",
        data() {
            return {
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
                        text: 'Quantidade',
                        value: 'quantidade'
                    },
                    {
                        sortable: false,
                        text: 'Subtotal',
                        value: 'subtotal'
                    },
                    {
                        sortable: false,
                        text: 'Funcionário',
                        value: 'funcionário'
                    },
                    {
                        sortable: false,
                        text: 'Mesa',
                        value: 'mesa'
                    },
                    {
                        sortable: false,
                        text: 'Data',
                        value: 'data'
                    }
                ]
            }
        },
        props: {
            dialog: {
                required: true
            },
            pedidosFiltrados: {
                required: true
            }
        },
        computed: {
            ...mapState(['dataFiltro'])
        },
        methods: {
            calcularSubValor(item) {
                if (item) {
                    let subPreco = parseFloat(item.preco.replace(",", "."))
                    subPreco = subPreco * item.quantidade
                    return subPreco.toFixed(2).replace(".", ",")
                }
            },
            fecharRelatorio() {
                this.$emit('fecharRelatorio')
            },
            totalVendido() {
                let valorFinal = 0;
                this.pedidosFiltrados.forEach((pedido) => {
                    valorFinal += parseFloat(pedido.valorTotal)
                })
                return valorFinal.toFixed(2).replace(".", ",")
            },
            quantidadeVendido() {
                return this.pedidosFiltrados.length
            }
        }
    }
</script>

<style>
    table.v-table thead th:not(:first-child) {
        padding: 0 !important;
        text-align: center !important;
    }

    .v-input--selection-controls {
        margin-top: 0px !important;
    }

    table.v-table tbody td {
        height: 30px;
    }
</style>