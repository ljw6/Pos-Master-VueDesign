<template>
<div class="goods">
  <a-form :label-col="labelCol" :wrapper-col="wrapperCol">
    <a-form-item
      label="商品名"
      validate-status="success">
      <a-input id="goodsname" placeholder="请输入商品名"/>
    </a-form-item>
    <a-form-item label="价格">
      <a-input id="price" placeholder="请输入价格"/>
    </a-form-item>
    <a-form-item label="品类">
      <a-input id="cater" placeholder="请选择品类"/>
    </a-form-item>
    <a-form-item label="园区">
      <a-input id="area" placeholder="请选择发布园区"/>
    </a-form-item>
    <a-form-item label="时间">
      <a-input id="time" placeholde="请选择发布时间"/>
    </a-form-item>
    <a-form-item label="描述">
      <a-input id="description" placeholder="请输入商品描述"/>
    </a-form-item>
  </a-form>
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
    };
  },
}
</script>

<style scoped>

</style>
