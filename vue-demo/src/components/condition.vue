<template>
  <div>
    type is {{ type}} :
    <div v-if="type === 'A'">A</div>
    <div v-else-if="type === 'B'">B</div>
    <div v-else-if="type === 'C'">C</div>
    <div v-else>Not A/B/C</div>

    <div>
      可复用元素
      <div v-if="loginType === 'username'">
        <label>Username</label>
        <input placeholder="Enter your username" />
      </div>
      <div v-else>
        <label>Email</label>
        <input placeholder="Enter your email address" />
      </div>
    </div>

    <div>
      可复用元素 不想复用的话 给元数添加KEY
      <div v-if="loginType === 'username'">
        <label>Username</label>
        <input placeholder="Enter your username" key="username-input" />
      </div>
      <div v-else>
        <label>Email</label>
        <input placeholder="Enter your email address" key="email-input" />
        <br />
      </div>
      <button v-on:click="toggleLoginType">Toggle login type</button>
    </div>

    v-show 的元素始终会被渲染并保留在 DOM 中。v-show 只是简单地切换元素的 CSS property display
    <div v-show="ok">Hello!</div>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      loginType: 'username',
      type: 'H',
      ok: false
    }
  },
  methods: {
    toggleLoginType: function() {
      if (this.loginType === 'username') {
        this.loginType = 'email'
      } else {
        this.loginType = 'username'
      }
    }
  }
}
</script>
