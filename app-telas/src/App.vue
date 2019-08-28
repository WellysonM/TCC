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
<style lang="scss">
    @import '@/styles/index.scss';

    .v-datatable thead th.column.sortable i {
        vertical-align: unset;
    }
</style>
