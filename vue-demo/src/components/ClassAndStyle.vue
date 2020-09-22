<template>
<div>
<div id="class">
  绑定CSS 对象语法
  <div id="object1" v-bind:class="{ active: isActive }"> v-bind:class="{ active: isActive }"</div>
  <div id="object2" class="static" v-bind:class="{ active: isActive, 'text-danger': hasError }">v-bind:class="{ active: isActive, 'text-danger': hasError }"</div>
  <div id="object3" v-bind:class="classObject">v-bind:class="classObject"></div>
  <div id="object4" v-bind:class="classObject1">计算属性：v-bind:class="classObject1"</div>

  数组语法
  <div id="arr1" v-bind:class="[activeClass, errorClass]"> v-bind:class="[activeClass, errorClass]"</div>
  这样写将始终添加 errorClass，但是只有在 isActive 是 truthy 时才添加 activeClass。
  <div id="arr2" v-bind:class="[isActive ? activeClass : '', errorClass]">v-bind:class="[isActive ? activeClass : '', errorClass]"</div>
  当有多个条件 class 时这样写有些繁琐。所以在数组语法中也可以使用对象语法：
  <div id="arr3" v-bind:class="[{ active: isActive }, errorClass]">v-bind:class="[{ active: isActive }, errorClass]"</div>
</div>

<div id="style">
  内联样式 对象语法
  <div v-bind:style="{ color: activeColor, fontSize: fontSize + 'px' }">v-bind:style="{ color: activeColor, fontSize: fontSize + 'px' }"</div>

  <div v-bind:style="styleObject">v-bind:style="styleObject"</div>

  <div v-bind:style="[styleObject, overridingStyles]"> v-bind:style="[baseStyles, overridingStyles]"</div>
</div>
</div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      isActive: true,
      hasError: false,
      error: null,
      activeClass: 'active',
      errorClass: 'text-danger',

      activeColor: 'red',
      fontSize: 30,
      classObject: {
        active: true,
        'text-danger': false
      },
      styleObject: {
        color: 'red',
        fontSize: '13px'
      },
      overridingStyles: {
        padding: '5px'

      }
    }
  },
  computed: {
    classObject1: function () {
      return {
        active: this.isActive && !this.error,
        'text-danger': this.error && this.error.type === 'fatal'
      }
    }
  }
}
</script>
