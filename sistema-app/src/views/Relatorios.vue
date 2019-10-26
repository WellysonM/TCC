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
    import {actionTypes} from '@/commons/constants'

    export default {
        data() {
            return {
                pedidos: {},
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
                        low: 0,
                        high: this.definirTamanhoVendasSemanais(),
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
                            [10, 15, 19, 25, 29, 31, 35, 0]
                        ]
                    },
                    options: {
                        lineSmooth: this.$chartist.Interpolation.cardinal({
                            tension: 0
                        }),
                        low: 0,
                        high: 100,
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
                            [151, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]
                        ]
                    },
                    options: {
                        axisX: {
                            showGrid: false
                        },
                        low: 0,
                        high: 1000,
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
            calcularQuantidadeVendas(dia) {
                let vendas = 0;
                if (this.pedidos) {
                    this.pedidos.forEach((pedido) => {
                        if (pedido.data.getDay() === dia) {
                            vendas++;
                        }
                    })
                    return vendas;
                }
            },
            definirTamanhoVendasSemanais() {
                return this.pedidos.length + 1
            },
            preencherPedidos() {
                this.pedidos = this.$store.state.pedidosFinalizados
            },
            vendasSemanais(dia) {
                this.preencherPedidos()
                return this.calcularQuantidadeVendas(dia)
            }
        }
    }
</script>
=