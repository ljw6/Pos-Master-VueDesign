<template>
  <div class="orders">
    <a-list
        class="demo-loadmore-list"
        item-layout="vertical" size="large" :pagination="pagination"
        :data-source="datalist"
    >
    <a-list-item slot="renderItem" key="item.title" slot-scope="item">
      <img :src="item.img" style="height: 150px;width: 150px">
    </a-list-item>
    </a-list>
  </div>
</template>

<script>
const datalist=[];
for (let i=0;i<10;i++){
  datalist.push({
    title: `ant design vue part ${i}`,
    img: "https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
  });
}
export default {
  name: "AllOrders",
  data(){
    return{
      datalist,
      pagination: {
        onChange: page => {
          console.log(page);
        },
        pageSize: 3,
      },
    }
  }
}
</script>

<style scoped>

</style>
