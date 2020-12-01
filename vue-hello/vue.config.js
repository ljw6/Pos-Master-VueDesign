module.exports={
    devServer:{
        host:"localhost",
        port:8088
        //https: false, // https:{type:Boolean}
        //open: true, //配置自动启动浏览器
        // proxy:{
        //     "/api":{
        //         target: "http://localhost:8081",
        //         ws: true,
        //         changeOrigin:true,
        //         pathRewrite:{
        //             "^/api": "/"
        //         }
        //     }
        // }
    },
    pages:{
        User: {
            entry: 'src/models/User/UserEntry.js',
            template: 'public/User.html',
            title: '用户主页'
        },
        Main:{
            entry: 'src/main.js',
            template: 'public/index.html',
            title: '师大集市'
        },
        doPush:{
            entry: 'src/models/Push/PushEntry.js',
            template: 'public/Push.html',
            title: '发布中心'
        },
        index:{
            entry: 'src/models/Login/LoginEntry.js',
            template: 'public/login.html',
            title: '师大集市'
        }
    }
}
