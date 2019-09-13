<template>
    <v-container fill-height
                 fluid
                 grid-list-xl>
        <v-layout wrap>
            <template>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                                <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   01
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                                <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   02
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                                <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   03
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                              <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   04
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                               <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   05
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
                <v-flex lg2 md2>
                    <v-hover>
                        <template v-slot="{ hover }">
                            <v-card
                                    :class="`elevation-${hover ? 24 : 2}`"
                                    class="pa-4 card transition-swing"
                                    color="padrao2"
                                    dark
                                    slot="offset"
                            >
                                <span style="font-size: 30px; text-align: center; letter-spacing: 2px; font-weight: bold;">
                                   06
                                </span>
                            </v-card>
                        </template>
                    </v-hover>
                </v-flex>
            </template>
        </v-layout>
    </v-container>
</template>