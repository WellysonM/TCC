<template>
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
        </v-layout>
    </v-container>
</template>
<script>
    export default {
        data() {
            return {
                pedidos: {},
                graficoSemanal: 0,
                graficoMensal: 0,
                graficoPorHora: 0,
                dailySalesChart: {
                    data: {
                        labels: ['Do', 'Se', 'Te', 'Qua', 'Qui', 'Se', 'Sá'],
                        series: [
                            [this.vendasSemanais(0), this.vendasSemanais(1), this.vendasSemanais(2), this.vendasSemanais(3), this.vendasSemanais(4), this.vendasSemanais(5), this.vendasSemanais(6)]
                        ]
                    },
                    options: {
                        lineSmooth: this.$chartist.Interpolation.cardinal({
                            tension: 0
                        }),
                        high: this.graficoSemanal,
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
                        high: this.graficoMensal,
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
        methods: {
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
            preencherPedidos() {
                this.pedidos = this.$store.state.pedidosFinalizados
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