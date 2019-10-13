import cadastrar from '../../views/autenticacao/Cadastrar'
import entrar from '../../views/autenticacao/Entrar'

export default [
    {
        path: '/',
        component: cadastrar,
        name: 'Cadastrar',
        view: 'Cadastrar'
    },
    {
        path: '/entrar',
        component: entrar,
        name: 'Entrar',
        view: 'Entrar'
    }
]
