import axios from 'axios'

export const Axios = axios.create({
    baseURL: 'http://localhost:8081',//后端服务端口
    timeout: 10000,
})

Axios.interceptors.request.use(config=>{
    if (config.method === 'post'){
        const formData = new FormData()
        Object.keys(config.data).forEach(key => formData.append(key,config.data[key]))
        config.data = formData
    }

    let token = localStorage.getItem('authorization');
    if (token){
        config.headers.Authorization= token
    }
    return config
},
    error => {
        alert("传参错误")
        return Promise.reject(error)
    })
