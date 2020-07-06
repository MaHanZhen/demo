<template>
  <div id="app">
    <div id="nav">
      <ul>
        <li>
          <a href="/#/HelloWorld">HelloWorld</a>
        </li>
        <li>
          <a href="/#/start">开始页面</a>
        </li>
        <li>
          <a href="/#/TemplateSyntax">模板语法</a>
        </li>
      </ul>
    </div>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#nav{
  display: inline-block;
  width: 20%;
  border-left: 1px solid #000;
  vertical-align: top;
  text-align: left;
}
#content{
  display: inline-block;
  width: 79%;
  text-align: left;
}
</style>
