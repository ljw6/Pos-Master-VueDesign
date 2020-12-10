<template>
<a-collapse accordion @change="changeTabname">
  <a-collapse-panel key="area" header="园区">
    <a-tabs
        :tab-position="top"
        :style="{height:'580px'}"
        @tabClick="value => clickTo(value,this.tabName)"
    >
      <a-tab-pane v-for="i in 9" :key="i" :tab="areaList[i-1]">
        <router-view/>
      </a-tab-pane>
    </a-tabs>
  </a-collapse-panel>
  <a-collapse-panel key="catergery" header="品类">
    <a-tabs
      :tab-position="top"
      :style="{height: '580px'}"
      @tabClick="value => clickTo(value,this.tabName)"
    >
      <a-tab-pane v-for="c in 4" :key="c" :tab="catList[c-1]">
        <router-view/>
      </a-tab-pane>
    </a-tabs>
  </a-collapse-panel>
  <a-collapse-panel key="service" header="服务">
    <a-tabs
        :tab-position="top"
        :style="{height: '580px'}"
        @tabClick="value => clickTo(value,this.tabName)"
    >
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
  },
  data(){
  return{
    areaList:['周园','秦园','汉园','唐园','梅园','兰园','竹园','菊园','家属区'],
    catList:['美妆护肤','消费电子','学习用具','生活用品'],
    schoolServices:['辅导','跑腿','代做'],
    tabName:null,
    top:'top',
  }
  },
  methods:{
  Callback(val){
    console.log(val);
  },
    Callbackp(val){
    console.log(val);
    console.log("pre");
    },
    Callbackn(val){
      console.log(val);
      console.log("next");
    },
    clickTo(val,name){
      // this.$router.replace({name:"lists",params:{tabTag:name,tagVal:val}});
      this.$router.push({path:"list",query:{tabTag:name,tagVal:val}});
    },
    changeTabname(val){
      this.tabName=val;
      this.$router.push({path:"list",query:{tabTag:val,tagVal:"1"}});
    },
  }
}
</script>

<style scoped>

</style>
