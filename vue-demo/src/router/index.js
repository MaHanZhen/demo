import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import lodash from 'lodash'
import HelloWorld from '@/components/HelloWorld'
import start from '@/components/start'
import TemplateSyntax from '@/components/TemplateSyntax'
import CalculateAttribute from '@/components/CalculateAttribute'
import ClassAndStyle from '@/components/ClassAndStyle'
import condition from '@/components/condition'
import list from '@/components/list'
import event from '@/components/event'
import form from '@/components/form'

Vue.use(Router)
Vue.prototype.$axios = axios
Vue.prototype.lodash = lodash
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
    }, {
      path: '/CalculateAttribute',
      name: 'CalculateAttribute',
      component: CalculateAttribute
    }, {
      path: '/ClassAndStyle',
      name: 'ClassAndStyle',
      component: ClassAndStyle
    }, {
      path: '/condition',
      name: 'condition',
      component: condition
    }, {
      path: '/list',
      name: 'list',
      component: list
    }, {
      path: '/event',
      name: 'event',
      component: event
    }, {
      path: '/form',
      name: 'form',
      component: form
    }
  ]
})
