<template>
    <div>
        <notificacao
                :cor="cor"
                :mensagem="mensagem"
                :notificacao="notificacao"
                @abrirNotificacao="abrirNotificacao"
                @fecharNotificacao="fecharNotificacao"
        />

        <v-container
                fill-height
                fluid
                grid-list-xl
                style="width:50%; float: left"
        >
            <v-layout justify-center wrap
            >
                <v-flex md12>
                    <material-card
                            color="padrao2"
                            text="Tabela de produtos"
                            title="Comanda"
                    >
                        <v-data-table
                                :headers="headers"
                                :items="items"
                                :search="search"
                                style="text-align: center"
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
                                    {{item.produto}}
                                </td>
                                <td>{{ item.preco}}</td>
                                <td>
                                    <v-text-field
                                            step="0.01"
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
                            </template>
                        </v-data-table>
                    </material-card>
                </v-flex>
            </v-layout>
        </v-container>
        <v-container
                fill-height
                fluid
                grid-list-xl
                style="width:50%;"
        >
            <v-layout justify-center wrap
            >
                <v-flex md12>
                    <material-card
                            color="padrao2"
                            text="Detalhes do Pedido"
                            title="Comanda"
                    >
                        <table class="v-datatable v-table theme--light">
                            <tbody>
                            <tr>
                                <td>
                                    <v-flex md12 xs12>
                                        <v-select
                                                :items="tamanhos"
                                                hide-details
                                                label="Icone"
                                                menu-props="auto"
                                                single-line
                                                v-model="styleCard.icone"
                                        ></v-select>
                                    </v-flex>
                                </td>
                                <td>
                                    <v-card style="text-align: center; max-height: 59px; min-height: 59px"
                                            class="elevation-6 pa-2"
                                            color="padrao2"
                                            dark
                                            slot="offset"
                                    >
                                        <v-icon
                                                size="40"
                                        >
                                            {{ styleCard.icone }}
                                        </v-icon>
                                    </v-card>
                                </td>
                                <td></td>
                                <td></td>
                                <td class="text-xs-right">
                                    <button class="acao-fechar v-btn v-btn--flat theme--light"
                                            style="float: right; min-width: 10px;"
                                            type="button">
                                        <div class="v-btn__content"><i aria-hidden="true"
                                                                       class="v-icon mdi mdi-close-circle-outline theme--light"></i>
                                        </div>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    jantar
                                </td>
                                <td>12,00</td>
                                <td>
                                    <div class="v-input v-text-field theme--light" style="width: 50%;">
                                        <div class="v-input__control">
                                            <div class="v-input__slot">
                                                <div class="v-text-field__slot"><input step="0.01" type="number"></div>
                                            </div>
                                            <div class="v-text-field__details">
                                                <div class="v-messages theme--light">
                                                    <div class="v-messages__wrapper"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td>0,00</td>
                                <td class="text-xs-right">
                                    <button class="acao-fechar v-btn v-btn--flat theme--light"
                                            style="float: right; min-width: 10px;"
                                            type="button">
                                        <div class="v-btn__content"><i aria-hidden="true"
                                                                       class="v-icon mdi mdi-close-circle-outline theme--light"></i>
                                        </div>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    pizza
                                </td>
                                <td>12,00</td>
                                <td>
                                    <div class="v-input v-text-field theme--light" style="width: 50%;">
                                        <div class="v-input__control">
                                            <div class="v-input__slot">
                                                <div class="v-text-field__slot"><input step="0.01" type="number"></div>
                                            </div>
                                            <div class="v-text-field__details">
                                                <div class="v-messages theme--light">
                                                    <div class="v-messages__wrapper"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td>0,00</td>
                                <td class="text-xs-right">
                                    <button class="acao-fechar v-btn v-btn--flat theme--light"
                                            style="float: right; min-width: 10px;"
                                            type="button">
                                        <div class="v-btn__content"><i aria-hidden="true"
                                                                       class="v-icon mdi mdi-close-circle-outline theme--light"></i>
                                        </div>
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </material-card>
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    import notificacao from './Notifications'

    export default {
        components: {notificacao},
        data: () => ({
            notificacao: false,
            cor: null,
            search: '',
            mensagem: '',
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
                icone: 'mesa',
                titulo: '',
                subTitulo: '',
                preco: '',
                cor: 'color'
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
                    quantidade: '',
                    subValor: null
                },
                {
                    produto: 'escondidinho',
                    preco: '12,50',
                    tempoPreparo: '40 minutos',
                    quantidade: '',
                    subValor: null
                },
                {
                    produto: 'jantar',
                    preco: '12,00',
                    tempoPreparo: '40 minutos',
                    quantidade: '',
                    subValor: null
                }
            ]
        }),
        methods: {
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
