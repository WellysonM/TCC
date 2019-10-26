<template>
    <div>
        <v-dialog
                persistent
                v-model="modalComanda"
                width="500">
            <v-card>
                <v-card-title
                        class="title padrao2 white--text"
                        id="card-title"
                        primary-title>
                    <v-flex md6>
                        Comanda de pedidos
                    </v-flex>
                </v-card-title>
                <v-container fill-height fluid grid-list-xl :key="pedido.id" v-for="pedido of comanda">
                    <v-layout justify-center wrap>
                        <v-flex md12>
                            <v-data-table
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
                                </template>
                            </v-data-table>
                            <v-divider></v-divider>
                            <!-- <v-layout wrap>
                                 <v-flex md6 style="margin-left: 20px">
                                     <v-checkbox
                                             prepend-icon="mdi-cash-usd-outline"
                                             label="Dinheiro"
                                             color="success"
                                             value="dinheiro"
                                             hide-details
                                     ></v-checkbox>
                                 </v-flex>
                                 <v-flex md5>
                                     <v-checkbox
                                             prepend-icon="mdi-credit-card-outline"
                                             label="Cartão"
                                             color="indigo"
                                             value="cartão"
                                             hide-details
                                     ></v-checkbox>
                                 </v-flex>
                             </v-layout>-->
                            <v-flex pa-2>
                                <div style="float: right">Total: {{pedido.valorTotal}}</div>
                            </v-flex>
                        </v-flex>
                        <v-divider/>
                    </v-layout>
                </v-container>
                <v-container fill-height fluid grid-list-xl style="justify-content: flex-end;">

                    <v-btn @click="fecharModalComanda" class="acao-fechar" flat style="margin: 0% 2%">fechar</v-btn>
                    <v-btn @click="abrirModalDialog" class="acao-sucesso" flat style="margin: 0% 2%">Pagamento
                    </v-btn>

                </v-container>
            </v-card>
        </v-dialog>
        <atencao
                :dialog="dialog"
                :mensagem="'Você esta prestes a realizar uma operação sem volta, tem certeza que deseja continuar?'"
                @confirmar="confirmar"
                @cancelar="cancelar"
        />
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    import Atencao from './Atencao'

    export default {
        name: "ModalComanda",
        components: {Atencao},
        data() {
            return {
                dialog: false,
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
                    }

                ]
            }
        },
        props: {
            modalComanda: {
                required: true
            }
        },
        computed: {
            ...mapState(['comanda'])
        },
        methods: {
            abrirModalDialog() {
                this.dialog = true
            },
            confirmar() {
                this.$emit('confirmar')
                this.cancelar()
            },
            cancelar() {
                this.dialog = false
            },
            calcularSubValor(item) {
                if (item) {
                    let subPreco = parseFloat(item.preco.replace(",", "."))
                    subPreco = subPreco * item.quantidade
                    return subPreco.toFixed(2).replace(".", ",")
                }
            },
            fecharModalComanda() {
                this.$emit('fecharModalComanda')
            }
        }
    }
</script>

<style>
    table.v-table thead th:not(:first-child) {
        padding: 0 !important;
    }

    .v-input--selection-controls {
        margin-top: 0px !important;
    }
</style>