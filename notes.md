### java - web 技术栈笔记

#### 前端

1. Vue

   1. router

      1. 通过路由实现页面跳转

         安装router

         `npm i vue-router`

         配置

         创建router目录，并添加index.js

         ```javascript
         //index.js
         import Vue from "vue"
         import Router from 'vue-router'
         import Index from '@/components/index'
         import login from '@/components/login'
         
         Vue.use(Router)
         
         export default new Router({
             routes : [
                 {
                     path: '/',
                     name: 'Index',
                     component: Index
                 },
                 {
                     path: '/login',
                     name: 'login',
                     component: login
                 }
             ]
         })
         ```

         使用

         ```html
         <router-link to="A">跳转到A页面</router-link>
         ```

      2. 实现子路由

         ```javascript
         children:[
             {path:"",
             commponent: },
            	{path: "",
             commponent: }
         ]
         ```

         在父页面添加

         ```html
         <router-view></router-view>
         ```

         **父页面中的子页面的路由跳转只改变`<router-view></router-view>`中的值**

      3. 路由中的"#"

         1. 显示模式

            1. hash模式

               “#”后面的内容不会被获取，以减少请求次数

            2. history模式

               具有对url历史记录进行修改的功能

         2. 修改模式

            沟通后台处理404

            router

            ​	index.js中

            ```javascript
            //添加到routers上方
            //修改模式
                mode: "history",
            ```

            

   2. axios

   3. store