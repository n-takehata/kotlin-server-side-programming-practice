<template>
  <div id="app">
    書籍登録
    <table class="register_book">
      <tbody>
      <tr>
        <td class="book">ID</td>
        <td class="book"><input v-model="id"></td>
      </tr>
      <tr>
        <td class="book">タイトル</td>
        <td class="book"><input v-model="title"></td>
      </tr>
      <tr>
        <td class="book">著者</td>
        <td class="book"><input v-model="author"></td>
      </tr>
      <tr>
        <td class="book">発売日</td>
        <td class="book"><input v-model="release_date"></td>
      </tr>
      </tbody>
    </table>
    <br/>
    <button v-on:click="registBook">登録</button>
  </div>
</template>

<script>
import book from '@/api/book.js'
export default {
  data () {
    return {
      id: '',
      title: '',
      author: '',
      release_date: ''
    }
  },
  methods: {
    registBook () {
      book.register(this.id, this.title, this.author, this.release_date)
        .then(() => this.$router.push('/admin/book/register/completed'))
    }
  }
}
</script>

<style scoped>
@import "../assets/css/base.css";
</style>
