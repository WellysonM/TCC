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
                        color="info"
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
                        color="info"
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
                        color="info"
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
                dailySalesChart: {
                    data: {
                        labels: ['Do', 'Se', 'Te', 'Qua', 'Qui', 'Se', 'Sá'],
                        series: [
                            [12, 17, 7, 17, 23, 18, 38]
                        ]
                    },
                    options: {
                        lineSmooth: this.$chartist.Interpolation.cardinal({
                            tension: 0
                        }),
                        low: 0,
                        high: 50,
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
        }
    }
</script>
