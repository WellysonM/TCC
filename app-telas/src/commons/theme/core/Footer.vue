<template>
    <v-footer absolute
              id="core-footer">
        <v-spacer/>
        <span class="font-weight-light copyright">
            &copy;{{ (new Date()).getFullYear() }}
      <v-icon
              color="tertiary"
              size="20">mdi-pizza</v-icon>
    </span>
    </v-footer>
</template>
<style>
    #core-footer {
        margin-top: 3%;
        z-index: 0;
        position: fixed;
        bottom: 0;
        border: none;
    }
</style>
