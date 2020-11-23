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
            entry: 'src/models/User/User.js',
            template: 'public/User.html',
            title: '用户主页'
        },
        index:{
            entry: 'src/main.js',
            template: 'public/index.html'
        }
    }
}
