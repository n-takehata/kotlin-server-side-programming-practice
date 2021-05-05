import { client } from './client'

export default {
  startRental (id) {
    return client.post('http://localhost:8080/rental/start', {
      book_id: id
    })
  },
  endRental (id) {
    return client.delete(`http://localhost:8080/rental/end/${id}`)
  }
}
