import { client } from './client'

export default {
  getList () {
    return client
      .get('http://localhost:8080/book/list')
      .then(response => (response.data.book_list))
  },
  getDetail (id) {
    return client
      .get(`http://localhost:8080/book/detail/${id}`)
      .then(response => (response.data))
  },
  register (id, title, author, releaseDate) {
    return client.post('http://localhost:8080/admin/book/register', {
      id: id,
      title: title,
      author: author,
      release_date: releaseDate
    })
  },
  update (id, title, author, releaseDate) {
    return client.put('http://localhost:8080/admin/book/update', {
      id: id,
      title: title,
      author: author,
      release_date: releaseDate
    })
  },
  delete (id) {
    return client
      .delete(`http://localhost:8080/admin/book/delete/${id}`)
  }
}
