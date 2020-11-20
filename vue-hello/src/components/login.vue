<template>
<div class="preload">
  <div class="preloader_content">
    <div class="loader">
      <span>{{preloads}}</span>
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
