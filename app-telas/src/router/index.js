import Vue from 'vue'
import Router from 'vue-router'
import _ from 'lodash'
import paths from './paths'
import pathsRegister from "./pathsRegister";

function route(path, view, name) {
    return {
        name: name || view,
        path,
        component: (resovle) => import(
            `@/views/${view}.vue`
            ).then(resovle)
    }
}

Vue.use(Router)

const rotasPadrao = paths.map(path => route(path.path, path.view, path.name)).concat([
    {path: '*', redirect: '/inicio'}
])

const rotasLogin = pathsRegister

const rotas = _.flatten([rotasPadrao, rotasLogin])
const router = new Router({
    mode: 'history',
    routes: rotas,
    scrollBehavior(to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition
        }
        if (to.hash) {
            return {selector: to.hash}
        }
        return {x: 0, y: 0}
    }
})

export default router
