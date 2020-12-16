<template>
<a-list :grid="{gutter:20,column:6}"
  :data-source="LastList"
>
  <a-list-item slot="renderItem" slot-scope="item">
    <a-card :title="item.goodsName">
      发布自{{item.area}}<br>
      分类：{{item.cate}}<br>
      商品描述：{{item.description}}<br>
      ￥{{item.price}}
    </a-card>
  </a-list-item>
</a-list>
</template>

<script>
const LastList=[];
export default {
name: "GoodsList",
  // activated() {
  //   this.getLastList();
  // },
  mounted() {
    // this.LastList=[];
    this.getRouterTag();
    // this.getLastList();
  },
  data(){
  return{
    tag:null,
    tagVal:null,
    LastList,
  }
  },
  methods:{
    getLastList(){
      let Lists = [];
      this.$http.get("/last_list/"+this.tag+"/"+this.tagVal).then(res =>{
        let data = res.data
        console.log(data);
        data.forEach((item)=>{
          Lists.push({
            goodsName: item.name,
            description: item.description,
            price: item.price,
            area: item.area,
            cate: item.catergery,
          })
        })
      });
      this.LastList = Lists;
    },
    getRouterTag(){
      let regTag = new RegExp("g=.*?&");
      let regNum = new RegExp("l=.*");
      let tabTag = self.location.href.match(regTag)[0];
      let tabNum = self.location.href.match(regNum)[0];
      this.tag =tabTag.substring(2,tabTag.length-1);
      this.tagVal = tabNum.substring(2);
      this.getLastList();
    }
  }
}
</script>

<style scoped>

</style>
