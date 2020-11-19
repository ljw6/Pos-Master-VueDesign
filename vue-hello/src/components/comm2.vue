<template>
  <div class="comm2">
    <button @click="addfunc">++</button>
    <button @click="divfunc">--</button>
  </div>

</template>

<script>
export default {
  name: "comm2",
  methods:{
    addfunc:function (){
      this.$store.commit("addfunc");
    },
    divfunc:function (){
      this.$store.commit("divfunc");
    }
  }

}
</script>

<style scoped>

</style>
