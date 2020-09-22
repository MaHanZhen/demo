<template>
  <div>
    List -->
    <br />
    <div>
      循环模式：for i in items
      <ul id="example-1">
        <li v-for="item in items" :key="item.message">{{ item.message }}</li>
      </ul>你也可以用 of 替代 in 作为分隔符，因为它更接近 JavaScript 迭代器的语法：
      for i of items
      <ul id="example-1-2">
        <li v-for="item of items" :key="item.message">{{ item.message }}</li>
      </ul>
    </div>

    <div>
      循环模式：for (item, index) in items ,parentMessage 是父作用域的 property
      <ul id="example-2">
        <li
          v-for="(item, index) in items"
          :key="item.message"
        >{{ parentMessage }} - {{ index }} - {{ item.message }}</li>
      </ul>
    </div>

    <div>
      循环模式：使用计算属性：for n in evenNumbers
      <ul id="example-2">
        <li v-for="n in evenNumbers" :key="n">{{ n }}</li>
      </ul>
    </div>

    <div>
      循环模式：使用方法：for n in evenNumbers
      <ul id="example-2">
        <li v-for="n in evenNumber(numbers)" :key="n">{{ n }}</li>
      </ul>
    </div>object -->
    <br />

    <div>
      object 简单迭代器 value in object
      <ul id="v-for-object1" class="demo">
        <li v-for="value in object" :key="value">{{ value }}</li>
      </ul>
    </div>
    <div>
      object 带键值迭代 (value, name) in object
      <ul id="v-for-object2" class="demo">
        <li v-for="(value, name) in object" :key="value">{{ name }}: {{ value }}</li>
      </ul>
    </div>
    <div>
      object 带键值、索引迭代 (value, name, index) in object
      <ul id="v-for-object3" class="demo">
        <li v-for="(value, name, index) in object" :key="value">{{ index }} ：{{ name }}: {{ value }}</li>
      </ul>
    </div>
    <div>
      v-for 与 v-if 一同使用
      <br />当它们处于同一节点，v-for 的优先级比 v-if 更高，这意味着 v-if 将分别重复运行于每个 v-for 循环中
      <li v-for="n in numbers" v-if="n%2 ==0" :key="n">{{ n }}</li>而如果你的目的是有条件地跳过循环的执行，那么可以将 v-if 置于外层元素
    </div>
    <ul v-if="items.length">
      <li v-for="item in items" :key="item.message">{{ item.message }}</li>
    </ul>
    <p v-else>No todos left!</p>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      parentMessage: 'parentMessage',
      items: [{ message: 'Foo' }, { message: 'Bar' }],
      itemsNull: [],
      numbers: [1, 2, 3, 4, 5],
      object: {
        title: 'How to do lists in Vue',
        author: 'Jane Doe',
        publishedAt: '2016-04-10'
      }
    }
  },
  computed: {
    evenNumbers: function() {
      return this.numbers.filter(function(number) {
        return number % 2 === 0
      })
    }
  },
  methods: {
    evenNumber: function(numbers) {
      return numbers.filter(function(number) {
        return number % 2 === 0
      })
    }
  }
}
</script>
