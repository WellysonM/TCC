import Vue from 'vue'
import Vuetify from 'vuetify'
import theme from './theme'
import 'vuetify/dist/vuetify.min.css'
import '@mdi/font/css/materialdesignicons.css'
import pt from 'vuetify/es5/locale/pt'

Vue.use(Vuetify, {
    iconfont: 'mdi',
    theme,
    lang: {
        locales: {pt},
        current: 'pt'
    }
})
