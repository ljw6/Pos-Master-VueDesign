<template>
  <div class="service">
    <a-form :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item
          label="类型"
          validate-status="success">
        <a-select id="servicesName" default-value="跑腿" style="width: 120px" @change="handleChange">
          <a-select-option value="paotui">
            跑腿
          </a-select-option>
          <a-select-option value="fudao">
            辅导
          </a-select-option>
          <a-select-option value="daizuo">
            代做
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="价格">
        <a-input id="price" placeholder="请输入价格"/>
      </a-form-item>
      <a-form-item label="园区">
        <a-select default-value="周园" style="width: 120px" @change="handleChange">
          <a-select-option value="zhou">
            周园
          </a-select-option>
          <a-select-option value="qin">
            秦园
          </a-select-option>
          <a-select-option value="han">
            汉园
          </a-select-option>
          <a-select-option value="tang">
            唐园
          </a-select-option>
          <a-select-option value="mei">
            梅园
          </a-select-option>
          <a-select-option value="lan">
            兰园
          </a-select-option>
          <a-select-option value="zhu">
            竹园
          </a-select-option>
          <a-select-option value="ju">
            菊园
          </a-select-option>
          <a-select-option value="jiashu">
            家属区
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="时间">
        <a-date-picker id="dataPush" @change="onChange" />
      </a-form-item>
      <a-form-item label="描述">
        <a-textarea id="description" placeholder="请输入服务描述" :rows="5"/>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
export default {
name: "PushService",
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
  methods:{
    onChange(date, dateString) {
      console.log(date, dateString);
    },
    handleChange(value) {
      console.log(`selected ${value}`);
    },
  }
}
</script>

<style scoped>

</style>
