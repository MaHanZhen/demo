<template>
<div>
  <div id="insertValue">
    <span>Message: {{ insertValue.msg }}</span><br/>
    <span v-once>这个将不会改变: {{ insertValue.msg }}</span>
    <p>
      Using v-html directive:
      <span v-html="insertValue.rawHtml"></span>
    </p>
    <p>
      html属性绑定<span v-bind:ipd="insertValue.id"></span><br/>
      对于disabled，有一套独立的规则<br/>
      对于布尔 attribute (它们只要存在就意味着值为 true)
      <button v-bind:disabled="insertValue.btnDisabled">btnDisabled</button><br/>
      如果 isButtonDisabled 的值是 null、undefined 或 false，则 disabled attribute 甚至不会被包含在渲染出来的 button 元素中。
      <button v-bind:disabled="insertValue.btnDisabledBBiu">btnDisabledBBiu</button>
    </p>
     虽然VUE支持简单表达，但是并不建议使用
     <p> {{ insertValue.number + 1 }}</p>
     <p>{{ insertValue.ok ? 'YES' : 'NO' }}</p>
     <p>{{ insertValue.msg.split('').reverse().join('') }}</p>
     <p  v-bind:id="'list-' + insertValue.id"></p>
  </div>
  <div id="instruct">
    <a v-bind:href="instructValue.url">{{ instructValue.url }}</a>
    <button v-on:click="instructDoSomething">instructDoSomething</button><br>
     <a v-bind:[attributeName]="instructValue.url">{{ instructValue.url }}</a>
    <button v-on:[eventName]="instructDoSomething">instructDoSomething</button><br>
  </div>
</div>
</template>

<script>
export default {
  name: 'TemplateSyntax',
  data: function() {
    const data = {
      attributeName: 'href',
      eventName: 'click',
      insertValue: {
        id: 'qaq',
        msg: 'this is insertValue msg',
        rawHtml: '<span style="color:red">this is has style message </span>',
        btnDisabled: 'qaq',
        number: 666,
        ok: true
      },
      instructValue: {
        url: 'https://www.bilibili.com/',
        attributeName: 'href',
        eventName: 'click'
      }
    }
    return data
  },

  methods: {
    instructDoSomething: function(event) {
      alert(this.instructValue.url)
    }
  }
}
</script>

<style >
</style>
