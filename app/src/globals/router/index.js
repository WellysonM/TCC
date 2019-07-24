import Vue from 'vue'
import Router from 'vue-router'
import singIn from '../../commons/components/SignIn'
import Menu from '../../views/Menu'

Vue.use(Router)

const index = new Router({
    routes: [
        {
            path: '/',
            name: 'SignIn',
            component: singIn
        },
        {
            path: '/menu',
            name: 'paginaInicial',
            component: Menu
        }
    ]
})
export default index