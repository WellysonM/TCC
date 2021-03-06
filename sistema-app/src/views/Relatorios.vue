<template>
    <div>
        <v-container
                fill-height
                fluid
                grid-list-xl>
            <v-layout wrap>
                <v-flex
                        lg4
                        md12
                        sm12>
                    <material-chart-card
                            :data="dailySalesChart.data"
                            :options="dailySalesChart.options"
                            color="padrao"
                            type="Line">
                        <h4 class="title font-weight-light">Vendas Semanais</h4>
                    </material-chart-card>
                </v-flex>
                <v-flex
                        lg4
                        md12
                        sm12>
                    <material-chart-card
                            :data="emailsSubscriptionChart.data"
                            :options="emailsSubscriptionChart.options"
                            :responsive-options="emailsSubscriptionChart.responsiveOptions"
                            color="padrao"
                            type="Bar">
                        <h4 class="title font-weight-light">Vendas Mensais</h4>
                    </material-chart-card>
                </v-flex>
                <v-flex
                        lg4
                        md12
                        sm12>
                    <material-chart-card
                            :data="dataCompletedTasksChart.data"
                            :options="dataCompletedTasksChart.options"
                            color="padrao"
                            type="Line">
                        <h3 class="title font-weight-light">Vendas Por Horas</h3>
                    </material-chart-card>
                </v-flex>
                <v-flex
                        lg5
                        md14
                        sm12>
                    <v-flex py-3>
                        <h3>Relatório de vendas por período</h3>
                    </v-flex>
                    <v-date-picker
                            @change="filtro"
                            color="#4caf50"
                            year-icon="mdi-calendar-blank"
                            prev-icon="mdi-skip-previous"
                            next-icon="mdi-skip-next"
                            locale="pt-br"
                            header-color="padrao"
                            v-model="date"
                            show-current
                            landscape>
                        <v-flex style="display:flex; justify-content: center">
                            <v-btn depressed color="white green--text" text @click="PrepararRelatorioCaixa">Gerar
                                Relatório
                            </v-btn>
                        </v-flex>
                    </v-date-picker>
                </v-flex>
            </v-layout>
        </v-container>
        <notificacao/>
        <relatorio
                :dialog="dialog"
                :pedidosFiltrados="pedidosFiltrados"
                @fecharRelatorio="fecharRelatorio"
        />
    </div>
