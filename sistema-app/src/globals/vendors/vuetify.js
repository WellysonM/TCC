import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import '@mdi/font/css/materialdesignicons.css'
import pt from 'vuetify/es5/locale/pt'

Vue.use(Vuetify, {
    iconfont: 'mdi',
    theme: {
        primary: '#000',
        secondary: '#4caf50',
        tertiary: '#495057',
        accent: '#82B1FF',
        error: '#f55a4e',
        info: '#00d3ee',
        success: '#5cb860',
        warning: '#ffa21a',
        color: '#263238',
        padrao: '#0a1819',
        padrao2: '#19cca3'
    },
    lang: {
        locales: {pt},
        current: 'pt'
    }
})
