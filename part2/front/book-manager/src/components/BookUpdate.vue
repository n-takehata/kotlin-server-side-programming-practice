<template>
  <div id="app">
    書籍更新
    <table class="register_book">
      <tbody>
        <tr>
          <td class="book">ID</td>
          <td class="book" align="left">{{ book.id }}</td>
        </tr>
        <tr>
          <td class="book">タイトル</td>
          <td class="book"><input v-model="book.title"></td>
        </tr>
        <tr>
          <td class="book">著者</td>
          <td class="book"><input v-model="book.author"></td>
        </tr>
        <tr>
          <td class="book">発売日</td>
          <td class="book"><input v-model="book.release_date"></td>
        </tr>
      </tbody>
    </table>
    <br />
    <button v-on:click="updateBook">更新</button>
  </div>
</template>

<script>
import book from '@/api/book.js'
export default {
  data () {
    return {
      book: ''
    }
  },
  mounted () {
    book.getDetail(this.$route.params.book_id).then((bookDetail) => (this.book = bookDetail))
  },
  methods: {
    updateBook () {
      book.update(this.book.id, this.book.title, this.book.author, this.book.release_date)
        .then(() => this.$router.push('/admin/book/update/completed'))
    }
  }
}
</script>

<style scoped>
  @import "../assets/css/base.css";
</style>