</template>
<script>
    import relatorio from '../components/RelatorioMovimentoCaixa'
    import _ from 'lodash'
    import notificacao from './Notifications'
    import {mapMutations} from 'vuex'
    import {mutationTypes} from '@/commons/constants'

    export default {
        components: {notificacao, relatorio},
        data() {
            return {
                data: new Date().toLocaleDateString(),
                pedidosFiltrados: [],
                dialog: false,
                date: new Date().toISOString().substring(0, 10),
                month: false,
                pedidos: {},
                graficoSemanal: 0,
                graficoMensal: 0,
                graficoPorHora: 0,
                dailySalesChart: {
                    data: {
                        labels: ['Se', 'Te', 'Qua', 'Qui', 'Se', 'Sá', 'Do'],
                        series: [
                            [this.vendasSemanais(1), this.vendasSemanais(2), this.vendasSemanais(3), this.vendasSemanais(4),
                                this.vendasSemanais(5), this.vendasSemanais(6), this.vendasSemanais(0)]
                        ]
                    },
                    options: {
                        lineSmooth: this.$chartist.Interpolation.cardinal({
                            tension: 0
                        }),
                        high: this.graficoSemanal + 1,
                        low: 0,
                        chartPadding: {
                            top: 0,
                            right: 0,
                            bottom: 0,
                            left: 0
                        }
                    }
                },
                dataCompletedTasksChart: {
                    data: {
                        labels: ['18', '19', '20', '21', '22', '23', '00', '01'],
                        series: [
                            [this.vendasPorHora(18), this.vendasPorHora(19), this.vendasPorHora(20), this.vendasPorHora(21), this.vendasPorHora(22),
                                this.vendasPorHora(23), this.vendasPorHora(0), this.vendasPorHora(1)]
                        ]
                    },
                    options: {
                        lineSmooth: this.$chartist.Interpolation.cardinal({
                            tension: 0
                        }),
                        high: this.graficoPorHora + 1,
                        low: 0,
                        chartPadding: {
                            top: 0,
                            right: 0,
                            bottom: 0,
                            left: 0
                        }
                    }
                },
                emailsSubscriptionChart: {
                    data: {
                        labels: ['Ja', 'Fe', 'Ma', 'Ab', 'Mai', 'Ju', 'Jul', 'Ag', 'Se', 'Out', 'No', 'De'],
                        series: [
                            [this.vendasMensais(0), this.vendasMensais(1), this.vendasMensais(2), this.vendasMensais(3), this.vendasMensais(4), this.vendasMensais(5),
                                this.vendasMensais(6), this.vendasMensais(7), this.vendasMensais(8), this.vendasMensais(9), this.vendasMensais(10), this.vendasMensais(11)]
                        ]
                    },
                    options: {
                        axisX: {
                            showGrid: false
                        },
                        high: this.graficoMensal + 1,
                        low: 0,
                        chartPadding: {
                            top: 0,
                            right: 5,
                            bottom: 0,
                            left: 0
                        }
                    },
                    responsiveOptions: [
                        ['screen and (max-width: 640px)', {
                            seriesBarDistance: 5,
                            axisX: {
                                labelInterpolationFnc: function (value) {
                                    return value[0]
                                }
                            }
                        }]
                    ]
                }
            }
        },
        mounted() {
            this.tenhoPermissao()
        },
        methods: {
            ...mapMutations([mutationTypes.SET_NOTIFICACAO]),
            abrirRelatorio() {
                this.dialog = true
            },
            abrirNotificacaoErro() {
                this.notificacao = {
                    cor: 'error',
                    mensagem: 'Seu usuário não tem acesso a essa página !',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            abrirNotificacaoAlerta() {
                this.notificacao = {
                    cor: 'warning',
                    mensagem: 'Não há vendas nesse dia!',
                    mostrar: true
                }
                this.setNotificacao(this.notificacao)
            },
            calcularQuantidadeVendasPorDias(dia) {
                let vendas = 0;
                if (this.pedidos) {
                    this.pedidos.forEach((pedido) => {
                        if (pedido.data.getDay() === dia) {
                            vendas++;
                        }
                    })
                    this.definirTamanhoVendasSemanais(vendas)
                    return vendas;
                }
            },
            calcularQuantidadeVendasPorMes(mes) {
                let vendas = 0;
                if (this.pedidos) {
                    this.pedidos.forEach((pedido) => {
                        if (pedido.data.getMonth() === mes) {
                            vendas++;
                        }
                    })
                    this.definirTamanhoVendasMensais(vendas)
                    return vendas;
                }
            },
            calcularQuantidadeVendasPorHora(hora) {
                let vendas = 0;
                if (this.pedidos) {
                    this.pedidos.forEach((pedido) => {
                        if (pedido.data.getHours() === hora) {
                            vendas++;
                        }
                    })
                    this.definirTamanhoVendasPorHora(vendas)
                    return vendas;
                }
            },
            definirTamanhoVendasSemanais(vendas) {
                if (this.graficoSemanal === undefined) {
                    this.graficoSemanal = 0
                }
                if (vendas > this.graficoSemanal) {
                    this.graficoSemanal = vendas
                }
            },
            definirTamanhoVendasMensais(vendas) {
                if (this.graficoMensal === undefined) {
                    this.graficoMensal = 0
                }
                if (vendas > this.graficoMensal) {
                    this.graficoMensal = vendas
                }
            },
            definirTamanhoVendasPorHora(vendas) {
                if (this.graficoPorHora === undefined) {
                    this.graficoPorHora = 0
                }
                if (vendas > this.graficoPorHora) {
                    this.graficoPorHora = vendas
                }
            },
            fecharRelatorio() {
                this.dialog = false
            },
            filtro(value) {
                this.data = new Date(value.substring(5, 7) + "/" + value.substring(8, 10) + "/" + value.substring(0, 4)).toLocaleDateString()
            },
            PrepararRelatorioCaixa() {
                this.pedidosFiltrados = []
                this.pedidos = _.cloneDeep(this.$store.state.pedidosFinalizados)
                this.pedidos.forEach((pedido) => {
                    pedido.data = new Date(pedido.data).toLocaleDateString()
                    if (pedido.data === this.data) {
                        this.pedidosFiltrados.push(pedido)
                    }
                })
                if (this.pedidosFiltrados.length !== 0) {
                    this.abrirRelatorio()
                } else {
                    this.abrirNotificacaoAlerta()
                }
            },
            preencherPedidos() {
                this.pedidos = this.$store.state.pedidosFinalizados
            },
            tenhoPermissao() {
                const usuario = this.$store.state.usuarioLogado
                if (usuario.admin) {
                    return
                } else {
                    this.$router.push({path: '/inicio'})
                    this.abrirNotificacaoErro()
                }
            },
            vendasPorHora(hora) {
                this.preencherPedidos()
                return this.calcularQuantidadeVendasPorHora(hora)
            },
            vendasSemanais(dia) {
                this.preencherPedidos()
                return this.calcularQuantidadeVendasPorDias(dia)
            },
            vendasMensais(mes) {
                this.preencherPedidos()
                return this.calcularQuantidadeVendasPorMes(mes)
            }
        }
    }
</script>
<style>
    .v-date-picker-table .v-btn.v-btn--active {
        color: #fff !important;
    }
</style>