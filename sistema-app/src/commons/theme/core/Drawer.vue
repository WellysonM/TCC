<template>
    <div>
        <v-navigation-drawer
                app
                dark
                floating
                id="app-drawer"
                mobile-break-point="991"
                persistent
                v-model="inputValue"
                width="260"
        >
            <div class="img">
                <v-img
                        class="layer"
                        gradient="rgba(27, 27, 27, 0.74), rgba(27, 27, 27, 0.74)"
                        height="100%">
                    <v-layout
                            class="fill-height"
                            column
                            tag="v-list">
                        <v-list-tile avatar>
                            <v-list-tile-avatar>
                                <v-icon size="50">mdi-account-circle</v-icon>
                            </v-list-tile-avatar>
                            <v-list-tile-title class="title">
                                Bem Vindo
                            </v-list-tile-title>
                        </v-list-tile>
                        <v-divider/>
                        <v-list-tile
                                :key="i"
                                :to="link.to"
                                active-class="info"
                                avatar
                                class="v-list-item"
                                v-for="(link, i) in links">
                            <v-list-tile-action>
                                <v-icon>{{ link.icon }}</v-icon>
                            </v-list-tile-action>
                            <v-list-tile-title
                                    v-text="link.text"/>
                        </v-list-tile>
                        <div class="pa-2 v-list-item v-list__tile--btn">
                            <v-btn block class="acao-sair" flat>Sair</v-btn>
                        </div>
                    </v-layout>
                </v-img>
            </div>
        </v-navigation-drawer>
    </div>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'

    export default {
        data: () => ({
            logo: '',
            responsive: false,
            links: [
                {
                    to: '/inicio',
                    icon: 'mdi-home',
                    text: 'Inicio'
                },
                {
                    to: '/vendas',
                    icon: 'mdi-account-cash',
                    text: 'Vendas'
                },
                {
                    to: '/perfil',
                    icon: 'mdi-account',
                    text: 'Perfil'
                },
                {
                    to: '/funcionarios',
                    icon: 'mdi-worker',
                    text: 'Gerenciar Funcionários'
                },
                {
                    to: '/produtos',
                    icon: 'mdi-food-fork-drink',
                    text: 'Gerenciar Produtos'
                },
                {
                    to: '/relatorios',
                    icon: 'mdi-clipboard-outline',
                    text: 'Relatorios'
                }
            ]
        }),
        computed: {
            ...mapState('app', ['image', 'color']),
            inputValue: {
                get() {
                    return this.$store.state.app.drawer
                },
                set(val) {
                    this.setDrawer(val)
                }
            }
        },
        mounted() {
            this.onResponsiveInverted()
            window.addEventListener('resize', this.onResponsiveInverted)
        },
        beforeDestroy() {
            window.removeEventListener('resize', this.onResponsiveInverted)
        },
        methods: {
            ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
            onResponsiveInverted() {
                if (window.innerWidth < 991) {
                    this.responsive = true
                } else {
                    this.responsive = false
                }
            },
            ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
            onClickBtn() {
                this.setDrawer(!this.$store.state.app.drawer)
            }
        }
    }
</script>
<style lang="scss">
    #app-drawer {
        .v-list__tile {
            border-radius: 4px;

            &--btn {
                margin-top: auto;
                margin-bottom: 17px;
            }
        }

        .v-image__image--contain {
            top: 9px;
            height: 60%;
        }

        div.v-responsive.v-image > div.v-responsive__content {
            overflow-y: auto;
        }

        .img {
            background: url(../../../views/autenticacao/images/bg.jpg);
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            -ms-background-size: cover;
            position: relative;
            min-height: 100vh;
            overflow: hidden;
        }
    }
</style>
