<template>
  <div>
    <div id="example-1">
      简单写法
      <button v-on:click="counter += 1">Add 1</button>
      <p>The button above has been clicked {{ counter }} times.</p>
    </div>
    <div id="example-2">
      定义方法
      <button v-on:click="greet">Greet</button>
    </div>
    <div id="example-3">
      传入参数
      <button v-on:click="say('hi')">Say hi</button>
      <button v-on:click="say('what')">Say what</button>
    </div>
    <div>
      传入参数和事件
      <button v-on:click="warn('Form cannot be submitted yet.', $event)">Submit</button>
    </div>
    按键修饰符：<input v-on:keyup.enter="greet" />

    <h2>关于事件修饰符建议看文档</h2>
    <!-- 阻止单击事件继续传播 -->
    <!-- <a v-on:click.stop="doThis"></a> -->

    <!-- 提交事件不再重载页面 -->
    <!-- <form v-on:submit.prevent="onSubmit"></form> -->

    <!-- 修饰符可以串联 -->
    <!-- <a v-on:click.stop.prevent="doThat"></a> -->

    <!-- 只有修饰符 -->
    <!-- <form v-on:submit.prevent></form> -->

    <!-- 添加事件监听器时使用事件捕获模式 -->
    <!-- 即内部元素触发的事件先在此处理，然后才交由内部元素进行处理 -->
    <!-- <div v-on:click.capture="doThis">...</div> -->

    <!-- 只当在 event.target 是当前元素自身时触发处理函数 -->
    <!-- 即事件不是从内部元素触发的 -->
    <!-- <div v-on:click.self="doThat">...</div> -->
  </div>
</template>
<script>
export default {
  data: function() {
    return {
      counter: 0,
      name: 'bilibili'
    }
  },
  methods: {
    greet: function(event) {
      // `this` 在方法里指向当前 Vue 实例
      alert('Hello ' + this.name + '!')
      // `event` 是原生 DOM 事件
      if (event) {
        console.log(event.target.tagName)
      }
    },
    say: function(message) {
      alert(message)
    },
    warn: function(message, event) {
      // 现在我们可以访问原生事件对象
      if (event) {
        event.preventDefault()
      }
      alert(message)
    }
  }
}
</script>
