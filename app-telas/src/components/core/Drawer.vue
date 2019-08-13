<template>
    <div>
        <v-btn
                @click.stop="onClickBtn"
                class="default v-btn--simple"
                dark
                icon
                v-if="responsive">
            <v-icon>mdi-view-list</v-icon>
        </v-btn>
        <v-navigation-drawer
                app
                dark
                floating
                id="app-drawer"
                mobile-break-point="991"
                persistent
                v-model="setDrawer"
                width="260">
            <v-img
                    gradient="rgba(27, 27, 27, 0.74), rgba(27, 27, 27, 0.74)"
                    height="100%"
                    src="https://demos.creative-tim.com/vue-material-dashboard/img/sidebar-2.32103624.jpg">
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
                </v-layout>
            </v-img>
        </v-navigation-drawer>
    </div>
</template>

<script>
    export default {
        data: () => ({
            logo: '',
            setDrawer: false,
            responsive: false,
            links: [
                {
                    to: '/inicio',
                    icon: 'mdi-home',
                    text: 'Inicio'
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
        mounted() {
            this.setDrawer = true
            this.onResponsiveInverted()
            window.addEventListener('resize', this.onResponsiveInverted)
        },
        beforeDestroy() {
            window.removeEventListener('resize', this.onResponsiveInverted)
        },
        methods: {
            onResponsiveInverted() {
                if (window.innerWidth < 991) {
                    this.responsive = true
                } else {
                    this.responsive = false
                }
            },
            onClickBtn() {
                this.setDrawer = true
            },
        }
    }
</script>

<style lang="scss">
    #app-drawer {
        .v-list__tile {
            border-radius: 4px;
        }

        .v-image__image--contain {
            top: 9px;
            height: 60%;
        }

        div.v-responsive.v-image > div.v-responsive__content {
            overflow-y: auto;
        }
    }
</style>
