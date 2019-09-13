<template>
    <div>
        <modal-pedido
                :modal-pedido="modalPedido"
                @abrirModalPedido="abrirModalPedido"
                @enviarMesaEscolhida="enviarMesaEscolhida"
                @fecharModalPedido="fecharModalPedido"
        />
        <v-container fill-height
                     fluid
                     grid-list-xl
                     style="width: 50%; float: left">
            <v-layout wrap>
                <template>
                    <v-flex lg3 md3>
                        <v-hover>
                            <template v-slot="{ hover }">
                                <v-card
                                        :class="`elevation-${hover ? 24 : 6}`"
                                        class="pa-4 card transition-swing"
                                        color="padrao2"
                                        dark
                                        slot="offset"
                                >
                                    <v-icon
                                            size="40"
                                    >
                                        mdi-plus-box-outline
                                    </v-icon>
                                </v-card>
                            </template>
                        </v-hover>
                    </v-flex>
                    <v-flex lg3 md3>
                        <v-card
                                class="pa-4 elevation-10 card"
                                color="padrao2"
                                dark
                                slot="offset"
                        >
                            <v-icon
                                    size="40"
                            >
                                mdi-plus-box-outline
                            </v-icon>
                        </v-card>
                    </v-flex>
                    <v-flex lg3 md3>
                        <v-card
                                class="pa-4 elevation-10 card"
                                color="padrao2"
                                dark
                                slot="offset"
                        >
                            <v-icon
                                    size="40"
                            >
                                mdi-plus-box-outline
                            </v-icon>
                        </v-card>
                    </v-flex>
                    <v-flex lg3 md3>
                        <v-card
                                class="pa-4 elevation-10 card"
                                color="padrao2"
                                dark
                                slot="offset"
                        >
                            <v-icon
                                    size="40"
                            >
                                mdi-plus-box-outline
                            </v-icon>
                        </v-card>
                    </v-flex>
                    <v-flex lg3 md3>
                        <v-card
                                class="pa-4 elevation-10 card"
                                color="padrao2"
                                dark
                                slot="offset"
                        >
                            <v-icon
                                    size="40"
                            >
                                mdi-plus-box-outline
                            </v-icon>
                        </v-card>
                    </v-flex>
                </template>
            </v-layout>
        </v-container>
        <v-container fill-height
                     fluid
                     grid-list-xl
                     style="width: 50%; float: right">
            <v-layout wrap>
                <material-card
                        color="padrao2"
                        text="Tabela de produtos"
                        title="Comanda">
                    <v-data-table
                            :headers="headers"
                            :items="items"
                            style="text-align: center;">
                        <template
                                slot="headerCell"
                                slot-scope="{ header }">

                                    <span class="subheading font-weight-light text--darken-3"
                                          v-text="header.text"/>
                        </template>
                        <template
                                slot="items"
                                slot-scope="{ item }">
                            <tr>
                                <td>
                                    {{item.produto}}
                                </td>
                                <td>{{ item.preco}}</td>
                                <td>
                                    <v-text-field
                                            style="width: 50%"
                                            type="number"
                                            v-model="item.quantidade"
                                    ></v-text-field>
                                </td>
                                <td>{{calcularSubValor(item)}}</td>
                                <td class="text-xs-right">
                                    <v-btn @click="deleteItem(item)" class="acao-fechar" flat
                                           style="float: right; min-width: 10px">
                                        <v-icon>mdi-close-circle-outline</v-icon>
                                    </v-btn>
                                </td>
                            </tr>
                        </template>
                    </v-data-table>
                    <div>
                        <v-btn class="acao-fechar" flat style="float: right">Desistir</v-btn>
                        <v-btn :disabled="info" class="acao-sucesso" flat style="float: left; margin:0 2%">enviar
                            pedido
                        </v-btn>
                        <v-btn @click="abrirModalPedido" class="acao-sucesso" flat style="float: none;">info
                        </v-btn>
                    </div>
                </material-card>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import ModalPedido from "./modal/ModalPedido";

    export default {
        components: {ModalPedido},
        data: () => ({
            info: true,
            modalPedido: false,
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
                    sortable: true,
                    text: 'Sub Valor',
                    value: 'subValor'
                }
            ],
            items: [
                {
                    produto: 'pizza',
                    preco: '12,00',
                    tempoPreparo: '40 minutos',
                    quantidade: '1',
                    subValor: null
                },
                {
                    produto: 'escondidinho',
                    preco: '12,50',
                    tempoPreparo: '40 minutos',
                    quantidade: '1',
                    subValor: null
                },
                {
                    produto: 'jantar',
                    preco: '12,00',
                    tempoPreparo: '40 minutos',
                    quantidade: '1',
                    subValor: null
                }
            ]
        }),
        methods: {
            abrirModalPedido() {
                this.modalPedido = true
            },
            fecharModalPedido() {
                this.modalPedido = false
            },
            enviarMesaEscolhida() {
                this.info = false
                this.fecharModalPedido()
            },
            abrirNotificacao() {
                this.notificacao = true
                this.cor = 'green'
                this.mensagem = 'teste'
            },
            fecharNotificacao() {
                this.notificacao = false
            },
            deleteItem(item) {
                const index = this.items.indexOf(item)
                confirm('Are you sure you want to delete this item?') && this.items.splice(index, 1)
            },
            calcularSubValor(item) {
                let subPreco = parseFloat(item.preco.replace(",", "."))
                subPreco = subPreco * item.quantidade
                return subPreco.toFixed(2).replace(".", ",")
            }
        }
    }
</script>
<style>
    .card {
        margin-top: 48px !important;
        width: 90px;
        margin: 10px;
    }
</style>
