import cadastrar from '../../views/autenticacao/Cadastrar'
import entrar from '../../views/autenticacao/Entrar'

export default [
    {
        path: '/',
        component: entrar,
        name: 'Entrar',
        view: 'Entrar'
    },
    {
        path: '/cadastrar',
        component: cadastrar,
        name: 'Cadastrar',
        view: 'cadastrar'
    }
]
