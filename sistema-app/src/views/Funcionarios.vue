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
                                hide-actions
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
                                    <v-btn @click="abrirNotificacao" class="acao-sucesso" flat style="float: right">
                                        Editar
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
                }
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
                },
                {
                    funcionario: 'Jão',
                    funcao: 'Garçom',
                    contato: '(99) 9 9999-9999'
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
            }
        }
    }
</script>
