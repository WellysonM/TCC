import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import pt from 'vuetify/es5/locale/pt'
import '@mdi/font/css/materialdesignicons.css'

Vue.use(Vuetify, {
  lang: {
    locales: { pt },
    current: 'pt'
  },
  options: {
    customProperties: true
  },
  icons: {
    iconfont: 'mdi',
  }
})
