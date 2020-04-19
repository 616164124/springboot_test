<template>
    <div >
      {{msg}}

      <li v-for="user in tuser">
        {{user.userId}}  {{user.username}}
      </li>
    </div>
</template>

<script>
  export default {
    //name: 'HelloWorld',
    data () {
      return {
        msg: 'fklsjhfk',
        tuser:[
          {userId:"",username:""}
        ],

      }
    },
     created(){
       console.log("jsjflsfl");
       const _this= this;
       this.$axios.get('/tuser').then(function (resp) {
         console.log(resp),
         _this.tuser=resp.data

       })
     },
    methods:{
      anbutton:function () {
        console.log("1323");
      }

    }
  }
</script>

<style scoped>

</style>
