<template>
    <v-app>
        <div v-if="$store.state.route.name === 'Cadastrar'">
            <router-view/>
        </div>
        <div v-else>
            <core-toolbar/>
            <core-drawer/>
            <core-view/>
        </div>
    </v-app>
</template>

<script>
    export default {
        name: 'app'
    }
</script>

<style lang="scss">
    @import '@/commons/theme/styles/index.scss';

    .v-datatable thead th.column.sortable i {
        vertical-align: unset;
    }

    table.v-table tbody td {
        height: 30px;
    }

    .v-datatable__actions__select {
        color: black;
    }

    .v-datatable__actions__select .v-select__selections .v-select__selection--comma {
        color: black;
    }

    .v-datatable__actions__pagination {
        color: black;
    }

    .v-datatable__actions .v-btn:last-of-type {
        color: black !important;
    }

    .v-btn.v-btn--icon {
        color: black !important;
    }

    .v-input--selection-controls.v-input .v-label {
        color: black;
        font-size: 14px;
        padding: 2px 8px;
    }

    .padrao2 {
        background: #0F2027; /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027); /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #2C5364, #243B55, #0F2027); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

    }

    .card {
        margin-top: 48px !important;
        width: 90px;
        margin: 10px;
    }
</style>
