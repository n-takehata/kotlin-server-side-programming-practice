import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BookList from '@/components/BookList'
import BookDetail from '@/components/BookDetail'
import BookRegister from '@/components/BookRegister'
import BookRegisterCompleted from '@/components/BookRegisterCompleted'
import BookUpdate from '@/components/BookUpdate'
import BookUpdateCompleted from '@/components/BookUpdateCompleted'
import BookDeleteCompleted from '@/components/BookDeleteCompleted'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/book/list',
      name: 'BookList',
      component: BookList
    },
    {
      path: '/book/detail/:book_id',
      name: 'BookDetail',
      component: BookDetail
    },
    {
      path: '/admin/book/register',
      name: 'BookRegister',
      component: BookRegister
    },
    {
      path: '/admin/book/register/completed',
      name: 'BookRegisterCompleted',
      component: BookRegisterCompleted
    },
    {
      path: '/admin/book/update/completed',
      name: 'BookUpdateCompleted',
      component: BookUpdateCompleted
    },
    {
      path: '/admin/book/update/:book_id',
      name: 'BookUpdate',
      component: BookUpdate
    },
    {
      path: '/admin/book/delete/completed',
      name: 'BookDeleteCompleted',
      component: BookDeleteCompleted
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
