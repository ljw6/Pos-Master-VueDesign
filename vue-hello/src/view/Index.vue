<template>
<a-collapse accordion>
  <a-collapse-panel key="1" header="园区">
    <a-tabs
        :default-active-key="1"
        :tab-position="top"
        :style="{height:'580px'}"
        @prevClick="Callback"
        @nextClick="Callback"
    >
      <a-tab-pane v-for="i in 9" :key="i" :tab="areaList[i-1]">
        <router-view/>
      </a-tab-pane>
    </a-tabs>
  </a-collapse-panel>
  <a-collapse-panel key="2" header="品类">
    <a-tabs
      :default-active-key="1"
      :tab-position="top"
      :style="{height: '580px'}"
      @prevClick="Callback"
      @nextClick="Callback">
      <a-tab-pane v-for="c in 4" :key="c" :tab="catList[c-1]">
        <router-view/>
      </a-tab-pane>
    </a-tabs>
  </a-collapse-panel>
  <a-collapse-panel key="3" header="服务">
    <a-tabs
        :default-active-key="1"
        :tab-position="top"
        :style="{height: '580px'}"
        @prevClick="Callback"
        @nextClick="Callback">
      <a-tab-pane v-for="s in 4" :key="s" :tab="schoolServices[s-1]">
        <router-view/>
      </a-tab-pane>
    </a-tabs>
  </a-collapse-panel>
</a-collapse>

</template>

<script>
export default {
name: "Index",
  mounted() {
    this.GetList();
  },
  data(){
  return{
    areaList:['周园','秦园','汉园','唐园','梅园','兰园','竹园','菊园','家属区'],
    catList:['美妆护肤','学习用具','生活用品','消费电子'],
    schoolServices:['辅导','跑腿','代做'],
  }
  },
  methods:{
  Callback(val){
    console.log(val);
  },
    GetList(){
    this.$router.push("/list");
    }
  }
}
</script>

<style scoped>

</style>
