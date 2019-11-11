<template>
    <v-app>
        <v-app-bar app color="padrao2" dark>
            <v-spacer/>
            <div class="d-flex align-center">
                <v-icon large left>
                    mdi-nutrition
                </v-icon>
            </div>
            <v-flex center>
                <h4>Lista de pedidos</h4>
            </v-flex>
        </v-app-bar>
        <v-content>
            <pedidos/>
        </v-content>
    </v-app>
</template>

<script>
    import pedidos from './components/Pedidos';

    export default {
        name: 'App',

        components: {
            pedidos,
        },

        data: () => ({
            //
        }),
    };
</script>
<style>
    .padrao2 {
        background: #0F2027; /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027); /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #2C5364, #243B55, #0F2027); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

    }
</style>
