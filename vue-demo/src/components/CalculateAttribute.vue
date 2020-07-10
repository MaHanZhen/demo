<template>
  <div>
    <div id="computed">
    <p>Original message: "{{ message }}"</p>
    <p>Computed reversed message: "{{ reversedMessage }}"</p>
    </div>
    <div id="computedVswatch">
        <p>watch fullName : "{{ fullName }}"</p>
        <p>computed fullName2 : "{{ fullName2 }}"</p>
        <p>computed hasGetter fullName3 : "{{ fullName2 }}"</p>
    </div>
    <div id="watch-example">
  <p>
    Ask a yes/no question:
    <input v-model="question">
  </p>
  <p>{{ answer }}</p>
</div>
  </div>
</template>

<script>
export default {
  name: 'CalculateAttribute',
  data: function() {
    return {
      message: 'Hello',
      firstName: 'Foo',
      lastName: 'Bar',
      fullName: 'Foo Bar',
      question: '',
      answer: 'I cannot give you an answer until you ask a question!'
    }
  },
  computed: {
    // 计算属性的 getter
    reversedMessage: function () {
      // `this` 指向 vm 实例
      return this.message.split('').reverse().join('')
    },
    fullName2: function () {
      return this.firstName + ' ' + this.lastName
    },
    fullName3: {
    // getter
      get: function () {
        return this.firstName + ' ' + this.lastName
      },
      // setter
      set: function (newValue) {
        var names = newValue.split(' ')
        this.firstName = names[0]
        this.lastName = names[names.length - 1]
      }
    }
  },
  watch: {
    firstName: function (val) {
      this.fullName = val + ' ' + this.lastName
    },
    lastName: function (val) {
      this.fullName = this.firstName + ' ' + val
    },
    question: function (newQuestion, oldQuestion) {
      this.answer = 'Waiting for you to stop typing...'
      this.debouncedGetAnswer()
    }
  },
  created: function () {
    // `_.debounce` 是一个通过 Lodash 限制操作频率的函数。
    // 在这个例子中，我们希望限制访问 yesno.wtf/api 的频率
    // AJAX 请求直到用户输入完毕才会发出。想要了解更多关于
    // `_.debounce` 函数 (及其近亲 `_.throttle`) 的知识，
    // 请参考：https://lodash.com/docs#debounce
    this.debouncedGetAnswer = this.lodash.debounce(this.getAnswer, 500)
  },
  methods: {
    getAnswer: function () {
      // if (this.question.indexOf('?') === -1) {
      //   this.answer = 'Questions usually contain a question mark. ;-)'
      //   return
      // }
      this.answer = 'Thinking...'
      this.$axios.get('https://www.bilibili.com/')
        .then((response) => {
          this.answer = this.lodash.capitalize(response.data)
        })
        .catch((response) => {
          console.log(response)
          this.answer = this.lodash.capitalize(response)
        })
    }
  }
}
</script>
