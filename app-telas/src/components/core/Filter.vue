<template>
    <v-menu
            :close-on-content-click="false"
            bottom
            left
            max-width="300"
            min-width="300"
            nudge-left="12"
            offset-x
            transition="slide-y-transition"
    >
        <v-btn
                class="elevation-0"
                color="grey"
                dark
                fab
                fixed
                slot="activator"
                style="top: 96px;"
                top
        >
            <v-icon>mdi-settings</v-icon>
        </v-btn>
        <v-card>
            <v-container grid-list-xl>
                <v-layout wrap>
                    <v-flex xs12>
                        <div class="text-xs-center body-2 text-uppercase sidebar-filter">Sidebar Filters</div>

                        <v-layout justify-center>
                            <v-avatar
                                    :class="[c === color ? 'color-active color-' + c: 'color-' + c]"
                                    :key="c"
                                    @click="setColor(c)"
                                    size="23"

                                    v-for="c in colors"
                            />
                        </v-layout>
                        <v-divider class="mt-3"/>
                    </v-flex>
                    <v-flex
                            xs12
                    >
                        <div class="text-xs-center body-2 text-uppercase sidebar-filter">Images</div>
                    </v-flex>
                    <v-flex
                            :key="img"
                            v-for="img in images"
                            xs3
                    >
                        <v-img
                                :class="[image === img ? 'image-active' : '']"
                                :src="img"
                                @click.native="setImage(img)"
                                height="120"
                        />
                    </v-flex>
                    <v-flex xs12>
                        <v-btn
                                block
                                color="success"
                                href="https://www.creative-tim.com/product/vuetify-material-dashboard"
                                target="_blank"
                        >
                            Free Download
                        </v-btn>
                    </v-flex>
                    <v-flex xs12>
                        <v-btn
                                block
                                class="white--text"
                                color="primary"
                                href="https://demos.creative-tim.com/vuetify-material-dashboard/documentation"
                                target="_blank"
                        >
                            Documentation
                        </v-btn>
                    </v-flex>
                    <v-flex xs12>
                        <div class="text-xs-center body-2 text-uppercase">
                            <div class=" sidebar-filter">
                                Thank You for Sharing!
                            </div>

                            <div>
                                <v-btn
                                        class="mr-2 v-btn-facebook"
                                        color="indigo"
                                        fab
                                        icon
                                        round
                                        small
                                >
                                    <v-icon>mdi-facebook</v-icon>
                                </v-btn>
                                <v-btn
                                        class="v-btn-twitter"
                                        color="cyan"
                                        fab
                                        icon
                                        round
                                        small
                                >
                                    <v-icon>mdi-twitter</v-icon>
                                </v-btn>
                            </div>
                        </div>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-card>
    </v-menu>
</template>

<script>
    // Utilities
    import {mapMutations, mapState} from 'vuex'

    export default {
        data: () => ({
            colors: [
                'primary',
                'info',
                'success',
                'warning',
                'danger'
            ],
            images: [
                'https://demos.creative-tim.com/vue-material-dashboard/img/sidebar-1.23832d31.jpg',
                'https://demos.creative-tim.com/vue-material-dashboard/img/sidebar-2.32103624.jpg',
                'https://demos.creative-tim.com/vue-material-dashboard/img/sidebar-3.3a54f533.jpg',
                'https://demos.creative-tim.com/vue-material-dashboard/img/sidebar-4.3b7e38ed.jpg'
            ]
        }),

        computed: {
            ...mapState('app', ['image', 'color']),
            color() {
                return this.$store.state.app.color
            }
        },

        methods: {
            ...mapMutations('app', ['setImage']),
            setColor(color) {
                this.$store.state.app.color = color
            }
        }
    }
</script>

<style lang="scss">
    .v-avatar,
    .v-responsive {
        cursor: pointer;
    }
</style>
