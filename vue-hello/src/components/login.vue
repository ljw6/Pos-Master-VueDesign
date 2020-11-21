<template>
<div class="preload">
  <div class="preloader_content">
    <div class="loader">
      <span>{{preloads}}</span>
      <a-button type="primary"><a-icon type="step-forward" /></a-button>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      preloads: "POS",
      }
  },
}
</script>

<style scoped>

</style>
