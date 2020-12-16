<template>
<div class="goods">
  <a-form-model :label-col="labelCol" :wrapper-col="wrapperCol">
    <a-form-model-item
      label="商品名"
      validate-status="success">
      <a-input id="goodsName" placeholder="请输入商品名" v-model="Goods.goodsName"/>
    </a-form-model-item>
    <a-form-model-item label="价格">
      <a-input id="price" placeholder="请输入价格" v-model="Goods.goodsPrice"/>
    </a-form-model-item>
    <a-form-model-item label="品类">
      <a-select default-value="美妆护肤" style="width: 120px" @change="handleChange" v-model="Goods.goodsCategory">
        <a-select-option value="美妆护肤">
          美妆护肤
        </a-select-option>
        <a-select-option value="生活用品">
          生活用品
        </a-select-option>
        <a-select-option value="学习用具">
          学习用具
        </a-select-option>
        <a-select-option value="消费电子">
          消费电子
        </a-select-option>
      </a-select>
    </a-form-model-item>
    <a-form-model-item label="园区">
      <a-select default-value="周园" style="width: 120px" @change="handleChange" v-model="Goods.goodsArea">
        <a-select-option value="周园">
          周园
        </a-select-option>
        <a-select-option value="秦园">
          秦园
        </a-select-option>
        <a-select-option value="汉园">
          汉园
        </a-select-option>
        <a-select-option value="唐园">
          唐园
        </a-select-option>
        <a-select-option value="梅园">
          梅园
        </a-select-option>
        <a-select-option value="兰园">
          兰园
        </a-select-option>
        <a-select-option value="竹园">
          竹园
        </a-select-option>
        <a-select-option value="菊园">
          菊园
        </a-select-option>
        <a-select-option value="家属区">
          家属区
        </a-select-option>
      </a-select>
    </a-form-model-item>
    <a-form-model-item label="描述">
      <a-textarea id="description" placeholder="请输入商品描述" :rows="5" v-model="Goods.goodsDescription" />
    </a-form-model-item>
    <a-form-model-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary" @click="saveNew">
        发布
      </a-button>
    </a-form-model-item>
  </a-form-model>
</div>
</template>

<script>
export default {
name: "PushGoods",
  data() {
    return {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 5 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 12 },
      },
      Goods: {
        "goodsName":"",
        "goodsPrice":null,
        "goodsCategory":"",
        "goodsArea":"",
        "goodsDescription":null
      },
    };
  },
  methods:{
    onChange(date, dateString) {
      console.log(date, dateString);
    },
    handleChange(value) {
      console.log(`selected ${value}`);
    },
    saveNew(){
      this.$http.post("/saveNew",{
        name:this.Goods.goodsName,
        description:this.Goods.goodsDescription,
        price:this.Goods.goodsPrice,
        catergery:this.Goods.goodsCategory,
        pushId:localStorage.getItem("userid"),
      }).then(
          res =>{
            console.log(res);
          }
      ).catch(
          err =>{
            console.log(err);
          }
      );
    },
  }
}
</script>

<style scoped>

</style>
