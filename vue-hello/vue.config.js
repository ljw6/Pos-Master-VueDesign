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
    }
    // pages: {//multi-page多页应用构建的配置
    //     index :{
    //         entry: "src/entry/main.js",
    //         template: "public/index.html",
    //         filename: "index.html",
    //         title: "index page",
    //         chunks: ['chunk-vendors','chunk-common','index']
    //     },
    //     login: {
    //         entry: "src/entry/login.js",
    //         template: "public/login.html",
    //         filename: "login.html",
    //         title: "login page",
    //         chunks: ['chunk-vendors','chunk-common','login']
    //     }
    // }
}
