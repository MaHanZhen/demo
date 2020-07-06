import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import start from '@/components/start'
import TemplateSyntax from '@/components/TemplateSyntax'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    }, {
      path: '/start',
      name: 'start',
      component: start
    }, {
      path: '/TemplateSyntax',
      name: 'TemplateSyntax',
      component: TemplateSyntax
    }
  ]
})
