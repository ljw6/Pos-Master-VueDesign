<template>
<a-row :gutter="{xs:8,sm:12,md:14,lg:16,xl:18}">
  <a-col v-for="i in 6" :key="i" :span="4">
    list
  </a-col>
  <a-col v-for="i in 6" :key="i" :span="4">
    list
  </a-col>
</a-row>
</template>

<script>
const LastList = [];
export default {
name: "GoodsList",
  mounted() {
    this.getLastList();
  },
  data(){
  return{
    tag:[],
    LastList,
  }
  },
  methods:{
    getLastList(){
      this.$http.get("/last_list").then(res =>{
        let data = res.data
        data.forEach((item)=>{
          LastList.push({
            goodsName: item.name,
            description: item.description,
            price: item.price,
            area: item.area,
            cate: item.catergery,
            pic: item.pic
          })
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
