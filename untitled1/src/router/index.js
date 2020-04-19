import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Name from '@/components/name.vue'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/name',
      component: Name
    } ,
    {
      path:'/user',
      component:User
    }
  
  
  ]
})
