<template>
  <div id="app" class="center">
    書籍リスト
    <table border="1" align="center">
      <thead>
      <tr>
        <th class="book">タイトル</th>
        <th class="book">著者</th>
        <th class="book">貸出状況</th>
        <th class="book">操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="book in list" :key="book">
        <td class="book"><router-link v-bind:to="{ name: 'BookDetail', params: { book_id: book.id }}">{{ book.title }}</router-link></td>
        <td class="book">{{ book.author }}</td>
        <td v-if="book.is_rental" class="book">貸出中</td><td v-else class="book">貸出可</td>
        <td class="book"><router-link v-bind:to="{ name: 'BookUpdate', params: { book_id: book.id }}">更新</router-link> <a href="javascript:void(0)" @click.prevent="deleteBook(book.id)">削除</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import book from '@/api/book.js'
export default {
  data () {
    return {
      list: ''
    }
  },
  mounted () {
    book.getList().then((res) => (this.list = res))
  },
  methods: {
    deleteBook (id) {
      let isOk = window.confirm('削除しますか？')
      if (isOk) {
        book.delete(id)
          .then(() => this.$router.push('/admin/book/delete/completed'))
      }
    }
  }
}
</script>

<style scoped>

</style>
