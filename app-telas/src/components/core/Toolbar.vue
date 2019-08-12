<template>
    <v-toolbar
            id="core-toolbar"
            flat
            prominent
            style="background: #eee;">
        <div class="v-toolbar-title">
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
                        v-ripple
                        class="toolbar-items"
                        to="/">
                    <v-icon color="tertiary">mdi-home</v-icon>
                </router-link>
                <v-menu
                        bottom
                        left
                        content-class="dropdown-menu"
                        offset-y
                        transition="slide-y-transition">
                    <router-link
                            v-ripple
                            slot="activator"
                            class="toolbar-items"
                            to="/notifications">
                        <v-badge
                                color="error"
                                overlap>
                            <template slot="badge">
                                {{ notifications.length }}
                            </template>
                            <v-icon color="tertiary">mdi-bell</v-icon>
                        </v-badge>
                    </router-link>
                    <v-card>
                        <v-list dense>
                            <v-list-tile
                                    v-for="notification in notifications"
                                    :key="notification"
                                    @click="">
                                <v-list-tile-title
                                        v-text="notification"/>
                            </v-list-tile>
                        </v-list>
                    </v-card>
                </v-menu>
                <router-link
                        v-ripple
                        class="toolbar-items"
                        to="/perfil">
                    <v-icon color="tertiary">mdi-account</v-icon>
                </router-link>
            </v-flex>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
    export default {
        data: () => ({
            notifications: [],
            title: null,
            responsive: false,
            responsiveInput: false,
            drawer: false
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
                if (window.innerWidth < 991) {
                    this.responsive = true
                    this.responsiveInput = false
                } else {
                    this.responsive = false
                    this.responsiveInput = true
                }
            }
        }
    }
</script>

<style>
    #core-toolbar a {
        text-decoration: none;
    }
</style>
