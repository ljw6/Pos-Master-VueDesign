<template>
  <div class="comm1">
    <button @click="addfunc">+</button>
    <button @click="divfunc">-</button>
  </div>
</template>

<script>

export default {
  methods:{
    addfunc:function (){
      this.$store.state.counter++;
    },
    divfunc:function (){
      this.$store.state.counter--;
    }
  }
}
</script>

<style scoped>

</style>
