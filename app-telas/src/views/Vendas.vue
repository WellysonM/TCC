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
        >
            <v-layout justify-center wrap
            >
                <v-flex md12>
                    <material-card
                            color="padrao2"
                            text="Selecione um funcionário para editar"
                            title="Gerenciar Funcionários"
                    >
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
                                <td>
                                    <v-checkbox :label="item.produto" :multiple=true :value="item" color="success"
                                                style="font-size: 14px" v-model="seleted"/>
                                </td>
                                <td>{{ item.preco}}</td>
                                <td>{{ item.tempoPreparo}}</td>
                                <td class="text-xs-right">
                                    <v-btn class="acao-fechar" flat @click="deleteItem(item)"
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
            mensagem: '',
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
                    text: 'Tempo Medio de Preparo',
                    value: 'tempoPreparo'
                }
            ],
            items: [
                {
                    produto: 'pizza',
                    preco: '12,00',
                    tempoPreparo: '40 minutos'
                },
                {
                    produto: 'escondidinho',
                    preco: '12,00',
                    tempoPreparo: '40 minutos'
                },
                {
                    produto: 'jantar',
                    preco: '12,00',
                    tempoPreparo: '40 minutos'
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
            deleteItem (item) {
                const index = this.items.indexOf(item)
                confirm('Are you sure you want to delete this item?') && this.items.splice(index, 1)
            }
        }
    }
</script>
