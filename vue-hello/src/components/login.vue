<template>
<div :class="preloads">
  <div class="preloader_content">
    <div class="loader">
      <span>P</span>
      <span>O</span>
      <span>S</span>
    </div>
  </div>
</div>
</template>

<script>
export default {
name: "login",
  data() {
    return {
      preloads: null
      }
  },
  mounted() {
  this.preload();
  },
  methods: {
    preload(){
    this.preloads.fadeout("red",100);
}
  }
}
</script>

<style scoped>

</style>
