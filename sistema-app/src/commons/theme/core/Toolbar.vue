<template>
    <v-toolbar
            flat
            id="core-toolbar"
            prominent
            style="background: #eee;">
        <div class="v-toolbar-title">
            <v-btn
                    @click.stop="onClickBtn"
                    class="default v-btn--simple"
                    dark
                    icon
                    v-if="responsive"
            >
                <v-icon>mdi-view-list</v-icon>
            </v-btn>
            <v-toolbar-title
                    class="tertiary--text font-weight-light">
                {{ title }}
            </v-toolbar-title>
        </div>
        <v-spacer/>
        <v-toolbar-items>
            <v-flex
                    align-center
                    layout
                    py-2>
                <router-link
                        class="toolbar-items"
                        to="/inicio"
                        v-ripple>
                    <v-icon color="tertiary">mdi-home</v-icon>
                </router-link>
                <v-menu
                        bottom
                        content-class="dropdown-menu"
                        left
                        offset-y
                        transition="slide-y-transition">
                    <router-link
                            class="toolbar-items"
                            slot="activator"
                            to=""
                            v-ripple>
                        <v-badge
                                color="error"
                                overlap>
                            <template slot="badge">
                                {{ notifications.length}}
                            </template>
                            <v-icon color="tertiary">mdi-bell</v-icon>
                        </v-badge>
                    </router-link>
                    <v-card>
                        <v-list dense>
                            <v-list-tile
                                    :key="notification"
                                    @click=""
                                    v-for="notification in notifications">
                                <v-list-tile-title
                                        v-text="notification"/>
                            </v-list-tile>
                        </v-list>
                    </v-card>
                </v-menu>
                <router-link
                        class="toolbar-items"
                        to="/perfil"
                        v-ripple>
                    <v-icon color="tertiary">mdi-account</v-icon>
                </router-link>
            </v-flex>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
    import {mapMutations, mapState} from 'vuex'

    export default {
        data: () => ({
            notifications: [],
            title: null,
            responsive: false,
            responsiveInput: false
        }),
        watch: {
            '$route'(val) {
                this.title = val.name
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
            onResponsiveInverted() {
                if (window.innerWidth < 1150) {
                    this.responsive = true
                    this.responsiveInput = false
                } else {
                    this.responsive = false
                    this.responsiveInput = true
                }
            },
            ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
            onClickBtn() {
                this.setDrawer(!this.$store.state.app.drawer)
            }
        }
    }
</script>

<style>
    #core-toolbar a {
        text-decoration: none;
    }
</style>
