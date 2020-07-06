<template>
  <div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>details:{{ details() }}</h1>
  </div>
</template>

<script>
export default {
  name: 'start',
  data: function() {
    return {
      site: '欢迎来到德莱联盟！',
      url: 'this is url',
      alexa: 'this is alexa'
    }
  },

  methods: {
    details: function() {
      return this.site
    }
  }
}
</script>
