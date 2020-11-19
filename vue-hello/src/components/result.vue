<template>
<div class="result">
  <h2>{{res}}</h2>
</div>
</template>

<script>
export default {
  name: "result",
  // props:{
  //   res: String
  // },
//   data:function() {
//   return {
//     res : this.$store.state.counter
//   };
// },
  computed:{

    res(){
      return this.$store.state.counter;
    }
  }

}
</script>

<style scoped>

</style>
