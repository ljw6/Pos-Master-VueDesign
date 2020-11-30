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
export default {
name: "GoodsList",
  data(){
  return{
    tag:[],
  }
  },
  methods:{
    getTag(){

    }
  }
}
</script>

<style scoped>

</style>
