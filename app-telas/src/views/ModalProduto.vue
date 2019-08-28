<template>
    <v-card flat>
        <v-card-text>
            <v-container fluid>
                <v-row>
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="red"
                                hide-details
                                label="red"
                                v-model="ex4"
                                value="red"
                        ></v-checkbox>
                        <v-checkbox
                                color="red darken-3"
                                hide-details
                                label="red darken-3"
                                v-model="ex4"
                                value="red darken-3"
                        ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="indigo"
                                hide-details
                                label="indigo"
                                v-model="ex4"
                                value="indigo"
                        ></v-checkbox>
                        <v-checkbox
                                color="indigo darken-3"
                                hide-details
                                label="indigo darken-3"
                                v-model="ex4"
                                value="indigo darken-3"
                        ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="orange"
                                hide-details
                                label="orange"
                                v-model="ex4"
                                value="orange"
                        ></v-checkbox>
                        <v-checkbox
                                color="orange darken-3"
                                hide-details
                                label="orange darken-3"
                                v-model="ex4"
                                value="orange darken-3"
                        ></v-checkbox>
                    </v-col>
                </v-row>

                <v-row class="mt-12">
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="primary"
                                hide-details
                                label="primary"
                                v-model="ex4"
                                value="primary"
                        ></v-checkbox>
                        <v-checkbox
                                color="secondary"
                                hide-details
                                label="secondary"
                                v-model="ex4"
                                value="secondary"
                        ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="success"
                                hide-details
                                label="success"
                                v-model="ex4"
                                value="success"
                        ></v-checkbox>
                        <v-checkbox
                                color="info"
                                hide-details
                                label="info"
                                v-model="ex4"
                                value="info"
                        ></v-checkbox>
                    </v-col>
                    <v-col cols="12" md="4" sm="4">
                        <v-checkbox
                                color="warning"
                                hide-details
                                label="warning"
                                v-model="ex4"
                                value="warning"
                        ></v-checkbox>
                        <v-checkbox
                                color="error"
                                hide-details
                                label="error"
                                v-model="ex4"
                                value="error"
                        ></v-checkbox>
                    </v-col>
                </v-row>
            </v-container>
        </v-card-text>
    </v-card>
</template>
<script>
    export default {
        data() {
            return {
                ex4: ['red', 'indigo', 'orange', 'primary', 'secondary', 'success', 'info', 'warning', 'error', 'red darken-3', 'indigo darken-3', 'orange darken-3'],
            }
        },
    }
</script>