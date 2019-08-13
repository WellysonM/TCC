<template>
    <v-container
            fill-height
            fluid
            grid-list-xl
    >
        <v-layout justify-center wrap
        >
            <v-flex md12>
                <material-card
                        color="info"
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
                            <td>{{ item.nome }}</td>
                            <td>{{ item.funcao }}</td>
                            <td>{{ item.contato }}</td>
                            <td class="text-xs-right">
                                <n :cor="'green'"
                                   :icone="'mdi-square-edit-outline'"
                                   :mensagem="'teste'">
                                </n>
                            </td>
                        </template>
                    </v-data-table>
                </material-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import n from './Notifications'

    export default {
        components: {n},
        data: () => ({
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
                    nome: 'Jão',
                    funcao: 'Garçom',
                    contato: '(99) 9 9999-9999'
                },
                {
                    nome: 'Jão',
                    funcao: 'Garçom',
                    contato: '(99) 9 9999-9999'
                }, {
                    nome: 'Jão',
                    funcao: 'Garçom',
                    contato: '(99) 9 9999-9999'
                }
            ]
        }),
        methods: {
            chamar() {
                this.$emit('chamou');
            }
        }
    }
</script>
