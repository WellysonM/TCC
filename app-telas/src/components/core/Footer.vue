<template>
    <v-footer id="core-footer"
              absolute
              height="82">
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
        z-index: 0;
    }
</style>
