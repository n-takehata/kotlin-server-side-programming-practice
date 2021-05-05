<template>
  <div id="app">
    書籍詳細
    <table class="book">
      <thead>
        <tr>
          <th class="book">タイトル</th>
          <th class="book">著者</th>
          <th class="book">発売日</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="book">{{ book.title }}</td>
          <td class="book">{{ book.author }}</td>
          <td class="book">{{ book.release_date }}</td>
        </tr>
      </tbody>
    </table>
    <router-link v-bind:to="{ name: 'BookUpdate', params: { book_id: book.id }}">更新</router-link><br />
    <a href="javascript:void(0)" @click.prevent="deleteBook()">削除</a><br />
    <a v-if="book.rental_info == null" href="javascript:void(0)" @click.prevent="startRental()">貸出</a><br />
    <br />
    <div v-if="book.rental_info != null">
      貸出情報
      <table class="book">
        <thead>
        <tr>
          <th class="book">貸出ユーザーID</th>
          <th class="book">貸出日</th>
          <th class="book">返却予定日</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td class="book">{{ book.rental_info.user_id }}</td>
          <td class="book">{{ book.rental_info.rental_datetime }}</td>
          <td class="book">{{ book.rental_info.return_deadline }}</td>
        </tr>
        </tbody>
      </table>
      <a href="javascript:void(0)" @click.prevent="endRental()">返却</a><br />
      <br />
    </div>
    <router-link to="/book/list">一覧へ戻る</router-link>
  </div>
</template>

<script>
import book from '@/api/book.js'
import rental from '@/api/rental.js'
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
    deleteBook () {
      let isOk = window.confirm('削除しますか？')
      if (isOk) {
        book.delete(this.book.id)
          .then(() => this.$router.push('/admin/book/delete/completed'))
      }
    },
    startRental () {
      let isOk = window.confirm('この本を借りますか？')
      if (isOk) {
        rental.startRental(this.book.id)
          .then(() => this.$router.go({path: this.$router.currentRoute.path, force: true}))
      }
    },
    endRental () {
      let isOk = window.confirm('この本を返却しますか？')
      if (isOk) {
        rental.endRental(this.book.id)
          .then(() => this.$router.go({path: this.$router.currentRoute.path, force: true}))
      }
    }
  }
}
</script>

<style scoped>
  @import "../assets/css/base.css";
</style>
