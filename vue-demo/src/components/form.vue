<template>
  <form>
    <input v-model="message" placeholder="edit me" />
    <p>Message is: {{ message }}</p>
    <br />
    <br />
    <span>Multiline message is:</span>
    <p style="white-space: pre-line;">{{ message }}</p>
    <textarea v-model="message" placeholder="add multiple lines"></textarea>
    <br />
    <br />
    <input type="checkbox" id="checkbox" v-model="checked" />
    <label for="checkbox">{{ checked }}</label>
    <br />
    <br />
    <input type="checkbox" id="jack" value="Jack" v-model="checkedNames" />
    <label for="jack">Jack</label>
    <input type="checkbox" id="john" value="John" v-model="checkedNames" />
    <label for="john">John</label>
    <input type="checkbox" id="mike" value="Mike" v-model="checkedNames" />
    <label for="mike">Mike</label>
    <span>Checked names: {{ checkedNames }}</span>

    <br />
    <br />
    <input type="radio" id="one" value="One" v-model="picked" />
    <label for="one">One</label>
    <br />
    <input type="radio" id="two" value="Two" v-model="picked" />
    <label for="two">Two</label>
    <span>Picked: {{ picked }}</span>
    <br />
    <br />
    <select v-model="selected">
      <option disabled value>请选择</option>
      <option>A</option>
      <option>B</option>
      <option>C</option>
    </select>
    <span>Selected: {{ selected }}</span>
    <br />
    <br />
    <select v-model="selectedArr" multiple style="width: 50px;">
      <option>A</option>
      <option>B</option>
      <option>C</option>
    </select>
    <br />
    <span>selectedArr: {{ selectedArr }}</span>

    <br />
    <br />
    <select v-model="selected">
      <option
        v-for="option in options"
        v-bind:value="option.value"
        :key="option.value"
      >{{ option.text }}</option>
    </select>
    <span>Selected: {{ selected }}</span>
    <br />
    <br />修改选择框选中的值
    <input type="checkbox" v-model="toggle" true-value="yes" false-value="no" />
  </form>
</template>
<script>
export default {
  data: function() {
    return {
      checked: false,
      message: '',
      checkedNames: ['Jack', 'John'],
      picked: 'Two',
      selected: '',
      selectedArr: ['A', 'B'],
      options: [
        { text: 'One', value: 'A' },
        { text: 'Two', value: 'B' },
        { text: 'Three', value: 'C' }
      ],
      toggle: 'yes'
    }
  }
}
</script>
